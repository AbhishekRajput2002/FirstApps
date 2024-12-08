package com.example.firstapps.basic_of_kotlin

class GetterAndSetter {

    var name: String? = null
        set(value) {
            field = value
        }
        get() {return field?.uppercase()}

}  fun main()
{
    val getterAndSetter = GetterAndSetter()
    getterAndSetter.name = "Jane"
    println(getterAndSetter.name)

}