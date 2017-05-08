package br.com.fabricateste;

import br.com.fabricateste.persistencia.entidade.Usuario;
import br.com.fabricateste.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	public static void testeExcluir(){		
		Usuario usu = new Usuario();
		usu.setId(4);

		//Excluir
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.excluir(usu);
		System.out.println("Excluido com sucesso!");
	}
	public static void testeAlterar(){		
		Usuario usu = new Usuario();
		usu.setId(4);
		usu.setNome("Juliano V.");
		usu.setLogin("teste123");
		usu.setSenha("456123321");
		//Alterar
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.alterar(usu);
		System.out.println("Alterado com sucesso!");
	}
	
	public static void testeCadastrar(){		
		Usuario usu = new Usuario();
		usu.setNome("Juliano");
		usu.setLogin("teste");
		usu.setSenha("456123");
		//Cadastro
		UsuarioDAO usuDAO = new UsuarioDAO();
		usuDAO.cadastrar(usu);
		System.out.println("Cadastrado com sucesso!");
	}

}
