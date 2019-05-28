package bicycleRent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class bicycleRentServlet
 */
@WebServlet("/find.do")
public class findServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public findServlet() {
        super();   
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String caseNum1 = request.getParameter("caseNum");
		Integer caseNum = Integer.parseInt(caseNum1);
		try {
			bicycleService service = new bicycleService();
			request.setAttribute("bicycleBean", service.findByPk(caseNum));				
			RequestDispatcher rd = request.getRequestDispatcher("/FindSuccess.jsp");
			rd.forward(request, response);
			return;
        } catch (Exception e) {
			e.printStackTrace();		
		}
	}
}
