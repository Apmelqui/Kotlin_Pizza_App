package com.hfad.adrianomelquiades_comp304_002_lab01_ex02

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Defining local variables
        var editTextName = findViewById<EditText>(R.id.editTextName)
        //var editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        var editTextPhone = findViewById<EditText>(R.id.editTextPhone)

        var spinnerPizzaSizes = findViewById<Spinner>(R.id.spinnerPizzaSizes)

        var checkBoxOnion = findViewById<CheckBox>(R.id.checkBoxOnion)
        var checkBoxPepper = findViewById<CheckBox>(R.id.checkBoxPepper)
        var checkBoxTomato = findViewById<CheckBox>(R.id.checkBoxTomato)
        var checkBoxOlive = findViewById<CheckBox>(R.id.checkBoxOlive)

        var radioButtonHome = findViewById<RadioButton>(R.id.radioButtonHome)
        var radioButtonTakeOut = findViewById<RadioButton>(R.id.radioButtonTakeOut)

        var buttonPlaceOrder = findViewById<Button>(R.id.buttonPlaceOrder)
        var textViewOutput = findViewById<TextView>(R.id.textViewOutput)


        //Creating event handler for the button
        buttonPlaceOrder.setOnClickListener {

            var selectedPizzaSize = spinnerPizzaSizes.selectedItem.toString()
            var total = 0.0

            //If statement for the size of the pizza
            if (selectedPizzaSize == "Small - \$10.00") {
                total = 10.0
            } else if (selectedPizzaSize == "Medium - \$12.00") {
                total = 12.0
            } else if (selectedPizzaSize == "Large - \$14.00") {
                total = 14.0
            }

            //If statement for the toppings
            if (checkBoxOnion.isChecked) {
                total += 1.0
            }
            if (checkBoxPepper.isChecked) {
                total += 1.0
            }
            if (checkBoxTomato.isChecked) {
                total += 1.0
            }
            if (checkBoxOlive.isChecked) {
                total += 1.0
            }

            //If statement for delivery
            if (radioButtonHome.isChecked) {
                total += 5.0
            }
            textViewOutput.text = "Order detais: \nCustomer Name: ${editTextName.text} \nPhone: ${editTextPhone.text} \nTotal: ${String.format("$%.2f", total)}"
            Toast.makeText(applicationContext, "Total: ${String.format("$%.2f", total).toString()}", Toast.LENGTH_SHORT).show()
        }
    }
}


