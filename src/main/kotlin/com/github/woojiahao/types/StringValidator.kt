package com.github.woojiahao.types

import kotlin.reflect.KProperty

class StringValidator(
  private val rule: String = "",
  private var value: String = ""
) {
  private val regex = rule.toRegex()

  init {
    if (value != "") require(regex.matches(value)) { "Initial value does not match rule." }
  }

  operator fun getValue(thisRef: Any?, property: KProperty<*>) = value

  @Throws(IllegalArgumentException::class)
  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
    require(regex.matches(value)) { "Value provided does not match rule: \"${rule}\"" }
    this.value = value
  }
}