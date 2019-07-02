package com.projeto.apresentacao;

import java.util.Scanner;
import com.projeto.model.Avaliacao;
import com.projeto.model.Clube;
import com.projeto.model.Usuario;
import com.projeto.persistencia.AvaliacaoDAO;

public class MenuAvaliacao {
	private static Scanner sc;
	private static Scanner sc1;
	private static Avaliacao avaliacao;
	private static AvaliacaoDAO avaliacaoDAO;
	private static Usuario usuario;
	private static Clube clube;
	public static void mostrarMenuAvaliacao() {
		int opcaoMenu = 1;
		while (opcaoMenu != 0) {
			sc = new Scanner(System.in);
			sc1 = new Scanner(System.in);
			System.out.println("Bem Vindo ao Menu Avaliacao");
			System.out.println("1 - Avaliar ");
			System.out.println("0 - Voltar ao menu principal");
			opcaoMenu = sc.nextInt();
			switch (opcaoMenu) {
			case 1:
				avaliarUsuarioTimeTela();
				break;
			case 0:
				MenuPrincipal.mostrarMenu();
				break;
			}
		}
	}

	public static void avaliarUsuarioTimeTela() {
		avaliacao = new Avaliacao();
		avaliacaoDAO = new AvaliacaoDAO();
		usuario = new Usuario();
		clube = new Clube();
		System.out.println("Digite A avaliação de conduta de 1 a 5");
		avaliacao.setAvalCond(sc1.nextInt());
		System.out.println("Digite a avaliação de desempenho de 1 a 5");
		avaliacao.setAvalDesemp(sc1.nextInt());
		System.out.println("Descrição opcional sobre o jogo");
		avaliacao.setDescricao(sc1.next());
		System.out.println("Passe o id do usuario");
		usuario.setIdUsuario(sc1.nextLong());
		System.out.println("Passe o id do clube ");
		clube.setIdClube(sc1.nextLong());
		avaliacaoDAO.avaliar(avaliacao, usuario, clube);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
