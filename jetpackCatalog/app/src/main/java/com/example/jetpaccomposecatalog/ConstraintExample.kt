package com.example.jetpaccomposecatalog.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

//@Preview
@Composable
fun ConstraintExample1() {



    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxRed, boxGreen, boxBlue, boxMagenta, boxYellow) = createRefs()

        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Red)
            .constrainAs(boxRed) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Green)
            .constrainAs(boxGreen) {
                top.linkTo(boxRed.bottom)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Blue)
            .constrainAs(boxBlue) {
                bottom.linkTo(boxRed.top)
                end.linkTo(boxRed.start)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Magenta)
            .constrainAs(boxMagenta) {
                bottom.linkTo(boxRed.top)
                start.linkTo(boxRed.end)
            })
        Box(modifier = Modifier
            .size(125.dp)
            .background(Color.Yellow)
            .constrainAs(boxYellow) {
                top.linkTo(boxRed.bottom)
                end.linkTo(boxRed.start)
            })
    }
}

//@Preview
@Composable
fun ConstraintExampleGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

//        Utilizar guias invisibles para anclar elementos a ellas.
//        Solo disponibles en Constraint Layouts

//        val guideTop = createGuidelineFromTop(16.dp)  // En "dp" no escala segun el dispositivo
        val guideTop = createGuidelineFromTop(0.1f)  // Porcentage adaptativo a diferentes pantallas
        val guideStart = createGuidelineFromStart(0.2f)

        val boxRed = createRef()

        Box(modifier = Modifier.size(125.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(guideTop)
            start.linkTo(guideStart)
        })

    }
}

//@Preview
@Composable
fun ConstraintBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (boxRed, boxGreen, boxYellow) = createRefs()
        val barrier = createEndBarrier(boxRed, boxGreen)

        Box(modifier = Modifier.size(125.dp).background(Color.Green).constrainAs(boxGreen){
            start.linkTo(parent.start, margin= 16.dp)
        })
        Box(modifier = Modifier.size(250.dp).background(Color.Red).constrainAs(boxRed){
            top.linkTo(boxGreen.bottom)
            start.linkTo(parent.start, margin = 32.dp)
        })
        Box(modifier = Modifier.size(50.dp).background(Color.Yellow).constrainAs(boxYellow){
            start.linkTo((barrier))
        })
    }
}


@Preview
@Composable
fun ConstraintChainExample() {

    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (redBox, greenBox, blueBox) = createRefs()
        createHorizontalChain(redBox, greenBox, blueBox, chainStyle = ChainStyle.Spread)

        Box(modifier = Modifier.size(75.dp).background(Color.Red).constrainAs(redBox){
            start.linkTo(parent.start)
            end.linkTo(greenBox.start)
        })
        Box(modifier = Modifier.size(75.dp).background(Color.Green).constrainAs(greenBox){
            start.linkTo(redBox.end)
            end.linkTo(blueBox.start)
        })
        Box(modifier = Modifier.size(75.dp).background(Color.Blue).constrainAs(blueBox){
            start.linkTo(greenBox.end)
            end.linkTo(parent.end)
        })
    }

}