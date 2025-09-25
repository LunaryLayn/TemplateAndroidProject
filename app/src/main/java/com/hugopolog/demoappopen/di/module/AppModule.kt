package com.hugopolog.demoappopen.di.module

import android.content.Context
import com.hugopolog.demoappopen.di.app.DemoApp
import com.hugopolog.demoappopen.navigation.AppScreens
import com.hugopolog.demoappopen.navigation.DefaultNavigator
import com.hugopolog.demoappopen.navigation.Navigator
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): DemoApp {
        return app as DemoApp
    }
    @Provides
    @Singleton
    fun provideContext(application: DemoApp): Context {
        return application.applicationContext
    }
    @Provides
    @Singleton
    fun provideNavigator(): Navigator {
        return DefaultNavigator(startDestination = AppScreens.MainScreen)
    }
}