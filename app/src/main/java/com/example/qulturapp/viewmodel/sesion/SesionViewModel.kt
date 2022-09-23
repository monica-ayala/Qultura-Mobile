package com.example.qulturapp.viewmodel.sesion

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qulturapp.model.ApiCallerService
import com.example.qulturapp.model.sesion.UsuarioActual
import kotlinx.coroutines.launch


class SesionViewModel: ViewModel() {
    private var caller: ApiCallerService = ApiCallerService()
    var usuarioNuevo: MutableLiveData<Boolean> = MutableLiveData(null)
    var sesionIniciada: MutableLiveData<Boolean> = MutableLiveData(null)

    fun guardarUsuario(nombre: String, correo: String, contrasenia: String) {
        viewModelScope.launch {
            val exito = caller.agregarUsuario(nombre, correo, contrasenia)?.paso
            if(exito == 1){
                usuarioNuevo.postValue(true)
            } else {
                usuarioNuevo.postValue(false)
            }
        }
    }

    fun validaUsuario(correo: String, contrasenia: String){
        viewModelScope.launch{
            val usuarioList = caller.searchUsuario(correo, contrasenia)
            if(usuarioList!= null && usuarioList.usuarios.isNotEmpty()) {
                val usuario = usuarioList.usuarios[0]
                UsuarioActual.setInfo(usuario.id, usuario.nombre, usuario.correo, usuario.contrasenia, usuario.rol)
                sesionIniciada.postValue(true)
            }
            else {
                sesionIniciada.postValue(false)
            }
        }
    }

    fun comparaContrasenia(contrasenia: String) {
        TODO()
    }

    //Aún no tengo idea de como sirve esto solo no lo vean luego checo esta onda
    /*
    private fun generaLlave(): SecretKey {
        val keystore = KeyStore.getInstance("AndroidKeyStore")
        keystore.load(null)

        val secretKeyEntry = keystore.getEntry("MyKeyAlias", null) as KeyStore.SecretKeyEntry
        return secretKeyEntry.secretKey
    }

    private fun cifrarClave(cadena: String): Pair<ByteArray, ByteArray> {
        val cipher = Cipher.getInstance("AES/CBC/NoPadding")

        var temp = cadena
        while (temp.toByteArray().size % 16 != 0)
            temp += "\u0020"

        cipher.init(Cipher.ENCRYPT_MODE, generaLlave())

        val ivBytes = cipher.iv
        val encryptedBytes = cipher.doFinal(temp.toByteArray(Charsets.UTF_8))

        return Pair(ivBytes, encryptedBytes)
    }

    fun descifrarClave(ivBytes: ByteArray, data: ByteArray): String{
        val cipher = Cipher.getInstance("AES/CBC/NoPadding")
        val spec = IvParameterSpec(ivBytes)

        cipher.init(Cipher.DECRYPT_MODE, generaLlave(), spec)
        return cipher.doFinal(data).toString(Charsets.UTF_8).trim()
    }*/
}