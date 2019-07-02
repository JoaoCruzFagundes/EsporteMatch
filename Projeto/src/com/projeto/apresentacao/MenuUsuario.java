package com.projeto.apresentacao;

import com.projeto.model.Clube;
import com.projeto.model.Partida;
import com.projeto.model.Posicao;
import com.projeto.model.Usuario;
import com.projeto.persistencia.ParticipaDAO;
import com.projeto.persistencia.PartidaDAO;
import com.projeto.persistencia.UsuarioDAO;
import com.projeto.apresentacao.MenuPrincipal;

import java.util.Scanner;

public class MenuUsuario {
	private static Scanner sc = new Scanner(System.in);
	private static Scanner sc1 = new Scanner(System.in);
	private static Long numeroPartida;
	private static Usuario usuario;
	private static UsuarioDAO usuarioDAO;
	private static Clube clube;
	private static Partida partida;
	private static Posicao posicao;
	private static ParticipaDAO participaDAO;
	private static PartidaDAO partidaDAO;
	public static void mostrarMenuUsuario() {
		int opcaoDoMenu = 1;
		while (opcaoDoMenu != 0) {
			sc = new Scanner(System.in);
			System.out.println("Menu do usuario");
			System.out.println("1 - Cadastrar usuario");
			System.out.println("2 - Editar usuario");
			System.out.println("3 - Excluir usuario");
			System.out.println("4 - Adcionar clube");
			System.out.println("5 - Entrar em uma partida");
			System.out.println("0 - Voltar ao menu principal");
			System.out.println("Menu do usuario");
			opcaoDoMenu = sc.nextInt();
			switch (opcaoDoMenu) {
			case 1:
				mostrarCadastrarTela();
				break;
			case 2:
				mostrarEditarTela();
				break;
			case 3:
				mostrarExcluirTela();
				break;
			case 4:
				adcionarClubeTela();
				break;
			case 5:
				entrarPartidaTela();
			case 0:
				MenuPrincipal.mostrarMenu();
			}
		}
	}

	static void mostrarCadastrarTela() {
		usuario = new Usuario();
		usuarioDAO = new UsuarioDAO();
		System.out.println("Bem vindo a tela de cadastro de usuario");
		System.out.println("Digite o nome");
		usuario.setNome(sc1.next());
		System.out.println("Digite o login");
		usuario.setLogin(sc1.next());
		System.out.println("Digite a senha");
		usuario.setSenha(sc.next());
		System.out.println("Digite o email");
		usuario.setEmail(sc1.next());
		System.out.println("Digite o cpf");
		usuario.setCpf(sc1.next());
		System.out.println("Digite o telefone");
		usuario.setTel(sc1.next());
		usuarioDAO.cadastrar(usuario);
		System.out.println("Cadastro realizado com sucesso ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void mostrarEditarTela() {
		usuario = new Usuario();
		usuarioDAO = new UsuarioDAO();
		System.out.println("Bem vindo a tela de edição de usuario");
		System.out.println("Digite o nome");
		usuario.setNome(sc.next());
		System.out.println("Digite o login");
		usuario.setLogin(sc.next());
		System.out.println("Digite a senha");
		usuario.setSenha(sc.next());
		System.out.println("Digite o email");
		usuario.setEmail(sc.next());
		System.out.println("Digite o cpf");
		usuario.setCpf(sc.next());
		System.out.println("Digite o telefone");
		usuario.setTel(sc.next());
		System.out.println("Digite o seu id");
		usuario.setIdUsuario(sc.nextLong());
		usuarioDAO.editar(usuario);
		System.out.println("Editado com sucesso");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void mostrarExcluirTela() {
		usuarioDAO = new UsuarioDAO();
		System.out.println("Bem vindo a tela de exclusão de usuario");
		System.out.println("Digite o ID do Usuario");
		usuarioDAO.excluir(sc.nextLong());
		System.out.println("Usuario deletado");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void adcionarClubeTela() {
		clube = new Clube();
		usuario = new Usuario();
		usuarioDAO = new UsuarioDAO();
		System.out.println("Digite o ID do clube");
		clube.setIdClube(sc1.nextLong());
		System.out.println("Digite o ID do usuario");
		usuario.setIdUsuario(sc1.nextLong());
		usuarioDAO.adcionarClube(usuario, clube);
		System.out.println("Voce está em um clube");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void entrarPartidaTela() {
		usuario = new Usuario();
		partida = new Partida();
		posicao = new Posicao();
		participaDAO = new ParticipaDAO();
		partidaDAO = new PartidaDAO();
		System.out.println("Digite o id do usuario");
		usuario.setIdUsuario(sc1.nextLong());
		System.out.println("Digite id da partida");
		partida.setIdPartida(numeroPartida = sc1.nextLong());
		System.out.println("Digite o id da posicao");
		posicao.setIdPosicao(sc1.nextLong());
		partidaDAO.checarStatusPartida(numeroPartida);
		if (partidaDAO.checarStatusPartida(numeroPartida) == 1) {
			participaDAO.entrarPartida(usuario, partida, posicao);
			System.out.println("Voce entrou na partida");
		}
		if (partidaDAO.checarStatusPartida(numeroPartida) == 2) {
			System.out.println("Partida fechada");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
