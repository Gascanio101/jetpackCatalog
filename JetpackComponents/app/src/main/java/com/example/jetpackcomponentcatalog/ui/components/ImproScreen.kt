package com.example.jetpackcomponentcatalog.ui.components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.jetpackcomponentcatalog.MyHorizontalSpacer
import com.example.jetpackcomponentcatalog.MyVerticalSpacer
import com.example.jetpackcomponentcatalog.R
import com.example.jetpackcomponentcatalog.ui.Starred
import com.example.jetpackcomponentcatalog.ui.theme.Shapes
import kotlinx.coroutines.NonDisposableHandle.parent

@Composable
fun MyComplexLayout() {
    Column(
        Modifier
            .padding(8.dp)
            .verticalScroll(state = ScrollState(0), enabled = true, reverseScrolling = false)
            .background(Color.LightGray, shape = CircleShape)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .background(Color.Blue, shape = CircleShape)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            MyHorizontalSpacer(size = 24)
            Column(
                Modifier
                    .fillMaxHeight()
                    .background(Color.Green),
                horizontalAlignment = Alignment.Start
            ) {
                ConstraintContent()
            }
            MyHorizontalSpacer(size = 8)
            Icon(imageVector = Icons.Rounded.Star, contentDescription = "Star", tint = Color.White)
            MyHorizontalSpacer(size = 24)
        }
    }
}

@Preview
@Composable
fun MyComplexPreview() {
    MyComplexLayout()
//    ConstraintContent()
}

@Composable
fun ConstraintContent() {

    ConstraintLayout(Modifier.fillMaxHeight()) {
        val (nameText, surnameText, divider) = createRefs()
        Text("Name", Modifier.constrainAs(nameText) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
        }, color = Color.White)
        Divider(
            Modifier
//                .padding(rstart = 4.dp, end = 4.dp)
                .constrainAs(divider) {
                    start.linkTo(nameText.start)
                    end.linkTo(surnameText.end)
                }, color = Color.White, thickness = 2.dp
        )
        Text("Surname", Modifier.constrainAs(surnameText) {
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
        }, color = Color.White)
        val textChain =
            createVerticalChain(nameText, divider, surnameText, chainStyle = ChainStyle.Spread)
    }
}

/*
    Create a row with various UI elements (Favourite icon, 2 texts one above the other)
*/

/*
@Composable
fun RandomIcon() {
    Icons.Rounded.forEach
}*/
