    package com.example.calculatrice.ui.theme
    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxHeight
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.width
    import androidx.compose.material.icons.Icons
    import androidx.compose.material3.Icon
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.graphics.vector.ImageVector
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.text.TextStyle
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.lifecycle.viewmodel.viewModelFactory
    import java.text.DecimalFormat


    @Composable
    fun CalculatorScreen(viewModel: CalculatorViewModel =androidx.lifecycle.viewmodel.compose.viewModel() ) {
        val uiState  = viewModel.uiState
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier.fillMaxWidth()
                    .weight(2f)
            )
            Column(
                modifier = Modifier.fillMaxWidth()
                    .weight(4f)
                    .padding(8.dp)
                    .align(alignment = Alignment.End)
            )
            {
                Text(
                    text = uiState.value.calculationExpression ,
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 30.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.End
                    )
                )
                Text(
                    text = if(uiState.value.answer.isNotEmpty())  DecimalFormat("###.#").format(uiState.value.answer.toDouble())
                    else if(uiState.value.currentOperator==CalculationOperator.NONE) DecimalFormat("###.#").format(uiState.value.firstNumber.toDouble())
                    else DecimalFormat("###.#").format(uiState.value.secondNumber.toDouble() ),
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 60.sp,
                        textAlign = TextAlign.End
                    )
                )
            }
            Spacer(modifier  = Modifier.height(16.dp))
            Column(modifier =  Modifier.fillMaxWidth().weight(6f).padding(16.dp)){
                Row(modifier =Modifier.fillMaxWidth().weight(1f) ,
                    verticalAlignment = Alignment.CenterVertically) {
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "CA",
                        isHeighlight = true,
                        onActionCalculator = {viewModel.onUiEvent(UiEvent.OnClearAll)}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "/",
                        isHeighlight = true,
                        onActionCalculator = {/*onActionCalculator*/}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "X",
                        isHeighlight = true,
                        onActionCalculator = {/*onActionCalculator*/}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                    character = "CLR",
                    isHeighlight = true,
                    onActionCalculator = {viewModel.onUiEvent(UiEvent.OnClear)}
                    )

                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier =Modifier.fillMaxWidth().weight(1f) ,
                    verticalAlignment = Alignment.CenterVertically) {
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "7",
                        isHeighlight = true,
                        onActionCalculator = {viewModel.onUiEvent(UiEvent.On7Clicked)}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "8",
                        isHeighlight = true,
                        onActionCalculator = {viewModel.onUiEvent(UiEvent.On8Clicked)}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "9",
                        isHeighlight = true,
                        onActionCalculator = {viewModel.onUiEvent(UiEvent.On9Clicked)}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "-",
                        isHeighlight = true,
                        onActionCalculator = {/*onActionCalculator*/}
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier =Modifier.fillMaxWidth().weight(1f) ,
                    verticalAlignment = Alignment.CenterVertically) {
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "4",
                        isHeighlight = true,
                        onActionCalculator ={viewModel.onUiEvent(UiEvent.On4Clicked)}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "5",
                        isHeighlight = true,
                        onActionCalculator = {viewModel.onUiEvent(UiEvent.On5Clicked)}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "6",
                        isHeighlight = true,
                        onActionCalculator = {viewModel.onUiEvent(UiEvent.On6Clicked)}
                    )
                    ActionCalculator(modifier = Modifier.weight(1f),
                        character = "+",
                        isHeighlight = true,
                        onActionCalculator = {/*onActionCalculator*/}
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(modifier =Modifier.fillMaxWidth().weight(2f) ,
                    verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(3f)){
                        Row(modifier = Modifier.fillMaxWidth().weight(1f)){
                            ActionCalculator(modifier = Modifier.weight(1f),
                                character = "1",
                                isHeighlight = true,
                                onActionCalculator = {viewModel.onUiEvent(UiEvent.On1Clicked)}
                            )
                            ActionCalculator(modifier = Modifier.weight(1f),
                                character = "2",
                                isHeighlight = true,
                                onActionCalculator = {viewModel.onUiEvent(UiEvent.On2Clicked)}
                            )
                            ActionCalculator(modifier = Modifier.weight(1f),
                                character = "3",
                                isHeighlight = true,
                                onActionCalculator = {viewModel.onUiEvent(UiEvent.On3Clicked)}
                            )
                        }
                        Row(modifier = Modifier.fillMaxWidth().weight(1f), ){
                            ActionCalculator(modifier = Modifier.weight(3f),
                                character = "0",
                                isHeighlight = true,
                                onActionCalculator = {viewModel.onUiEvent(UiEvent.On0Clicked)}
                            )
                        }
                    }
                    Box(modifier = Modifier.fillMaxHeight().weight(1f)){
                        Box(modifier =Modifier.fillMaxHeight(0.8f).width(60.dp).background(color=MaterialTheme.colorScheme.secondary).align(Alignment.Center).clickable {}) {
                            Text(text="=",
                                modifier = Modifier.align(Alignment.Center) ,
                                style= TextStyle(color = Color.White,fontSize = 30.sp))
                        }
                    }
                }



            }

        }
    }
 @Composable
 fun ActionCalculator (modifier: Modifier = Modifier,
                       character: String? = null,
                       icon: ImageVector? = null,
                       isHeighlight: Boolean = false,
                       onActionCalculator: () -> Unit){
     Box(modifier = modifier.size(60.dp).clickable { onActionCalculator() }, ){
         if(icon != null){
             Icon(imageVector = icon, contentDescription = "icon de description", tint = MaterialTheme.colorScheme.secondary)
         }
         else {
             Text(modifier =Modifier.align(Alignment.Center),
                 text = character !!,
                 style = TextStyle(fontSize = 30.sp , color = if (isHeighlight) MaterialTheme.colorScheme.secondary else Color.Black))
         }
     }

 }
    @Preview(showBackground = true)
    @Composable
    fun CalculatorScreenPreview(){
        CalculatorScreen()
    }