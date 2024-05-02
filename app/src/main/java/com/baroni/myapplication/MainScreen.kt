package com.baroni.myapplication

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import android.Manifest
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.clickable
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@ExperimentalMaterial3Api
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()

) {


        MainScreen1()
   // Spacer(modifier = Modifier.height(30.dp))


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
    fun MainScreen1(viewModel: MainViewModel = viewModel()) {

        val christianWords = listOf(
            "God",
            "Jesus",
            "Faith",
            "Grace",
            "Bible",
            "Prayer",
            "Church",
            "Salvation",
            "Cross",
            "Love",
            "Redemption",
            "Atonement",
            "Resurrection",
            "Holy Spirit",
            "Sin",
            "Repentance",
            "Heaven",
            "Eternal Life",
            "Savior",
            "Worship"
        )

        val christianPhrases = listOf(
            "John 3:16 - For God so loved the world, that he gave his only Son, that whoever believes in him should not perish but have eternal life.",
            "Matthew 28:19 - Go therefore and make disciples of all nations, baptizing them in the name of the Father and of the Son and of the Holy Spirit.",
            "Hebrews 11:1 - Now faith is the assurance of things hoped for, the conviction of things not seen.",
            "Ephesians 2:8 - For by grace you have been saved through faith. And this is not your own doing; it is the gift of God.",
            "Psalm 119:105 - Your word is a lamp to my feet and a light to my path.",
            "Philippians 4:6-7 - Do not be anxious about anything, but in everything by prayer and supplication with thanksgiving let your requests be made known to God. And the peace of God, which surpasses all understanding, will guard your hearts and your minds in Christ Jesus.",
            "Matthew 18:20 - For where two or three are gathered in my name, there am I among them.",
            "Romans 10:9 - Because, if you confess with your mouth that Jesus is Lord and believe in your heart that God raised him from the dead, you will be saved.",
            "1 Corinthians 1:18 - For the word of the cross is folly to those who are perishing, but to us who are being saved, it is the power of God.",
            "1 Corinthians 13:13 - So now faith, hope, and love abide, these three; but the greatest of these is love.",
            "Ephesians 1:7 - In him we have redemption through his blood, the forgiveness of our trespasses, according to the riches of his grace.",
            "Romans 5:11 - More than that, we also rejoice in God through our Lord Jesus Christ, through whom we have now received reconciliation.",
            "1 Corinthians 15:3-4 - For I delivered to you as of first importance what I also received: that Christ died for our sins in accordance with the Scriptures, that he was buried, that he was raised on the third day in accordance with the Scriptures.",
            "John 14:26 - But the Helper, the Holy Spirit, whom the Father will send in my name, he will teach you all things and bring to your remembrance all that I have said to you.",
            "Acts 3:19 - Repent therefore, and turn back, that your sins may be blotted out.",
            "Revelation 21:4 - He will wipe away every tear from their eyes, and death shall be no more, neither shall there be mourning, nor crying, nor pain anymore, for the former things have passed away.",
            "John 11:25-26 - Jesus said to her, 'I am the resurrection and the life. Whoever believes in me, though he die, yet shall he live, and everyone who lives and believes in me shall never die. Do you believe this?'",
            "John 3:5 - Jesus answered, 'Truly, truly, I say to you, unless one is born of water and the Spirit, he cannot enter the kingdom of God.'",
            "Psalm 95:6 - Oh come, let us worship and bow down; let us kneel before the Lord, our Maker!"
        )

        val words = christianWords
        val state = viewModel.state.value
        val context = LocalContext.current
        var selectedIndex by remember {
            mutableStateOf(0)
        }
        var expanded by remember {
            mutableStateOf(false)
        }

        var text by remember { mutableStateOf(christianWords[selectedIndex]) }
        var phrase by remember { mutableStateOf(christianPhrases[selectedIndex]) }



        Box(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.BottomCenter)
        ) {

            Text(
                text = christianWords[selectedIndex],
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
                            text = christianWords[selectedIndex]
                            phrase = christianPhrases[selectedIndex]

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

            }}





            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                ElevatedCard(createHighLightText(text,text),50)


                //Text(text)
                viewModel.onTextFieldValueChange(text)

                Spacer(modifier = Modifier.height(12.dp))

                Row {


                    Button(onClick = {

                        selectedIndex--

                        text = christianWords[selectedIndex]
                        phrase = christianPhrases[selectedIndex]

                    }) {

                        Text("Preview")
                    }

                    Button(
                        onClick = {
                            viewModel.textToSpeech(context)
                        }, enabled = state.isButtonEnabled
                    ) {
                        Text(text = "Listen")
                    }

                    Button(onClick = {

                        selectedIndex++

                        text = christianWords[selectedIndex]
                        phrase = christianPhrases[selectedIndex]

                    }) {

                        Text("next")
                    }

                }

                Spacer(modifier = Modifier.height(5.dp))

                val destaque =  createHighLightText(phrase, text)
                ElevatedCard(destaque,180)
                MainScreen2()


            }
        }

        @Composable
        fun ElevatedCard(text: AnnotatedString,heightPass: Int) {
            ElevatedCard(
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

