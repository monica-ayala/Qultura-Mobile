package com.example.qulturapp.viewmodel.sesion

import androidx.lifecycle.ViewModel
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec


class SesionViewModel: ViewModel() {
    fun guardarUsuario(nombre: String, correo: String, contrasenia: String) {
        TODO()
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