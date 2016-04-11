package com.itv.scalapact.plugin.stubber

import com.itv.scalapact.plugin.common.{LocalPactFileLoader, CommandArguments}
import sbt._

import CommandArguments._
import LocalPactFileLoader._
import PactStubService._
import InteractionManager._
import com.itv.scalapact.plugin.common.Rainbow._

object ScalaPactStubberCommand {

  lazy val pactStubberCommandHyphen: Command = Command.args("pact-stubber", "<options>")(pactStubber)
  lazy val pactStubberCommandCamel: Command = Command.args("pactStubber", "<options>")(pactStubber)

  private lazy val pactStubber: (State, Seq[String]) => State = (state, args) => {

    println("*************************************".white.bold)
    println("** ScalaPact: Running Stubber      **".white.bold)
    println("*************************************".white.bold)

    val pactTestedState = Command.process("pact-test", state)

    (parseArguments andThen loadPactFiles("target/pacts") andThen addToInteractionManager andThen startServer)(args)

    pactTestedState
  }

}