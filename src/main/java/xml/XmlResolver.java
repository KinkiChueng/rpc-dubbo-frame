package xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class XmlResolver {
    public static List doParse() {
        //首先获得XmlPullParserFactory对象
        SAXReader reader = new SAXReader();
        Document document = null;
        try {
            document = reader.read(new File("dubbo-consumer"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        Element bookStore = document.getRootElement();
        return null;
    }
}
