package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.Movie_DAO;
import dto.Movie_DTO;

@WebServlet("/UpdateAdmin")
public class UpdateMovie extends HttpServlet
{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		int id = Integer.parseInt(req.getParameter("id"));
		
		Movie_DAO dao = new Movie_DAO();
		try {
			Movie_DTO list= dao.findDetails(id);
			if(list != null)
			{
				req.setAttribute("message", list);
				RequestDispatcher dispatcher = req.getRequestDispatcher("Update.jsp");
				dispatcher.include(req, res);
			}
			else
			{
				req.setAttribute("error", "Something Went Wrong...!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("Update.jsp");
				dispatcher.include(req, res);				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}