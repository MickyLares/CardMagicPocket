package com.miguellares.cardmagicpocket.model

import com.google.gson.annotations.SerializedName

data class Cards(
    @SerializedName("id") var id: Int = 0,
    @SerializedName("name") var nombre: String = "",
    @SerializedName("image") var imagen: String = "",
    @SerializedName("gender") var genero: String = "",
    @SerializedName("created") var creado: String = "",
    @SerializedName("species") var especies: String = "",
    @SerializedName("status") var estatus: String = ""
)
