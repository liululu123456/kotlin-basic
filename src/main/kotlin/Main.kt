import com.thoughtworks.kotlin_basic.util.ExcelListUtil
fun main(args: Array<String>) {

    val excelListUtil = ExcelListUtil()
    val characterList = excelListUtil.characterList(1, 26)
    println(characterList)
}