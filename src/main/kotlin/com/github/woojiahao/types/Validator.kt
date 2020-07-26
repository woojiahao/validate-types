package com.github.woojiahao.types

interface Validator<T> {
  @Throws(IllegalArgumentException::class)
  fun validate(value: T)
}
