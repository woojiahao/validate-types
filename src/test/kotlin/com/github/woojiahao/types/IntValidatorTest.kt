package com.github.woojiahao.types

import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object IntValidatorTest : Spek({
  describe("IntValidator") {
    describe("simple") {
      var simple by IntValidator(min = 10, max = 99)
      it("passes if value is within given range of 10 and 99") {
        simple = 11
        println(simple)
        simple = 55
        println(simple)
      }
    }
  }
})