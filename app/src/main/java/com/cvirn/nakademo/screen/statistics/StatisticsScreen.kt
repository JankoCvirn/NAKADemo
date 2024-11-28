package com.cvirn.nakademo.screen.statistics

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.cvirn.nakademo.viewmodel.StatisticsScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Suppress("ktlint:standard:function-naming")
@Composable
fun StatisticsScreen() {
    val statisticsViewModel: StatisticsScreenViewModel = koinViewModel()

    LaunchedEffect(Unit) {
        statisticsViewModel.loadUsers()
    }
    StatisticsScreenContent(statisticsViewModel)
}
