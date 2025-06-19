package Rpg;

import java.util.Scanner;

public class Clerigo extends ClassePersonagem {

    public Clerigo() {
        super("Clérigo", 5, 9, 4, 2);
    }

    @Override
    public void usarHabilidades(Personagem usuario, Personagem inimigo, Scanner scanner) {
        System.out.println("\nEscolha sua habilidade:");
        System.out.println("1 - Explosão de Benção");
        System.out.println("2 - Proteção Divina");
        System.out.println("3 - Benção da Deusa");
        System.out.println("4 - Extermínio do CÉUS");
        System.out.print("Escolha: ");

        int escolha;
        while (true) {
            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                if (escolha >= 1 && escolha <= 4) {
                    break;
                } else {
                    System.out.print("Escolha inválida. Digite de 1 a 4: ");
                }
            } else {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }
        }

        switch (escolha) {
            case 1 -> {
                // Dano através da defesa inimiga, por exemplo
                int dano = (usuario.getAtaque()) + (inimigo.getDefesa() / 2);
                inimigo.setVida(inimigo.getVida() - dano);
                System.out.println(usuario.getNome() + " usou Explosão de Benção causando " + dano + " de dano!");
            }
            case 2 -> {
                // Aumenta defesa temporariamente
                usuario.setDefesa(usuario.getDefesa() + 5);
                System.out.println(usuario.getNome() + " usou Proteção Divina! Defesa aumentada para " + usuario.getDefesa() + ".");
            }
            case 3 -> {
                // Cura parcial
                int cura = 30;
                usuario.setVida(Math.min(usuario.getVida() + cura, 100)); // Supondo vida max 100
                System.out.println(usuario.getNome() + " usou Benção da Deusa e recuperou " + cura + " de vida!");
            }
            case 4 -> {
                // Dano em área (simulado apenas dano alto)
                int dano = usuario.getAtaque() * 3;
                inimigo.setVida(inimigo.getVida() - dano);
                System.out.println(usuario.getNome() + " usou Extermínio do CÉUS causando " + dano + " de dano massivo!");
            }
        }
    }
}
