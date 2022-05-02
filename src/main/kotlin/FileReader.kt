import java.io.File

class FileReader {
    fun getPuzzle1(): List<Int> {
        val url = "src/main/resources/puzzle1.txt"
        var file = File(url).readLines()
        //println(file);
        val inputList = file.map { it.toInt() }
        return inputList;
    }

    fun getPuzzle2(): List<List<Any>> {
        val url = "src/main/resources/puzzle2.txt"
        var file = File(url).readLines()
        val inputList = mutableListOf<List<Any>>()
        file.forEach{
            val splittedString = it.split(' ')
            inputList.add(listOf<Any>(splittedString[0], splittedString[1].toInt()))
        }
        return inputList
    }

    fun getPuzzle3(): List<List<Int>> {
        val url = "src/main/resources/puzzle3.txt"
        var file = File(url).readLines()
        val inputList = mutableListOf<List<Int>>()
        file.forEach{
            println("Test")
            val charArray = it.toCharArray()
            val intList = charArray.map{it -> it.digitToInt() }
            inputList.add(intList)
        }
        return inputList
    }

    fun getPuzzle4Numbers(): List<Int> {
        val url = "src/main/resources/puzzle4_numbers.txt"
        var file = File(url).readLines()
        var inputs = file[0].split(',')
        return inputs.map { it.toInt() }
    }

    fun getPuzzle4Cards(): List<List<Int>> {
        val url = "src/main/resources/puzzle4_cards.txt"
        var file = File(url).readLines()
        val allNumbers = mutableListOf<Int>()
        file.forEach{
            var splittedString = it.split(' ')
            splittedString.forEach {
                if(!it.isNullOrEmpty()) {
                    allNumbers.add(it.toInt())
                }
            }
        }
        var inputs = mutableListOf<List<Int>>()
        var card = mutableListOf<Int>()
        allNumbers.forEachIndexed { index, i ->
            card.add(i)
            if(card.size >= 25) {
                inputs.add(card)
                card = mutableListOf<Int>()
            }
        }
        return inputs
    }

}