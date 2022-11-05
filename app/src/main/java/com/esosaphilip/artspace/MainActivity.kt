package com.esosaphilip.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esosaphilip.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtDisplay()

                }
            }
        }
    }
}

@Composable
fun ArtDisplay() {
    var result by rememberSaveable { mutableStateOf(1)}
    Column(modifier = Modifier.fillMaxHeight(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        when (result ) {
            // Update states to show the second artwork.
            1 ->  Art(painterResource(R.drawable.basel2), stringResource(R.string.basel2),2022)

            // Update states to show the third artwork.
            2 -> Art(painterResource(R.drawable.nft_art_1), stringResource(R.string.image1),2024)

            // Update state to show the first artwork.

            else -> Art(painterResource(R.drawable.the_art_of_making_art_about_a_plague), stringResource(R.string.plague),2023)
        }
        Row(horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = { result -= if ( result in 2..3) 1 else 2 } ,
                modifier = Modifier.padding(3.dp)) {
                Text("Previous")
            }
            Button(onClick = { result += if (result in 1..3) 1 else 2 } ) {
                Text("Next")
            }
        }
    }


}
/**@Composable
fun ButtonArt() {

    Row() {
        Button(onClick = {if ( result == 1) result -= 1 else result == 1 } ,modifier = Modifier.padding(3.dp)) {
            Text("Previous")
        }
        Button(onClick = onButtonClick) {
            Text("Next")
        }
    }
}**/
@Composable
fun Art(image: Painter,
        name: String,
        year: Int) {

    Column(
        Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .border(1.dp, Color.Green, shape = RectangleShape),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement  = Arrangement.Center
        ) {

      Box() {
          Card(
              elevation = 5.dp,
              modifier = Modifier.border(1.dp,Color.Red,shape = RectangleShape)
          ) {
              Image(painter = image, contentDescription = null
              )
          }
      }
        Spacer(modifier = Modifier.size(6.dp))

        Card(elevation = 4.dp,
            modifier = Modifier.border(1.dp,Color.Blue,shape = RectangleShape)) {
            Column(modifier = Modifier.padding(4.dp)){
                Text(text = name,modifier = Modifier.padding(4.dp))
                Text(text = year.toString() )
            }

        }
        Spacer(modifier = Modifier.size(6.dp))






    }
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtDisplay()
    }
}