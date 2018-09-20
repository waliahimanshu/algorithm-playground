package demo

import java.util.*

fun main(args: Array<String>) {
    println("${if (args[0].toInt() < 12) "Good Morning" else "Good night "}")

    //    println("Your fortune is: ${getFortuneCookie()}")


    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper")

    val message = spices.filter { it.contains("curry") }.sortedBy { it.length }

    println(message)

    val random1 = { sides: Int ->
        if (sides == 0) 0
        else {
            Random().nextInt(sides) + 1
        }
    }

    val random2: (Int) -> Int = { sides -> if (sides == 0 ) 0 else Random().nextInt(sides) + 1 }
    random2.invoke(3);
    random1.invoke(3)
}

fun getFortuneCookie(): String {

    val listOfFortunes = listOf("You will have a great day!",
            "Things will go well for you today.",
            "Enjoy a wonderful day of success.",
            "Be humble and all will turn out well.",
            "Today is a good day for exercising restraint.",
            "Take it easy and enjoy life!",
            "Treasure your friends because they are your greatest fortune.")

    print("Enter your birthday")
    val userEntered: String? = readLine();


    var birthday: Int = 0
    if (userEntered.isNullOrEmpty()) {
        birthday = 1;
    } else {
        val toInt = userEntered?.toInt();
        birthday = toInt!!;
    }

    whatShouldIDoToday(mood = readLine())

    return listOfFortunes[birthday.div(listOfFortunes.size)]

}

fun whatShouldIDoToday(mood: String?, weather: String = "Sunny") {


}

fun Nothing.inc(): Int? {
    return 1
}
