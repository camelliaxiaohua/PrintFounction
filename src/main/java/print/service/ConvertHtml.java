package print.service;

import java.io.InputStream;

/**
 * @Datetime: 2024/9/8下午3:02
 * @author: Camellia.xioahua
 */
public interface ConvertHtml {

    String convertHtmlToPDF(String html);

    InputStream convertHtmlToPDFStream(String html);
}
