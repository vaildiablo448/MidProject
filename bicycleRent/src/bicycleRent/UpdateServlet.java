package bicycleRent;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class bicycleRentServlet
 */
@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Map<String, String> errorMessage = new HashMap<>();
		request.setAttribute("ErrorMsg", errorMessage);
		request.setCharacterEncoding("UTF-8");

		String caseNumS = request.getParameter("caseNum");
		Integer caseNum = Integer.parseInt(caseNumS);

		if (caseNumS == null || caseNumS.trim().length() == 0) {
			errorMessage.put("caseNum", "此欄必須輸入");
		}

		String rentStation = request.getParameter("rentStation");

		if (rentStation == null || rentStation.trim().length() == 0) {
			errorMessage.put("rentStation", "此欄必須輸入");
		}

		String returnStation = request.getParameter("returnStation");

		if (returnStation == null || returnStation.trim().length() == 0) {
			errorMessage.put("returnStation", "此欄必須輸入");
		}

		String totalRentTime = request.getParameter("totalRentTime");

		if (totalRentTime == null || totalRentTime.trim().length() == 0) {
			errorMessage.put("totalRentTime", "此欄必須輸入");
		}

		String rentTimeS = request.getParameter("rentTime");
		java.sql.Date rentTime = null;

		if (rentTimeS == null || rentTimeS.trim().length() == 0) {
			errorMessage.put("rentTime", "此欄必須輸入");
		} else {

			if (rentTimeS != null && rentTimeS.trim().length() > 0) {
				try {
					rentTime = java.sql.Date.valueOf(rentTimeS);
				} catch (IllegalArgumentException e) {

					errorMessage.put("rentTime", "格式錯誤");
				}
			}
		}

		java.sql.Date returnTime = null;
		String returnTimeS = request.getParameter("returnTime");
		if (returnTimeS == null || returnTimeS.trim().length() == 0) {
			errorMessage.put("returnTime", "此欄必須輸入");
		} else {
			if (returnTimeS != null && returnTimeS.trim().length() > 0) {
				try {
					returnTime = java.sql.Date.valueOf(returnTimeS);
				} catch (IllegalArgumentException e) {

					errorMessage.put("returnTime", "格式錯誤");
				}
			}
		}
		if (!errorMessage.isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("/Update.jsp");
			rd.forward(request, response);
			return;
		}
		bicycleBean bB = new bicycleBean(caseNum, rentTime, rentStation, returnTime, returnStation, totalRentTime);
		try {
			bicycleService service = new bicycleService();
			service.update(rentTime, rentStation, returnTime, returnStation, totalRentTime, caseNum);
			request.setAttribute("bicycleBean", bB);
			RequestDispatcher rd = request.getRequestDispatcher("/UpdateSuccess.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
