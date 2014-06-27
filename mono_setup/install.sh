#!/bin/bash

echo "This script will do following:
1. create mono user
2. install mono version 3.2.3
3. configure mono deamon

please ensure that following packages are installed:
curl, gettext, g++, make"

read -p "[Enter] to continue"

# 1. create user (root)

echo "====================="
echo "Creating user"
echo "====================="
useradd -r -d /var/mono -m -s /bin/bash -U mono

# 2. install mono (root) - zasto robi ne zeli root?

echo "====================="
echo "Installing mono"
echo "====================="
mkdir /tmp/monoinst
cd /tmp/monoinst
rm -rf /tmp/monoinst/*
#./getmono.sh

if [ $? -ne 0 ]; then
    echo "Installation of mono failed. Please check log files"
    exit 1
fi
    
# 3. setup mono user
echo "====================="
echo "Setup mono deamon"
echo "====================="
cp setupmono.sh /var/mono
chown mono:mono /var/mono/setupmono.sh
sudo -H -u mono bash -c '/var/mono/setupmono.sh' 
rm /var/mono/setupmono.sh

cat >/etc/default/mono <<EOL
WWWROOT=/var/mono/wwwroot
USER=mono
GROUP=mono
EOL
cp monod.sh /etc/init.d/mono
chmod 0500 /etc/init.d/mono /etc/default/mono

cp start.sh.example /var/mono
chown mono:mono /var/mono/start.sh.example

echo "Done!!!"
echo "please assign a password to mono user using:
passwd mono"
echo " To start mono applications on boot on debian run this:
update-rc.d mono defaults"