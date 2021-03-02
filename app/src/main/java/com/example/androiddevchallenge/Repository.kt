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

import com.example.androiddevchallenge.model.DogItem

class Repository {

    fun getSampleData(): List<DogItem> {
        // A domesticated asylum dog, //Zoki Photo
        val d1 = DogItem(
            "Rog",
            "German Shepherd",
            "A domesticated asylum dog. $loremIpsum",
            "Zoki Photo",
            "https://images.unsplash.com/photo-1586263374340-75d101b05f1a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80",
            "Sisak, Hrvatska"
        )

        // Short coated tan and white dog, Marcelo Harassen
        val d2 = DogItem(
            "Fluffy",
            "Pequinês",
            "Short coated tan and white dog. $loremIpsum",
            "Marcelo Harassen",
            "https://images.unsplash.com/photo-1571066470962-f10fcf2fdf9e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80",
            "Curitiba, PR, Brasil"
        )

        //
        val d3 = DogItem(
            "Whitey",
            "Siberian Husky",
            "White and black siberian husky. $loremIpsum",
            "Keytion",
            "https://images.unsplash.com/photo-1591900972995-97334a95c1ac?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80",
            "Irving, TX"
        )

        val d4 = DogItem(
            "Bully",
            "English Bull Dog",
            "Grey scale photo of an English Bull Dog. $loremIpsum",
            "David Manning",
            "https://images.unsplash.com/photo-1530100493986-978cbf8b782a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1082&q=80",
            "London, UK"
        )

        val d5 = DogItem(
            "Browny",
            "German Shepherd",
            "Short coated brown dog. $loremIpsum",
            "Alex Jones",
            "https://images.unsplash.com/photo-1526520112421-5054395689a9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80",
            "Manchester, UK"
        )

        val d6 = DogItem(
            "Sparky",
            "German Shepherd",
            "Brown short coated dog sitting on brown grass during daytime. $loremIpsum",
            "Alan Chen",
            "https://images.unsplash.com/photo-1601950620185-f9c6a84b2c15?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80",
            "Liverpool, UK"
        )

        val d7 = DogItem(
            "Cookie",
            "Beagle",
            "Tricolor beagle puppy on brick floor. $loremIpsum",
            "Sippakorn",
            "https://images.unsplash.com/photo-1582079313048-f13462814383?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80",
            "Thailand"
        )

        val d8 = DogItem(
            "Blacky",
            "Pug",
            "A black pug looking sad. $loremIpsum",
            "Toshi",
            "https://images.unsplash.com/photo-1537815749002-de6a533c64db?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1090&q=80",
            "Garland, TX"
        )

        val d9 = DogItem(
            "Jack",
            "Terrier",
            "A white and brown jack russel terrier mix sitting on brick pavement. $loremIpsum",
            "Juli Kosolapova",
            "https://images.unsplash.com/photo-1612877966217-eaa2cc09ad6e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1000&q=80",
            "Waco, TX"
        )

        val d10 = DogItem(
            "Goldy",
            "Labrador",
            "A yellow labrador retriever lying on the ground. $loremIpsum",
            "Ezequiel Garrido",
            "https://images.unsplash.com/photo-1610312287759-a7aae807b165?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=958&q=80",
            "Wilmer, TX"
        )

        return mutableListOf(d1, d2, d3, d4, d5, d6, d7, d8, d9, d10)
    }

    private val loremIpsum = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
}
