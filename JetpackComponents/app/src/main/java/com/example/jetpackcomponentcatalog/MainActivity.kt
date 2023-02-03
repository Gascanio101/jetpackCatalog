package com.example.jetpackcomponentcatalog

import android.graphics.Color.green
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentcatalog.ui.theme.JetpackComponentCatalogTheme
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComponentCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

//                    var myText by remember { mutableStateOf("") }

                    Column {
//                        MyOutlinedTextField(myText) { myText = it }
                        MyButtonExample()
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComponentCatalogTheme {
        MyButtonExample()
//        MyOutlinedTextField(name = "", onValueChanged = "")
    }
}

@Composable
fun MyVerticalSpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyHorizontalSpacer(size: Int) {
    Spacer(modifier = Modifier.width(size.dp))
}

@Composable
fun MyButtonExample() {

    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { enabled = false },
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Magenta,
                contentColor = Color.Blue
            ),
            modifier = Modifier.width(120.dp),
            border = BorderStroke(5.dp, Color.Green)
        ) {
            Text("Button!")
        }

        MyVerticalSpacer(size = 12)

        OutlinedButton(onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.width(120.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan,
                contentColor = Color.Magenta,
                disabledBackgroundColor = Color.LightGray,
                disabledContentColor = Color.DarkGray
            ), border = BorderStroke(3.dp, Color.Black),

            ) {

            Text("Outlined")

        }

        MyVerticalSpacer(size = 12)

        TextButton(onClick = { /*TODO*/ }) {
            Text("TextButton")
        }
    }

}

@Composable
fun MyText() {
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Hola Gabs")
        Text("Hola Gabs", color = Color.Blue)
        Text("Hola Gabs", fontWeight = FontWeight.ExtraBold)
        Text("Hola Gabs", fontWeight = FontWeight.Light)
        Text("Hola Gabs", fontFamily = FontFamily.Cursive)
        Text("Hola Gabs", style = TextStyle(textDecoration = TextDecoration.Underline))
        Text("Hola Gabs", style = TextStyle(textDecoration = TextDecoration.LineThrough))
        Text(
            "Hola Gabs", style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.LineThrough, TextDecoration.Underline)
                )
            )
        )
        Text(
            "Hola Gabs", textDecoration = TextDecoration.combine(
                listOf(TextDecoration.LineThrough, TextDecoration.Underline)
            ), fontSize = 30.sp, fontFamily = FontFamily.Cursive
        )
    }

}

@Composable
fun MyTextFieldAdvanced() {
    var myText by remember { mutableStateOf("") }
    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text("Introduce tu nombre") })
}

@Composable
fun MyOutlinedTextField(name: String, onValueChanged: (String) -> Unit) {

    OutlinedTextField(
        value = name,
        onValueChange = {
            onValueChanged(it)
        },
        modifier = Modifier.padding(24.dp),
        label = { Text(text = "Better Ui design, by Gabs") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Red,
            unfocusedBorderColor = Color.Black,
            focusedLabelColor = Color.Black,
            unfocusedLabelColor = Color.Red
        )
    )
}

@Composable
fun MyTextField(name: String, onValueChanged: (String) -> Unit) {

    // This is not the most efficient way:
    // The composable fun should avoid managing states, so we will recur to "State Hosting", as seen below:
/*    // Importar import androidx.compose.runtime.* para que funcione
    var myText by remember { mutableStateOf("") }
    TextField(value = myText, onValueChange = { myText = it })*/

    OutlinedTextField(value = name, onValueChange = { onValueChanged(it) })
}


