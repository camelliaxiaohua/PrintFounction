package print.service.impl;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import print.service.ConvertHtml;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @Datetime: 2024/9/8 下午3:02
 * @author: Camellia.xioahua
 */
@Service
public class ConvertHtmlImpl implements ConvertHtml {
    @Override
    public String convertHtmlToPDF(String html) {
        ITextRenderer renderer = new ITextRenderer();
        ITextFontResolver fontResolver = renderer.getFontResolver();
        renderer.setDocumentFromString(html);
        // 创建 FileOutputStream 将PDF保存到文件
        try (OutputStream outputStream = new FileOutputStream("thymeleaf.pdf")) {
            String fontPath ="static/font/simsun.ttc";
            fontResolver.addFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            renderer.layout();
            renderer.createPDF(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (com.lowagie.text.DocumentException e) {
            e.printStackTrace();
        }
        return html;
    }


    @Override
    public InputStream convertHtmlToPDFStream(String html) {
        return null;
    }
}
