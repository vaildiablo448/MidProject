package bicycleRent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/delete.do")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public deleteServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String caseNumS = request.getParameter("caseNum");
		Integer caseNum=Integer.parseInt(caseNumS);
			bicycleService service = new bicycleService();
			service.remove(caseNum);
			RequestDispatcher rd = request.getRequestDispatcher("/DeleteSuccess.jsp");
			rd.forward(request, response);
			return;

	}

}
