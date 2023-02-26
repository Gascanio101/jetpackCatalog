package com.example.jetpackcomponentcatalog

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentcatalog.ui.model.Superhero

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Gabs", "Adri", "Joan", "Pepe", "Amparo")
    LazyColumn (){
        item { Text("Header") }
        items(myList) {
            Text("My name is $it")
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyRow (horizontalArrangement = Arrangement.spacedBy(8.dp)){
        items(getSuperHeroeList()) {
            HeroItem(it)
            { Toast.makeText(context, it.heroName, Toast.LENGTH_SHORT).show() }
        }
    }
}

@Composable
fun HeroItem(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier.width(200.dp).clickable { onItemSelected(superhero) }) {
        Column() {
            Image(
                painter = painterResource(superhero.image),
                contentDescription = "Hero avatar",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superhero.heroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superhero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superhero.publisher,
                modifier = Modifier.align(Alignment.End).padding(end = 16.dp, bottom = 16.dp),
                fontSize = 10.sp
            )
        }
    }
}

fun getSuperHeroeList(): List<Superhero> {
    return listOf(
        Superhero("Spiderman", "Peter Parker", "Marvel", R.drawable.spiderman),
        Superhero("Wolverine", "James Howlett", "Marvel", R.drawable.logan),
        Superhero("Batman", "Bruce Wayne", "DC", R.drawable.batman),
        Superhero("Thor", "Thor Odinson", "Marvel", R.drawable.thor),
        Superhero("Flash", "Jay Garrick", "DC", R.drawable.flash),
        Superhero("Green Lantern", "Alan Scott", "DC", R.drawable.green_lantern),
        Superhero("Wonder Woman", "Princess Diana", "DC", R.drawable.wonder_woman)
    )
}