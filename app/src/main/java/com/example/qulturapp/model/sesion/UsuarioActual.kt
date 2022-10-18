package com.example.qulturapp.model.sesion

//Objeto con información del usuario que ha iniciado sesión
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

    fun limpiaInfo() {
        this.id = 1
        this.nombre = ""
        this.correo = ""
        this.contrasenia = ""
        this.rol = 0
    }

}