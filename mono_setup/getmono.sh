#!/bin/bash
# this script should NOT be run directly (especially not as root)
# prerequisit : apt-get install gettext build-essential   
VERSION=3.2.3

echo "====================="
echo "Fetching mono"
echo "====================="
curl -O http://download.mono-project.com/sources/mono/mono-${VERSION}.tar.bz2
if [ $? -ne 0 ]; then
    exit 1
fi

tar -xaf mono-${VERSION}.tar.bz2
if [ $? -ne 0 ]; then
    exit 1
fi

echo "====================="
echo "Configuring mono"
echo "====================="
cd mono-${VERSION}
./configure --prefix=/usr \
    --sysconfdir=/etc \
    --bindir=/usr/bin \
    --sbindir=/usr/sbin \
    --disable-quiet-build \
    --disable-system-aot \
    --disable-static

if [ $? -ne 0 ]; then
    echo Configure has failed
    exit 1
fi

echo "====================="
echo "Make"
echo "====================="
make
if [ $? -ne 0 ]; then
    echo Make has failed
    exit 1
fi

echo "====================="
echo "Make install"
echo "====================="
make install
if [ $? -ne 0 ]; then
    echo Install has failed # Run this line as root
    exit 1
fi

echo "====================="
echo "Success!!!"
echo "====================="
exit 0
