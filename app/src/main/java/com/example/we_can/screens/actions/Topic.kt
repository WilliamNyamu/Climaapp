package com.example.we_can.screens.actions

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector

data class Topic(
    val title: String,
    val imageRes: Int,
    val description: String,
    val tips: List<String>,
    val icons: List<ImageVector>
)
