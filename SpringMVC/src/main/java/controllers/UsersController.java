package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import JavaBeans.Users;
import businessClassNew.UsersBL_JDBC;

@Controller
public class UsersController {
	@RequestMapping(path="/loai-user/{ml}", method = RequestMethod.GET)
	public String TimUsers(Model model,@PathVariable(name = "ml" , required = false) String ml) { /// cho cái biến bằng đường path 
		
		Users ls = UsersBL_JDBC.getUsersByName(ml);
		List<Users> dslu  = new ArrayList<Users>();
		dslu.add(ls);
		model.addAttribute("dslu", dslu);
		return "loai-user";   /// trả về tên view cho viewResolver
	}
	@RequestMapping(path="/loai-user", method = RequestMethod.GET)
	public String TimUsers2(Model model,@RequestParam(name = "ml" ,defaultValue = "",required = false) String ml) { /// cho cái biến bằng đường path 
		List<Users> dslu = null;
		if(ml.isEmpty())
			dslu = UsersBL_JDBC.getAll();
		else
		{
			Users ls = UsersBL_JDBC.getUsersByName(ml);
			dslu = new ArrayList<Users>();
			dslu.add(ls);
		}
		model.addAttribute("dslu", dslu);
		return "loai-user";   /// trả về tên view cho viewResolver
	}
}
