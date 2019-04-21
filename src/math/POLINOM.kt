package math

import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Text

import java.util.ArrayList

class POLINOM: Function {
    lateinit var koef: ArrayList<Double>

    constructor(koef: ArrayList<Double>) {
        this.koef = koef
    }

    constructor(vararg args: Double)   {
        var koef1: ArrayList<Double>
        for (item in args) {
            koef.add(item)
        }
    }

    override fun Calculate(`val`: Double): Double {
        var result = 0
        var a = 0
        var n = koef.size - 1
        while (a < koef.size) {
            result += (koef[a] * Math.pow(`val`, n.toDouble())).toInt()
            a++
            n--
        }
        return result.toDouble()
    }

    override fun funToString(): String {
        var result = ""
        var sign: Char

        var a = 0
        var n = koef.size - 1
        while (a < koef.size) {
            if (koef[a] > 0) {
                sign = '+'
            } else {
                sign = '-'
            }
            result += " " + sign + " " + koef[a] + "*" + "x^" + n
            a++
            n--
        }
        return result
    }

    override fun CFunction(): Function {
        val new_koef = ArrayList<Int>()
        var a = 0
        var n = koef.size - 1
        while (a < koef.size) {
            new_koef.add(n * a)
            a++
            n--
        }
        new_koef.removeAt(new_koef.size - 1)
        return POLINOM()
    }

    override fun toXML(document: Document, parents_element: Element) {
        val element = document.createElement(this.javaClass.simpleName)
        element.setAttribute("coefficients", koef.toString())
        parents_element.appendChild(element)
        val text = document.createTextNode(" ")
        element.appendChild(text)
    }
}
