package com.miguellares.cardmagicpocket.model

import com.google.gson.annotations.SerializedName

data class PersonajesCardsResponse(
   @SerializedName("results") var results: List<Cards>
)