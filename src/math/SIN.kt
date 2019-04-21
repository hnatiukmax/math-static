package math

class SIN internal constructor(arg: Function) : UnaryFunctions() {
    init {
        this.arg = arg
    }

    override fun Calculate(`val`: Double): Double {
        return Math.sin(arg!!.Calculate(`val`))
    }


    override fun CFunction(): Function {
        return MULT(arg!!.CFunction(), COS(arg!!))
    }
}
