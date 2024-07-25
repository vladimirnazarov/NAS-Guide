package by.ssrlab.data.util

sealed class MainActivityUiState {
    data object DateFragment : MainActivityUiState()
    data object Other : MainActivityUiState()
}

sealed class ToolbarStateByDates {
    data object OnCreate : ToolbarStateByDates()
    data object OnDestroy : ToolbarStateByDates()
}