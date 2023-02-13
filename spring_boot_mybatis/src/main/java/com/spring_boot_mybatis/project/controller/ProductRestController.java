package com.spring_boot_mybatis.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_mybatis.project.model.ProductVO;
import com.spring_boot_mybatis.project.service.ProductService;


@RestController
public class ProductRestController {
	@Autowired
	ProductService service;
	@RequestMapping("/product/productSearch3")
	public ArrayList<ProductVO> productSearch1(@RequestParam HashMap<String, Object> param,
			Model model){
// 서비스로 전송해서 DB 검색 결과 받아옴
ArrayList<ProductVO> prdList = service.productSearch(param);		
return prdList;
}

}
