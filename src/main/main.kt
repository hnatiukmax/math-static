package main

import math.*

fun main(args: Array<String>) {
    //lambda 1
    val function = MULT(CONST(4.0), ARG())
    val exp1 : (Double) -> Double  =  { value ->  function.Calculate(value) }

    //lambda 2
    val exp2 = { value : Double -> value*4 + Math.pow(value, 3.0) }

    println("Value of Integrate exp1 = " +
            "${Numerical_Methods.Integrate(exp1, 0.0, 4.0, IntegrateType.TRAPEZE)}")
    println("Value of Integrate exp2 = " +
            "${Numerical_Methods.Integrate(exp2, 0.0, 4.0, IntegrateType.TRAPEZE)}")
}