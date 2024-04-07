package com.example.tranunitapp.viewmodel

import androidx.lifecycle.LiveData

interface IMainActivityOutput {
    val inputUnitType: LiveData<UnitType>
    val outputUnitType: LiveData<UnitType>
    val inputValue: LiveData<String>
    val outputValue: LiveData<String>
}