package by.ssrlab.data.data.additional

import com.google.gson.annotations.SerializedName

data class Development(

    @SerializedName("pk")
    val pk: Int,

    @SerializedName("key_name")
    val keyName: String,

    @SerializedName("logo")
    val logo: String,

    @SerializedName("organization")
    val organization: Organization?,

    @SerializedName("department_filter")
    val departmentFilter: DepartmentFilter,

    @SerializedName("images")
    val image: Image
)
