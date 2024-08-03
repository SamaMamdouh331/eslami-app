package com.example.islamiapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamiapp.R

class TasbehFragment : Fragment() {
    lateinit var numberOfTasbeh: TextView
    lateinit var sebhaTextBtn: Button
    var count = 5

    var sebhaText: Array<String> = arrayOf(
        "سيحان الله", "الحمدلله", "الله اكبر"
    )

    var currentTasbehIndex = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_tasbeeh, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        numberOfTasbeh = view.findViewById(R.id.sebhaNumber)
        sebhaTextBtn = view.findViewById(R.id.sebhaBtn)
        updateText()
        sebhaTextBtn.setOnClickListener {
            if (count > 1) {
                count--
                updateText()
            } else {
                count = 5
                updateText()
                currentTasbehIndex++
                if (currentTasbehIndex > sebhaText.size - 1) {
                    currentTasbehIndex = 0
                }

                sebhaTextBtn.text = sebhaText[currentTasbehIndex]

            }
        }
    }

    fun updateText() {
        numberOfTasbeh.text = count.toString()
    }
}

