Akka demo
=================

## required

+ docker


## container up

```
$ pwd
/path/to/directory/akka-demo
$ docker network create \
    --driver bridge \
    --subnet=192.168.31.0/24 \
    --gateway=192.168.31.10 \
    --opt "com.docker.network.bridge.name"="brige" \
    shared_nw
$ docker run --name=frontend -ti -v $(pwd):/work -p 5000:5000 --ip 192.168.31.11 --net shared_nw hseeberger/scala-sbt /bin/bash
$ docker run --name=backend -ti -v $(pwd):/work -p 5001:5000 --ip 192.168.31.12 --net shared_nw hseeberger/scala-sbt /bin/bash
```

## frontend start

```
$ docker exec -ti frontend /bin/bash
$ cd work && sbt run

Multiple main classes detected, select one to run:

 [1] com.goticks.BackendRemoteDeployMain
 [2] com.goticks.FrontendRemoteDeployhMain
 [3] com.goticks.SingleNodeMain

Enter number: 2

[info] Running com.goticks.FrontendRemoteDeployhMain
[DEBUG] [03/21/2018 05:41:15.526] [run-main-0] [EventStream] StandardOutLogger started
INFO  [Slf4jLogger]: Slf4jLogger started
[DEBUG] [03/21/2018 05:41:16.488] [run-main-0] [EventStream(akka://frontend)] logger log1-Slf4jLogger started
[DEBUG] [03/21/2018 05:41:16.491] [run-main-0] [EventStream(akka://frontend)] Default Loggers started
INFO  [Remoting]: Starting remoting
INFO  [Remoting]: Remoting started; listening on addresses :[akka.tcp://frontend@192.168.31.11:2552]
INFO  [Remoting]: Remoting now listens on addresses: [akka.tcp://frontend@192.168.31.11:2552]
INFO  [go-ticks]: RestApi bound to /192.168.31.11:5000
```

## backend start

```
$ docker exec -ti backend /bin/bash
root@8b96ace4a374:~# cd /work/
root@8b96ace4a374:/work# sbt run

Multiple main classes detected, select one to run:

 [1] com.goticks.BackendRemoteDeployMain
 [2] com.goticks.FrontendRemoteDeployhMain
 [3] com.goticks.SingleNodeMain

Enter number: 1

[info] Running com.goticks.BackendRemoteDeployMain
INFO  [Slf4jLogger]: Slf4jLogger started
INFO  [Remoting]: Starting remoting
INFO  [Remoting]: Remoting started; listening on addresses :[akka.tcp://backend@192.168.31.12:2551]
INFO  [Remoting]: Remoting now listens on addresses: [akka.tcp://backend@192.168.31.12:2551]
```

## packet capter

```
$ root@8b96ace4a374:~# tcpdump -Anns 1000 dist port 2551
  tcpdump: syntax error in filter expression: syntax error
  root@8b96ace4a374:~# apt-get update
  Ign:1 http://deb.debian.org/debian stretch InRelease
  Hit:2 http://deb.debian.org/debian stretch-updates InRelease
  Hit:3 http://deb.debian.org/debian stretch Release
  Hit:4 http://security.debian.org stretch/updates InRelease
```