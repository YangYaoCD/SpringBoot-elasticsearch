package com.yangyao.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * SpringBoot默认支持两种技术来和ES交互
 * 1、Jest(默认不生效，需要导入包)
 * 2、SpringData ElasticSearch
 *      1）Client 节点信息clusterNodes;clusterName
 *      2）ElasticsearchTemplate操作es
 *      3）编写一个ElasticsearchRepository的子接口来操作ES;
 *      两种用法：
 *          1 编写一个ElasticsearchRepository
 */
@SpringBootApplication
public class ElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApplication.class, args);
    }

}
