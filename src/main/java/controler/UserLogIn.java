package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User_DAO;
import dto.User_DTO;

@WebServlet("/userlogin")
public class UserLogIn extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String email = req.getParameter("userEmail");
		String password = req.getParameter("userPassword");
		
		User_DAO dao = new User_DAO();
		try {
			User_DTO result = dao.findDetails(email);
			
			if(result != null)
			{
				if(password.equals(result.getUserPassword()))
				{
					RequestDispatcher dispatcher = req.getRequestDispatcher("User.jsp");
					dispatcher.include(req, resp);
				}
				else
				{
					req.setAttribute("message", "Invalid Password..!");
					RequestDispatcher dispatcher = req.getRequestDispatcher("UserLogIn.jsp");
					dispatcher.include(req, resp);
				}
			}
			else
			{
				req.setAttribute("message", "Invalid Email Id..!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("UserLogIn.jsp");
				dispatcher.include(req, resp);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}