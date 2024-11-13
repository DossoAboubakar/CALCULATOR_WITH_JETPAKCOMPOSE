package com.example.calculatrice.ui.theme

sealed class UiEvent (
    val character:String ? = null,
    val operator:CalculationOperator = CalculationOperator.NONE
    ){
    object On0Clicked: UiEvent(character="0")
    object On1Clicked: UiEvent(character="0")
    object On2Clicked: UiEvent(character="0")
    object On3Clicked: UiEvent(character="0")
    object On4Clicked: UiEvent(character="0")
    object On5Clicked: UiEvent (character="0")
    object On6Clicked: UiEvent(character="0")
    object On7Clicked: UiEvent(character="0")
    object On8Clicked: UiEvent(character="0")
    object OnPlusClicked: UiEvent(operator = CalculationOperator.ADDITION)
    object OnMinusClicked:  UiEvent(operator = CalculationOperator.SUBSTRACTION)
    object OnDivideClicked: UiEvent( operator = CalculationOperator.DIVISION)
object OnTimesClicked: UiEvent( operator = CalculationOperator.MUTILPLICATION)
    object On9Clicked: UiEvent(character="0")
    object OnClear: UiEvent()
    object OnClearAll: UiEvent()
    object OnEgalClicked : UiEvent()







}