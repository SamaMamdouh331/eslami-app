package com.example.islamiapp.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.islamiapp.R

//tasbeeh fragment
class TasbehFragment : Fragment() {
    lateinit var numberOfTasbeh: TextView
    lateinit var sebhaTextBtn: Button
    var rotationAngle: Float = 0f
    var count = 0
    var sebhaText: Array<String> = arrayOf(
        "سيحان الله", "الحمدلله", "الله اكبر"
    )
    var currentTasbehIndex = 0;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_tasbeeh, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val image = view.findViewById<ImageView>(R.id.sebhaBody)
        numberOfTasbeh = view.findViewById(R.id.sebhaNumber)
        sebhaTextBtn = view.findViewById(R.id.sebhaBtn)
        updateText()
        sebhaTextBtn.setOnClickListener {
            if (count < 33) {
                count++
                updateText()
                rotateImage(image)
            } else {
                count = 0
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
    fun rotateImage(view: View) {
        rotationAngle += 45f
        ObjectAnimator.ofFloat(view, "rotation", rotationAngle).apply {
            duration = 500
            start()
        }

    }
}

