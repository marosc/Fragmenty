package com.example.fragmenty.nav

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmenty.R
import kotlinx.android.synthetic.main.nav1_fragment.*

class Nav1Fragment : Fragment() {
    private var listener: ButtonClicker? = null

    companion object {
        fun newInstance() = Nav1Fragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.nav1_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_goTo2.setOnClickListener { listener?.buttonClicked() }
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
