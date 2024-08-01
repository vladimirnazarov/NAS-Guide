package by.ssrlab.data.data.common

interface RepositoryData {
    val pk: Int
    val name: String
    val about: String
    val audio: String?
    val description: DescriptionData?
}