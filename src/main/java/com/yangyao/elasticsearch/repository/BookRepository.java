package com.yangyao.elasticsearch.repository;

import com.yangyao.elasticsearch.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
