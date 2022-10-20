package com.example.qulturapp.viewmodel.sesion

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.sesion.UsuarioActual
import kotlinx.coroutines.launch


class SesionViewModel: ViewModel() {
    private var caller: ApiCallerService = ApiCallerService()
    var usuarioCreado: MutableLiveData<Boolean> = MutableLiveData(null)
    var sesionIniciada: MutableLiveData<Boolean> = MutableLiveData(null)
    var statusConexion: MutableLiveData<Boolean> = MutableLiveData(null)

    //Sign up
    fun guardarUsuario(nombre: String, correo: String, contrasenia: String) {
        viewModelScope.launch {
            try {
                val exito = caller.agregarUsuario(nombre, correo, contrasenia)?.paso
                if (exito == 1) {
                    usuarioCreado.postValue(true)
                } else {
                    usuarioCreado.postValue(false)
                }
            } catch (e: Exception) {
                statusConexion.postValue(false)
            }
        }
    }

    fun validaUsuario(correo: String, contrasenia: String){
        viewModelScope.launch{
            try {
                val usuarioList = caller.searchUsuario(correo, contrasenia)
                if (usuarioList != null && usuarioList.usuarios.isNotEmpty()) {
                    val usuario = usuarioList.usuarios[0]
                    UsuarioActual.setInfo(
                        usuario.id,
                        usuario.nombre,
                        usuario.correo,
                        usuario.contrasenia,
                        usuario.rol
                    )
                    sesionIniciada.postValue(true)
                } else {
                    sesionIniciada.postValue(false)
                }
            } catch (e: Exception) {
                statusConexion.postValue(false)
            }
        }
    }
}