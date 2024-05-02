package com.baroni.myapplication.screens

import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.baroni.myapplication.MainViewModel
import com.baroni.myapplication.R
import com.baroni.myapplication.SpeechRecognizerContract
import com.baroni.myapplication.repositories.RestaurantsRepository
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

@Composable
@ExperimentalMaterial3Api
@OptIn(ExperimentalPermissionsApi::class)
fun TalkScreen(
    viewModel: MainViewModel = viewModel(),
    contentPadding: PaddingValues,
    restaurantName: String?,
    onTitleChanged: (String) -> Unit,
    onNavigateToExplore: () -> Unit,
) {
    onTitleChanged("$restaurantName")
    RestaurantsRepository().getRestaurant(restaurantName!!)
        ?.let { restaurant ->


            MainScreen1(list = restaurant.word, listGrande = restaurant.prhase, listImage = restaurant.images )





                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {


                    // This will push the buttons to the bottom
                    Spacer(modifier = Modifier.weight(1f))



                }
            }

        }














fun createHighLightText(str :String,boldStr : String): AnnotatedString {

    val annotatedString = buildAnnotatedString {

        val startIndex = str.indexOf(boldStr,0,true)
        val endIndex = startIndex + boldStr.length
        append(str)
        addStyle(style = SpanStyle(color = Color.Red), start = startIndex, end = endIndex)
    }

    return annotatedString

}

@Composable
@ExperimentalMaterial3Api
@OptIn(ExperimentalPermissionsApi::class)
fun MainScreen1(
    viewModel: MainViewModel = viewModel(),
    list: List<String>,
    listGrande: List<String>,
    listImage: List<String>
) {



    val images = listImage
    val words = list
    val phases =listGrande
    val state = viewModel.state.value
    val context = LocalContext.current
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    var expanded by remember {
        mutableStateOf(false)
    }

    var text by remember { mutableStateOf(words[selectedIndex]) }
    var phrase by remember { mutableStateOf(phases[selectedIndex]) }
    var image  by remember { mutableStateOf(images[selectedIndex]) }



    Box(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.BottomCenter)
    ) {

    }





    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

       // ElevatedCard(createHighLightText(text,text),50)


        //Text(text)
        viewModel.onTextFieldValueChange(text)
        viewModel.onTextFieldValueChangeBig(phrase)

        Spacer(modifier = Modifier.height(50.dp))


        val destaque =  createHighLightText(phrase, text)



        Spacer(modifier = Modifier.height(5.dp))


        Text(
            text = words[selectedIndex],
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = { expanded = true })
                .padding(top = 4.dp, bottom = 16.dp)
        )
        DropdownMenu(
            expanded = expanded, onDismissRequest = { expanded = false },
            Modifier
                .fillMaxWidth()
        ) {
            words.forEachIndexed { index, s ->
                DropdownMenuItem(
                    onClick = {
                        selectedIndex = index
                        expanded = false
                        text = words[selectedIndex]
                        phrase = phases[selectedIndex]

                    },
                    text = {
                        Card(
                            modifier = Modifier
                                .padding(4.dp)
                                .fillMaxSize(),
                            colors = CardDefaults.cardColors(
                                MaterialTheme.colorScheme.background
                            )
                        ) {
                            Text(text = s)

                        }

                    }
                )

            }

        }



        Row {


            Button(onClick = {

                selectedIndex--

                text = words[selectedIndex]
                phrase = phases[selectedIndex]

            }) {

                Text("<-")
            }


           ElevatedCard(destaque,180)



            Button(onClick = {

                selectedIndex++

                text = words[selectedIndex]
                phrase = phases[selectedIndex]

            }) {

                Text("->" +
                        "" +
                        "")
            }




        }

        Spacer(modifier = Modifier.height(9.dp))
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(images[0])
                .crossfade(true)
                .build(),
            contentDescription = stringResource(R.string.mars_photo),
            // error = painterResource(R.drawable.ic_broken_image),
            // placeholder = painterResource(R.drawable.loading_img),
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(CircleShape))


        Row {




            Button(
                onClick = {
                    viewModel.textToSpeech(context)
                }, enabled = state.isButtonEnabled
            ) {
                Text(text = "Ouvir a palavra")
            }






            Button(
                onClick = {
                    viewModel.textToSpeechBig(context)
                }, enabled = state.isButtonEnabled
            ) {
                Text(text = "Ouvir o Texto")
            }



        }
        Spacer(modifier = Modifier.height(5.dp))






        MainScreen2()




    }
}

@Composable
private fun dropDown(
    words: List<String>,
    selectedIndex: Int,
    text: String,
    phrase: String,
    phases: List<String>
) {

    var expanded1 by remember {
        mutableStateOf(false)
    }
    var selectedIndex1 = selectedIndex
    var text1 = text
    var phrase1 = phrase
    Text(
        text = words[selectedIndex1],
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleLarge,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { expanded1 = true })
            .padding(top = 4.dp, bottom = 16.dp)
    )
    DropdownMenu(
        expanded = expanded1, onDismissRequest = { expanded1 = false },
        Modifier
            .fillMaxWidth()
    ) {
        words.forEachIndexed { index, s ->
            DropdownMenuItem(
                onClick = {
                    selectedIndex1 = index
                    expanded1 = false
                    text1 = words[selectedIndex1]
                    phrase1 = phases[selectedIndex1]

                },
                text = {
                    Card(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            MaterialTheme.colorScheme.background
                        )
                    ) {
                        Text(text = s)

                    }

                }
            )

        }

    }
}

@Composable
fun ElevatedCard(text: AnnotatedString, heightPass: Int) {
    androidx.compose.material3.ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = heightPass.dp)
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
@ExperimentalMaterial3Api
@OptIn(ExperimentalPermissionsApi::class)
fun MainScreen2(viewModel: MainViewModel = viewModel()) {

    val permissionState = rememberPermissionState(
        permission = Manifest.permission.RECORD_AUDIO
    )
    SideEffect {
        permissionState.launchPermissionRequest()
    }

    val speechRecognizerLauncher = rememberLauncherForActivityResult(
        contract = SpeechRecognizerContract(),
        onResult = {
            viewModel.changeTextValue(it.toString())
        }
    )


    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        // Spacer(modifier = Modifier.height(45.dp))

        Button(onClick = {
            if (permissionState.status.isGranted) {
                speechRecognizerLauncher.launch(Unit)
            } else
                permissionState.launchPermissionRequest()
        }) {
            Text(text = "Speak")
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (viewModel.correto()) {
            Text(
                text = viewModel.state2.text,
                fontSize = 24.sp
            )
        } else {
            Text(
                text = createHighLightText(viewModel.state2.text, viewModel.state2.text),
                fontSize = 24.sp
            )
        }


    }


}

