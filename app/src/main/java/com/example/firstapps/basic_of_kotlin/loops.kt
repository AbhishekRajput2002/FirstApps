package com.example.firstapps.basic_of_kotlin

fun main()
{
    var an : String
    for(i in 1..5)
    {
        for(j in 1..i)
        {
            print("* ")
        }
        print("\n")
    }

    println("hello\nAbhi")
    for(i in 5 downTo  1)
    {
        for(j in i downTo 1)
        {
            print("A ")
        }
        for(k in 1..5-i){
            print("* ")
        }
        print("\n")
    }
    for(i in 1..5) {
        for (j in 1..i) {
            print(". ")
        }
        for (k in 5 downTo i) {
            print("* ")
        }
        println()
    }


}