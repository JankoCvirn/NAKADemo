package com.cvirn.nakademo.screen.statistics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.cvirn.nakademo.R
import com.cvirn.nakademo.component.PieChart
import com.cvirn.nakademo.extension.toDegree
import com.cvirn.nakademo.viewmodel.StatisticsScreenViewModel
import com.cvirn.task4me.ui.values.LocalPaddingValues

@Composable
fun StatisticsScreenContent(statisticsViewModele: StatisticsScreenViewModel) {
    val statisticsScreenState by statisticsViewModele.statisticsFlow.collectAsState()
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .padding(LocalPaddingValues.current.large),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PieChart(
            data =
                mapOf(
                    Pair(
                        stringResource(R.string.user_gender_female),
                        statisticsScreenState.femalePercentage.toDegree(),
                    ),
                    Pair(
                        stringResource(R.string.user_genger_male),
                        statisticsScreenState.malePercentage.toDegree(),
                    ),
                ),
        )
        Row {
            Text(text = stringResource(R.string.average_age, statisticsScreenState.averageAge))
        }
    }
}
