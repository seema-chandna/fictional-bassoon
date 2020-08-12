package com.expedia.api.flights.query


/**
 * @author schandna created on 03/02/20
 */
fun main(args : Array<String>) {

    println("Hello World!")

        var ultimateQuestion = "What do you get when you multiply six by seven?"
        println(ultimateQuestion)

        ultimateQuestion = """
    Ultimate Answer to Life,
    The Universe,
    and Everything
""".trimIndent()
        println(ultimateQuestion)

    println("test 1: " + ultimateQuestion)
    println("test 2: ${ultimateQuestion} - ")

    var nullableName : String? = null
    var len = nullableName?.length ?: -1
    println(len)

    nullableName = "Sam"
    len = nullableName?.length ?: -1
    println(len)

    var name = "test"
    println(name)

   // not allowed
//    name = null
//    println(name)


    // Pair & Triples
    var cor = Pair(2, 3.1)
    println("x= ${cor.first} & y = ${cor.second}")

    val cor3D = Triple(2, 4, 6)
    val (x1, y1, z3) = cor3D

    val (x2, y2) = cor3D
    println("x= $x2 & y = $y2 ")

    val (x3, y3, _) = cor3D
    println("x= $x3 & y = $y3 ")

    var yes : Boolean = true
    var no = false

    println(" yes ${yes} -  no: ${no}")

    var i=10

    print("while")
    while(i>8){
        print(i)
        i
    }

    var range = 0..7

    for (j in 1..7) {
        print("i")
    }

}

