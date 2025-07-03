package controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import JavaBeans.LoaiSua;
import businessClassNew.LoaiSuaBL;

@Controller
public class LoaiSuaController {
	///Thêm
	@RequestMapping(path="/them-loai-sua-1", method = RequestMethod.GET)
	public String themLoaiSua() {
		return "them-loai-sua-1";   /// trả về tên view cho viewResolver
	}
	@RequestMapping(path="/them-loai-sua-1", method = RequestMethod.POST)
	public String themLoaiSua(HttpServletRequest request) throws UnsupportedEncodingException {
		String maLoai,tenLoai;
		request.setCharacterEncoding("UTF-8");
		maLoai= request.getParameter("txtMaLoai");
		tenLoai= request.getParameter("txtTenLoai");
		
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(maLoai);
		ls.setTenLoai(tenLoai);
		LoaiSuaBL.them(ls);
		return "them-loai-sua-1"; //// redirect: trả về đường dẫn them-loai-sua-1(không phải tên view)
	}
	
	
	///Cập nhật
	@RequestMapping(path="/cap-nhat-ten-loai-sua-1", method = RequestMethod.GET)
	public String hienThiFormCapNhatLoai(Model model) {
		List<LoaiSua> dsLoai = LoaiSuaBL.TimTheoLoaiSuaAll(); // nếu có dùng
		model.addAttribute("dsLoai", dsLoai); // để render <select>    /// trả về tên view cho viewResolver 
		return "cap-nhat-ten-loai-sua-1"; // -> WEB-INF/views/cap-nhat-ten-loai-sua-1.jsp
	}
	@RequestMapping(path="/cap-nhat-ten-loai-sua-1", method = RequestMethod.POST)
	public String upDateLoaiSua(HttpServletRequest request) throws UnsupportedEncodingException {
		String maLoai,tenLoai;
		request.setCharacterEncoding("UTF-8");
		maLoai= request.getParameter("txtMaLoai");
		tenLoai= request.getParameter("txtTenLoai");
		
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(maLoai);
		ls.setTenLoai(tenLoai);
		LoaiSuaBL.capnhat(ls);
		//System.out.println("Đang cập nhật: " + ls.getMaLoai() + " -> " + ls.getTenLoai());
		return "redirect:/cap-nhat-ten-loai-sua-1"; //// redirect: trả về đường dẫn cap-nhat-ten-loai-sua-1(không phải tên view)
	}

	//// Xóa 
	@RequestMapping(path="/xoa-loai-sua", method = RequestMethod.GET)
	public String hienThiFormXoaLoai(Model model) {
		List<LoaiSua> dsLoai = LoaiSuaBL.TimTheoLoaiSuaAll(); // nếu có dùng
		model.addAttribute("dsLoai", dsLoai); // để render <select>    /// trả về tên view cho viewResolver 
		return "xoa-loai-sua"; // -> WEB-INF/views/cap-nhat-ten-loai-sua-1.jsp
	}
	
	@RequestMapping(path="/xoa-loai-sua", method = RequestMethod.POST)
	public String DeleteLoaiSua(HttpServletRequest request) throws UnsupportedEncodingException {
		String maLoai;
		//request.setCharacterEncoding("UTF-8");
		maLoai= request.getParameter("txtMaLoai");
		//tenLoai= request.getParameter("txtTenLoai");
		LoaiSua ls = new LoaiSua();
		ls.setMaLoai(maLoai);
		//ls.setTenLoai(tenLoai); 
		LoaiSuaBL.xoaLoaiSua(ls);
		return "redirect:/xoa-loai-sua"; //// redirect: trả về đường dẫn cap-nhat-ten-loai-sua-1(không phải tên view)
	}
	
}
