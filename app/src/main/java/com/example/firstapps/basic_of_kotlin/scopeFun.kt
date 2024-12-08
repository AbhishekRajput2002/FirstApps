package com.example.firstapps.basic_of_kotlin

class Scope() {
    var name: String? = null
    var age: Int? = null

    var arr = mutableListOf<Int>(1,2,3,4,5)
    // also Fun
    var arr2 = arr.also {
        it.add(6)
        it.remove(3)
        println(it)
    }

}

    fun main() {
        val obj1 = Scope()
       // apply Fun
        obj1.apply {
            name = "Abhi"
            age = 20
        }
        //let Fun
        obj1.let {
            println(it.name)
            println(it.age)
        }
    }

