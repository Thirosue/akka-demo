FROM hseeberger/scala-sbt

MAINTAINER takeshi.hirosue@bigtreetc.com

# Install telnet
RUN \
  apt-get install telnet

# Define working directory
WORKDIR /work

CMD ["sbt", "run"]
