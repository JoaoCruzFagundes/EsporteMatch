package com.projeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.projeto.model.Partida;
import com.projeto.model.Posicao;
import com.projeto.model.Usuario;

public class ParticipaDAO {
	private ConexaoMysql conexao;

	public ParticipaDAO() {
		super();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto");
	}

	public void entrarPartida(Usuario usuario, Partida partida, Posicao posicao) {
		this.conexao.abrirConexao();
		String insert = "INSERT INTO participa VALUES (null, ?, ?,?)";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(insert);
			statement.setLong(1, usuario.getIdUsuario());
			statement.setLong(2, partida.getIdPartida());
			statement.setLong(3, posicao.getIdPosicao());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public List<Usuario> buscarTodosUsuarioPorPartida(long id_partida) {
		this.conexao.abrirConexao();
		String sqlSelect = "  SELECT * FROM  participa INNER JOIN usuario u ON u.id_usuario= participa.id_usuario WHERE id_partida=?  ";
		PreparedStatement statement;
		List<Usuario> listaUsuario = new ArrayList<Usuario>();
		try {
			statement = this.conexao.getConexao().prepareStatement(sqlSelect);
			statement.setLong(1, id_partida);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdUsuario(rs.getLong("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("Login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setTel(rs.getString("telefone"));
				listaUsuario.add(usuario);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaUsuario;
	}
}
