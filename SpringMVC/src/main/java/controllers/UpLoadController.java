package controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	@RequestMapping(path = "/upload-file" , method = RequestMethod.POST)
	public String upLoadFile(HttpServletRequest request,@RequestParam(name = "file") MultipartFile part,Model model) {
		String teptin = part.getOriginalFilename();
		String thuMuc= request.getServletContext().getRealPath("/upload/");
		try {
			InputStream is = part.getInputStream();
			OutputStream os = new FileOutputStream(thuMuc+teptin);
			int b; 
//			while((b= is.read())!=-1)
//			{
//				os.write(b);
//			}
			byte[] mb = part.getBytes();
			os.write(mb);
			is.close();
			os.close();
			model.addAttribute("teptin", teptin);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "upload-file"; 
	}
}
