package com.app.calculator

import kotlinx.android.synthetic.main.activity_main.result
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private val calculation = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)
    }

    fun appendToCalculation(view: View) {
        val buttonClicked = view as? Button
        buttonClicked?.let {
            calculation.append(it.text.toString())
            result.text = calculation.toString()
        }
    }

    fun calculateResult(view: View) {
        val calculationResult = eval(calculation.toString())
        result.text = calculationResult
        calculation.clear()
        calculation.append(calculationResult)
    }

    private fun eval(mathExpression: String): String {
        return Expression(mathExpression).calculate().toString()
    }

    fun clear(view: View) {
        result.text = ""
        calculation.clear()
    }

    fun undo(view: View) {
        result.text = result.text.dropLast(1)
        calculation.deleteCharAt(calculation.length -1 )
    }
}
