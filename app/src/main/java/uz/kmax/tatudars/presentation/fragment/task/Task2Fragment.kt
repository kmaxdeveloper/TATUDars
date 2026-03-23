package uz.kmax.tatudars.presentation.fragment.task

import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import uz.kmax.base.fragment.BaseFragmentNV
import uz.kmax.tatudars.domain.model.TestData
import uz.kmax.tatudars.databinding.FragmentTask2Binding

class Task2Fragment : BaseFragmentNV<FragmentTask2Binding>(FragmentTask2Binding::inflate) {
    private var testList : ArrayList<TestData> = ArrayList()
    private var variantList : ArrayList<RadioButton> = ArrayList()
    private var currentLevel = 0
    private var selectedVariant = -1
    override fun onViewCreated() {
        addTest()
        allWorks()
        binding.testCheck.setOnClickListener {
            selectedVariant = binding.radioList.checkedRadioButtonId
            val indexRadio = binding.root.findViewById<RadioButton>(selectedVariant)
            if (selectedVariant != -1) {
                Log.d("TEST", "onCreate: WORKED")
                if (indexRadio.text == testList[currentLevel].answer) {
                    binding.testStatus.visibility = View.VISIBLE
                    binding.testStatus.text = "TEST JAVOBI TO'G'RI"
                    binding.testStatus.setTextColor(Color.GREEN)
                } else {
                    binding.testStatus.visibility = View.VISIBLE
                    binding.testStatus.text = "TEST JAVOBI NOTO'G'RI"
                    binding.testStatus.setTextColor(Color.RED)
                }
            }else{
                Toast.makeText(requireContext(), "Variantni tanlang !", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun allWorks() {
        for (i in 0 until binding.radioList.childCount){
            variantList.add(binding.radioList.getChildAt(i) as RadioButton)
        }

        for (i in 0 until variantList.size){
            variantList[i].text = testList[currentLevel].variantList[i]
        }
        binding.testQuestion.text = testList[currentLevel].question
    }

    private fun addTest() {
        testList.add(TestData(
            "Android dasturlashda asosan qaysi dasturlash tillari ishlatiladi ?",
            "Java/Kotlin",
            listOf(
                "Java/Kotlin","Python/Matlab","Prolog/TypeScript", "JavaScript/C#"
            )
        ))
    }
}