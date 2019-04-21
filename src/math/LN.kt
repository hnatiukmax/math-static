package math

class LN(arg: Function) : UnaryFunctions() {
    init {
        this.arg = arg
    }

    override fun Calculate(`val`: Double): Double {
        return Math.log(arg!!.Calculate(`val`))
    }

    override fun CFunction(): Function {
        return MULT(arg!!.CFunction(), DIV(CONST(1.0), arg!!))
    }
}
