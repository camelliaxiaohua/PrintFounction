package print.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import print.service.ConvertHtml;
import print.service.HtmlRenderTemplate;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Datetime: 2024/9/8 下午2:04
 * @author: Camellia.xioahua
 */
@Service
public class HtmlRenderTemplateImpl implements HtmlRenderTemplate {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private ConvertHtml convertHtml;

    @Override
    public void renderByThymeleaf() {
        Map<String,Object> varisblesMap = new HashMap<>();
        varisblesMap.put("english","Camellia 中文测试");
        varisblesMap.put("chinese","小花");
        Context context = new Context();
        context.setVariables(varisblesMap);
        String thymeleaf = templateEngine.process("thymeleaf", context);
        convertHtml.convertHtmlToPDF(thymeleaf);
    }

}
