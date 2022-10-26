#!/bin/bash
sudo apt upgrade && sudo apt update 
java -version
if [ $? -eq 0 ];
then
echo "java instalado"
else
echo "java nao instalado"
echo "gostaria de instalar o java? (s/n)"
read inst
if [ \"$inst\" == \"s\" ];
then
sudo apt install default-jre -y
fi
fi

sudo apt install docker.io 

sudo systemctl start docker

sudo systemctl enable docker

sudo docket pull mysql:5.7

sudo docker run -d -p 3306:3306 --name ConteinerDB -e "MYSQL_DATABASE=Animix"-e"MYSQL_ROOT_PASSWORD=Animix" mysql:5.7

sudo docker ps -a

cd /home/ubuntu/Desktop
git clone https://github.com/thaylaandreassi/Animix-PI.git

cd Animix-PI/APPJar/target
java -jar banco-modelo-1.0-SNAPSHOT-jar-with-dependencies.jar