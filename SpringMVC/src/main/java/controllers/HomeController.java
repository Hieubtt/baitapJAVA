package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@RequestMapping({"/","/home.html"})
	public String home() {
		return "home";			//--> viewResolver = prefix + "home" + suffix --> /WEB-INF/views/home.jsp
		// request.getRequestDispatcher("Views/gio-hang.jsp").forward(request,response)
		// request.getRequestDispatcher("Views/san-pham-moi.jsp").forward(request,response)
	}
		@RequestMapping("/gethieubtt")
	@ResponseBody
	public String gethieubtt(@CookieValue(name="hieubtt") String s) {
		return s;
	}
}
