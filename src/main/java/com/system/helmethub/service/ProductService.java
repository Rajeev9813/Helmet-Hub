package com.system.helmethub.service;


import com.system.helmethub.dto.ProductDto;
import com.system.helmethub.entity.Product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    void saveProduct(ProductDto productDto) throws IOException;

    List<Product> findLatestProduct();

    int countAllProducts(String partialName);

    List<Product> getSixProducts(int page, String partialName);

    Optional<Product> getProduct(int id);
}
