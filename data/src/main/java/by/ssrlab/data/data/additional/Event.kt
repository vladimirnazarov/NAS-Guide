package by.ssrlab.data.data.additional

import com.google.gson.annotations.SerializedName

data class Event(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("start_date")
    val startDate: String,

    @SerializedName("end_date")
    val endDate: String,

    @SerializedName("key_name")
    val keyName: String
)
