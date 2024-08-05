package by.ssrlab.domain.utils

import by.ssrlab.data.data.remote.DepartmentFilter
import by.ssrlab.data.data.remote.Image
import by.ssrlab.data.data.remote.Organization
import org.json.JSONObject

//Extensions to language dialog
fun String.transformLanguageToInt(): Int {
    return when (this) {
        "en" -> 1
        "be" -> 2
        "ru" -> 3
        else -> -1
    }
}

fun Int.transformIntToLanguage(): String {
    return when (this) {
        1 -> "en"
        2 -> "be"
        3 -> "ru"
        else -> "en"
    }
}

//Extension to html text
fun String.fromHtml(): String {
    return this.replace(Regex("<[^>]*>"), "").replace("&nbsp;", " ")
}

//Extensions to JSON (ExhibitObject)
fun Image.Companion.fromJson(jsonObject: JSONObject): Image {
    return Image(
        address = jsonObject.getString("1")
    )
}

fun DepartmentFilter.Companion.fromJson(jsonObject: JSONObject): DepartmentFilter {
    return DepartmentFilter(
        pk = jsonObject.getInt("pk"),
        keyName = jsonObject.getString("key_name")
    )
}

fun Organization.Companion.fromJson(jsonObject: JSONObject): Organization {
    return Organization(
        pk = jsonObject.getInt("pk"),
        keyName = jsonObject.getString("key_name"),
        logo = jsonObject.getString("logo"),
        lat = jsonObject.getDouble("latitude"),
        lon = jsonObject.getDouble("longitude"),
        departmentFilter = DepartmentFilter.fromJson(
            jsonObject.getJSONObject(
                "department_filter"
            )
        ),
        image = Image.fromJson(jsonObject.getJSONObject("images"))
    )
}