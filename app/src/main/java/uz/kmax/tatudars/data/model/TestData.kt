package uz.kmax.tatudars.data.model

data class TestData(
    var question: String = "",
    var answer : String = "",
    var variantList : List<String> = listOf()
)