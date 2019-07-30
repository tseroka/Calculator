package com.app.calculator

import kotlinx.android.synthetic.main.activity_main.answer_tv
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

    fun appendToComputation(view: View) {
        val buttonClicked = view as? Button
        buttonClicked?.let {
            computation.append(it.text.toString())
        }
    }

    fun computeResult(view: View) {
        val resultButton = view as? Button
        resultButton?.let {
            answer_tv.text = eval(computation.toString())
        }
    }

    private fun eval(mathExpression: String): String {
        return Expression(mathExpression).calculate().toString()
    }

    fun clear(view: View) {
        answer_tv.text = ""
        computation.clear()
    }
}
