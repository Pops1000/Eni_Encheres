package fr.eni.enchere.dal;

import java.io.IOException;

import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.enchere.dal.jdbc.ConnectionProvider;

/**
 * Servlet implementation class ConnectionTestServlet
 */
@WebServlet("/ConnectionTestServlet")
public class ConnectionTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(Connection connection = ConnectionProvider.getConnection()){
			response.getWriter().append("La connection est réussie");
		}
		catch(Exception e) {
			response.getWriter().append("La connection a échouée, regarder le stacktrace");
			e.printStackTrace();
		}
	}
}
