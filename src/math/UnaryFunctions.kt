package math

import org.w3c.dom.Document
import org.w3c.dom.Element

abstract class UnaryFunctions : Function() {
    protected var arg: Function? = null

    override fun toXML(document: Document, parents_element: Element) {
        val element = document.createElement(this.javaClass.simpleName)
        parents_element.appendChild(element)
        arg!!.toXML(document, element)
    }

    override fun funToString(): String {
        return this.javaClass.simpleName + "(" + this.arg!!.funToString() + ")"
    }
}
