package com.yedam.product.service;

import java.util.List;

import com.yedam.product.vo.ProductVO;

public interface ProductService {
	List<ProductVO> productList();
	ProductVO getProduct(String productCode);
}
