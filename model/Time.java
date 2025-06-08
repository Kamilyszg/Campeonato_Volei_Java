package model;

import java.util.ArrayList;
import java.util.List;

public class Time {
    private String nome;
    private Integer qtdJogadores;
    private Integer pontuacao;
    private List<Jogador> jogadores;
    private Tecnico tecnico;

    public Time(String nome, Integer pontuacao) {
        this.nome = nome;
        this.qtdJogadores = 0;
        this.pontuacao = pontuacao;
        this.jogadores = new ArrayList<>();
        this.tecnico = null;
    }

    public String adicionarJogador(Jogador jogador){
        if (qtdJogadores == 15){ //jogadores.size ou qtd jogadores
            return String.format("O time %s já atingiu o limite de 15 jogadores", nome);
        }else {
            for (Jogador j : jogadores){
                if (j.getNumero() == jogador.getNumero()){
                    return "O time já possui um jogador com o número inserido";
                }
            }
            jogadores.add(jogador);
            qtdJogadores += 1;
            return "Jogador adicionado ao time";
        }
    }

    public String listarJogadores(){
        String resultado;

        if (this.tecnico == null) {
            resultado = String.format("Jogadores de %s\nTécnico: Não definido\n", this.nome.toUpperCase());
        } else {
            resultado = String.format("Jogadores de %s\nTécnico: %s\n", this.nome.toUpperCase(), this.tecnico); //quando se tenta utilizar um objeto como uma string já se entende que deve ser chamado o metodo toString da classe
        }

        for (Jogador j: jogadores){
            resultado += "- "+ j + "\n"; //metodo tostring chamado automaticamente
        }
        return resultado;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdJogadores() {
        return qtdJogadores;
    }

    //tirei o set qtd jogadores

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public List<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(List<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
}
