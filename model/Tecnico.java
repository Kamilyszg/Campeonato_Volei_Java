package model;

public class Tecnico extends Pessoa{
    private Integer ano;

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Tecnico(String nome, Integer ano) {
        super(nome);
        this.ano = ano;
    }

    @Override
    public String toString() {
        return this.nome + " | desde " + this.ano;
    }
}

