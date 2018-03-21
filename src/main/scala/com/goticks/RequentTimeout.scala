package com.goticks

import scala.concurrent.Future

import akka.actor.ActorSystem
import akka.event.Logging
import akka.util.Timeout

import akka.http.scaladsl.Http
import akka.http.scaladsl.Http.ServerBinding
import akka.stream.ActorMaterializer

import com.typesafe.config.{ Config, ConfigFactory }
import scala.util.{ Failure, Success }

trait RequestTimeout {
  import scala.concurrent.duration._
  def configuredRequestTimeout(config: Config): Timeout = {
    val t = config.getString("akka.http.server.request-timeout")
    val d = Duration(t)
    FiniteDuration(d.length, d.unit)
  }
}


