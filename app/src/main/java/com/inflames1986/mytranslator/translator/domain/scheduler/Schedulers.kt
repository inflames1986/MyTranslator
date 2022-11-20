package com.inflames1986.mytranslator.translator.domain.scheduler

import io.reactivex.Scheduler


interface Schedulers {

    fun background(): Scheduler

    fun main(): Scheduler

    fun computation(): Scheduler
}