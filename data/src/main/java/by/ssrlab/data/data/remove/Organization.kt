package by.ssrlab.data.data.remove

import by.ssrlab.data.data.common.DescriptionData
import com.google.gson.annotations.SerializedName

data class Organization(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("key_name")
    val keyName: String,

    @SerializedName("latitude")
    val lat: Double,

    @SerializedName("longitude")
    val lon: Double,

    @SerializedName("logo")
    override val logo: String,

    @SerializedName("department_filter")
    val departmentFilter: DepartmentFilter,

    @SerializedName("images")
    override val image: Image
): DescriptionData
