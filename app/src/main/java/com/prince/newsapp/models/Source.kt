package com.prince.newsapp.models

import kotlinx.serialization.Serializable

@Serializable
data class Source(
    val id: String,
    val name: String
)