package com.example.jetpackcomponentcatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentcatalog.ui.CheckboxInfo
import com.example.jetpackcomponentcatalog.ui.theme.JetpackComponentCatalogTheme

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
                    // State management for RadioButton on a Parent-Level.
                    var selected by rememberSaveable { mutableStateOf("Option 1") }

                    val titleList = GetOptions(listOf("Example 1", "Example 2", "Example 3"))

                    Column {
//                        MyTriStatusCheckbox()
//                        titleList.forEach {
//                            MyCheckBoxWithTextCompleted(it)
//                        }

//                        MyRadioButtonList(selected) { selected = it }

                        MyCard()
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
        MyCard()
//        MyCheckBox()
//        MyProgressBarAdvanced()
//        MyImageAdvanced()
//        MyButtonExample()
//        MyOutlinedTextField(name = "", onValueChanged = "")
    }
}

@Composable
fun MyCard() {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 12.dp,
        backgroundColor = Color.LightGray,
        border = BorderStroke(2.dp, Color.DarkGray)
    ) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Example 1")
            Text(text = "Example 2")
            Text(text = "Example 3")
        }
    }

}

@Composable
fun MyRadioButton() {
    RadioButton(
        selected = false, onClick = { }, colors = RadioButtonDefaults.colors(
            selectedColor = Color.Green,
            unselectedColor = Color.Red,
            disabledColor = Color.LightGray
        )
    )
}

@Composable
fun MyRadioButtonList(option: String, onItemSelected: (String) -> Unit) {

    Column(Modifier.fillMaxWidth()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = option == "Option 1", onClick = { onItemSelected("Option 1") })
            MyHorizontalSpacer(size = 8)
            Text("Option 1")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = option == "Option 2", onClick = { onItemSelected("Option 2") })
            MyHorizontalSpacer(size = 8)
            Text("Option 2")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = option == "Option 3", onClick = { onItemSelected("Option 3") })
            MyHorizontalSpacer(size = 8)
            Text("Option 3")
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(8.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            RadioButton(selected = option == "Option 4", onClick = { onItemSelected("Option 4") })
            MyHorizontalSpacer(size = 8)
            Text("Option 4")
        }
    }
}

@Composable
fun GetOptions(titles: List<String>): List<CheckboxInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckboxInfo(
            title = it,
            selected = status,
            onCheckedChange = { status = it }
        )
    }
}

@Composable
fun MyTriStatusCheckbox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    Row(
        Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        TriStateCheckbox(state = status, onClick = {
            status = when (status) {
                ToggleableState.On -> {
                    // Aqui se puede añadir logica para diferentes casos a traves de esta funcion lambda
                    ToggleableState.Off
                }
                ToggleableState.Off -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.On
            }
        })
        MyVerticalSpacer(size = 8)
        Text("Ejemplo Padre")
    }

}

@Composable
fun MyCheckBoxWithTextCompleted(checkboxInfo: CheckboxInfo) {

    Row(
        Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Checkbox(
            checked = checkboxInfo.selected,
            onCheckedChange = { checkboxInfo.onCheckedChange(!checkboxInfo.selected) })
        MyVerticalSpacer(size = 8)
        Text(checkboxInfo.title)
    }
}

@Composable
fun MyCheckBoxWithText() {

    var state by rememberSaveable { mutableStateOf(false) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {

        Row(Modifier.padding(8.dp)) {
            Checkbox(checked = state, onCheckedChange = { state = !state })
            MyVerticalSpacer(size = 8)
            Text("Ejercicio 1")
        }
    }
}

@Composable
fun MyCheckBox() {
    var state by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {
        Checkbox(
            checked = state, onCheckedChange = { state = !state }, colors = CheckboxDefaults.colors(
                checkedColor = Color.Green,
                uncheckedColor = Color.Red,
                checkmarkColor = Color.Black
            )
        )
    }
}

@Composable
fun MySwitch() {

    var switchState by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.End
    ) {

        Switch(
            checked = switchState,
            onCheckedChange = { switchState = !switchState },
            enabled = true,
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.Red,
                uncheckedTrackAlpha = 0.3f,
                uncheckedTrackColor = Color.Yellow,
                checkedTrackColor = Color.Yellow,
                checkedThumbColor = Color.Red,
                checkedTrackAlpha = 0.8f,
                disabledCheckedThumbColor = Color.DarkGray,
                disabledCheckedTrackColor = Color.DarkGray,
                disabledUncheckedThumbColor = Color.DarkGray,
                disabledUncheckedTrackColor = Color.DarkGray
            )
        )
    }

}

@Composable
fun MyProgressBarAdvanced() {

    var myProgressCount by rememberSaveable { mutableStateOf(0.5f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress = myProgressCount)

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceAround) {
            Button(onClick = { myProgressCount += 0.1f }) {
                Text("Button plus")
            }
            Button(onClick = { myProgressCount -= 0.1f }) {
                Text("Button less")
            }
        }
    }

}

@Composable
fun MyProgressBar() {

    var showLoading by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        if (showLoading) {

            CircularProgressIndicator(color = Color.Magenta, strokeWidth = 6.dp)
            LinearProgressIndicator(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .height(12.dp),
                color = Color.Red, backgroundColor = Color.Black
            )
        }

        Button(onClick = { showLoading = !showLoading }) {
            Text("Cargar Perfil")
        }
    }
}

@Composable
fun MyIcon() {

    // To download the complete library from google resources, add this to gradle file implementation:
    // implementation "androidx.compose.material:material-icons-extended:$compose_version"
    Icon(
        imageVector = Icons.Outlined.StarOutline,
        contentDescription = "Icon Star",
        tint = Color.Blue
    )
}

@Composable
fun MyImageAdvanced() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Advanced Example",
        modifier = Modifier
            .clip(RoundedCornerShape(25f))
            .border(2.dp, Color.DarkGray, shape = RoundedCornerShape(25f))
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.5f
    )
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

    Column(
        modifier = Modifier
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

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.width(120.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Cyan,
                contentColor = Color.Magenta,
                disabledBackgroundColor = Color.LightGray,
                disabledContentColor = Color.DarkGray
            ),
            border = BorderStroke(3.dp, Color.Black),

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


