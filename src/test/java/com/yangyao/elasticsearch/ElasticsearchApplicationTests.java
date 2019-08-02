package com.yangyao.elasticsearch;

import com.yangyao.elasticsearch.bean.Article;
import com.yangyao.elasticsearch.bean.Book;
import com.yangyao.elasticsearch.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchApplicationTests {

    @Autowired
    JestClient jestClient;
    @Autowired
    BookRepository bookRepository;


    //第二种方法操作elasticsearch，最方便的方法
    @Test
    public void  test02(){
        Book book = new Book();
        book.setId(1);
        book.setAuthor("吴承恩");
        book.setBookName("西游记");
        bookRepository.index(book);
    }

    //模糊查询
    @Test
    public void test03(){
        //快速for each：alt+enter然后第二个回车
        for (Book book : bookRepository.findByBookNameLike("记")) {
            System.out.println(book.toString());
        }
    }




    @Test
    public void contextLoads() {
        //1.给Es中索引（保存）一个文档
        Article article = new Article();
        article.setId(2);
        article.setTitle("好消息");
        article.setAuthor("zhangsan");
        article.setContent("Hello world");

        //构建一个索引功能
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //测试搜索
    @Test
    public void search(){
        String json="{\n" +
                "    \"query\": {\n" +
                "        \"match\": {\n" +
                "            \"author\": \"zhangsan\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
