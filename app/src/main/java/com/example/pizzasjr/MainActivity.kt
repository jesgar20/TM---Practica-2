package com.example.pizzasjr

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.pizzasjr.PizzaDetalleActivity

class MainActivity : AppCompatActivity() {

    // Mantén tus mismos arreglos
    private val nombresPizzas = arrayOf("Pepperoni", "Hawaiiana", "Mexicana", "4 Quesos", "Vegetariana", "Margarita")
    private val imagenesPizzas = intArrayOf(
        R.drawable.pepperoni, R.drawable.hawaiiana,
        R.drawable.mexicana, R.drawable.cuatro_quesos,
        R.drawable.vegetariana, R.drawable.margarita
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lvPizzas: ListView = findViewById(R.id.lvNombresPizzas)

        // Un adaptador simple para mostrar solo los nombres como botones
        val adapter = ArrayAdapter(this, android.R.layout.simple_selectable_list_item, nombresPizzas)
        lvPizzas.adapter = adapter

        // Evento Click: Aquí ocurre la navegación
        lvPizzas.setOnItemClickListener { _, _, position, _ ->
            // 1. Crear el Intent para ir a la pantalla de detalle
            val intent = Intent(this, PizzaDetalleActivity::class.java)

            // 2. "Empacar" los datos que necesitamos en la siguiente pantalla
            intent.putExtra("PIZZA_NOMBRE", nombresPizzas[position])
            intent.putExtra("PIZZA_IMAGEN", imagenesPizzas[position])

            // 3. Iniciar la nueva actividad
            startActivity(intent)
        }
    }
}