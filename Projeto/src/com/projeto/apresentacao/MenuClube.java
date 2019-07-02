package com.projeto.apresentacao;

import com.projeto.apresentacao.MenuPrincipal;
import com.projeto.model.Clube;
import com.projeto.persistencia.ClubeDAO;
import java.util.Scanner;

public class MenuClube {
	private static Scanner sc = new Scanner(System.in);
	private static Scanner sc1 = new Scanner(System.in);
	private static Clube clube;
	private static ClubeDAO clubeDAO;
	
	
	public static void mostrarMenuClube() {
		int opcaoDoMenu = 1;
		while (opcaoDoMenu != 0) {
			sc = new Scanner(System.in);
			System.out.println("Menu do Clube");
			System.out.println("1 - Cadastrar clube");
			System.out.println("2 - Editar clube");
			System.out.println("3 - Excluir clube");
			System.out.println("0 - Voltar ao menu principal");
			System.out.println("Menu do clube");
			opcaoDoMenu = sc.nextInt();
			switch (opcaoDoMenu) {
			case 1:
				mostrarCadastrarClubeTela();
				break;
			case 2:
				mostrarEditarClubeTela();
				break;
			case 3:
				mostrarExcluirClubeTela();
				break;
			case 0:
				MenuPrincipal.mostrarMenu();
			}
		}
	}

	public static void mostrarCadastrarClubeTela() {
		clube = new Clube();
		clubeDAO = new ClubeDAO();
		System.out.println("Bem vindo a tela de cadastro de Clube");
		System.out.println("Digite o nome");
		clube.setNome(sc1.next());
		clubeDAO.cadastrar(clube);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void mostrarEditarClubeTela() {
		clube = new Clube();
		clubeDAO = new ClubeDAO();
		String nomeC;
		Long idC;
		System.out.println("Bem vindo a tela de edição de clube");
		System.out.println("Digite o novo nome do clube");
		clube.setNome(nomeC =sc1.next());
		System.out.println("Digite o id do clube");
		clube.setIdUsuario(idC = sc1.nextLong());
		clubeDAO.editar(nomeC, idC);
		System.out.println("Editado com sucesso");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void mostrarExcluirClubeTela() {
		clubeDAO = new ClubeDAO();
		System.out.println("Bem vindo a tela de exclusão de clube");
		System.out.println("Digite o ID do clube");
		clubeDAO.excluir(sc1.nextLong());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
