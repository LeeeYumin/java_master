package com.yedam.product.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.product.mapper.ProductMapper;
import com.yedam.product.service.ProductService;
import com.yedam.product.vo.ProductVO;


public class ProductServiceImpl implements ProductService{
	SqlSession session = DataSource.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);

	@Override
	public ProductVO getProduct(String prodCode) {

		return mapper.getProduct(prodCode);
	}
	
	public List<ProductVO> productList(){
		return mapper.selectList();
	}
}
