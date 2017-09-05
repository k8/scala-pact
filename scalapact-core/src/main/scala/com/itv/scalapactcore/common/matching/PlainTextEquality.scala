package com.itv.scalapactcore.common.matching

object PlainTextEquality {

  def check(expected: String, received: String): Boolean = {
    expected.trim == received.trim
  }

  def checkOutcome(expected: String, received: String): MatchOutcome =
    if(expected.trim == received.trim) MatchOutcomeSuccess else MatchOutcomeFailed("Plain test bodies did not match")

}
