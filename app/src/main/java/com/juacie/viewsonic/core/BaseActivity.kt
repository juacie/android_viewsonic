package com.juacie.viewsonic.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.juacie.viewsonic.ui.theme.ViewSonicTheme

abstract class BaseActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewSonicTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenContent()// 讓子類別實作 Compose UI
                }
            }
        }
    }

    @Composable
    protected abstract fun ScreenContent()
}

abstract class BaseActivityVM<VM : BaseViewModel> : BaseActivity() {
    protected abstract val viewModel: VM
}