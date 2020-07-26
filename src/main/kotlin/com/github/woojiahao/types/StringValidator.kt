package com.github.woojiahao.types

import kotlin.reflect.KProperty

class StringValidator(
  private val rule: String = "",
  private var value: String = ""
): Validator<String> {
  private val regex = rule.toRegex()

  init {
    validate(value)
  }

  operator fun getValue(thisRef: Any?, property: KProperty<*>) = value

  @Throws(IllegalArgumentException::class)
  operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
    validate(value)
    this.value = value
  }

  @Throws(IllegalArgumentException::class)
  override fun validate(value: String) {
    if (value != "") require(regex.matches(value)) { "Value provided does not match rule: \"${rule}\"" }
  }
}
