package com.spring_boot_mybatis.project.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_boot_mybatis.project.model.ProductVO;
import com.spring_boot_mybatis.project.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService service;
	
	// 시작 시 index.jsp 페이지 열기
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	// 전체 상품 조회
	@RequestMapping("/product/productListAll")
	public String viewProductListAll(Model model) {
		// ProductService의  listAllProduct() 호출 (ProductService의 객체 필요 : DI 설정필요)
		ArrayList<ProductVO> prdList = service.listAllProduct();
		model.addAttribute("prdList", prdList);
		return "product/productAllListView";
	}
	// 상품 등록 폼 열기
	@RequestMapping("/product/productNewForm")
	public String productNewForm( ) {
		return "product/productNewForm";
	}
	//상품 등록
	@RequestMapping("/product/productInsert")
	public String insertProduct(ProductVO prd) {
		//서비스를 통해서 DB에 저장
		service.insertProduct(prd);
		return "redirect:/product/productListAll";
	}
	// 상품 상세조회 : 요청 url 뒤에 상품번호 붙여서 전달 : @PathVariable 로 받음
	@RequestMapping("/product/detailViewProduct/{prdNo}")
	public String detailViewProduct(@PathVariable String prdNo,
									Model model) {
		// 서비스에게 상품번호 전달하고 상품 정보 받아옴
		ProductVO prd = service.detailViewProduct(prdNo);
		model.addAttribute("prd", prd);
	return "product/productDetailView";
	}
	
	//상품 정보 수정 폼 열기 (수정할 데이터를 미리 출력하기 위해 상품 상세정보 결과 출력)
	@RequestMapping("/product/updateProductForm/{prdNo}")
	public String updateProductForm(@PathVariable String prdNo,
								 	Model model) {
		// 서비스에게 상품번호 전달하고 상품 정보 받아옴
		ProductVO prd = service.detailViewProduct(prdNo);
		model.addAttribute("prd", prd);
		return "product/productUpdateForm";
	}
	//상품 정보 수정 : 수정된 데이터 DB에 저장
	@RequestMapping("/product/updateProduct")
	public String updateProduct(ProductVO prd) {
		service.updateProduct(prd);
		//데이터 수정 후 상품 조회 화면으로 포워딩
		return "redirect:/product/productListAll";

	}
	
	//상품 정보 삭제
	//삭제할 상품의 상품번호 전달 받음 :@PathVariable 사용
	@RequestMapping("/product/deleteProduct/{prdNo}")
	public String deleteProduct(@PathVariable String prdNo) {
		service.deleteProduct(prdNo);
		
		return "redirect:/product/productListAll";
	
	}
	
	//제품번호 중복체크
	@ResponseBody
	@RequestMapping("/product/prdNoCheck")
	public String prdNoCheck(@RequestParam("prdNo") String prdNo) {
		// 서비스 호출하고 DB에 prdNo 존재하면 prdNo 받고, 존재하지 않으면 null 받음
		String prdNo_result = service.prdNoCheck(prdNo);
		
		String result = "use";
		if(prdNo_result != null)  // 존재한다면
			result = "no_use";
		
		return result;
	}
	
	//상품 검색 1 폼 열기
	@RequestMapping("/product/productSearchForm1")
	public String productSearchForm1() {
		return "product/productSearchForm1";
	}
	
	// 상품 검색1 처리
	@ResponseBody
	@RequestMapping("/product/productSearch1")
	public ArrayList<ProductVO> productSearch1(@RequestParam HashMap<String, Object> param,
																					Model model){
	// 서비스로 전송해서 DB 검색 결과 받아옴
	ArrayList<ProductVO> prdList = service.productSearch(param);		
	return prdList;
	}
	
	// 상품 검색 폼2 열기
		@RequestMapping("/product/productSearchForm2")
		public String productSearchForm2() {
			return "product/productSearchForm2";
		}
			
		// 상품 검색2 처리
		@RequestMapping("/product/productSearch2")
		public String productSearch2(@RequestParam HashMap<String, Object> param,
																						Model model){
			// 서비스로 전송해서 DB 검색 결과 받아옴
			ArrayList<ProductVO> prdList = service.productSearch(param);	
			model.addAttribute("prdList", prdList);
			return "product/productSearchResultView"; // productSearchResultView.jsp
		}
	
	
		
		// 상품 검색 폼3 열기
			@RequestMapping("/product/productSearchForm3")
			public String productSearchForm3() {
				return "product/productSearchForm3";
			}
				

	
	
	
	
	
	
	
	
	
	
	
	
	

}