package com.juacie.viewsonic.app.main.view

import androidx.compose.runtime.Composable
import com.juacie.viewsonic.app.base.BaseActivity
import com.juacie.viewsonic.app.main.viewModel.MainViewModel

class MainActivity : BaseActivity<MainViewModel>() {
    @Composable
    override fun ScreenContent() {
        MainScreen(viewModel = viewModel)
    }
}
