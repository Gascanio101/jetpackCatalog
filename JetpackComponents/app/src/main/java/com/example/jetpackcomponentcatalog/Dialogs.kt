package com.example.jetpackcomponentcatalog

import android.app.Dialog
import android.graphics.drawable.Drawable
import android.util.Log.d
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {

    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                MyDialogTitle(title = "Phone ringtone", modifier = Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 2.dp)
                var status by rememberSaveable { mutableStateOf("") }
                MyRadioButtonList(status) {status = it}
                Divider(Modifier.fillMaxWidth(), color = Color.LightGray, thickness = 2.dp)
                Row(
                    Modifier
                        .fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                    TextButton(onClick = { }) {
                        Text("Cancel")
                    }
                    TextButton(onClick = { }) {
                        Text("Select")
                    }
                }
            }
        }
    }

}

@Composable
fun MyCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {
                MyDialogTitle("Set backup account")
                AccountItem("Example1@gmail.com", R.drawable.avatar)
                AccountItem("Example2@gmail.com", R.drawable.avatar)
                AccountItem("Add new user", R.drawable.add)
            }
        }
    }

}

@Composable
fun MySimpleCustomDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
        ) {
            Column(
                Modifier
                    .padding(24.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray)
            ) {
                Text("Example")
            }
        }
    }
}

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text("Titulo") },
            text = { Text("Esto es la descripcion") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text("Dismiss")
                }
            })
    }
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Profile picture",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            color = Color.Black,
            fontSize = 16.sp,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyDialogTitle(title: String, modifier: Modifier = Modifier.padding(bottom = 16.dp)) {
    Text(
        text = title,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
        modifier = modifier
    )
}