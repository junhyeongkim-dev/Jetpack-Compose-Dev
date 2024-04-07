package com.example.tranunitapp.viewmodel

import androidx.lifecycle.LiveData
import com.example.tranunitapp.types.UnitType

interface IMainActivityOutput {
    val inputUnitType: LiveData<UnitType>
    val outputUnitType: LiveData<UnitType>
    val inputValue: LiveData<String>
    val outputValue: LiveData<String>
}