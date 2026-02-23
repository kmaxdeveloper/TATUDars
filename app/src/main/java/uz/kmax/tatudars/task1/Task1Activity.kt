package uz.kmax.tatudars.task1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import uz.kmax.tatudars.databinding.ActivityMainBinding
import uz.kmax.tatudars.databinding.ActivityTask1Binding
import kotlin.random.Random

class Task1Activity : AppCompatActivity() {
    private lateinit var binding : ActivityTask1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            binding.text.text = "Kod ishladi !"
            val randomColor = Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
            binding.text.setTextColor(randomColor)
            binding.imgAndroid.visibility = View.VISIBLE
        }

        binding.button2.setOnClickListener {
            binding.button2.text = "Tugma bosildi !"
        }
    }
}