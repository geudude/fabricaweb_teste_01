package br.com.fabricateste.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fabricateste.persistencia.entidade.Usuario;
import br.com.fabricateste.persistencia.jdbc.UsuarioDAO;

@WebServlet("/autenticador.do")
public class AutenticadorController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usu = new Usuario();
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario logado = usuarioDAO.autenticar(usu);
		if (logado != null){
			HttpSession sessao = req.getSession();
			sessao.setAttribute("usuarioLogado", logado);
			sessao.setMaxInactiveInterval(5);
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		}else{
			resp.getWriter().print("<script> widow.alert('Usuario não encontrado!'); location.href='login.html';</script>");
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession sessao = req.getSession(false);
		if (sessao != null){
			sessao.invalidate();
		}
		resp.sendRedirect("login.html");
		
	}
}
