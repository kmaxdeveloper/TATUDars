package uz.kmax.tatudars.domain.model

data class TestData(
    var question: String = "",
    var answer : String = "",
    var variantList : List<String> = listOf()
)