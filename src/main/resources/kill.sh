#!/bin/sh
pid=$(cat /tmp/spring_boot_demo.pid)
echo "try to kill pid:$pid..."
kill $pid