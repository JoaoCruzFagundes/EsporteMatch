package com.projeto.apresentacao;

import com.projeto.apresentacao.MenuUsuario;
import java.util.Scanner;

public class MenuPrincipal {
	private static int pedido;
	private static Scanner sc;

	public MenuPrincipal() {
	}

	public void MenuPincipal(MenuUsuario menuUsuario, int pedido) {
		MenuPrincipal.pedido = pedido;
	}

	public static void mostrarMenu() {
		sc = new Scanner(System.in);
		System.out.println("Bem vindo ao app");
		System.out.println("1 - Abrir menu Usuario");
		System.out.println("2 - Abrir menu Clube");
		System.out.println("3 - Abrir menu Avaliação");
		System.out.println("4 - Abrir menu Partida");
		System.out.println("5 - Abrir menu Posicao");
		System.out.println("0 - Sair do Aplicativo");
		pedido = sc.nextInt();
		{
			switch (pedido) {
			case 1:
				MenuUsuario.mostrarMenuUsuario();
				break;
			case 2:
				MenuClube.mostrarMenuClube();
				break;
			case 3:
				MenuAvaliacao.mostrarMenuAvaliacao();
				break;
			case 4:
				MenuPartida.mostrarMenuPartida();
				break;
			case 5:
				MenuPosicao.mostrarMenuPosicao();
				break;

			}
			pedido = sc.nextInt();
		}
		while (pedido != 0)
			;
		System.out.println("Bom Jogo");
	}
}