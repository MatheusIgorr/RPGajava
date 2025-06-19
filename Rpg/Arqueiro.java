package Rpg;

import java.util.Scanner;

public class Arqueiro extends ClassePersonagem {
    public Arqueiro() {
        super("Arqueiro", 60, 9, 8, 3);
    }

    @Override
    public void usarHabilidades(Personagem usuario, Personagem inimigo, Scanner scanner) {
        System.out.println("\n=== Habilidades do Arqueiro ===");
        System.out.println("1 - Flechas Mágicas (Dano alto)");
        System.out.println("2 - Agilidade Élfica (Aumenta velocidade)");
        System.out.println("3 - Defesa Mãe Natureza (Aumenta defesa)");
        System.out.println("4 - Flecha Espiritual da Floresta (Dano médio + enraizamento)");
        System.out.print("Escolha: ");

        int escolha;
        while (true) {
            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                if (escolha >= 1 && escolha <= 4) {
                    break;
                } else {
                    System.out.print("Escolha uma opção válida (1 a 4): ");
                }
            } else {
                System.out.print("Digite um número: ");
                scanner.next(); // descarta entrada inválida
            }
        }

        switch (escolha) {
            case 1:
                int danoFlechasMagicas = (usuario.getAtaque() * 2) - inimigo.getDefesa();
                danoFlechasMagicas = Math.max(danoFlechasMagicas, 0);
                inimigo.setVida(inimigo.getVida() - danoFlechasMagicas);
                System.out.println(usuario.getNome() + " usou Flechas Mágicas! Causou " + danoFlechasMagicas + " de dano.");
                break;
            case 2:
                usuario.setVelocidade(usuario.getVelocidade() + 3);
                System.out.println(usuario.getNome() + " usou Agilidade Élfica! Velocidade aumentou para " + usuario.getVelocidade() + ".");
                break;
            case 3:
                usuario.setDefesa(usuario.getDefesa() + 5);
                System.out.println(usuario.getNome() + " ativou Defesa Mãe Natureza! Defesa aumentou para " + usuario.getDefesa() + ".");
                break;
            case 4:
                int danoFlechaEspiritual = (usuario.getAtaque() + 5) - inimigo.getDefesa();
                danoFlechaEspiritual = Math.max(danoFlechaEspiritual, 0);
                inimigo.setVida(inimigo.getVida() - danoFlechaEspiritual);
                System.out.println(usuario.getNome() + " usou Flecha Espiritual da Floresta! Causou " + danoFlechaEspiritual + " de dano e enraizou o inimigo.");
                // inimigo.setEnraizado(true); // Implementar esse efeito no sistema de status
                break;
        }
    }
}