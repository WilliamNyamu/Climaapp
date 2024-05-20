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
        title = "Save Water  \uD83D\uDEB0",
        imageRes = R.drawable.save_water,
        description =
                " Water conservation is the practice of using water efficiently to reduce unnecessary water usage. According to Fresh Water Watch, water conservation is important because fresh clean water is a limited resource, as well as a costly one. As a homeowner, you’re probably already well aware of the financial costs of inefficient water use. Conservation of this natural resource is critical for the environment — and our wallets.",
        tips = listOf(
            "Take shorter showers \uD83D\uDEC0\uD83C\uDFFD",
            "Check faucets and pipes for leaks",
            "Turn off running water when not in use"
        ),
        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite
        )
    ),
    Topic(
        title = "Walk \uD83D\uDEB6\uD83C\uDFFF instead of drive \uD83D\uDE99",
        imageRes = R.drawable.walk,
        description = "Benefits of walking instead of driving,\n" +
                " ncreasing the role of walking in your daily commutes could have a major impact on longevity and risk of coronary heart disease, stroke, diabetes, and obesity. If it’s not that far, and you don’t have to carry anything ridiculously heavy on your way, then leave the car at home and hoof it at least part of the way.",
        tips = listOf(
            "Walk in short distances to your destination",
            "Encourage people out of cars",
            "Make it a habit to walk \uD83D\uDE09"
        ),
        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite
        )
    ),
    Topic(
        title = "Recycle Materials  ♻\uFE0F",
        imageRes = R.drawable.recycle,
        description = "Recycle what you can, and save money,\n" +
                " Recycling is the process of collecting and processing materials that would otherwise be thrown away as trash and turning them into new products. Recycling can benefit your community, the economy, and the environment.",
        tips = listOf(
            "Prevent Pollution",
            "Prevent Waste",
            "Save a penny"
        ),
        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite
        )
    ),
    Topic(
        title = "Plant a tree \uD83C\uDF33",
        imageRes = R.drawable.plant_tree,
        description = "Participate in tree planting projects!!" +
                " Forests play a critical part to keep our environment healthy. But our forests need us more than ever – more than 1 million acres of National Forests are in need of reforestation.",
        tips = listOf(
            "Tree planting improves wildlife habitat connectivity and supports biodiversity.",
            "Trees remove harmful pollutants from the air and act as our natural air filter",
            "Two trees planted will remove 1 ton of CO2 from the atmosphere over the life of those trees."
        ),
        icons = listOf(
            Icons.Filled.CheckCircle,
            Icons.Filled.Add,
            Icons.Filled.Favorite
        )
    )
)
