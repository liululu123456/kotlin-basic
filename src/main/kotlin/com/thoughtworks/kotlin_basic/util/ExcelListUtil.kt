package com.thoughtworks.kotlin_basic.util

private const val MAX_COLUMN = 18278

class ExcelListUtil {
    private fun convertToBase26(number:Int):String{
        val character = listOf("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z")
        var char = ""
        var originalNumber = number

        while (originalNumber > 0 ){
            val quotient = originalNumber/26
            val remainder = originalNumber%26

            var secondChar= ""
            if (quotient == 0) {
                char = character[remainder - 1]
                break
            }
            if (quotient == 1 && remainder == 0) {
                char = "Z"
                break
            }
            if (quotient in 1..26){
                if (remainder ==0)  char = character[quotient-1-1]+ "Z" + char
                if (remainder !=0) char = character[quotient-1]+ character[remainder-1] + char
                break
            }else
            {
                if (remainder ==0 && quotient ==27) {
                    char = "ZZ"+char
                    break
                }
                if (remainder ==0) {
                    secondChar = "Z"
                    originalNumber = quotient-1

                }
                if (remainder !=0) {
                    secondChar = character[remainder - 1]
                    originalNumber = quotient
                }
                char = secondChar + char
            }
        }
        return char
    }
    fun characterList(startColumn: Int, resultNumber: Int): List<String>{
        val endColumn = startColumn + resultNumber - 1
        val resultList= arrayListOf<String>()
        if (startColumn < 1 || startColumn > MAX_COLUMN || endColumn < 1 || endColumn > MAX_COLUMN){
            throw Exception("Exceed the max number of column!")
        }
        for (i in startColumn..endColumn){
            val char = convertToBase26(i);
            resultList.add(char)
        }
        return resultList
    }
}