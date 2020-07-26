package com.github.woojiahao.types

interface Validator {
  @Throws(IllegalArgumentException::class)
  fun validate()
}