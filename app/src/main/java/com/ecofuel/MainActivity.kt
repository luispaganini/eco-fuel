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
        binding.valorGasolina.setText("")
        binding.valorEtanol.setText("")
        binding.consEtanol.setText("")
        binding.consGasolina.setText("")
        binding.result.setText("")
        binding.valorEtanol.requestFocus()
    }

    private fun btButtonCalcOnClick() {
        val precoGasolina = binding.valorGasolina.text.toString().toDoubleOrNull() ?: return
        val precoEtanol = binding.valorEtanol.text.toString().toDoubleOrNull() ?: return
        val consGasolina = binding.consGasolina.text.toString().toDoubleOrNull() ?: return
        val consEtanol = binding.consEtanol.text.toString().toDoubleOrNull() ?: return

        val custoKmGasolina = precoGasolina / consGasolina
        val custoKmEtanol = precoEtanol / consEtanol

        if (custoKmGasolina < custoKmEtanol)
            binding.result.text = getString(R.string.gasolina)
        else
            binding.result.text = getString(R.string.etanol)
    }

}