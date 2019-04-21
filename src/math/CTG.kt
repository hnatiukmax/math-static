package math

class CTG internal constructor(arg: Function) : UnaryFunctions() {
    init {
        this.arg = arg
    }

    override fun Calculate(`val`: Double): Double {
        return 1 / Math.tan(arg!!.Calculate(`val`))
    }

    override fun CFunction(): Function {
        return MULT(arg!!.CFunction(), DIV(CONST(-1.0), MULT(SIN(arg!!), SIN(arg!!))))
    }
}
