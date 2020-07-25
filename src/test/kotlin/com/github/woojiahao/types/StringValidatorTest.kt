package com.github.woojiahao.types

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object StringValidatorTest : Spek({
  describe("StringValidator") {
    // Simple rule := can contain any letter, digit, _, and -
    //   At least 8 characters long
    var simple by StringValidator("[-_\\w\\d]{8,}")

    describe("simple") {
      it("passes if the value assigned matches the regex rule") {
        simple = "passw-ord123"
        println(simple)
      }
    }
  }
})

