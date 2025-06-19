package Rpg;
import java.util.Scanner;

public abstract class ClassePersonagem {
    private String nomeClasse;
    private int vida;
    private int ataque;
    private int defesa;
    private int velocidade;

    public ClassePersonagem(String nomeClasse, int vida, int ataque, int defesa, int velocidade) {
        this.nomeClasse = nomeClasse;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.velocidade = velocidade;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    // Método abstrato para obrigar cada classe a ter suas habilidades
    public abstract void usarHabilidades(Personagem usuario, Personagem inimigo, Scanner scanner);
}
