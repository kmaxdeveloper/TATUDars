package uz.kmax.tatudars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.kmax.base.fragmentcontroller.FragmentController
import uz.kmax.tatudars.databinding.ActivityMainBinding
import uz.kmax.tatudars.presentation.fragment.main.MenuFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FragmentController.init(R.id.container,supportFragmentManager)
        FragmentController.controller?.startMainFragment(MenuFragment())
    }
}