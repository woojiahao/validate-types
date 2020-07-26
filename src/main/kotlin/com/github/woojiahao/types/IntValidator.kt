package com.github.woojiahao.types

import kotlin.reflect.KProperty

class IntValidator(
  private var value: Int = 0,
  private val min: Int? = null,
  private val max: Int? = null
) : Validator {
  init {
    validate()
  }

  operator fun getValue(thisRef: Any?, property: KProperty<*>) = value

  @Throws(IllegalArgumentException::class)
  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
    validate()
    this.value = value
  }

  @Throws(IllegalArgumentException::class)
  override fun validate() {
    min?.let { require(value >= it) { "Value below set minimum value of \"${it}\"" } }
    max?.let { require(value <= it) { "Value above set maximum value of \"${it}\"" } }
  }
}