package math

import java.util.ArrayList

class DIFF(args: ArrayList<Function>) : ManyArgsFunctions() {

    init {
        this.args = args
    }

    override fun Calculate(`val`: Double): Double {
        var result = args[0].Calculate(`val`)
        for (i in 1 until args.size) {
            result -= args[i].Calculate(`val`)
        }
        return result
    }

    override fun CFunction(): Function {
        val cFunc = ArrayList<Function>()
        for (item in args) {
            cFunc.add(item.CFunction())
        }
        return DIFF(cFunc)
    }
}
