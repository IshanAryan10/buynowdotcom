package com.dailycodework.buynowdotcom.controller;

import com.dailycodework.buynowdotcom.dtos.ProductDto;
import com.dailycodework.buynowdotcom.model.Product;
import com.dailycodework.buynowdotcom.request.AddProductRequest;
import com.dailycodework.buynowdotcom.request.ProductUpdateRequest;
import com.dailycodework.buynowdotcom.response.ApiResponse;
import com.dailycodework.buynowdotcom.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController
{
    private final IProductService productService;

    @GetMapping("/all")//this was changed from "products" to all in lecture 77
    //Exists
    public ResponseEntity<ApiResponse> getAllProducts()
    {
        List<Product> products = productService.getAllProducts();
        List<ProductDto> convertedProducts = productService.getConvertedProducts(products);
        return ResponseEntity.ok(new ApiResponse("Found", convertedProducts));

    }

    @GetMapping("product/{productId}/product")
    //Exists
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long productId)
    {

            Product product = productService.getProductById(productId);
            ProductDto productDto = productService.convertToDto(product);
            return ResponseEntity.ok(new ApiResponse("Found", productDto));

    }

    @PostMapping("/add")
    //Exists
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product)
    {
            Product theProduct = productService.addProduct(product);
            ProductDto productDto = productService.convertToDto(theProduct);
            return ResponseEntity.ok(new ApiResponse("Add Product Success!", productDto));
    }

    @PutMapping("/product/{productId}/update")
    //Exists
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductUpdateRequest request, @PathVariable Long productId)
    {

            Product theProduct = productService.updateProduct(request, productId);
            ProductDto productDto = productService.convertToDto(theProduct);
            return ResponseEntity.ok(new ApiResponse("Update Product Success!", productDto));
    }

    @DeleteMapping("/product/{productId}/delete")
    //Exists
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId)
    {
            productService.deleteProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Delete Product Success!", productId));

    }

    @GetMapping("/by/brand")
    public ResponseEntity<ApiResponse> getProductsByBrand(
            @RequestParam String brand)
    {
        List<Product> products =
                productService.getProductsByBrand(brand);

        List<ProductDto> convertedProducts =
                productService.getConvertedProducts(products);

        return ResponseEntity.ok(
                new ApiResponse("Found", convertedProducts));
    }

    @GetMapping("/by/category")
    public ResponseEntity<ApiResponse> getProductsByCategory(
            @RequestParam String category)
    {
        List<Product> products =
                productService.getProductsByCategory(category);

        List<ProductDto> convertedProducts =
                productService.getConvertedProducts(products);

        return ResponseEntity.ok(
                new ApiResponse("Found", convertedProducts));
    }

    @GetMapping("/products/by/brand-and-name")
    //Exists
    public ResponseEntity<ApiResponse> getProductsByBrandAndName(@RequestParam String brandName, @RequestParam String productName) {

        List<Product> products = productService.getProductsByBrandAndName(brandName, productName);
        List<ProductDto> convertedProducts = productService.getConvertedProducts(products);
        return ResponseEntity.ok(new ApiResponse("Success", convertedProducts));
    }

    @GetMapping("/products/by/category-and-brand")
    //Exists
    public ResponseEntity<ApiResponse> getProductsByCategoryAndBrand(
            @RequestParam String category,
            @RequestParam String brand)
    {

            List<Product> products = productService.getProductsByCategoryAndBrand(category, brand);
            List<ProductDto> convertedProducts = productService.getConvertedProducts(products);
            return ResponseEntity.ok(new ApiResponse("Success", convertedProducts));
    }

    @GetMapping("/products/{name}/products")
    //Exists
    public ResponseEntity<ApiResponse> getProductsByName(
            @PathVariable String name)
    {
            List<Product> products = productService.getProductsByName(name);
            List<ProductDto> convertedProducts = productService.getConvertedProducts(products);
            return ResponseEntity.ok(new ApiResponse("Success", convertedProducts));
    }

    /* Present in resource but not in project
    @GetMapping("/product/by-brand")
    public ResponseEntity<ApiResponse> findProductByBrand(@RequestParam String brand) {
        List<Product> products = productService.getProductsByBrand(brand);
        List<ProductDto> convertedProducts = productService.getConvertedProducts(products);
        return ResponseEntity.ok(new ApiResponse("success", convertedProducts));
    }

    @GetMapping("/product/{category}/all/products")
    public ResponseEntity<ApiResponse> findProductsByCategory(@PathVariable String category) {
        List<Product> products = productService.getProductsByCategory(category);
        List<ProductDto> convertedProducts = productService.getConvertedProducts(products);
        return ResponseEntity.ok(new ApiResponse("success", convertedProducts));
    }*/

}
