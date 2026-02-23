package uz.kmax.tatudars.task2

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import uz.kmax.tatudars.data.model.TestData
import uz.kmax.tatudars.databinding.ActivityTask2TestBinding



class TestActivity : AppCompatActivity() {
    private var testList : ArrayList<TestData> = ArrayList()
    private var variantList : ArrayList<RadioButton> = ArrayList()
    private var currentLevel = 0
    private var selectedVariant = -1

    private lateinit var binding : ActivityTask2TestBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTask2TestBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
                Toast.makeText(this, "Variantni tanlang !", Toast.LENGTH_SHORT).show()
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