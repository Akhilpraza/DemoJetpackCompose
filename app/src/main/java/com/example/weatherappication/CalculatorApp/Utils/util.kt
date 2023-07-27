package com.example.composedemo.CalculatorApp.Utils

fun calculateTotalTip(
    totalBill: Double,
    tipParcentage: Int): Double {

    return if (totalBill > 1 && totalBill.toString().isNotEmpty())
        (totalBill * tipParcentage)/100 else 0.0

}

fun calculateTotalPerPerson(
    totalBill: Double,
    splitBy :Int,
    tipParcentage: Int
) : Double{
    val  bill = calculateTotalTip(totalBill = totalBill, tipParcentage = tipParcentage) +totalBill
    return (bill/splitBy)
}