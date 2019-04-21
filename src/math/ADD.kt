package math

import java.util.ArrayList

class ADD(args: ArrayList<Function>) : ManyArgsFunctions() {

    init {
        this.args = args
    }

    override fun Calculate(`val`: Double): Double {
        var result = 0.0
        for (item in args) {
            result += item.Calculate(`val`)
        }
        return result
    }

    //    @Override
    //    String funToString() {
    //        String result = " ";
    //        for (Function item: args) {
    //            result += item.funToString() + " + ";
    //        }
    //        return result;
    //    }

    override fun CFunction(): Function {
        val cFunc = ArrayList<Function>()
        for (item in args) {
            cFunc.add(item.CFunction())
        }
        return ADD(cFunc)
    }
}
