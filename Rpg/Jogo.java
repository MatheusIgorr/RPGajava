package Rpg;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bem-vindo ao RPG ===");
        System.out.print("Digite seu nome: ");
        String nomeJogador = scanner.nextLine();

        System.out.println("\nEscolha sua classe:");
        System.out.println("1 - Arqueiro");
        System.out.println("2 - Cavaleiro");
        System.out.println("3 - Clérigo");
        System.out.print("Escolha: ");
        int escolha = scanner.nextInt();

        ClassePersonagem classeJogador;

        switch (escolha) {
            case 1 -> classeJogador = new Arqueiro();
            case 2 -> classeJogador = new Cavaleiro();
            case 3 -> classeJogador = new Clerigo();
            default -> {
                System.out.println("Escolha inválida. Usando Arqueiro como padrão.");
                classeJogador = new Arqueiro();
            }
        }

        Personagem jogador = new Personagem(nomeJogador, classeJogador);
        Personagem orc = new Personagem("Orc", new Berserk());

        System.out.println("\n===============================");
        System.out.println("Seu personagem:");
        System.out.println(jogador.getStatus());
        System.out.println("===============================");

        System.out.println("\n===============================");
        System.out.println("Oponente:");
        System.out.println(orc.getStatus());
        System.out.println("===============================");

        // ✅ Aqui é onde estava o erro
        Batalha.iniciar(jogador, orc, scanner);

        scanner.close();
    }
}
