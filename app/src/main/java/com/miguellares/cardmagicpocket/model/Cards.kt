package com.miguellares.cardmagicpocket.model

import com.google.gson.annotations.SerializedName

data class Cards(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var name: String = "",
    @SerializedName("status") var status: String = "",
    @SerializedName("image") var image: String = ""
)
