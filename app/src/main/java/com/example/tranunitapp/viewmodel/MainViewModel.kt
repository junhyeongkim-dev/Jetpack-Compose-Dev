package com.example.tranunitapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.tranunitapp.KEY_PAD_BACK
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

) : ViewModel(), IMainActivityInput, IMainActivityOutput {

    var input: IMainActivityInput = this
    var output: IMainActivityOutput = this


    private val _inputUnitType: MutableLiveData<UnitType> = MutableLiveData(UnitType.CM)
    override val inputUnitType: LiveData<UnitType> = _inputUnitType

    private val _outputUnitType: MutableLiveData<UnitType> = MutableLiveData(UnitType.M)
    override val outputUnitType: LiveData<UnitType> = _outputUnitType

    private val _inputValue: MutableLiveData<String> = MutableLiveData("0")
    override val inputValue: LiveData<String> = _inputValue

    private val _outputValue: MutableLiveData<String> = MutableLiveData("0")
    override val outputValue: LiveData<String> = _outputValue

    override fun changeUnit(){
        val inputTemp =_inputUnitType.value
        val outputTemp = _outputUnitType.value

        _inputUnitType.value = outputTemp!!
        _outputUnitType.value = inputTemp!!

        _outputValue.value = convertUnitValue(_inputValue.value!!.toFloat())
    }

    override fun inputKeyPadValue(value: String) {
        if(value == ".") {
            // .이 입력 됐을 때
            if(!_inputValue.value!!.contains(".")) {
                _inputValue.value += value
            }
        }else if(value == KEY_PAD_BACK) {
            // 지우기가 들어왔을 때

            _inputValue.value = _inputValue.value!!.dropLast(1)

            if(_inputValue.value!!.isEmpty()){
                // 빈 값일 때 0 세팅
                _inputValue.value = "0"
            }

            if(_inputValue.value!!.last() == '.') {
                // 마지막 값을 지우고 난 후 의 마지막이 .일 때 스킵

                return
            }

            _outputValue.value = convertUnitValue(_inputValue.value!!.toFloat())
        }else {
            // 숫자가 들어 왔을 때
            if(_inputValue.value!!.length == 1 && _inputValue.value!!.toFloat() == 0f) {
                _inputValue.value = value
            }else{
                _inputValue.value += value
            }

            _outputValue.value = convertUnitValue(_inputValue.value!!.toFloat())
        }
    }

    private fun convertUnitValue(value:Float):String {
        var result = 1f

        result *= when(_inputUnitType.value) {
            UnitType.CM -> 10

            UnitType.M -> 1000
            else -> 1
        }

        result /= when(_outputUnitType.value) {
            UnitType.CM -> 10
            UnitType.M -> 1000
            else -> 1
        }

        return (value.toBigDecimal()*result.toBigDecimal()).toFloat().toString()
    }
}