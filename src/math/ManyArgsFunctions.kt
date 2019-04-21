package math

import org.w3c.dom.Document
import org.w3c.dom.Element

import java.util.ArrayList

abstract class ManyArgsFunctions : Function() {
    internal var args = ArrayList<Function>()

    override fun funToString(): String {
        val sign: Char
        var result = ""
        if (this.javaClass.simpleName == "ADD") {
            sign = '+'
        } else {
            sign = '-'
        }
        for (item in args) {
            result += item.funToString() + " " + sign + " "
        }
        return result.substring(0, result.length - 3)
    }


    override fun toXML(document: Document, parents_element: Element) {
        val element = document.createElement(this.javaClass.simpleName)
        parents_element.appendChild(element)
        for (item in args) {
            item.toXML(document, element)
        }
    }
}
