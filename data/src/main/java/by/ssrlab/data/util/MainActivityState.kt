package by.ssrlab.data.util

sealed class MainActivityUiState {
    data object DateFragment : MainActivityUiState()
    data object Other: MainActivityUiState()
}