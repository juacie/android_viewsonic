package com.juacie.viewsonic.ui.screen.time

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.juacie.viewsonic.utils.LogObj
import com.juacie.viewsonic.core.ResultWrapper
import org.koin.androidx.compose.koinViewModel


@Composable
fun TimePage(modifier: Modifier = Modifier, viewModel: TimeViewModel = koinViewModel()) {

    val currentTime by viewModel.currentTime.collectAsState()
    val timeZoneList by viewModel.timeZoneList.observeAsState(emptyList())

    // 首次載入或列表更新時滾動到頂部
    LaunchedEffect(timeZoneList) {
        if (timeZoneList.isNotEmpty()) {
            LogObj.trace("Time Zone List: $timeZoneList")
            // 取得美國紐約時間
            viewModel.fetchCurrentTime(timeZoneList[0])
        }
    }

    when(currentTime){
        is ResultWrapper.Loading -> CircularProgressIndicator()
        is ResultWrapper.Success -> Text(text = "Success")
        is ResultWrapper.Error -> Text(text = "Error")
    }

    // 取得所有時區列表
    viewModel.fetchAvailableTimeZones()

    // Time page content
    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Times", style = MaterialTheme.typography.headlineLarge)
    }
}