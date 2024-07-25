package by.ssrlab.data.data.additional

data class Development(
    val pk: Int,
    val keyName: String,
    val logo: String,
    val organization: Organization?,
    val departmentFilter: DepartmentFilter,
    val image: Image
)
