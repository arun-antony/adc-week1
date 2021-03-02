/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.androiddevchallenge.model.DogItem
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent?.getParcelableExtra<DogItem>("data")
        setContent {
            MyTheme {
                DetailPage(data, ::finish)
            }
        }
    }
}

@Composable
fun DetailPage(data: DogItem?, finishActivity: (() -> Unit)?) {
    Surface(color = colors.background) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(data?.name ?: "Woof Woof") },
                    navigationIcon = {
                        IconButton(onClick = { finishActivity?.invoke() }) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    },
                    actions = {
                        IconButton(onClick = { }) {
                            Icon(Icons.Filled.FavoriteBorder, null)
                        }
                    }
                )
            },
            content = {
                DetailContent(data)
            }
        )
    }
}

@Composable
fun DetailContent(data: DogItem?) {
    Column {

        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f)
        ) {

            val (imageHolder, image, buttonAdopt) = createRefs()
            Surface(
                modifier = Modifier.constrainAs(imageHolder) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                }.fillMaxHeight().fillMaxWidth(),
                color = Color.LightGray
            ) {
                CoilImage(
                    data = data?.imageUrl ?: "",
                    contentDescription = data?.name,
                    fadeIn = true,
                    contentScale = ContentScale.Crop,
                    error = {
                        Image(
                            painter = painterResource(R.drawable.ic_baseline_broken_image_24),
                            null,
                            alignment = Alignment.Center
                        )
                    },
                    modifier = Modifier.constrainAs(image) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }.fillMaxHeight().fillMaxWidth()
                )
            }

            Button(
                onClick = {},
                modifier = Modifier
                    .constrainAs(buttonAdopt) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }.padding(12.dp)
                    .fillMaxWidth()
                    .height(50.dp)
                    .alpha(0.8f)
                    .background(colors.primary, shape = RectangleShape)
            ) {
                Text(
                    text = stringResource(R.string.button_label_adopt_me),
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.button,
                )
            }
        }

        Text(
            text = data?.type ?: "",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)
        )

        Text(
            text = data?.description ?: "",
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)
        )

        DetailDataRow(stringResource(R.string.caption_image_courtesy), data?.owner ?: "")
        DetailDataRow(stringResource(R.string.caption_location), data?.location ?: "")

        Spacer(Modifier.height(12.dp))
    }
}

@Composable
fun DetailDataRow(title: String, dataValue: String) {
    Divider(modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp))

    Text(
        text = title,
        style = MaterialTheme.typography.caption,
        modifier = Modifier.padding(start = 12.dp, top = 12.dp, end = 12.dp)
    )

    Text(
        text = dataValue,
        modifier = Modifier.padding(start = 12.dp, top = 6.dp, end = 12.dp)
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailLightPreview() {
    MyTheme {
        DetailPage(Repository().getSampleData()[0], null)
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DetailDarkPreview() {
    MyTheme(darkTheme = true) {
        DetailPage(Repository().getSampleData()[0], null)
    }
}
