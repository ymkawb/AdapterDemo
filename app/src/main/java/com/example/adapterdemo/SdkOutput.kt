package com.example.adapterdemo

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class SdkOutput() {
    companion object {
          val instance : SdkOutput by lazy {
              SdkOutput()
          }
    }
    private val stateFlow = MutableStateFlow("")
    val output : Flow<String> = stateFlow

    @OptIn(DelicateCoroutinesApi::class)
    val job: Job =    GlobalScope.launch {
        run()
    }

    private suspend fun run() {
        var counter = 0
        while(true) {
            delay(1000L)
            stateFlow.emit("Message ${counter++}")
        }
    }
}