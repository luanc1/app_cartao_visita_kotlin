package br.me.dio.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import br.me.dio.businesscard.App
import br.me.dio.businesscard.R
import br.me.dio.businesscard.data.BusinessCard
import br.me.dio.businesscard.databinding.ActivityAddBusinessCardsBinding


class AddBusinessCardActivity : AppCompatActivity() {


    private val binding by lazy { ActivityAddBusinessCardsBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListeners()
    }

    private fun insertListeners() {

    binding.btnConfirmar.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}
