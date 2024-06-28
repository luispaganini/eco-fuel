package com.ecofuel

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ecofuel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedCombButton: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalc.setOnClickListener {
            btButtonCalcOnClick()
        }

        binding.buttonLimpar.setOnClickListener {
            btButtonLimparOnClick()
        }

        binding.comb1.setOnClickListener {
            btButtonCombOnClick(1)
        }

        binding.comb2.setOnClickListener {
            btButtonCombOnClick(2)
        }
    }

    private fun btButtonCombOnClick(buttonId: Int) {
        selectedCombButton = buttonId
        val intent = Intent(this, ListarCombustiveis::class.java)
        getResult.launch(intent)
    }

    @SuppressLint("SetTextI18n")
    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            val codSelecionado = it.data?.getIntExtra("codRetorno", 0)

            if (codSelecionado != null) {
                val valorSelecionado = when (codSelecionado) {
                    0 -> 9
                    1 -> 12
                    else -> null
                }

                if (valorSelecionado != null) {
                    when (selectedCombButton) {
                        1 -> binding.cons1.setText(valorSelecionado.toString())
                        2 -> binding.cons2.setText(valorSelecionado.toString())
                    }
                }
            }
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

    @SuppressLint("SetTextI18n")
    private fun btButtonCalcOnClick() {
        val preco2 = binding.valor2.text.toString().toDoubleOrNull() ?: return
        val preco1 = binding.valor1.text.toString().toDoubleOrNull() ?: return
        val cons2 = binding.cons2.text.toString().toDoubleOrNull() ?: return
        val cons1 = binding.cons1.text.toString().toDoubleOrNull() ?: return

        val custoKm2 = preco2 / cons2
        val custoKm1 = preco1 / cons1

        binding.result.text = "O Combustivel mais barato é: " + if (custoKm2 < custoKm1) {
            when (cons2) {
                9.0 -> getString(R.string.etanol)
                12.0 -> getString(R.string.gasolina)
                else -> getString(R.string.combustivel_2)
            }
        } else {
            when (cons1) {
                9.0 -> getString(R.string.etanol)
                12.0 -> getString(R.string.gasolina)
                else -> getString(R.string.combustivel_1)
            }
        }
    }
}
