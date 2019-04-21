package math

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Text

class CONST (val arg : Double) : Function() {

    override fun Calculate(`val`: Double): Double {
        return arg
    }

    override fun funToString(): String {
        return java.lang.Double.toString(arg)
    }

    override fun CFunction(): Function {
        return CONST(0.0)
    }

    override fun toXML(document: Document, parents_element: Element) {
        val element = document.createElement(this.javaClass.simpleName)
        parents_element.appendChild(element)
        val text = document.createTextNode(" ")
        element.appendChild(text)
    }
}
