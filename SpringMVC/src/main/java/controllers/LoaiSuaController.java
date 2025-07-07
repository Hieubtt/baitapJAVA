package controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	///Thêm
		@RequestMapping(path="/them-loai-sua-2", method = RequestMethod.GET)
		public String themLoaiSua2() {
			return "them-loai-sua-2";   /// trả về tên view cho viewResolver
		}
		@ModelAttribute
		public void setFond(HttpServletRequest request) {
			try {
				request.setCharacterEncoding("utf-8");
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}
		}
		@RequestMapping(path="/them-loai-sua-2", method = RequestMethod.POST)
		public String themLoaiSua2(HttpServletRequest request,@RequestParam(name="txtMaLoai") String ml,@RequestParam(name="txtTenLoai")String tl,Model model) {

			LoaiSua ls = new LoaiSua();
			ls.setMaLoai(ml);
			ls.setTenLoai(tl);
			int result1 = LoaiSuaBL.them(ls);
			if (result1 == -1) {
		        model.addAttribute("error", "Mã loại sữa đã tồn tại!");
		    } else if (result1 == 0) {
		        model.addAttribute("error", "Lỗi khi thêm dữ liệu!");
		    } else {
		        model.addAttribute("message", "Thêm thành công!");
		    }
			return "them-loai-sua-2"; //// redirect: trả về đường dẫn them-loai-sua-1(không phải tên view)
		}
		@RequestMapping(path="/them-loai-sua-3", method = RequestMethod.GET)
		public String themLoaiSua3() {
			return "them-loai-sua-3";   /// trả về tên view cho viewResolver
		}
		@RequestMapping(path = "/them-loai-sua-3", method = RequestMethod.POST)
		public String themLoaiSua3(LoaiSua ls, Model model) {
		    int result = LoaiSuaBL.them(ls); // Giả sử: -1 = mã trùng, 0 = lỗi khác, 1 = thành công

		    if (result == -1) {
		        model.addAttribute("error", "Mã loại sữa đã tồn tại!");
		    } else if (result == 0) {
		        model.addAttribute("error", "Lỗi khi thêm dữ liệu!");
		    } else {
		        model.addAttribute("message", "Thêm thành công!");
		    }

		    return "them-loai-sua-3"; // Trả về view (form thêm)
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
	
	///Tìm kiếm theo mã loại
//		@RequestMapping(path="/loai-sua", method = RequestMethod.GET)
//		public String LoaiSua(Model model) { /// cho cái biến bằng đường path 
//			List<LoaiSua> dsls = LoaiSuaBL.TimTheoLoaiSuaAll();
//			model.addAttribute("dsls", dsls);
//			return "loai-sua";   /// trả về tên view cho viewResolver
//		}
		
		@RequestMapping(path="/loai-sua/{ml}", method = RequestMethod.GET)
		public String TimLoaiSua2(Model model,@PathVariable(name = "ml" , required = false) String ml) { /// cho cái biến bằng đường path 
			
			LoaiSua ls = LoaiSuaBL.DocTheoMaLoaiID(ml);
			List<LoaiSua> dsls  = new ArrayList<LoaiSua>();
			dsls.add(ls);
			model.addAttribute("dsls", dsls);
			return "loai-sua";   /// trả về tên view cho viewResolver
		}
		@RequestMapping(path="/loai-sua", method = RequestMethod.GET)
		public String TimLoaiSua(Model model,@RequestParam(name = "ml" ,defaultValue = "",required = false) String ml) { /// cho cái biến bằng đường path 
			List<LoaiSua> dsls = null;
			if(ml.isEmpty())
				dsls = LoaiSuaBL.DocTatCa();
			else
			{
				LoaiSua ls = LoaiSuaBL.DocTheoMaLoaiID(ml);
				dsls = new ArrayList<LoaiSua>();
				dsls.add(ls);
			}
			model.addAttribute("dsls", dsls);
			return "loai-sua";   /// trả về tên view cho viewResolver
		}
		
		
	
}
