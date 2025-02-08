package com.juacie.viewsonic.app.base

interface IViewModel<out ViewModel : BaseViewModel> {
    val viewModel: ViewModel
}