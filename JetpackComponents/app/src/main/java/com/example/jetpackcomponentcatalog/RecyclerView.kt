package com.example.jetpackcomponentcatalog

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomponentcatalog.ui.model.Superhero
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroStickyView() {
    val context = LocalContext.current
    val superhero: Map<String, List<Superhero>> = getSuperHeroeList().groupBy { it.publisher }
    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        superhero.forEach { publisher, superhero ->
            stickyHeader {
                Text(text = publisher, modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(vertical = 4.dp), fontSize = 20.sp, textAlign = TextAlign.Center)
            }

            items(superhero) {
                HeroItem(it)
                { Toast.makeText(context, it.heroName, Toast.LENGTH_SHORT).show() }
            }
        }
    }
}

@Composable
fun SimpleRecyclerView() {
    val myList = listOf("Gabs", "Adri", "Joan", "Pepe", "Amparo")
    LazyColumn() {
        item { Text("Header") }
        items(myList) {
            Text("My name is $it")
        }
    }
}

@Composable
fun SuperHeroView() {
    val context = LocalContext.current
    LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(getSuperHeroeList()) {
            HeroItem(it)
            { Toast.makeText(context, it.heroName, Toast.LENGTH_SHORT).show() }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroWithStateControlView() {
    val context = LocalContext.current
    val rvState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Column {
        LazyColumn(
            state = rvState, verticalArrangement = Arrangement.spacedBy(4.dp), modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(getSuperHeroeList()) {
                HeroItem(it)
                { Toast.makeText(context, it.heroName, Toast.LENGTH_SHORT).show() }
            }
        }
        val showButton by remember {
            derivedStateOf {
                rvState.firstVisibleItemIndex > 0
            }
        }
        if (showButton) {
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        rvState.animateScrollToItem(0)
                    }
                }, modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Text("Go back to the top")
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SuperHeroGridView() {
    val context = LocalContext.current

    LazyVerticalGrid(cells = GridCells.Fixed(2), content = {
//    LazyVerticalGrid(cells = GridCells.Adaptive(100.dp), content = {

        items(getSuperHeroeList()) {
            HeroItem(it)
            { Toast.makeText(context, it.heroName, Toast.LENGTH_SHORT).show() }
        }
    })
}

@Composable
fun HeroItem(superhero: Superhero, onItemSelected: (Superhero) -> Unit) {
    Card(border = BorderStroke(2.dp, Color.Red), modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp)
        .clickable { onItemSelected(superhero) }) {
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
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 16.dp, bottom = 16.dp),
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