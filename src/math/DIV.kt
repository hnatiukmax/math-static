package math

import java.util.ArrayList

class DIV(first: Function, second: Function) : BinaryFunctions() {

    init {
        this.first = first
        this.second = second
    }

    override fun Calculate(`val`: Double): Double {
        return first!!.Calculate(`val`) / second!!.Calculate(`val`)
    }

    override fun CFunction(): Function {
        val l_r = ArrayList<Function>()
        l_r.add(MULT(first!!.CFunction(), second!!))
        l_r.add(MULT(first!!, second!!.CFunction()))

        val up = DIFF(l_r)
        val down = MULT(second!!, second!!)
        return DIV(up, down)
    }
}
