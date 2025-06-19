package Rpg;

import java.util.Scanner;

public class Berserk extends ClassePersonagem {

    public Berserk() {
        super("Berserk", 90, 15, 5, 7);
    }

    @Override
    public void usarHabilidades(Personagem usuario, Personagem inimigo, Scanner scanner) {
        System.out.println("\n=== Habilidades do Berserk ===");
        System.out.println("1 - Corte Profundo (Dano alto)");
        System.out.println("2 - Defesa Irregular (Aumenta defesa)");
        System.out.println("3 - Fúria do Ogro (Aumenta ataque)");
        System.out.println("4 - Machado Ceifador (Dano muito alto, mas perde defesa)");
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
                System.out.print("Digite um número: ");
                scanner.next();
            }
        }

        switch (escolha) {
            case 1 -> { // Corte Profundo
                int dano = (usuario.getAtaque() * 2) - inimigo.getDefesa();
                dano = Math.max(dano, 0);
                inimigo.setVida(inimigo.getVida() - dano);
                System.out.println(usuario.getNome() + " usou Corte Profundo! Causou " + dano + " de dano.");
            }
            case 2 -> { // Defesa Irregular
                usuario.setDefesa(usuario.getDefesa() + 4);
                System.out.println(usuario.getNome() + " usou Defesa Irregular! Defesa aumentou para " + usuario.getDefesa() + ".");
            }
            case 3 -> { // Fúria do Ogro
                usuario.setAtaque(usuario.getAtaque() + 5);
                System.out.println(usuario.getNome() + " ativou Fúria do Ogro! Ataque aumentou para " + usuario.getAtaque() + ".");
            }
            case 4 -> { // Machado Ceifador
                int dano = (usuario.getAtaque() * 3) - inimigo.getDefesa();
                dano = Math.max(dano, 0);
                inimigo.setVida(inimigo.getVida() - dano);
                usuario.setDefesa(Math.max(usuario.getDefesa() - 3, 0)); // Perde 3 de defesa
                System.out.println(usuario.getNome() + " usou Machado Ceifador! Causou " + dano + " de dano, mas perdeu 3 de defesa.");
            }
        }
    }
}
