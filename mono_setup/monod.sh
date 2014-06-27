#!/bin/sh
### BEGIN INIT INFO
# Provides:          mono
# Required-Start:    $syslog $time $remote_fs
# Required-Stop:     $syslog $time $remote_fs
# Default-Start:     2 3 4 5
# Default-Stop:      0 1 6
# Short-Description: Starts Mono applications
# Description:       Debian init script for starting Mono applications server
### END INIT INFO
#
# Author:  Nova Generacija Softvera d.o.o. <robert@element.hr>
#

PATH=/bin:/usr/bin:/sbin:/usr/sbin
DAEMON=/usr/bin/mono
PIDPREFIX=/var/run/mono-
DEFAULTS=/etc/default/mono
FINDOPT="-maxdepth 1 -mindepth 1"

test -x $DAEMON || exit 0

. /lib/lsb/init-functions

[ -r "$DEFAULTS" ] && . "$DEFAULTS"

start_daemon() {
  start-stop-daemon --start --quiet --oknodo --background --make-pidfile \
    --exec "$1" --pidfile "$2" \
    --chuid $USER:$GROUP
}

stop_daemon() {
  start-stop-daemon --stop \
    --pidfile "$1"
  rm -f "$1"
}

start() {
  path="$1"

  script="$path/start.sh"
  name="$(name_from_path "$path")"
  pid="${PIDPREFIX}$name.pid"

  test -x "$script" || {
    status=$?
    echo "Unknown Mono application '$name'!"
    return $status
  }

  status "$path" > /dev/null 2>&1 && return 0

  log_daemon_msg "Starting Mono application" "$name"
  start_daemon "$script" "$pid"
  status=$?
  log_end_msg $?
  test "$?" -ne "0" && exit $status
  return 0
}

stop() {
  pid="$1"

  name="$(name_from_pid "$pid")"
  test -r "$pid" || {
    echo "Unknown Mono application '$name'!"
    return 1
  }

  log_daemon_msg "Stopping Mono application" "$name"
  stop_daemon "$pid"
  log_end_msg $?

}

status() {
  path="$1"

  script="$path/start.sh"
  name="$(name_from_path "$path")"
  pid="${PIDPREFIX}$name.pid"

  test -x "$script" || {
    echo "Unknown Mono application '$name'!"
    return 1
  }

  status_of_proc -p "$pid" "$script" "$name"
}

name_from_path() {
  name="$(expr substr "$1" ${#WWWROOT} ${#1})"
  name="$(expr substr "$name" 2 ${#name})"
  test "$(expr substr "$name" 1 1)" = "/" && name="$(expr substr "$name" 2 ${#name})"
  echo "$name"
}

name_from_pid() {
  name="$(expr substr "$1" ${#PIDPREFIX} ${#1})"
  name="$(expr substr "$name" 2 ${#name})"
  name="${name%.pid}"
  echo "$name"
}

case "$1" in
  start)
    if [ -z "$2" ]; then
      echo Starting of your applications:
      find "$WWWROOT/" $FINDOPT -type d | while read -r path; do
        start "$path"
      done
    else
      start "$WWWROOT/$2" || exit $?
     fi
    ;;
  stop)
    if [ -z "$2" ]; then
      pidpath="$(dirname "$PIDPREFIX")"
      pidname="$(basename "$PIDPREFIX")"
      echo Stopping of your applications:
      find "$pidpath/" $FINDOPT -name "${pidname}*.pid" | while read -r pid; do
        stop "$pid"
      done
    else
      pid="${PIDPREFIX}$2.pid"
      stop "$pid" || exit $?
    fi
    ;;
  force-reload|restart)
    "$0" stop "$2"
    "$0" start "$2"
    ;;
  status)
    if [ -z "$2" ]; then
      echo Status of your applications:
      find "$WWWROOT/" $FINDOPT -type d | while read -r path; do
        status "$path"
      done;
    else
      status "$WWWROOT/$2" || exit $?
    fi
    ;;
  *)
    echo "Usage: /etc/init.d/mono {start|stop|restart|force-reload|status} [application]"
    exit 1
    ;;
esac

exit 0
