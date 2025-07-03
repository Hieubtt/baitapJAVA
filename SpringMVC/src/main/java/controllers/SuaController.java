package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/sua")
public class SuaController {
	@RequestMapping(path="/them.html") // -> /sua/them.html
	public String themSua(Model model) {
		model.addAttribute("thongBao","Trang thêm Sữa"); // request.setAttribute("thongBao","Trang them sua")
		return "sua";                                    // request.getRequestDispatcher(/WEB-INF/vỉews/sua.jsp).forward(request,respone)
		
	}
	@RequestMapping(path="/tim.html")
	public String timSua(Model model) {
		model.addAttribute("thongBao","Trang tìm Sữa");
		return "sua";
		
	}
	@RequestMapping(path="/xoa.html")
	public String xoaSua(Model model) {
		model.addAttribute("thongBao","Trang xoá Sữa");
		return "sua";
		
	}
}
