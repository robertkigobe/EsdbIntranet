package technicalResources.IT;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;

/**
 * Servlet implementation class GetDetails
 */
@WebServlet("/GetChartDetails")
public class GetChartDetails extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetChartDetails()
	{
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		response.setContentType("application/json;charset=UTF-8");

		response.setHeader("Cache-Control", "no-cache");

		PrintWriter out = response.getWriter();
		String jsonData = "";

		try
		{
			String jsonp = request.getParameter("jsonp");
			GetChartData getChartData = new GetChartData();
			jsonData = getChartData.GenerateJSonChartDataYearWisePassPercentage(jsonp);
			out.print(jsonData);
		}
		catch (JSONException e)
		{
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	}

}