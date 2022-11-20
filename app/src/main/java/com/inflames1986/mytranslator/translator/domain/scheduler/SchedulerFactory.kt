package com.inflames1986.mytranslator.translator.domain.scheduler

object SchedulerFactory {
    fun create(): Schedulers = DefaultSchedulers()
}