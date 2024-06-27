package com.ecofuel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ecofuel.databinding.ActivityListarCombustiveisBinding

class ListarCombustiveis : AppCompatActivity() {
    private lateinit var binding: ActivityListarCombustiveisBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar_combustiveis)

        binding.lvCombustiveis.setOnItemClickListener{parent, view, position, id ->
            val codSelecionado = position + 1
            intent.putExtra("codRetorno", codSelecionado)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}