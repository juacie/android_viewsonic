package com.juacie.viewsonic.ui.screen.time

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juacie.viewsonic.core.BaseViewModel
import com.juacie.viewsonic.core.ResultWrapper
import com.juacie.viewsonic.data.model.DateTimeInfo
import com.juacie.viewsonic.domain.TimeUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimeViewModel(private val timeUserCase: TimeUseCase) : BaseViewModel() {
    private val _currentTime = MutableStateFlow<ResultWrapper<DateTimeInfo>>(ResultWrapper.Loading)
    val currentTime: StateFlow<ResultWrapper<DateTimeInfo>> = _currentTime

    private val _timeZoneList = MutableLiveData<List<String>>()
    val timeZoneList: LiveData<List<String>> get() = _timeZoneList

    fun fetchCurrentTime(timeZone: String) {
        viewModelScope.launch {
            _currentTime.value = timeUserCase.getTimeByZone(timeZone)
        }
    }

    fun fetchAvailableTimeZones() {
        viewModelScope.launch {
            _timeZoneList.value = timeUserCase.getTimeZoneList()
        }
    }
}