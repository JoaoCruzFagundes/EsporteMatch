package com.projeto.apresentacao;

import java.util.List;
import java.util.Scanner;
import com.projeto.model.Clube;
import com.projeto.model.Esporte;
import com.projeto.model.Partida;
import com.projeto.model.Usuario;
import com.projeto.persistencia.ParticipaDAO;
import com.projeto.persistencia.PartidaDAO;

public class MenuPartida {
	private static Scanner sc;
	private static Scanner sc1;
	private static Partida partida;
	private static PartidaDAO partidaDAO;
	private static Clube clube;
	private static Esporte esporte;
	private static ParticipaDAO participaDAO;
	public static void mostrarMenuPartida() {
		int opcaoMenu = 1;
		while (opcaoMenu != 0) {
			sc = new Scanner(System.in);
			System.out.println("Bem vindo ao menu de partida");
			System.out.println("1 - Criar uma nova partida");
			System.out.println("2 - Editar uma partida ");
			System.out.println("3 - Adcionar faltas em partida");
			System.out.println("4 - Excluir uma partida");
			System.out.println("5 - Mostrar Usuarios em uma partida");
			System.out.println("0 - Retornar para o menu principal");
			opcaoMenu = sc.nextInt();
			switch (opcaoMenu) {
			case 1:
				criarNovaPartidaTela();
				break;
			case 2:
				editarPartidaTela();
				break;
			case 3:
				adcionarFaltasPartidaTela();
				break;
			case 4:
				excluirPartidaTela();
				break;
			case 5:
				mostrarUsuariosEmPartida();
				break;
			case 0:
				MenuPrincipal.mostrarMenu();
				break;
			}
		}
	}

	public static void criarNovaPartidaTela() {
		sc1 = new Scanner(System.in);
		partida = new Partida();
		partidaDAO = new PartidaDAO();
		clube = new Clube();
		esporte = new Esporte();
		System.out.println("Digite a data da partida");
		partida.setData(sc1.next());
		System.out.println("Digite o endereço da partida");
		partida.setEndereco(sc1.next());
		System.out.println("Digite 1 - partida aberta para todos 2 - partida fechada ");
		partida.setStatusPartida(sc1.nextInt());
		System.out.println("Digite o ID do clube");
		clube.setIdClube(sc1.nextLong());
		System.out.println("Digite o ID do esporte 1 - futsal, 2 - volei, 3 - futebol, 4 - basquete");
		esporte.setId_esporte(sc1.nextLong());
		partidaDAO.criarPartida(partida, clube, esporte);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void editarPartidaTela() {
		sc1 = new Scanner(System.in);
		partida = new Partida();
		partidaDAO = new PartidaDAO();
		esporte = new Esporte();
		System.out.println("Digite a data da partida");
		partida.setData(sc1.next());
		System.out.println("Digite o endereço da partida");
		partida.setEndereco(sc1.next());
		System.out.println("Digite 1 - partida aberta para todos 2 - partida fechada ");
		partida.setStatusPartida(sc.nextInt());
		System.out.println("Digite o ID do esporte 1 - futsal, 2 - volei, 3 - futebol, 4 - basquete");
		esporte.setId_esporte(sc1.nextLong());
		System.out.println("Degite o id da partida");
		partida.setIdPartida(sc.nextLong());
		partidaDAO.editarPartida(partida, esporte);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void adcionarFaltasPartidaTela() {
		sc1 = new Scanner(System.in);
		partida = new Partida();
		partidaDAO = new PartidaDAO();
		System.out.println("Digite as faltas da partida");
		partida.setFaltas(sc1.nextInt());
		System.out.println("Digite o id da partida");
		partida.setIdPartida(sc1.nextLong());
		partidaDAO.adcionarFaltas(partida);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void excluirPartidaTela() {
		sc1 = new Scanner(System.in);
		partidaDAO = new PartidaDAO();
		System.out.println("Digite o id da partida ");
		partidaDAO.excluir(sc1.nextLong());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void mostrarUsuariosEmPartida() {
		participaDAO = new ParticipaDAO();
		System.out.println("Digite o id da partida");
		List<Usuario> listaUsuarios = participaDAO.buscarTodosUsuarioPorPartida(sc.nextLong());
		for (Usuario usuario1 : listaUsuarios) {
			System.out.println(usuario1.getNome());
		}
	}

}
