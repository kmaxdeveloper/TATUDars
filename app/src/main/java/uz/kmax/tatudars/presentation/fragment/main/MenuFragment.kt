package uz.kmax.tatudars.presentation.fragment.main

import androidx.fragment.app.Fragment
import uz.kmax.base.fragment.BaseFragmentNV
import uz.kmax.base.fragment.BaseFragmentWC
import uz.kmax.base.fragmentcontroller.InnerFragmentController
import uz.kmax.tatudars.R
import uz.kmax.tatudars.databinding.FragmentMenuBinding
import uz.kmax.tatudars.presentation.fragment.task2.AddFragment
import uz.kmax.tatudars.presentation.fragment.task2.ListFragment

class MenuFragment : BaseFragmentWC<FragmentMenuBinding>(FragmentMenuBinding::inflate) {
    override fun onViewCreated() {

        InnerFragmentController.init(R.id.innerContainer,requireActivity().supportFragmentManager)
        replaceFr(HomeFragment())

        binding.nav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.homePage-> {
                    replaceFr(ListFragment())
                }

                R.id.addContact->{
                    replaceFr(AddFragment())
                }
            }
            true
        }
    }

    private fun replaceFr(fragment : Fragment){
        InnerFragmentController.innerController?.startInnerMainFragment(fragment)
    }
}