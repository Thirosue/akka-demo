Akka demo
=================

## required

+ docker
+ docker compose

## run

```
$ docker
$ docker compose up -d
$ docker ps
  CONTAINER ID        IMAGE                  COMMAND             CREATED             STATUS              PORTS                    NAMES
  4641a5688a42        front                  "sbt run"           28 minutes ago      Up 28 minutes       0.0.0.0:5000->5000/tcp   front
  2a790ff54b6d        back                   "sbt run"           28 minutes ago      Up 28 minutes                                back
```

## stop

```
$ docker compose down
```
