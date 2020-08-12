package com.expedia.api.flights.query


/**
 * @author schandna created on 03/02/20
 */
fun main(): Unit {
    val someObject: Any = "Generic Object Type"

    // various representation of numbers
    val myInt = 100
    val myLong = 100L
    val myHex = 0x0F
    val myBinary = 0b01

    val myFloat = 0.1F
    val myDouble = 0.1

    val myBoolean = true

    val myString = "Single Line"
    val multilineString = """
        Multi
        Line
        String
    """.trimIndent()

    // string templating
    val name = "Kotlin"
    println("Hello, $name!")

    var evenNum = intArrayOf(2, 4, 6)

    for(even in evenNum) {
        println(even)
    }
    evenNum += 8
    for(even in evenNum) {
        println(even)
    }
}

/*fun findTheAnswer(): Int = if (timeHasPassed()) {
    42
} else {
    fail("Not Ready")
}

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}*/
