package com.islam.navigationcomponentsexample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_confirmation.*
import kotlinx.android.synthetic.main.fragment_main.*


class ConfirmationFragment : Fragment() {

    lateinit var recipient: String
    lateinit var money: Money

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Getting arguments the normal way
//        recipient = arguments!!.getString("recipient")
//        money = arguments!!.getParcelable("amount")

        // Getting arguments with Safe Args
        recipient = ConfirmationFragmentArgs.fromBundle(arguments!!).recipient
        money = ConfirmationFragmentArgs.fromBundle(arguments!!).amount
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirmation_message.text = "You have sent $${money.amount} to $recipient"
    }
}
