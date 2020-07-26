package com.github.woojiahao.types

import kotlin.reflect.KProperty

class IntValidator(
  private var value: Int = 0,
  private val min: Int? = null,
  private val max: Int? = null
) {
  operator fun getValue(thisRef: Any?, property: KProperty<*>) = value

  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
    min?.let { require(value >= it) { "Value below set minimum value of \"${it}\"" } }
    max?.let { require(value <= it) { "Value above set maximum value of \"${it}\"" } }
    this.value = value
  }
}