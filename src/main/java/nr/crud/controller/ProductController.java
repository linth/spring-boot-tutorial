package nr.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nr.crud.entity.Product;

/**
 * 定義API的controller和路徑
 * 
 * Reference -
 * https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-controller-1.html
 * 
 * 問題: - 如何確認每個@keyword有什麼功能? 如: @RequestMapping -
 */
@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {
    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        Product product = new Product();
        product.setId(id);
        product.setName("George");
        product.setPrice(200);

        return product;
    }
}
