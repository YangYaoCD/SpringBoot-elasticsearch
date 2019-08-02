package com.yangyao.elasticsearch.repository;

import com.yangyao.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    //不用写方法实现
    public List<Book> findByBookNameLike(String bookName);
}
