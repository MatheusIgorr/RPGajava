package Rpg;

import java.util.Scanner;

public class Cavaleiro extends ClassePersonagem {

    public Cavaleiro() {
        super("Cavaleiro", 8, 5, 6, 7);
    }

    @Override
    public void usarHabilidades(Personagem usuario, Personagem inimigo, Scanner scanner) {
        System.out.println("\nEscolha sua habilidade:");
        System.out.println("1 - Corte de Estocada Dupla");
        System.out.println("2 - Defesa Paladina");
        System.out.println("3 - Até o Último Batimento");
        System.out.println("4 - Divino Corte do Herói");
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
                // Exemplo: dano duplo simples
                int dano = (usuario.getAtaque() * 2) - inimigo.getDefesa();
                dano = Math.max(dano, 0);
                inimigo.setVida(inimigo.getVida() - dano);
                System.out.println(usuario.getNome() + " usou Corte de Estocada Dupla causando " + dano + " de dano!");
            }
            case 2 -> {
                // Defesa aumentada temporariamente
                usuario.setDefesa(usuario.getDefesa() + 5);
                System.out.println(usuario.getNome() + " usou Defesa Paladina! Defesa aumentada para " + usuario.getDefesa() + ".");
            }
            case 3 -> {
                // Ataque aumentado para próximo turno (exemplo simples)
                usuario.setAtaque(usuario.getAtaque() + 7);
                System.out.println(usuario.getNome() + " ativou Até o Último Batimento! Ataque aumentado para " + usuario.getAtaque() + ".");
            }
            case 4 -> {
                // Ataque poderoso
                int dano = (usuario.getAtaque() * 4) - inimigo.getDefesa();
                dano = Math.max(dano, 0);
                inimigo.setVida(inimigo.getVida() - dano);
                System.out.println(usuario.getNome() + " usou Divino Corte do Herói causando " + dano + " de dano devastador!");
            }
        }
    }
}
