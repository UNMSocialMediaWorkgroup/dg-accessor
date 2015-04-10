package edu.unm.carc.socialmedia.dg_accessor;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Sixstring982
 * @since 4/12/2015
 */
public class Query {

    private final String QUERY_BASE = "http://www.pollicompsus.com/get/xml/";

    private final String queryString;

    public Query() {
        queryString = QUERY_BASE;
    }

    public Query(List<String> filters) {
        StringBuilder builder = new StringBuilder("?");
        for (int i = 0; i < filters.size(); i++) {
            builder.append(filters.get(i));
            if (i < filters.size() - 1) {
                builder.append("&");
            }
        }

        queryString = QUERY_BASE + builder.toString();
    }

    public List<Record> execute()
            throws IOException, SAXException, ParserConfigurationException {
        InputStream xmlStream = IOUtil.webRequestToStream(queryString);
        QueryHandler qh = new QueryHandler();

        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.parse(xmlStream, qh);

        return qh.records;
    }
}
