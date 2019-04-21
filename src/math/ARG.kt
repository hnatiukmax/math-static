package math

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Text

class ARG : Function() {

    override fun Calculate(`val`: Double): Double {
        return `val`
    }

    override fun CFunction(): Function {
        return CONST(1.0)
    }

    override fun toXML(document: Document, parents_element: Element) {
        val element = document.createElement(this.javaClass.simpleName)
        parents_element.appendChild(element)
        val text = document.createTextNode(" ")
        element.appendChild(text)
    }

    override fun funToString(): String {
        return "x"
    }
}
