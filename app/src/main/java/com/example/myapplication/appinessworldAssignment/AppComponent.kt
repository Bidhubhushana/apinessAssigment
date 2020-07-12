package com.example.myapplication.appinessworldAssignment
import com.example.myapplication.repository.PhotoRepositoryModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import com.example.myapplication.appinessworldAssignment.core.SchedulerFactoryModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    AndroidBindingModule::class,
    AppModule::class,
    PhotoRepositoryModule::class,
    SchedulerFactoryModule::class
))
interface AppComponent : AndroidInjector<App> {
  @Component.Builder
  abstract class Builder : AndroidInjector.Builder<App>()
}
