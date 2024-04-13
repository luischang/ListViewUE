package dev.luischang.listviewue

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var arrSO = arrayOf("Android",
        "iPhone","Windows Phone","Blackberry OS",
        "Firefox OS","Amazon World","Nokia")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val lsvSistemasOperativos: ListView = findViewById(R.id.lsvSO)
        val adaptador: Any? = ArrayAdapter<Any?>(this,
            android.R.layout.simple_list_item_1,
            arrSO)
        lsvSistemasOperativos.adapter = adaptador as ListAdapter?
        
        lsvSistemasOperativos
            .setOnItemClickListener { parent, view, position, id ->
                Toast.makeText(applicationContext,
                    "Posición: $position",
                    Toast.LENGTH_LONG).show()
            }
    }
}