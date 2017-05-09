package br.com.fabricateste;

import java.util.List;

import br.com.fabricateste.persistencia.entidade.Usuario;
import br.com.fabricateste.persistencia.jdbc.UsuarioDAO;

public class TestUsuarioDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testeAutenticar();
	}
	
	
	private static void testeAutenticar() {
		// TODO Auto-generated method stub
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = new Usuario();
		usuario.setLogin("jose");
		usuario.setSenha("9876554");
		Usuario usu = dao.autenticar(usuario);
		if(usu != null){
			System.out.println("Autenticado com sucesso!");
			System.out.println(usu.toString());}
		else{
			System.out.println("Usuário Inválido!");
			}
	}


	private static void testaBuscaPorTodos() {
		// TODO Auto-generated method stub
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> listausu = dao.buscarTodos();
		if(listausu != null)
			for (Usuario u: listausu){
				System.out.println(u.toString());
			}
		else
		System.out.println("Não foram encontrados registos!");
		
	}
	private static void testeBuscarPorId(int i) {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.buscaPorId(i);
		if(usuario != null)
		System.out.println(usuario.toString());
		else
		System.out.println("Não foram encontrados registos com o id: "+i);
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
	
	public static void testeSalvar(){
		Usuario usu = new Usuario();
		usu.setId(1);
		usu.setNome("tre");
		usu.setLogin("teste2");
		usu.setSenha("123456789");
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(usu);
		System.out.println("Salvo com sucesso!");
		}
	
}
