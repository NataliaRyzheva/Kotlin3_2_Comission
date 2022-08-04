val type1 = "Maestro"
val type2 = "MasterCard"
val type3 = "VISA"
val type4 = "Мир"
val type5 = "VK Pay"

fun main(args: Array<String>) {
    calcPay(1000000)
    calcPay(1000000, cardType = type3, 8000000)
    calcPay(1000000, cardType = type1, 8000000)
    calcPay(10000, cardType = type4)
    calcPay(1000000, cardType = type2)
}

fun calcPay(amountNow: Int, cardType: String = type5, amountMonth: Int = 0) {
    println("**********************************")
    println("Сумма перевода: " + convertToRubKop(amountNow))
    println("Тип карты: $cardType")
    println("Сумма предыдущих переводов в этом месяце: " + convertToRubKop(amountMonth))
    println("Комиссия : " + convertToRubKop(calcCommission(cardType, amountMonth, amountNow)))
}

fun calcCommission(cardType: String, amountMonth: Int, amountNow: Int): Int {

    val maxType1 = 75000_00
    val fixType1 = 20_00
    val commissionType1 = 0.006
    val fixType3 = 35_00
    val commissionType3 = 0.0075
    val commissionType5 = 0

    when (cardType)  {
        type1, type2 ->  { if
            ((amountMonth + amountNow) < maxType1) return 0
            else return  (amountNow * commissionType1 + fixType1).toInt()
        }
        type3, type4 ->  { if
                ((amountNow * commissionType3) < fixType3)  return fixType3
            else return  (amountNow * commissionType3).toInt()
        }
        type5 -> {
            return commissionType5
        }
    }
return 0
}

fun convertToRubKop(amount: Int): String {
    return (amount / 100).toInt().toString() + " руб " + amount % 100 + " коп"
}










