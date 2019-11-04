package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateLoan()
        }
    }

    private fun calculateLoan(){
        //TODO get all inputs from user and perform calculation
        if(editTextCarPrice.text.isEmpty()){ //if not empty
            editTextCarPrice.setError(getString(R.string.error))
            return //stop execution
        }

        val carPrice = editTextCarPrice.text.toString().toInt()
        val downPayment = editTextdownPayment.text.toString().toInt()
        val loanPeriod = editTextLoanPeriod.text.toString().toInt()
        val interestRte = editTextInterestRte.text.toString().toFloat()

        val currency = Currency.getInstance(Locale.getDefault())
        var symbol = currency.symbol

        //TODO Display the outputs
        val loan = carPrice - downPayment;
        val interest = (loan * interestRte * loanPeriod)
        val monthlyPayment = (loan + interest) / loanPeriod

        textViewLoan.setText(getString(R.string.loan) + symbol +  "${loan}")
        textViewInterest.setText(getString(R.string.interest)  + symbol +"${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthlyPayment) + symbol + "${monthlyPayment}")
    }

    fun resetInput(view: View) {
        //TODO: Clear all inputs and outputs
        textViewLoan.setText(getString(R.string.loan))
        textViewInterest.setText(getString(R.string.interest))
        textViewMonthlyRepayment.setText(getString(R.string.monthlyPayment))
        editTextCarPrice.setText(null)
        editTextInterestRte.setText(null)
        editTextLoanPeriod.setText(null)
        editTextdownPayment.setText(null)
    }
}
