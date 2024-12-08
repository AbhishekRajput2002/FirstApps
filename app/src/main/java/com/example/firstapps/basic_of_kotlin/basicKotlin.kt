package com.example.firstapps.basic_of_kotlin

import kotlin.reflect.KFunction1

fun main()
{
    var name :String? = "Abhi"

 //   println( name?.length?:"null value")
//    println(name)

    val num1 = 26
    if(num1 % 2 == 0)
    {
        println("$num1 is even")
    }else{ println("$num1 is odd") }

    var results = 4
    val res = when(results)
    {
        1 ->"One"
        2 ->"Two"
        3 -> "Three"
        4 -> "Four"
        else -> "no result found"
    }
 //   println(res)

    var arr = arrayOf(1,2,3,4,5)
 //   for(i in arr){print("$i, ")}

 //   fun dummyfun() = println("hello")


 //   println(cal(2,4){ a, b -> a+b})
//    println(cal(2,8,::add))

 // Loops


}


fun add(a:Int,b:Int):Int{
    return a+b
}
 fun cal(a:Int,b:Int,sum:(Int,Int)->Int) :Int{
     return add(a,b)
}














