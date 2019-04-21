package math

import org.w3c.dom.Document
import org.w3c.dom.Element

import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException
import javax.xml.transform.OutputKeys
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerException
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult
import java.io.FileNotFoundException
import java.io.FileOutputStream

abstract class Function {

    abstract fun Calculate(`val`: Double): Double
    abstract fun funToString(): String
    abstract fun CFunction(): Function
    abstract fun toXML(document: Document, parents_element: Element)


    @Throws(ParserConfigurationException::class, TransformerException::class, FileNotFoundException::class)
    fun createXML(fileName: String, rootName: String): Document {
        val factory = DocumentBuilderFactory.newInstance()
        val builder = factory.newDocumentBuilder()
        val document = builder.newDocument()

        val root = document.createElement(rootName)
        document.appendChild(root)

        this.toXML(document, root)

        val t = TransformerFactory.newInstance().newTransformer()
        t.setOutputProperty(OutputKeys.INDENT, "yes")

        t.transform(DOMSource(document), StreamResult(FileOutputStream(fileName)))
        return document
    }
}
