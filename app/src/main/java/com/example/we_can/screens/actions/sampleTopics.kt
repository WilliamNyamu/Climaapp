package com.example.we_can.screens.actions

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Favorite
import com.example.we_can.R

val sampleTopics = listOf(
    Topic(
        title = "Reduce Food Wastage \uD83E\uDD6B",
        imageRes = R.drawable.food_stuff,
        description = "Reduce your personal food waste by using sustainable practices " +
                "and save precious resources and money" +
                "Food that ends up getting thrown away means wasted water \uD83C\uDF0A, land, and energy used in production and transportation." +
                "A massive amount of food is wasted per person each year. That adds up to some serious money \uD83E\uDD11 thrown into the bin \uD83D\uDEAE" +
                "If we minimize food waste as a society, we can save millions of dollars a year and take the equivalent of half a billion cars off the road." +
                "Be a part of that movement today and save the planet \uD83C\uDF0D",
        tips = listOf(
            "Shop wisely by planning meals, using lists, purchasing accurate quantities, and reducing impulse buys. This includes holiday meals",
            "Share extra food with family, friends, neighbours, and colleagues. You can also use the app Olio to give away unwanted food",
            "Share dishes at restaurants or take home the extras"
        ),
        icons = listOf(
            Icons.Filled.Add,
            Icons.Filled.CheckCircle,
            Icons.Filled.Favorite)
    ),
    Topic(
        title = "Clean Energy \uD83C\uDF90",
        imageRes = R.drawable.lamp_stand,
        description = "Take a big energy efficient step and change your light bulbs to LEDs as they go out." +
                "Collectively we save huge amounts of energy and pollution by doing this" +
                "LEDs last longer so that saves time from buying and changing them." + " Plus they save money from lower energy cod" +
                "A typical incandescent bulb will glow for about 1000 hours while LEDs hang in there for about 25,000 hours or more"
                ,

        tips = listOf(
            "Lighting accounts for about 20% annual household electricity bills so switching to more efficient LEDs adds up to meaningful savings over time",
            "LED bulbs are much cooler than most bulbs and thus present less of a fire and burn hazard",
            "Use renewable energy sources"
        ),
        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite
        )
    ),
    Topic(
        title = "E-BIKING \uD83D\uDEB4\uD83C\uDFFD",
        imageRes = R.drawable.e_bike,
        description = "Unlike gas-powered vehicles,\n" +
                " e-bikes don't produce tailpipe emissions that trap heat in the atmosphere and contribute to global warming.  While e-bikes do use battery power, electricity generation can be much cleaner than burning fossil fuels, especially if it comes from renewable sources like solar or wind.",
        tips = listOf(
            "Studies show that e-bikes could potentially replace enough car trips to cut carbon emissions by millions of tons per year.",
            "Encourage people out of cars",
            "Join a vibrant communities of e-bikers around Africa and the world"
        ),
        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite
        )
    )

)
