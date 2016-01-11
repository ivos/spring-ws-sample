package com.github.ivos.ws.it;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

public class XmlUtils {

    public static String normalize(String xml) {
        return removeNamespaces(indent(xml));
    }

    private static String indent(String xml) {
        try {
            InputSource is = new InputSource(new StringReader(xml));
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            OutputFormat format = new OutputFormat();
            format.setIndenting(true);
            format.setIndent(4);
            Writer out = new StringWriter();
            new XMLSerializer(out, format).serialize(document);
            return out.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String removeNamespaces(String xml) {
        // remove NS declarations
        xml = xml.replaceAll("xmlns:.*=\".*\"", "").replaceAll("xmlns=\".*\"", "").replaceAll("\\p{Space}+>", ">");
        // remove NS at element start
        xml = xml.replaceAll("<[^/\":]+:", "<");
        // remove NS at element end
        xml = xml.replaceAll("</[^\":]+:", "</");
        return xml;
    }

}
