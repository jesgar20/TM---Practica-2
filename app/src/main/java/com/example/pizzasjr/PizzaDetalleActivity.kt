package com.example.pizzasjr // Asegúrate de que sea tu paquete

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzasjr.R

class PizzaDetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pizza_detalle)

        val imgDetalle: ImageView = findViewById(R.id.imgDetallePizza)
        val txtNombre: TextView = findViewById(R.id.txtDetalleNombrePizza)
        val btnAtras: Button = findViewById(R.id.btnAtras)

        // 1. Recibir los datos "empacados" en el Intent
        val nombrePizza = intent.getStringExtra("PIZZA_NOMBRE")
        val imagenPizzaResId = intent.getIntExtra("PIZZA_IMAGEN", 0)

        // 2. Mostrar los datos en las vistas
        txtNombre.text = nombrePizza
        imgDetalle.setImageResource(imagenPizzaResId)

        // 3. Programar el botón atrás
        btnAtras.setOnClickListener {
            // Cierra esta actividad y regresa automáticamente a la anterior
            finish()
        }
    }
}