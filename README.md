# mongodb

Sample REST Application using mongodb


Reference commands for docker

docker commands

docker build -t xxx:1 --no-cache .
docker run -d --name xxx_app -p 8080:8080 xxx:1
docker commit xxx_app xxx_app:1
docker tag xxx_app:1 narendhiran/xxx_app:1
docker push narendhiran/xxx_app:1
