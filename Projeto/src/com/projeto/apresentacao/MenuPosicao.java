package com.projeto.apresentacao;

import java.util.Scanner;
import com.projeto.model.Posicao;
import com.projeto.persistencia.PosicaoDAO;

public class MenuPosicao {
	private static Scanner sc;
	private static Scanner sc1;
	private static Posicao posicao;
	private static PosicaoDAO posicaoDAO;
	public static void mostrarMenuPosicao() {
		int opcaaMenu = 1;
		while (opcaaMenu != 0) {
			sc = new Scanner(System.in);
			sc1 = new Scanner(System.in);
			System.out.println("Bem Vindo ao Menu de Posições ");
			System.out.println("1 - Adcionar Posições para conta");
			System.out.println("0 - Voltar ao menu principal");
			int opcaoMenu = sc.nextInt();
			switch (opcaoMenu) {
			case 1:
				escolherPosicao();
				break;
			case 0:
				MenuPrincipal.mostrarMenu();
				break;
			}
		}
	}

	public static void escolherPosicao() {
		posicao = new Posicao();
		posicaoDAO = new PosicaoDAO();
		System.out.println("Digite a sua posição preferencial");
		posicao.setPosJog1(sc1.next());
		System.out.println("Digite o quanto gosta dessa posição de 1 a 5");
		posicao.setPeso1(sc1.nextInt());
		System.out.println("Digite a sua posição secundaria ");
		posicao.setPosJog2(sc1.next());
		System.out.println("Digite o quanto gosta dessa posição de 1 a 5");
		posicao.setPeso2(sc1.nextInt());
		posicaoDAO.escolherPosicao(posicao);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
