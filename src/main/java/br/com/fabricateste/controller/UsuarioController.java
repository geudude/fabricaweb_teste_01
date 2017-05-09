package br.com.fabricateste.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fabricateste.persistencia.entidade.Usuario;
import br.com.fabricateste.persistencia.jdbc.UsuarioDAO;

@WebServlet("/usucontroller.do")
public class UsuarioController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4677932485104624574L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String nome =  req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		Usuario usu = new Usuario();
		if( id!= null)
			usu.setId(Integer.parseInt(id));
		usu.setNome(nome);
		usu.setLogin(login);
		usu.setSenha(senha);
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.salvar(usu);
		
		resp.getWriter().println("<h1>Sucesso ao Salvar!</h1>");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String acao = req.getParameter("acao");
		resp.setContentType("text/html");
		UsuarioDAO usuDAO = new UsuarioDAO();
		if(acao.equals("excluir")){
			String id = req.getParameter("id");
			Usuario usu = new Usuario();
			usu.setId(Integer.parseInt(id));
			usuDAO.excluir(usu);
			resp.sendRedirect("usucontroller.do?acao=lista");
		}else if(acao.equals("lista")){
			List<Usuario> lista = usuDAO.buscarTodos();
			req.setAttribute("lista", lista);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/listausu.jsp");
			dispatcher.forward(req,resp);
			
		  }else if (acao.equals("alterar")){
			  String id = req.getParameter("id");
			  Usuario usuario = usuDAO.buscaPorId(Integer.parseInt(id));
			  req.setAttribute("usuario",usuario);
			  RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
			 dispatcher.forward(req,resp);
		  }else if(acao.equals("cadastro")){
			  Usuario usuario = new Usuario();
			  usuario.setId(0);
			  usuario.setNome("");
			  usuario.setLogin("");
			  usuario.setSenha("");
			  req.setAttribute("usuario",usuario);
			  RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/formusuario.jsp");
			 dispatcher.forward(req,resp);
		  }
		
	}
	
}
