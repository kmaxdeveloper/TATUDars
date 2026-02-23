package uz.kmax.tatudars.task2

import android.graphics.Color
import android.os.Bundle
import android.widget.RadioButton
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
            if (variantList[selectedVariant].text == testList[currentLevel].answer){
                binding.testStatus.text = "TEST JAVOBI TO'G'RI"
                binding.testStatus.setTextColor(Color.GREEN)
            }else{
                binding.testStatus.text = "TEST JAVOBI NOTO'G'RI"
                binding.testStatus.setTextColor(Color.RED)
            }
        }
    }

    private fun allWorks() {
        for (i in 0 until binding.radioList.childCount){
            variantList.add(binding.radioList.getChildAt(i) as RadioButton)
            if (variantList[i].isChecked || variantList[i].isSelected){
                selectedVariant = i
            }
        }

        binding.testQuestion.text = testList[currentLevel].question
    }

    private fun addTest() {
        testList.add(TestData(
            "Current Windows is .... ?",
            "Windows 11",
            listOf(
                "Windows 11","Windows 10","Windows 8", "Windows XP"
            )
        ))
    }
}