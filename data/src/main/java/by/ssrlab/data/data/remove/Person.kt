package by.ssrlab.data.data.remove

import by.ssrlab.data.data.common.DescriptionData
import com.google.gson.annotations.SerializedName

data class Person(

    @SerializedName("pk")
    override val pk: Int,

    @SerializedName("key_name")
    val keyName: String,

    @SerializedName("logo")
    override val logo: String,

    @SerializedName("images")
    override val image: Image
): DescriptionData
