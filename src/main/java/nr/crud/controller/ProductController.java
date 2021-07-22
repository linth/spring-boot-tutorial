package nr.crud.controller;

import nr.crud.entity.Product;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
    private final List<Product> productDB = new ArrayList<>();

    @PostConstruct
    public void initDB() {
        productDB.add(new Product("B0001", "iPhone", 380));
        productDB.add(new Product("B0002", "Android", 420));
        productDB.add(new Product("B0003", "SONY", 250));
        productDB.add(new Product("B0004", "HTC", 450));
        productDB.add(new Product("B0005", "SAMSUNG", 330));
    }

    @GetMapping("/productInfo/{id}")
    public Product getProduct(@PathVariable("id") String id) {
        Product product = new Product();
        product.setId(id);
        product.setName("George");
        product.setPrice(200);
        return product;
    }

    // 自訂回應 ResponseEntity
    // TODO: ResponseEntity concept.
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductInfo(@PathVariable("id") String id) {
        // TODO: Optional, stream concept.
        Optional<Product> productOp = productDB.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (productOp.isPresent()) {
            Product product = productOp.get();
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/product")
    // TODO: annotation
    public ResponseEntity<Product> createProduct(@RequestBody Product request) {
        boolean isIdDuplicated = productDB.stream().anyMatch(p -> p.getId().equals(request.getId()));

        // TODO: HTTP status concept, and so on.
        /**
         * Reference - https://developer.mozilla.org/zh-TW/docs/Web/HTTP/Status
         * 
         * HTTP status: - 200: OK, 201: create, 202: accepted.
         */
        if (isIdDuplicated) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }

        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        productDB.add(product);

        // TODO: URI
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).body(product);
    }

    @PutMapping("/change_product/{id}")
    public ResponseEntity<Product> changeProduct(@PathVariable String id, @RequestBody Product request) {
        Optional<Product> productOp = productDB.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (productOp.isPresent()) {
            // TODO: Optional get function.
            Product product = productOp.get();
            product.setName(request.getName());
            product.setPrice(request.getPrice());
            return ResponseEntity.ok().body(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete_product/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable("id") String id) {
        // TODO: removeif, or ListArray function.
        boolean isRemoved = productDB.removeIf(p -> p.getId().equals(id));

        // 204 (No Content): 原先資料存在的，但被刪除了；404: 原先並不存在。
        return isRemoved ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/getAllProduct")
    public ResponseEntity<List<Product>> getAllProduct() {
        // TODO: stream and collect concept.
        List<Product> products = productDB.stream().collect(Collectors.toList());

        return ResponseEntity.ok().body(products);
    }

    /**
     * Reference:
     * https://chikuwa-tech-study.blogspot.com/2021/05/spring-boot-controller-2.html
     * 
     */
    @GetMapping("/searchProduct")
    public ResponseEntity<List<Product>> getProductName(@RequestParam(value = "name", defaultValue = "") String name) {
        List<Product> product = productDB.stream().filter(p -> p.getName().toUpperCase().contains(name.toUpperCase()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(product);
    }
}
