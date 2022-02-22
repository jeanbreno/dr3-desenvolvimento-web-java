package br.edu.infnet.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.model.domain.User;

public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserController() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("home.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String pwd = request.getParameter("pwd");
		
		User user = new User(nome, email, pwd);
		
		request.setAttribute("usr", user.getNome());
		
		request.getRequestDispatcher("confirmacao.jsp").forward(request, response);
	}

}
