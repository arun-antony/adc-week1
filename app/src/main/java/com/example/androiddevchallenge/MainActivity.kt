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

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.DogItem
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val repository = Repository()
        setContent {
            MyTheme {
                MyApp(repository.getSampleData(), ::onItemClicked)
            }
        }
    }

    private fun onItemClicked(item: DogItem) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("data", item)
        startActivity(intent)
    }
}

// Start building your app here!
@Composable
fun MyApp(list: List<DogItem>, itemClicked: ((dogItem: DogItem) -> Unit)? = null) {
    Surface(color = colors.background) {

        Scaffold(
            topBar = {
                TopAppBar(title = { Text(stringResource(R.string.label_app_name)) })
            },
            content = {
                BodyContent(list, itemClicked = itemClicked)
            }
        )
    }
}

@Composable
fun BodyContent(list: List<DogItem>, itemClicked: ((dogItem: DogItem) -> Unit)?) {
    val scrollState = rememberLazyListState()
    LazyColumn(state = scrollState, modifier = Modifier.padding(12.dp)) {

        items(list) {
            PetItemCard(it, itemClicked)
        }
    }
}

@Composable
fun PetItemCard(it: DogItem, clicked: ((dogItem: DogItem) -> Unit)?) {
    Row(
        modifier = Modifier
            .padding(top = 0.dp, start = 0.dp, end = 0.dp, bottom = 12.dp)
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(colors.secondary)
            .clickable {
                clicked?.invoke(it)
            }
    ) {
        Surface(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterVertically),
            color = Color.LightGray
        ) {
            CoilImage(
                data = it.imageUrl ?: "",
                contentDescription = "",
                fadeIn = true,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp),
                error = {
                    Image(
                        painter = painterResource(R.drawable.ic_baseline_broken_image_24),
                        null,
                        alignment = Alignment.Center
                    )
                }
            )
        }
        Column(
            modifier = Modifier
                .padding(8.dp)
                .align(Alignment.Top)
        ) {
            Text(it.name ?: "", fontWeight = FontWeight.Black)
            Text(it.type ?: "", fontWeight = FontWeight.Light)
            Text(
                it.location ?: "",
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp(Repository().getSampleData())
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp(Repository().getSampleData())
    }
}
