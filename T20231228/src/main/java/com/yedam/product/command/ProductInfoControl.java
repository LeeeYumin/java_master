package com.yedam.product.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.product.service.ProductService;
import com.yedam.product.serviceImpl.ProductServiceMybatis;
import com.yedam.product.vo.ProductVO;

public class ProductInfoControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String productCode = req.getParameter("productCode");
		
		ProductService svc = new ProductServiceMybatis();
		ProductVO vo = svc.getProduct(productCode);
		
		req.setAttribute("vo", vo);
		
		//페이지 이동(forward)
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/product/productInfo.jsp");
		try {
			rd.forward(req, resp); 
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}

	}

}
