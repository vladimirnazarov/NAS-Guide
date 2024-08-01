package by.ssrlab.data.util

sealed class ExhibitObject {
    data object Development: ExhibitObject()
    data object Organization: ExhibitObject()
    data object Person: ExhibitObject()
    data object Place: ExhibitObject()
}