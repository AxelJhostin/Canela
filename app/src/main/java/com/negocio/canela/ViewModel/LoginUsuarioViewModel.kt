package com.negocio.canela.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.negocio.canela.Modelo.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginUsuarioViewModel : ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val fireStore = Firebase.firestore

    private val _mostrarAlerta = MutableStateFlow(false)
    val mostrarAlerta: StateFlow<Boolean> = _mostrarAlerta

    private val _mensajeError = MutableStateFlow("")
    val mensajeError: StateFlow<String> = _mensajeError

    fun crearUsuario(
        email: String,
        nombre: String,
        apellido: String,
        contrasenia: String,
        cedula: String,
        celular: String,
        alProcesar: () -> Unit
    ) {
        viewModelScope.launch {
            if (email.isEmpty() || contrasenia.isEmpty() || nombre.isEmpty()) {
                mostrarError("Todos los campos son obligatorios")
                return@launch
            }

            auth.createUserWithEmailAndPassword(email, contrasenia)
                .addOnCompleteListener { tarea ->
                    if (tarea.isSuccessful) {
                        guardarUsuario(email, nombre, apellido, contrasenia, cedula, celular)
                        alProcesar()
                    } else {
                        val errorMsg = tarea.exception?.message ?: "Error al crear usuario"
                        if (errorMsg.contains("The email address is already in use", ignoreCase = true)) {
                            mostrarError("Este correo ya está registrado. Usa otro o inicia sesión.")
                        } else {
                            mostrarError(errorMsg)
                        }
                    }
                }
        }
    }

    fun loginUsuario(email: String, contrasenia: String, alProcesar: () -> Unit) {
        viewModelScope.launch {
            if (email.isEmpty() || contrasenia.isEmpty()) {
                mostrarError("Por favor, complete los campos")
                return@launch
            }

            auth.signInWithEmailAndPassword(email, contrasenia)
                .addOnCompleteListener { tarea ->
                    if (tarea.isSuccessful) {
                        fireStore.collection("Usuario")
                            .whereEqualTo("email", email)
                            .get()
                            .addOnSuccessListener { documents ->
                                if (!documents.isEmpty) {
                                    alProcesar()
                                } else {
                                    mostrarError("No puede ingresar, usuario no encontrado")
                                }
                            }
                            .addOnFailureListener {
                                mostrarError("Error al verificar usuario")
                            }
                    } else {
                        mostrarError("Email y/o contraseña incorrectos")
                    }
                }
        }
    }

    private fun guardarUsuario(
        email: String,
        nombre: String,
        apellido: String,
        contrasenia: String,
        cedula: String,
        celular: String
    ) {
        viewModelScope.launch {
            val userDocRef = fireStore.collection("Usuario").document() // 🔥 Genera un ID automático
            val userId = userDocRef.id // 🔥 Obtiene el ID generado por Firestore

            val nuevoUsuario = Usuario(
                id = userId, // 🔥 Ahora el ID se almacena en Firestore
                email = email,
                nombre = nombre,
                apellido = apellido,
                contrasenia = contrasenia,
                cedula = cedula,
                celular = celular
            )

            userDocRef.set(nuevoUsuario)
                .addOnSuccessListener {
                    println("✅ Usuario agregado correctamente con ID: $userId")
                }
                .addOnFailureListener {
                    mostrarError("❌ No se pudo guardar el usuario")
                }
        }
    }

    fun cerrarAlerta() {
        _mostrarAlerta.value = false
        _mensajeError.value = ""
    }

    fun cerrarSesion() {
        auth.signOut()
    }

    private fun mostrarError(mensaje: String) {
        _mensajeError.value = mensaje
        _mostrarAlerta.value = true
    }
}
