package print.get.path;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Datetime: 2024/9/8下午2:19
 * @author: Camellia.xioahua
 */
public class GetPathTest {


    @Test
    void  getPathByClassPathResource(){
        // 使用类加载器获取名为"templates/thymeleaf.html"的资源的URL
        URL url = getClass().getClassLoader().getResource("static/font/simsun.ttc");
        // 获取资源的路径
        String path = url.getPath();
        // 使用类加载器来获取资源的路径并打印出来
        System.out.println("类加载器来获取资源的路径: "+path);
    }



    @Test
    void getPathByClass(){
        // 使用类对象获取资源路径，"/" 表示从根目录开始获取资源
        URL url = getClass().getResource("/static/font/simsun.ttc");
        // 提取资源路径
        String path = url.getPath();
        // 输出路径信息
        System.out.println("类对象获取资源路径: "+path);
    }



    @Test
    void getPathByFile(){
        // 创建一个File对象，指向资源文件系统中的一个特定文件
        File file = new File("src/main/resources/static/font/simsun.ttc");
        // 获取文件的绝对路径
        String path = file.getAbsolutePath();
        // 打印文件的绝对路径
        System.out.println("文件对象获取资源路径: "+path);
    }



    @Test
    void getPathByPaths(){
        // 创建一个Path对象，指向资源文件
        Path path = Paths.get("src/main/resources/static/font/simsun.ttc");
        // 将Path对象转换为绝对路径字符串
        String absolutePath = path.toAbsolutePath().toString();
        // 打印Path对象的绝对路径
        System.out.println("Path对象获取资源路径: "+absolutePath);
    }



    @Test
    void getPathBySystem(){
        // 获取项目根目录
        String userDir = System.getProperty("user.dir");
        // 拼接项目中的资源文件路径
        String path = userDir + "/src/main/resources/static/font/simsun.ttc";
        // 打印通过系统属性获取的资源路径
        System.out.println("系统属性获取资源路径: "+path);
    }

}


//https://www.cnblogs.com/virgosnail/p/10119674.html