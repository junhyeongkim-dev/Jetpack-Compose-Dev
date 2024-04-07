import java.text.DecimalFormat

fun getDecimalFormat(value: String) : String {
    return if(value.toFloat() == 0f) {
        "0.0"
    }else if(value.toFloat() < 1){
        value
    } else{
        if(value.contains(".")) {
            val integerTemp = value.split(".")[0]
            val decimalTemp = value.split(".")[1]

            DecimalFormat("#,###").format(integerTemp.toLong()) + "." + decimalTemp
        }else {
            DecimalFormat("#,###").format(value)
        }
    }
}

getDecimalFormat("1.11")