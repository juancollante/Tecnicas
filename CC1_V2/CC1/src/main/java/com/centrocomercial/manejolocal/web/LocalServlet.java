package com.centrocomercial.manejolocal.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.centrocomercial.manejolocal.modelo.Local;
import com.centrocomercial.manejolocal.dao.LocalDAO;

/**
 * Servlet implementation class LocalServlet
 */
@WebServlet("/")
public class LocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LocalDAO LocalDAO;

	public void init() {
		LocalDAO = new LocalDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertLocal(request, response);
				break;
			case "/delete":
				deleteLocal(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateLocal(request, response);
				break;
			default:
				listLocal(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listLocal(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Local> listLocal = LocalDAO.selectAllLocales();
		request.setAttribute("listLocal", listLocal);
		RequestDispatcher dispatcher = request.getRequestDispatcher("local-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("local-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		
		String numero = request.getParameter("numero");
		
		Local existingLocal = LocalDAO.selectLocal(numero);
		RequestDispatcher dispatcher = request.getRequestDispatcher("local-form.jsp");
		request.setAttribute("local", existingLocal);
		dispatcher.forward(request, response);

	}

	private void insertLocal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
			
		String nombre = request.getParameter("nombre");
		String number = request.getParameter("numero");
		String tamaño = request.getParameter("tamano");
		String vendeComida = request.getParameter("vendeComida");
		String ventas = request.getParameter("ventas");
		Local newlocal = new Local(nombre, number, tamaño, vendeComida, ventas);
		
		LocalDAO.insertLocal(newlocal);
		response.sendRedirect("list");
		
		
	}

	private void updateLocal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String nombre = request.getParameter("nombre");
		String numero = request.getParameter("numero");
		String tamaño = request.getParameter("tamano");
		String vendeComida = request.getParameter("vendeComida");
		String ventas = request.getParameter("ventas");
		Local local = new Local(nombre, numero, tamaño, vendeComida, ventas);
		LocalDAO.updateLocal(local);
		response.sendRedirect("list");
	}

	private void deleteLocal(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String numero = request.getParameter("numero");
		LocalDAO.deleteLocal(numero);
		response.sendRedirect("list");
	}

}
