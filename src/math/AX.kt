package math

import org.w3c.dom.Document
import org.w3c.dom.Element

class AX(arg: Function, internal var foundation: Double) : UnaryFunctions() {

    init {
        this.arg = arg
    }

    override fun Calculate(`val`: Double): Double {
        return Math.pow(foundation, arg!!.Calculate(`val`))
    }

    override fun CFunction(): Function {
        return MULT(this, CONST(Math.log(foundation)))
    }

    override fun funToString(): String {
        return foundation.toString() + "^" + "(" + arg!!.funToString() + ")"
    }

    override fun toXML(document: Document, parents_element: Element) {
        val element = document.createElement(this.javaClass.simpleName)
        element.setAttribute("foundation", java.lang.Double.toString(foundation))
        parents_element.appendChild(element)
        arg!!.toXML(document, element)
    }
}
