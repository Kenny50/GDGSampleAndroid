package com.example.gdgsampleandroid.di.module

import javax.inject.Qualifier

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class IoDispatcher

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class MainDispatcher


@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope