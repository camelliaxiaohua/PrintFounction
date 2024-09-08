package print.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import print.service.ConvertHtml;
import print.service.HtmlRenderTemplate;

/**
 * @Datetime: 2024/9/8 下午2:08
 * @author: Camellia.xioahua
 */

@RestController
public class HtmlConvertController {


    @Autowired
    private HtmlRenderTemplate htmlRenderTemplate;

    @GetMapping("/htmlConvertPDF")
    public ResponseEntity<String> htmlConvertPDF(){
        htmlRenderTemplate.renderByThymeleaf();
        return ResponseEntity.ok("PDF conversion complete");
    }
}
