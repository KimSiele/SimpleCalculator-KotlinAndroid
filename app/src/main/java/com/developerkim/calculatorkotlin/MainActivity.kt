package com.developerkim.calculatorkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.developerkim.calculatorkotlin.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

//    private lateinit var binding:ActivityMainBinding
    private var operaton = ""
    private var value1:Double = 0.0
    private var value2:Double = 0.0
    private var  result:Double = 0.0
    private  lateinit var stringBuilder: StringBuilder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        stringBuilder = StringBuilder()

        btnZero.setOnClickListener{buttonClick(btnZero)}
        btnOne.setOnClickListener{buttonClick(btnOne)}
        btnTwo.setOnClickListener{buttonClick(btnTwo)}
        btnThree.setOnClickListener{buttonClick(btnThree)}
        btnFour.setOnClickListener{buttonClick(btnFour)}
        btnFive.setOnClickListener{buttonClick(btnFive)}
        btnSix.setOnClickListener{buttonClick(btnSix)}
        btnSeven.setOnClickListener{buttonClick(btnSeven)}
        btnEight.setOnClickListener{buttonClick(btnEight)}
        btnNine.setOnClickListener{buttonClick(btnNine)}
        btnDot.setOnClickListener{buttonClick(btnDot)}
        btnAdd.setOnClickListener{math(btnAdd)}
        btnMinus.setOnClickListener{math(btnMinus)}
        btnMult.setOnClickListener{math(btnMult)}
        btnDiv.setOnClickListener{math(btnDiv)}

        btnCancel.setOnClickListener{buttonClick(btnCancel)}
        btnDelete.setOnClickListener{buttonClick(btnDelete)}

        btnEqual.setOnClickListener { buttonEqual() }
    }
    fun buttonClick(view: View){

        var value = etxtResult.text.toString()

        when(view){

            btnZero -> {
                value += "0"
                stringBuilder.append("0")
            }
            btnOne -> {
                value += "1"
                stringBuilder.append("1")

            }
            btnTwo -> {
                value += "2"
                stringBuilder.append("2")

            }
            btnThree -> {
                value += "3"
                stringBuilder.append("3")

            }
            btnFour -> {
                value += "4"
                stringBuilder.append("4")

            }
            btnFive -> {
                value += "5"
                stringBuilder.append("5")

            }
            btnSix -> {
                value += "6"
                stringBuilder.append("6")

            }
            btnSeven -> {
                value += "7"
                stringBuilder.append("7")

            }
            btnEight -> {
                value += "8"
                stringBuilder.append("8")

            }
            btnNine -> {
                value += "9"
                stringBuilder.append("9")

            }
            btnDot -> {
                value += "."
                stringBuilder.append(".")
            }
            btnCancel ->{
                value = ""
            }
            btnDelete ->{
                value = etxtResult.text.toString()
                if (value.length > 0){
                    value = value.substring(0, value.length - 1)
                }
                if (stringBuilder.length > 0){
                    stringBuilder.deleteCharAt(stringBuilder.length - 1)
                    txtProcess.text = stringBuilder
                }
            }
        }
        etxtResult.setText(value)

        txtProcess.text = stringBuilder
    }

    fun math(view: View){

        when(view){
            btnAdd ->{
                operaton = "+"
            }
            btnMinus ->{
                operaton = "-"
            }

            btnMult ->{
                operaton = "*"
            }

            btnDiv ->{
                operaton = "/"
            }

        }

        val value = etxtResult.text.toString()
        value1 = value.toDouble()

//        clearing edittext values
        etxtResult.text.clear()

        stringBuilder.append(operaton)
        txtProcess.text = stringBuilder


    }

    fun buttonEqual(){

        val value = etxtResult.text.toString()
        value2 = value.toDouble()

        when(operaton){
            "+" ->{
                if (!value1.toString().isEmpty()) {
                    result = value1 + value2
                } else{
                    Toast.makeText(this@MainActivity,"Please Enter first value",Toast.LENGTH_SHORT).show()
                    etxtResult.requestFocus()
                }
            }
            "-" ->{
                if (!value1.toString().isEmpty()) {
                result = value1 - value2
                } else {
                    Toast.makeText(this@MainActivity, "Please Enter first value", Toast.LENGTH_SHORT).show()
                    etxtResult.requestFocus()
                }
            }
            "*" ->{
                if (!value1.toString().isEmpty()) {
                result = value1 * value2 }
                else {
                     Toast.makeText(this@MainActivity, "Please Enter first value", Toast.LENGTH_SHORT).show()
                    etxtResult.requestFocus()
                 }


            }
            "/" ->{
                if (!value1.toString().isEmpty()) {
                    result = value1 / value2
                } else {
                    Toast.makeText(this@MainActivity, "Please Enter first value", Toast.LENGTH_SHORT).show()
                    etxtResult.requestFocus()
                }
            }
        }

        etxtResult.setText(result.toString())
        stringBuilder.append(" = ")
        stringBuilder.append(result)
        txtProcess.text = stringBuilder

    }


}
