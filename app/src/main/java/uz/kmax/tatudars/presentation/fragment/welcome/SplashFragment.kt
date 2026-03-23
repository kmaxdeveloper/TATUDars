package uz.kmax.tatudars.presentation.fragment.welcome

import android.os.CountDownTimer
import uz.kmax.base.fragment.BaseFragmentNV
import uz.kmax.base.fragment.BaseFragmentWC
import uz.kmax.tatudars.databinding.FragmentSplashBinding

class SplashFragment : BaseFragmentWC<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun onViewCreated() {
        object : CountDownTimer(3000, 100) {
            override fun onFinish() {

            }
            override fun onTick(value: Long) {}
        }.start()
    }
}