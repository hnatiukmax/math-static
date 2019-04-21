package math

import org.w3c.dom.Document
import org.w3c.dom.Element

abstract class BinaryFunctions : Function() {
    protected var first: Function? = null
    protected var second: Function? = null

    override fun funToString(): String {
        val sign: Char
        if (this.javaClass.simpleName.replace("\\s".toRegex(), "") == "MULT") {
            sign = '*'
        } else {
            sign = '/'
        }
        return first!!.funToString() + " " + sign + " " + second!!.funToString()
    }

    override fun toXML(document: Document, parents_element: Element) {
        val element = document.createElement(this.javaClass.simpleName)
        parents_element.appendChild(element)
        first!!.toXML(document, element)
        second!!.toXML(document, element)
    }
}
