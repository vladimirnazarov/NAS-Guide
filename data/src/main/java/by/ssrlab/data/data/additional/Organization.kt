package by.ssrlab.data.data.additional

data class Organization(
    val pk: Int,
    val keyName: String,
    val lat: Double,
    val lon: Double,
    val departmentFilter: DepartmentFilter,
    val image: Image
)
