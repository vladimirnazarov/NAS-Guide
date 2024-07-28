package by.ssrlab.data.data.additional

import com.google.gson.annotations.SerializedName

data class DepartmentFilter(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("key_name")
    val keyName: String
)