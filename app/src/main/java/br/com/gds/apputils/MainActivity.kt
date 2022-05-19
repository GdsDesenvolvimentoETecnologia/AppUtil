package br.com.gds.apputils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.gds.apputils.databinding.ActivityMainBinding
import br.com.gds.osservices.Bateria

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()


    }

    private fun initViews() = with(binding) {
        text.text = Bateria._VidaBateria

    }
}