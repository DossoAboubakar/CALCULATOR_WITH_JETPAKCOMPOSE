package com.example.calculatrice.ui.theme

import android.icu.text.DecimalFormat
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    val uiState: MutableState<UiState> = mutableStateOf(UiState())
    fun onUiEvent(uiEvent:UiEvent){
        when(uiEvent){
            is UiEvent.On0Clicked ,  UiEvent.On1Clicked ,  UiEvent.On2Clicked ,
             UiEvent.On3Clicked , UiEvent.On4Clicked , UiEvent.On5Clicked ,UiEvent.On6Clicked,
                    UiEvent.On7Clicked,UiEvent.On8Clicked,UiEvent.On9Clicked -> {
                        updateNumber(uiEvent.character!!)
                    }
            is UiEvent.OnClearAll -> {
                uiState.value = UiState()

            }
            is UiEvent.OnClear -> {
                clear()
            }

            else -> {}
        }


      }
    private fun clear(){
        if(uiState.value.currentOperator == CalculationOperator.NONE){
            uiState.value = uiState.value.copy( firstNumber = uiState.value.firstNumber.dropLast(1))
        }
        else {
            uiState.value = uiState.value.copy(secondNumber = uiState.value.secondNumber.dropLast(1))
        }

    }
    private fun updateNumber(numberCharacter:String){
       if(uiState.value.currentOperator == CalculationOperator.NONE){
           uiState.value = uiState.value.copy(
               firstNumber  = uiState.value.firstNumber + numberCharacter,
               answer  = "")
       }
       else {
           uiState.value =
               uiState.value.copy(calculationExpression = "${uiState.value.firstNumber} ${uiState.value.currentOperator.symbol}")
       }
   }
    private fun myDecimalFormater( input : Double) : String = DecimalFormat("###.#").format(input)
}