package math

class COS internal constructor(arg: Function) : UnaryFunctions() {
    init {
        this.arg = arg
    }

    override fun Calculate(`val`: Double): Double {
        return Math.cos(arg!!.Calculate(`val`))
    }

    override fun CFunction(): Function {
        return MULT(arg!!.CFunction(), MULT(CONST(-1.0), SIN(arg!!)))
    }
}
