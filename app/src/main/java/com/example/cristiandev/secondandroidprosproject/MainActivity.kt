package com.example.cristiandev.secondandroidprosproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_restaurant_full.*

class MainActivity : AppCompatActivity() {

    val initialSet:ConstraintSet = ConstraintSet()
    val finalSet:ConstraintSet = ConstraintSet()
    var full : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_full)
        initialSet.clone(this,R.layout.activity_restaurant)
        finalSet.clone(root)

        fab.setOnClickListener {
            TransitionManager.beginDelayedTransition(root)
            if(full) initialSet.applyTo(root)
            else finalSet.applyTo(root)
            full = !full
        }

        loadData()

    }
    fun loadData(){
        name.text = "La Pizarra"
        location.text = "Parque el Recuerdo"
        phone.text = "8234675"
        description.text = "Pizzeria en el parque el recuerdo"
    }
}
