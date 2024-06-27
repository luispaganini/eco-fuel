package com.ecofuel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ecofuel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalc.setOnClickListener{
            btButtonCalcOnClick()
        }

        binding.buttonLimpar.setOnClickListener{
            btButtonLimparOnClick()
        }
    }

    private fun btButtonLimparOnClick() {
        binding.valor2.setText("")
        binding.valor1.setText("")
        binding.cons1.setText("")
        binding.cons2.setText("")
        binding.result.setText("")
        binding.valor1.requestFocus()
    }

    private fun btButtonCalcOnClick() {
        val preco2 = binding.valor2.text.toString().toDoubleOrNull() ?: return
        val preco1 = binding.valor1.text.toString().toDoubleOrNull() ?: return
        val cons2 = binding.cons2.text.toString().toDoubleOrNull() ?: return
        val cons1 = binding.cons1.text.toString().toDoubleOrNull() ?: return

        val custoKm2 = preco2 / cons2
        val custoKm1 = preco1 / cons1

        if (custoKm2 < custoKm1)
            binding.result.text = getString(R.string.combustivel_2)
        else
            binding.result.text = getString(R.string.combustivel_1)
    }

}