package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Vd1Servlet
 */
@WebServlet("/Vd1Servlet")
public class Vd1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private int  a = 1 ;
    private int cong (int x , int y) {
    	return x+y;
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vd1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int b = 2 ;
		int t = cong(a,b);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title> Ví dụ 1 Servlet </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Tổng : " +a+ "+"+b+"="+t+"</h3>");
		request.getRequestDispatcher("chao.jsp").include(request, response);
		//minh hoạ dùng JSP tag chèn java  vào jsp
		out.println("</body>");
		out.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
