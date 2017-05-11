package br.com.fabricateste.persistencia.jdbc;

import br.com.fabricateste.persistencia.entidade.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	private Connection con = ConexaoFactory.getConnection();
	
	public void cadastrar(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "insert into usuario (nome,login,senha) values(?,?,md5(?))";
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void alterar(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "update usuario set nome=?, login=?, senha=md5(?) where id = ?";
		try{
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setString(1, usu.getNome());
			preparador.setString(2, usu.getLogin());
			preparador.setString(3, usu.getSenha());
			preparador.setInt(4,usu.getId());
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
      }
	 public void excluir(Usuario usu) {
		// TODO Auto-generated method stub
		String sql = "delete from usuario where id = ?";
		try{
			PreparedStatement preparador = con.prepareStatement(sql);
			preparador.setInt(1,usu.getId());
			preparador.execute();
			preparador.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
      }
	 public void salvar(Usuario usuario){
			if(usuario.getId()!= null && usuario.getId()!=0){
				alterar(usuario);
			}else{
				cadastrar(usuario);
			}
		}
	 /**
	  * Busca por um usuario dentro do banco de dados de acordo com o id
	  * @param id é um inteiro que representa o id do usuario
	  * @return Um objetto usuario quando encontrado, ou null quando não tem usuario
	  */
	 public Usuario buscaPorId(Integer id){
		 String sql = "select * from usuario where id = ?";
		 try{
		 PreparedStatement preparador = con.prepareStatement(sql);
		 preparador.setInt(1, id);
		 ResultSet resultado = preparador.executeQuery();
		 if(resultado.next()){
			 Usuario usuario = new Usuario();
			 usuario.setId(resultado.getInt("id"));
			 usuario.setNome(resultado.getString("nome"));
			 usuario.setLogin(resultado.getString("login"));
			 usuario.setSenha(resultado.getString("senha"));
			return usuario;
		 }
		 preparador.close();
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return null;
	 }
	 /**
	  * Realiza a busca de todos os registros da tabela usuarios
	  * @return Retorna uma lista de objetos usuarios
	  */
	 public List<Usuario> buscarTodos(){
		 String sql = "select * from usuario order by id";
		 List<Usuario> lista = new ArrayList<Usuario>();
		 try{
		 PreparedStatement preparador = con.prepareStatement(sql);
		 ResultSet resultado = preparador.executeQuery();
		 while(resultado.next()){
			 Usuario usuario = new Usuario();
			 usuario.setId(resultado.getInt("id"));
			 usuario.setNome(resultado.getString("nome"));
			 usuario.setLogin(resultado.getString("login"));
			 usuario.setSenha(resultado.getString("senha"));
			 lista.add(usuario);
		 }
		 preparador.close();
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return lista;
	 }
	 
	 public Usuario autenticar(Usuario usuConsulta){
		 String sql = "select * from usuario where login=? and senha=md5(?) limit 1";
		 try{
			 PreparedStatement preparador = con.prepareStatement(sql);
			 preparador.setString(1, usuConsulta.getLogin());
			 preparador.setString(2, usuConsulta.getSenha());
			 ResultSet resultado = preparador.executeQuery();
			 if(resultado.next()){
				Usuario usu = new Usuario();
			 	usu.setId(resultado.getInt("id"));
			 	usu.setNome(resultado.getString("nome"));	
			 	usu.setLogin(resultado.getString("Login"));
			 	usu.setSenha(resultado.getString("senha"));
			 return usu;}
			 preparador.close();
			
		 }catch(SQLException e){
			 e.printStackTrace();
		 }
		 return null;
	 }
}
