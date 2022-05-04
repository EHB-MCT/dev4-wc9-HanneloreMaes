fun main(args: Array<String>) {
    var reader = FileReader();
//    getNumber1(reader)
//    getNumber2(reader)

//    getPilot1(reader)
    getPilot2(reader)
}

fun getNumber1(reader: FileReader){
    var numbers = reader.getPuzzle1()
    var index = 0;
    var teller = 0;
    var prevNumber=0

    for (number in numbers){

        if (prevNumber < number){
            teller++
        }
        index++
        prevNumber = number
    }
    println(teller)

}
fun getNumber2(reader: FileReader){
    var correct:Int = 0
    var currentNumber:Int = 0
    var numbers = reader.getPuzzle1()


    for (number in numbers){

        var nextNumber1 = currentNumber + 1
        var nextNumber2 = currentNumber + 2
        var nextNumber3 = currentNumber + 3

        if (nextNumber3 < 2000){
            var sumCurrent = numbers.elementAt(currentNumber) + numbers.elementAt(nextNumber1) + numbers.elementAt(nextNumber2)
            var nextSum = numbers.elementAt(nextNumber1) + numbers.elementAt(nextNumber2) + numbers.elementAt(nextNumber3)

            if (sumCurrent < nextSum){
                correct++
            }
        }

        currentNumber ++
    }

    println(correct)
}

fun getPilot1(reader: FileReader){
    val numbers = reader.getPuzzle2()
    var currentMove:Int = 0
    var upNumber: Int = 0
    var downNumber: Int = 0
    var forwardNumber:Int = 0


    for (moves in numbers){
        var currentMoves = numbers.elementAt(currentMove)
        var currentPosition = currentMoves.elementAt(0)
        var currentNumber = currentMoves.elementAt(1)

        if(currentPosition == "up"){
            upNumber += currentNumber as Int
        }
        if(currentPosition == "down"){
            downNumber += currentNumber as Int
        }
        if(currentPosition == "forward"){
            forwardNumber += currentNumber as Int
        }
        currentMove++
    }
    var location = (downNumber - upNumber) * forwardNumber
    println(location)
}
fun getPilot2(reader: FileReader){
    val numbers = reader.getPuzzle2()
    var currentMove:Int = 0
    var upNumber: Int = 0
    var downNumber: Int = 0
    var forwardNumber:Int = 0
    var aim: Int = 0


    for (moves in numbers){
        var currentMoves = numbers.elementAt(currentMove)
        var currentPosition = currentMoves.elementAt(0)
        var currentNumber = currentMoves.elementAt(1)

        if(currentPosition == "up"){
            aim -= currentNumber as Int
        }
        if(currentPosition == "down"){
            aim -= currentNumber as Int
        }
        if(currentPosition == "forward"){
            forwardNumber += currentNumber as Int
            downNumber += aim * currentNumber
        }

        currentMove++
    }
    var location = forwardNumber * downNumber
    println(location)
}