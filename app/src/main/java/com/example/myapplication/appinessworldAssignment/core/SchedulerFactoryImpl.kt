package com.example.myapplication.appinessworldAssignment.core
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.schedulers.Schedulers.io

class SchedulerFactoryImpl : SchedulerFactory {
  override val mainScheduler: Scheduler = mainThread()
  override val ioScheduler: Scheduler = io()
}
