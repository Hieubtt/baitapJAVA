package controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UpLoadController {

	
	@RequestMapping(path = "/upload-file" , method = RequestMethod.GET)
	
	public String upLoadFile() { //HttpServletRequest request,@RequestParam(name ="file") MultipartFile part
		
		return "upload-file";  /// trả về cái tên định nghĩa trong file tiles.xml
	}
}
