package com.example.smartrecommendationsai.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ChatGPTRequest(
    @Json(name = "model") val model: String,
    @Json(name = "messages") val messages: List<Message>
)

@JsonClass(generateAdapter = true)
data class Message(
    @Json(name = "role") val role: String,
    @Json(name = "content") val content: String
)

@JsonClass(generateAdapter = true)
data class ChatGPTResponse(
    @Json(name = "id") val id: String,
    @Json(name = "choices") val choices: List<Choice>
)

@JsonClass(generateAdapter = true)
data class Choice(
    @Json(name = "message") val message: MessageContent
)

@JsonClass(generateAdapter = true)
data class MessageContent(
    @Json(name = "content") val content: String
)
