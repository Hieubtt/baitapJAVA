package Servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UpLoadServlet
 */
@WebServlet("/UpLoadServlet")
@MultipartConfig
public class UpLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpLoadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("upload-file.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Part part = request.getPart("f");
		String NameFile , linkPath;
		NameFile = part.getSubmittedFileName();
		linkPath = getServletContext().getRealPath("/uploads/");
		
		InputStream is = part.getInputStream();
		OutputStream os = new FileOutputStream(linkPath+NameFile);
		
//		int b;
//		while((b=is.read())!= -1) {
//			os.write(b);
//		}	
		
		
		byte [] mb = new byte[1024];
		int len;
		while((len=is.read(mb,0,1024))>0)
			os.write(mb,0,len); 
		is.close();
		os.close();
		request.setAttribute("tt", NameFile);
		request.getRequestDispatcher("upload-file.jsp").forward(request, response);
	}

}
