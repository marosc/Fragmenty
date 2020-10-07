package com.example.fragmenty.nav

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmenty.R
import kotlinx.android.synthetic.main.nav2_fragment.*

class Nav2Fragment : Fragment() {
    private var listener: ButtonClicker? = null

    companion object {
        fun newInstance() = Nav2Fragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.nav2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_goTo1.setOnClickListener { listener?.button2Clicked() }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ButtonClicker) {
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
