package by.ssrlab.data.data.additional

import com.google.gson.annotations.SerializedName

data class Organization(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("key_name")
    val keyName: String,

    @SerializedName("latitude")
    val lat: Double,

    @SerializedName("longitude")
    val lon: Double,

    @SerializedName("department_filter")
    val departmentFilter: DepartmentFilter,

    @SerializedName("images")
    val image: Image
)
