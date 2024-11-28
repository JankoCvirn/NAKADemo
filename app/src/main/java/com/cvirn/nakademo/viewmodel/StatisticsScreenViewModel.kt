package com.cvirn.nakademo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cvirn.nakademo.screen.statistics.StatisticsScreenState
import com.cvirn.nakademo.usecase.UserCrudUseCaseImpl
import db.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StatisticsScreenViewModel(
    val userUseCase: UserCrudUseCaseImpl,
) : ViewModel() {
    private val _statisticsFlow =
        MutableStateFlow(StatisticsScreenState(0.0, 0.0, 0.0))
    val statisticsFlow: StateFlow<StatisticsScreenState> = _statisticsFlow

    fun loadUsers() {
        viewModelScope.launch {
            userUseCase.getAll().collect {
                val averageAge = averageAge(it)
                val percentage = calculateGenderDistribution(it)
                _statisticsFlow.value =
                    StatisticsScreenState(
                        averageAge = averageAge,
                        femalePercentage = percentage.first,
                        malePercentage = percentage.second,
                    )
            }
        }
    }

    private fun averageAge(list: List<User>): Double {
        var ageSum = 0.0
        list.forEach {
            ageSum += it.age
        }
        return ageSum / list.count()
    }

    private fun calculateGenderDistribution(list: List<User>): Pair<Double, Double> {
        val female = list.count { it.gender == 0L }
        val male = list.count { it.gender == 1L }
        val femalePercentage: Double = (female.toDouble() / list.count()) * 100
        val malePercentage = (male.toDouble() / list.count()) * 100
        return Pair(femalePercentage, malePercentage)
    }
}
