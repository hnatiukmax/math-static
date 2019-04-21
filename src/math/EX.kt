package math

class EX(arg: Function) : UnaryFunctions() {
    init {
        this.arg = arg
    }

    override fun Calculate(`val`: Double): Double {
        return Math.exp(arg!!.Calculate(`val`))
    }


    override fun CFunction(): Function {
        return MULT(arg!!.CFunction(), this)
    }
}
