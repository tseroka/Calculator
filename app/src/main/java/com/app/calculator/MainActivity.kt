package com.app.calculator

import kotlinx.android.synthetic.main.activity_main.result
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private val computation = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun appendToCalculation(view: View) {
        val buttonClicked = view as? Button
        buttonClicked?.let {
            computation.append(it.text.toString())
            result.text = computation.toString()
        }
    }

    fun calculateResult(view: View) {
        val resultButton = view as? Button
        resultButton?.let {
            result.text = eval(computation.toString())
        }
    }

    private fun eval(mathExpression: String): String {
        return Expression(mathExpression).calculate().toString()
    }

    fun clear(view: View) {
        result.text = ""
        computation.clear()
    }
}
