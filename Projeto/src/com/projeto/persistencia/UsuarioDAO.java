package com.projeto.persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.projeto.model.Clube;
import com.projeto.model.Usuario;

public class UsuarioDAO {
	private ConexaoMysql conexao;

	public UsuarioDAO() {
		super();
		new Clube();
		this.conexao = new ConexaoMysql("localhost", "root", "", "projeto");
	}

	public void cadastrar(Usuario usuario) {
		this.conexao.abrirConexao();
		String insert = "INSERT INTO usuario VALUES (null, ?, ? , ? , ? , ? , ?, ?)";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(insert);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getSenha());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getCpf());
			statement.setString(6, usuario.getTel());
			statement.setNull(7, java.sql.Types.NUMERIC);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void editar(Usuario usuario) {
		this.conexao.abrirConexao();
		String sqlUpdate = " UPDATE  usuario SET  nome = ?, login =?, senha =?, email=?,cpf=?, telefone=? WHERE id_usuario = ?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getLogin());
			statement.setString(3, usuario.getSenha());
			statement.setString(4, usuario.getEmail());
			statement.setString(5, usuario.getCpf());
			statement.setString(6, usuario.getTel());
			statement.setLong(7, usuario.getIdUsuario());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void excluir(long id_usuario) {
		this.conexao.abrirConexao();
		String sqlDelete = " DELETE FROM usuario  WHERE id_usuario=?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlDelete);
			statement.setLong(1, id_usuario);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}

	public void adcionarClube(Usuario usuario, Clube clube) {
		this.conexao.abrirConexao();
		String sqlUpdate = "UPDATE usuario SET id_clube=? where id_usuario=?";
		try {
			PreparedStatement statement = this.conexao.getConexao().prepareStatement(sqlUpdate);
			statement.setLong(1, clube.getIdClube());
			statement.setLong(2, usuario.getIdUsuario());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.conexao.fecharConexao();
		}
	}
}
