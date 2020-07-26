package com.github.woojiahao.types

import kotlin.reflect.KProperty

class IntValidator(
  private var value: Int = 0,
  private val min: Int? = null,
  private val max: Int? = null
) : Validator<Int> {
  init {
    if (value != 0) validate(value)
  }

  operator fun getValue(thisRef: Any?, property: KProperty<*>) = value

  @Throws(IllegalArgumentException::class)
  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
    validate(value)
    this.value = value
  }

  @Throws(IllegalArgumentException::class)
  override fun validate(value: Int) {
    min?.let { require(value >= it) { "Value ($value) below set minimum value of \"$it\"" } }
    max?.let { require(value <= it) { "Value ($value) above set maximum value of \"$it\"" } }
  }
}
