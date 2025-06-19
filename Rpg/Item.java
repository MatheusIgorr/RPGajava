package Rpg;

public class Item {
    private String nome;
    private String tipo;
    private int poder;
    private String raridade;  // novo campo

    public Item(String nome, String tipo, int poder, String raridade) {
        this.nome = nome;
        this.tipo = tipo;
        this.poder = poder;
        this.raridade = raridade;
    }

    public String getDescricao() {
        return nome + " (" + tipo + ", " + raridade + ") - Poder: " + poder;
    }

    // getters e setters aqui...
}

