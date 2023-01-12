package xhd.practice.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class getTxt {
    // 爬取目标网址：从第一章开始爬取，直至最后一章
    private static String url = "http://www.paoshuzw.com/26/26874/13244872.html";
    // 输出文件名称(一般为书名)，如果仅仅是想拿来用改这两个参数就够了
    private static String fileName = "仓元图";
    // 空格，四格位置
    private static String space = "    ";
    // 文件输出流
    private static FileWriter writer;
    // 计数器
    private static int pageCount = 1;
    // 启动类函数
    public static void main(String[] args) throws Exception {
        // 初始化程序
        getWriter();
        long l = System.currentTimeMillis();
        // 循环爬取小说
        do {
            Element element = nextPage(url);
            outputToFile(element);
            url = hasNext(element);
        } while (url != null);
        writer.close();
        long time = (System.currentTimeMillis() - l) / 1000;
        System.out.println("\n\n 成功爬取所有章节！耗时" + time + "秒");
    }
    // 爬取页面
    private static Element nextPage(String url) throws Exception{
        // 获取连接实例，伪造浏览器身份
        Connection conn = Jsoup.connect(url)
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
                .header("Accept-Encoding", "gzip, deflate")
                .header("Accept-Language", "zh-CN,zh;q=0.9,en;q=0.8,en-GB;q=0.7,en-US;q=0.6")
                .header("Cache-Control", "max-age=0")
                .header("Connection", "keep-alive")
                .header("Host", url)
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Safari/537.36 Edg/88.0.705.56");
        return conn.execute().parse().body();
    }
    // 获取当前章节标题
    private static String getTitle(Element element) {
        return element.select(".bookname h1").text();
    }
    // 获取章节具体内容
    private static String getContent(Element element) {
        // 删除底部P标签的广告内容
        element.getElementsByTag("p").remove();
        // 获取到ID为content的所有HTML内容
        String body = element.select("#content").html();
        // 对body进行处理，返回正常格式的内容
        body = body.replace("&nbsp;&nbsp;&nbsp;&nbsp;", space);
        body = body.replace("<br>", "");
        return body.replace(" \n \n", "\r\n");
    }
    // 是否有下一页？有返回下一页URL地址，没有就返回NULL
    private static String hasNext(Element element) {
        // 找到"下一章"的按钮，获取跳转的目标地址
        Elements div = element.getElementsByClass("bottem2");
        Element a = div.get(0).getElementsByTag("a").get(3);
        String href = a.attr("href");
        // 通过观察存在下一章的时候URL会以.html结尾，不存在时会跳转到首页，通过这个特点判断是否存在下一章
        return href.endsWith(".html") ? "http://www.paoshuzw.com" + href : null;
    }
    // 获取输出流
    private static void getWriter() throws IOException {
        String path = "D:/" + fileName + ".txt";
        File file = new File(path);
        if (file.exists()) {
            System.out.println("目标书籍已存在！请修改文件名称或删除原书籍：" + path);
            System.exit(0);
        }
        writer = new FileWriter(file);
    }
    // 输出到文件
    private static void outputToFile(Element element) throws IOException {
        String title = getTitle(element);
        String content = getContent(element);
        String text = space + title + "\r\n\r\n" + content;
        writer.write(text);
        writer.flush();
        System.out.println("==>>【" + title + "】爬取完成，正在爬取下一章（第" + pageCount++ + "次操作）");
    }
}
