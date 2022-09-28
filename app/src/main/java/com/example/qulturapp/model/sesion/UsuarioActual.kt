package com.example.qulturapp.model.sesion

object UsuarioActual {
    var id: Int = 1
    var nombre: String = ""
    var correo: String = ""
    var contrasenia: String = ""
    var rol: Int = 0;

    fun setInfo(id: Int, nombre:String, correo:String, contrasenia:String, rol:Int){
        this.id = id
        this.nombre = nombre
        this.correo = correo
        this.contrasenia = contrasenia
        this.rol = rol
    }

}