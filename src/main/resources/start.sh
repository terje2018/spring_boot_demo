#!/bin/sh

main_class="me.terje.spring.boot.SpringBootDemo"
app_base_path=$(cd "$(dirname "$0")"&& cd ..&& pwd)
echo "APP BASE PATH: "$app_base_path

mkdir -p $app_base_path/logs

lib_jars="."
jars=$(ls $app_base_path/lib/)
for jar in $jars
do
        lib_jars=$lib_jars:$app_base_path/lib/$jar
done
#some params must be read from env.such as docker/k8s: ENV
cmd="$JAVA_HOME/bin/java \
-Dlogging.config=$app_base_path/conf/logback.xml \
-Dlog_dir=$app_base_path/logs \
-Dspring.config.location=$app_base_path/conf/application.yml \
$GC_CONFIG \
-cp $lib_jars $main_class"

echo "STARTING APP: $cmd"
$cmd > $app_base_path/logs/std_err.out 2>&1 #没有&，因为需要让app进程与container进程挂钩。
echo $!>/tmp/spring_boot_demo.pid