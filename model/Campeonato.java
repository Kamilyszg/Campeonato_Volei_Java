package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Campeonato {
    private String nome;
    private Double premio;
    private List<Time> times;
    private List<Partida> partidas;


    public Campeonato(String nome, Double premio) {
        this.nome = nome;
        this.premio = premio;
        this.times = new ArrayList<>();
        this.partidas = new ArrayList<>();
    }

    public Boolean adicionarTime(Time time){
        if (time.getQtdJogadores() < 2){
            System.out.println("O time não possui o número mínimo de integrantes aceito.");
            return false;
        } else {
            for (Time t: times){
                if (t.getNome().equalsIgnoreCase(time.getNome())){
                    System.out.println("Time já inscrito no campeonado.");
                    return false;
                }
            }
            times.add(time);
            return true;
        }
    }

    public static Campeonato adicionarCampeonato(Scanner sc){ //como parametro é passada a entrada do usuário
        System.out.print("Digite o nome do campeonato: ");
        String nomeCampeonato = sc.nextLine();

        System.out.print("Digite o valor do prêmio: ");
        Double valor = sc.nextDouble();
        sc.nextLine();

        return new Campeonato(nomeCampeonato, valor);
    }

    public String registrarPartida(Partida partida){
        partidas.add(partida);

        Time t1 = partida.getTimesPartida()[0];
        Time t2 = partida.getTimesPartida()[1];

        t1.setPontuacao(t1.getPontuacao() + partida.getSetsT1());
        t2.setPontuacao(t2.getPontuacao() + partida.getSetsT2());

        return "Partida adicionada com sucesso!";
    }

    public String listarResultados(Time time){
        String resultado = "";

        for (Partida p : partidas){ //para cada partida
            Time[] t = p.getTimesPartida(); //armazeno em um vetor o time 1 e 2

            if (t[0].equals(time)){ //se t na posicao 0 é o time que busco
                resultado += t[0].getNome() + " X " + t[1].getNome() + " | " + p.getSetsT1() + " X " + p.getSetsT2() + "\n";
            } else if (t[1].equals(time)){ // se t na posicao 1 é o time que busco
                resultado += t[1].getNome() + " X " + t[0].getNome() + " | " + p.getSetsT2() + " X " + p.getSetsT1() + "\n";
            }
        }

        if (resultado.isEmpty()){
            return "O time não participou de nenhuma partida. \n";
        }

        return resultado;
    }

    public String gerarRanking(){
        if (times.isEmpty()){
            return "O campeonato selecionado não possui times inscritos";
        }

        List<Time> auxTimes = new ArrayList<>();
        String ranking = "";

        for (Time t: times){
            if (auxTimes.isEmpty()){ //primeira repetição
                auxTimes.add(t);
            } else {
                boolean inserido = false;
                for (int i = 0; i < auxTimes.size(); i++) {
                    if (t.getPontuacao() >= auxTimes.get(i).getPontuacao()){
                        auxTimes.add(i, t); //adicione t na posição i, ou seja, se a pontuação de t for maior que a do time da posição i, t deve ser inserido antes
                        inserido = true;
                        break;
                    }
                }

                if (!inserido){
                    auxTimes.add(t); //se a pontuação não for maior ou igual, adiciona o time no final da fila
                }
            }
        }

        for (int i = 0; i < auxTimes.size(); i++ ){
            ranking += String.format(" %d | %s | %d\n", i+1, auxTimes.get(i).getNome(), auxTimes.get(i).getPontuacao());
        }

        return ranking;
    }

    @Override
    public String toString() {
        return this.nome + "| Prêmio: " + this.premio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPremio() {
        return premio;
    }

    public void setPremio(Double premio) {
        this.premio = premio;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }
}
