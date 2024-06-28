package com.ecofuel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ecofuel.databinding.ActivityListarCombustiveisBinding
import com.ecofuel.databinding.ActivityMainBinding

class ListarCombustiveis : AppCompatActivity() {
    private lateinit var binding: ActivityListarCombustiveisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarCombustiveisBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.lvCombustiveis.setOnItemClickListener{parent, view, position, id ->
            val codSelecionado = position
            intent.putExtra("codRetorno", codSelecionado)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}