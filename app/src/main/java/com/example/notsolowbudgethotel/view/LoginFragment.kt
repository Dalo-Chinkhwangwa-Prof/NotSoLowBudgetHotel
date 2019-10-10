package com.example.notsolowbudgethotel.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.notsolowbudgethotel.R
import kotlinx.android.synthetic.main.login_fragment_layout.*

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.login_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_button.setOnClickListener { _ ->

            if (passcode_edittext.text.toString().trim() == "7777") {
                fragmentManager?.popBackStack()
            } else {
                Toast.makeText(activity, "WRONG PASSWORD! SEE MANAGER", Toast.LENGTH_LONG).show()
            }
            passcode_edittext.text.clear()
        }
    }
}