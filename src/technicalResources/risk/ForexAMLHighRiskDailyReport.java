package technicalResources.risk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sz.co.swazibank.beans.DirectoryBean;
import util.ConnectionHelper;


@WebServlet("/ForexAMLHighRiskDailyReport")
public class ForexAMLHighRiskDailyReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Connection con;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Statement selectStatement = null;
		ResultSet results = null;
		
		ArrayList<ForexAMLRiskDailyBean> forexAMLRiskDailyList = new ArrayList<ForexAMLRiskDailyBean>();

		forexAMLRiskDailyList.clear();

		ConnectionHelper connectionHelper = new ConnectionHelper();
		con = connectionHelper.connect();
		if (con != null) {

			String sql = "SELECT [id],[transactionDate],[customerName] ,[branch] ,[currency] ,[amount] ,[destination]  ,[cif]  FROM [dbo].[forexAMLRiskDailyTransactions]"
					+ " where [cif] in ('161445','239720','355584','111754','172141','108342','128169','241668','170259','192235','270307','270308','281321','457530','338689','188709','508754','508708','155201','109952','495018','109952','338779','528264','101861','104332','105740','106199','108192','108329','108944','113107','113934','116850','119024','119376','119965','122823','131912','135400','135671','140046','146934','159479','166173','166686','174653','178810','179838','185767','200914','202563','207478','208528','212547','218130','219454','223043','226358','228584','228626','228627','228902','229180','229996','232767','234572','234634','236330','250659','266145','268294','277455','292082','299626','301888','301905','302093','302100','302152','302236','302306','302365','302513','302584','302850','302946','303125','303569','304187','319180','513256','355412','525606','232952','576522','194640','469787','213577','492068','246789','234572','336127','119965','201546','175348','161445','239720','171415','119959','576365','217486','162539','166595','194326','584086','570326','460927','563364','377978','590273','590576','567560','570808','209657','604526','199008','208280','507993','607520','468949','569986','526105','54516','180314')";

			try {
				selectStatement = con.createStatement();
				results = selectStatement.executeQuery(sql);

				while (results.next()) {
					
					String transactionDate = results.getString("transactionDate");
					String customerName = results.getString("customerName");
					String branch = results.getString("branch");
					String currency = results.getString("currency");
					String amount = results.getString("amount");
					String destination = results.getString("destination");
					String cif = results.getString("cif");
				
					forexAMLRiskDailyList.add(new ForexAMLRiskDailyBean(transactionDate,customerName,  branch , currency, amount , destination , cif));
				}
				
				request.setAttribute("forexAMLRiskDailyList", forexAMLRiskDailyList);

				RequestDispatcher view = request
						.getRequestDispatcher("WEB-INF/technicalResources_risk/forexAMLHighRiskDailyReport.jsp");
				view.forward(request, response);
				
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Cannot connect to activity database here");
			}

			finally {
				if (con != null) {
					try {
						ConnectionHelper.disconnect(con);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
