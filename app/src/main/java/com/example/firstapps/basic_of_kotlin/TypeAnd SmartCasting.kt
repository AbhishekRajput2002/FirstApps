package com.example.firstapps.basic_of_kotlin

fun result(a:Any)
{
    if(a is String)
    {
        println(" a is String")
        println(a.length)
    }
    else if (a is Int)
    {
        println("a is Integer")
        println(a*2)
    }
    else{
        println(" a is not String and Integer")
    }
}
fun result2(a: Any) {
    val res: String? = a as? String
    if (res == null) println("Not String") else println(" String")
}
fun main()
{
    result("Abhi")
    result2("DD")
}