package cat.insvidreres.inf.layouttheory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView
import cat.insvidreres.inf.layouttheory.databinding.ActivityMainBinding
import java.text.NumberFormat
import java.util.Currency
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val buttonView: Button = findViewById(R.id.calculate_button)
        buttonView.setOnClickListener{
            val tipAmountFieldString = findViewById<EditText>(R.id.editTextCost).text.toString()

            val tipAmount = tipAmountFieldString.toDouble()

            val selectedOption = findViewById<RadioGroup>(R.id.tip_options).checkedRadioButtonId
            val tipPercentage = when(selectedOption) {
                R.id.option_fifteen_percent -> 0.15
                R.id.option_eighteen_percent -> 0.18
                else -> 0.20
            }

            var tip = tipPercentage * tipAmount
            val roundUp = findViewById<Switch>(R.id.round_up_switch).isChecked

            if (roundUp) {
                tip = ceil(tip)
            }

            val nFormat = NumberFormat.getCurrencyInstance()
            nFormat.maximumFractionDigits = 2
            nFormat.currency = Currency.getInstance("EUR")

            val tipFormatted = nFormat.format(tip)

            findViewById<TextView>(R.id.tip_result).text = tipFormatted

        }
    }

//    fun calculateTip() {
//        val stringInTextField = binding.editTextCost.text.toString()
//
//        val cost = stringInTextField.toDouble()
//        val selectedOption = binding.tipOptions.checkedRadioButtonId
//
//        val tipPercentage = when(selectedOption) {
//            R.id.option_fifteen_percent -> 0.15
//            R.id.option_eighteen_percent -> 0.18
//            else -> 0.20
//        }
//        var tip = tipPercentage * cost
//
//        val roundUp = binding.roundUpSwitch.isChecked
//
//        if (roundUp) {
//            tip = ceil(tip)
//        }
//    }
}