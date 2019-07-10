package com.islam.navigationcomponentsexample


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_amount.*
import java.math.BigDecimal

class AmountFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController
    lateinit var recipient: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Getting arguments the normal way
//        recipient = arguments!!.getString("recipient")

        // Getting arguments with Safe Args
        recipient = AmountFragmentArgs.fromBundle(arguments!!).recipient
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
        recipient_text.text = "Sending money to $recipient"
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.send_btn -> {
                if (!TextUtils.isEmpty(input_amount.text.toString())) {
                    val amount = Money(BigDecimal(input_amount.text.toString()))

                    // Passing data between fragments the normal way using bundle
//                    val bundle = bundleOf(
//                        "recipient" to recipient,
//                        "amount" to amount
//                    )
//                    navController!!.navigate(
//                        R.id.action_amountFragment_to_confirmationFragment,
//                        bundle
//                    )

                    // Passing data between fragments with Safe Args
                    val directions = AmountFragmentDirections
                        .actionAmountFragmentToConfirmationFragment(
                            recipient = recipient, amount = amount)
                    navController!!.navigate(directions)
                } else {
                    Toast.makeText(activity, "Enter an amount", Toast.LENGTH_SHORT).show()
                }
            }
            R.id.cancel_btn -> activity!!.onBackPressed()
        }
    }

}
