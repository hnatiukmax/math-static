package math

class TNG internal constructor(arg: Function) : UnaryFunctions() {
    init {
        this.arg = arg
    }

    override fun Calculate(`val`: Double): Double {
        return Math.tan(arg!!.Calculate(`val`))
    }

    override fun CFunction(): Function {
        return MULT(arg!!.CFunction(), DIV(CONST(1.0), MULT(COS(arg!!), COS(arg!!))))
    }
}
