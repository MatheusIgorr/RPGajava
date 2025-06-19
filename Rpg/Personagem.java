package Rpg;

public class Personagem {
    private String nome;
    private int vida;
    private int ataque;
    private int defesa;
    private int velocidade;
    private int nivel;
    private ClassePersonagem classe;

    public Personagem(String nome, ClassePersonagem classe) {
        this.nome = nome;
        this.classe = classe;
        this.nivel = 1;

        this.vida = 100 + (classe.getVida() / 2);
        this.ataque = 10 + classe.getAtaque();
        this.defesa = 5 + classe.getDefesa();
        this.velocidade = 5 + classe.getVelocidade();
    }

    public String atacar(Personagem inimigo) {
        double chanceCritico = Math.random();
        double chanceEsquiva = Math.random();

        if (chanceEsquiva < 0.1) {
            return inimigo.nome.toUpperCase() + " ESQUIVOU DO ATAQUE!";
        }

        int dano = this.ataque - inimigo.defesa;
        dano = Math.max(dano, 0);

        StringBuilder resultado = new StringBuilder();

        if (chanceCritico < 0.1) {
            dano *= 2;
            resultado.append("⚡ ATAQUE CRÍTICO!\n");
        }

        inimigo.vida -= dano;
        resultado.append(this.nome.toUpperCase())
                .append(" ATACOU ")
                .append(inimigo.nome.toUpperCase())
                .append(" CAUSANDO ")
                .append(dano)
                .append(" DE DANO!");

        return resultado.toString();
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public String getStatus() {
        return nome + " - Vida: " + vida +
               " | Nível: " + nivel +
               " | Classe: " + classe.getNomeClasse() +
               " | Ataque: " + ataque +
               " | Defesa: " + defesa +
               " | Velocidade: " + velocidade;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public ClassePersonagem getClasse() {
        return classe;
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

    public int getNivel() {
        return nivel;
    }

    // Setters
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

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
