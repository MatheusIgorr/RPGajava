package Rpg;

import java.util.Random;
import java.util.Scanner;

public class Batalha {

    // Lista de itens possíveis para dropar
private static final Item[] ITENS = {
    new Item("Espada Flamejante", "Arma", 50, "Épico"),
    new Item("Arco do Vento", "Arma", 40, "Raro"),
    new Item("Poção de Vida", "Consumível", 30, "Comum"),
    new Item("Escudo de Pedra", "Defesa", 35, "Comum"),
    new Item("Anel da Força", "Acessório", 25, "Raro"),
    new Item("Cajado de Bença Imensuravel", "Arma", 59, "Lendário")
};


    public static void iniciar(Personagem jogador, Personagem inimigo, Scanner scanner) {
        System.out.println("\n=== A Batalha Começou! ===");

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            System.out.println("\n==============================");
            System.out.println("Seu status: " + jogador.getStatus());
            System.out.println("Inimigo: " + inimigo.getStatus());
            System.out.println("==============================");

            boolean jogadorComeca = jogador.getVelocidade() >= inimigo.getVelocidade();

            System.out.println("\n--- Turno ---\n");

            if (jogadorComeca) {
                turnoJogador(jogador, inimigo, scanner);
                if (inimigo.estaVivo()) {
                    turnoInimigo(inimigo, jogador);
                }
            } else {
                turnoInimigo(inimigo, jogador);
                if (jogador.estaVivo()) {
                    turnoJogador(jogador, inimigo, scanner);
                }
            }
        }

        if (jogador.estaVivo()) {
            System.out.println("\n🏆 Você venceu a batalha!");

            // Gerar item para o vencedor
            Item itemDrop = gerarItemDrop();
            System.out.println("🎉 Você ganhou um item: " + itemDrop.getDescricao());
        } else {
            System.out.println("\n☠️ Você foi derrotado...");
        }
    }

    private static Item gerarItemDrop() {
        Random random = new Random();
        int indice = random.nextInt(ITENS.length);
        return ITENS[indice];
    }

    private static void turnoJogador(Personagem atacante, Personagem defensor, Scanner scanner) {
        System.out.println(atacante.getNome().toUpperCase() + " seu turno! Escolha uma ação:");
        System.out.println("1 - Ataque básico");
        System.out.println("2 - Usar habilidade");
        System.out.print("Escolha: ");

        int acao;
        while (true) {
            if (scanner.hasNextInt()) {
                acao = scanner.nextInt();
                if (acao == 1 || acao == 2) {
                    break;
                } else {
                    System.out.print("Escolha inválida. Digite 1 ou 2: ");
                }
            } else {
                System.out.print("Digite um número válido: ");
                scanner.next();
            }
        }

        if (acao == 1) {
            int dano = atacante.getAtaque() - defensor.getDefesa();
            dano = Math.max(dano, 0);
            defensor.setVida(defensor.getVida() - dano);

            System.out.println(atacante.getNome() + " atacou " + defensor.getNome() + " causando " + dano + " de dano!\n");
        } else {
            atacante.getClasse().usarHabilidades(atacante, defensor, scanner);
        }
    }

    private static void turnoInimigo(Personagem inimigo, Personagem jogador) {
        if (!inimigo.estaVivo()) return;

        if (inimigo.getNome().equalsIgnoreCase("Orc")) {
            System.out.println("Orc atacou com seu golpe poderoso!");
            int dano = inimigo.getAtaque() - jogador.getDefesa();
            dano = Math.max(dano, 0);
            jogador.setVida(jogador.getVida() - dano);
            System.out.println("Orc atacou " + jogador.getNome() + " causando " + dano + " de dano!\n");
        } else {
            double chance = Math.random();

            if (chance < 0.7) {
                int dano = inimigo.getAtaque() - jogador.getDefesa();
                dano = Math.max(dano, 0);
                jogador.setVida(jogador.getVida() - dano);
                System.out.println(inimigo.getNome() + " atacou " + jogador.getNome() + " causando " + dano + " de dano!\n");
            } else {
                System.out.println(inimigo.getNome() + " usou uma habilidade!");
                inimigo.getClasse().usarHabilidades(inimigo, jogador, null);
            }
        }
    }
}
