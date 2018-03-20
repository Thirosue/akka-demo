Akka demo
=================

## required

+ docker
+ docker-compose

## run

```

$ docker-compose up -d
$ docker ps
  CONTAINER ID        IMAGE                  COMMAND             CREATED             STATUS              PORTS                    NAMES
  4641a5688a42        front                  "sbt run"           28 minutes ago      Up 28 minutes       0.0.0.0:5000->5000/tcp   front
  2a790ff54b6d        back                   "sbt run"           28 minutes ago      Up 28 minutes                                back
```

## stop

```
$ docker-compose down
```

## Not Use docker-compose

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
