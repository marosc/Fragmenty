package com.example.fragmenty.intenty

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmenty.R
import kotlinx.android.synthetic.main.intenty_fragment.*


class IntentyFragment : Fragment() {
    private var listener: IntentClicker? = null

    companion object {
        fun newInstance() = IntentyFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.intenty_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_contact.setOnClickListener { listener?.buttonContacts() }
        btn_call.setOnClickListener { listener?.buttonCall() }
        btn_web.setOnClickListener { listener?.buttonWeb() }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IntentClicker) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
