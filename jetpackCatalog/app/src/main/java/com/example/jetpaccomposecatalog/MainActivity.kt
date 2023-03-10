package com.example.jetpaccomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.example.jetpaccomposecatalog.ui.theme.JetpacComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpacComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    MyBox(name = "Android")
//                    MyColumn()
                    MyRow()
                }
            }
        }
    }
}

@Composable
fun MyColumn() {
    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
        ,verticalArrangement = Arrangement.SpaceAround ) {
        Text("Example 01", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Red)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .height(50.dp))
        Text("Example 01", modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .height(50.dp))
    }
}

@Composable
fun MyRow() {
    Row(modifier = Modifier
        .background(Color.Yellow)
        .fillMaxWidth()
        .height(120.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Box(modifier = Modifier
            .fillMaxHeight()
            .width(240.dp)
            .background(Color.DarkGray),
            contentAlignment = Alignment.Center) {
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround) {

                Box(modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(Color.Cyan), contentAlignment = Alignment.Center) {
                    Text("Left Box")
                }
                Box(modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
                    .background(Color.Cyan), contentAlignment = Alignment.Center) {
                    Text("Right Box")
                }
            }
        }
    }
}

@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue), contentAlignment = Alignment.Center) {
        // Box(modifier = Modifier.width(50.dp).height(50.dp).background(Color.Cyan))
        Box(modifier = Modifier
            .height(200.dp)
            .width(200.dp)
            .background(Color.Cyan)
            .verticalScroll(
                rememberScrollState()
            ), contentAlignment = Alignment.Center) {
            Text("Fullfill my needs")
        }
    }
}

@Composable
fun MyComplexLayout() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .background(Color.Cyan)
            .fillMaxWidth()
            .weight(1f), contentAlignment = Alignment.Center) {
            Text("Example 1")
        }
        MyHeightSpacer(size = 40)
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)) {
            Box(modifier = Modifier
                .background(Color.Red)
                .fillMaxHeight()
                .weight(1f), contentAlignment = Alignment.Center) {
                Text("Example 2")
            }
            Box(modifier = Modifier
                .background(Color.Green)
                .fillMaxHeight()
                .weight(1f), contentAlignment = Alignment.Center) {
                Text("Example 3")
            }
        }
        MyHeightSpacer(size = 40)
        Box(modifier = Modifier
            .background(Color.Magenta)
            .fillMaxWidth()
            .weight(1f), contentAlignment = Alignment.BottomCenter) {
            Text("Example 4")
        }
    }
    Box(modifier = Modifier.fillMaxWidth())
}

@Composable
fun MyHeightSpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyWidthSpacer(size: Int) {
    Spacer(modifier = Modifier.width(size.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpacComposeCatalogTheme {
        MyComplexLayout()
//        MyRow()
//        MyBox("Android")
//        MyColumn()
    }
}