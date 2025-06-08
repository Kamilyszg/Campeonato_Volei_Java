package model;

public class Jogador extends Pessoa {
    private Posicao posicao;
    private int numero;

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Jogador(String nome, Posicao posicao, Integer numero) {
        super(nome);
        this.posicao = posicao;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return this.numero + "|" + this.nome + "|" + this.posicao;
    }
}
