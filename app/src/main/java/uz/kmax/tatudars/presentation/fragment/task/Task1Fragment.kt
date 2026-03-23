package uz.kmax.tatudars.presentation.fragment.task

import android.graphics.Color
import android.view.View
import uz.kmax.base.fragment.BaseFragmentNV
import uz.kmax.tatudars.databinding.FragmentTask1Binding
import kotlin.random.Random

class Task1Fragment : BaseFragmentNV<FragmentTask1Binding>(FragmentTask1Binding::inflate) {
    override fun onViewCreated() {
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