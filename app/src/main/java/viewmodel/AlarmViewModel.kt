package com.example.sistemaalarmasobrecarga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AlarmViewModel(private val dao: AlarmDao) : ViewModel() {

    private val _systemStatus = MutableStateFlow("Todo en orden")
    val systemStatus: StateFlow<String> = _systemStatus

    fun activateSystem() {
        viewModelScope.launch {
            dao.insert(Alarm(status = "Sistema Activado"))
            _systemStatus.value = "Sistema Activado"
        }
    }

    fun deactivateSystem() {
        viewModelScope.launch {
            dao.insert(Alarm(status = "Sistema Desactivado"))
            _systemStatus.value = "Sistema Desactivado"
        }
    }

    suspend fun deleteLastAlarm() {
        val lastAlarm = dao.getLastAlarm()
        if (lastAlarm != null) {
            dao.delete(lastAlarm)
            _systemStatus.value = "Última alarma eliminada"
        }
    }
}
