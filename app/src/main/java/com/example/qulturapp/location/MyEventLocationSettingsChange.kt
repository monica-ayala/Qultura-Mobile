package com.example.qulturapp.location

import org.greenrobot.eventbus.EventBus

/**
 * EventBus class
 */
class MyEventLocationSettingsChange(val on:Boolean) {
    companion object {
        var globalState=false //Configuracion pror primera vez
        /**
         * En algunos dispositivos el cambio del evento se llama dos veces
         * esto se limita con el estado interno
         */
        fun setChangeAndPost(_on:Boolean) {
            if (globalState !=_on) { //Send Just Change
                globalState = _on;
                EventBus.getDefault().post(MyEventLocationSettingsChange(_on))
            }
        }
    }
}