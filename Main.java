import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Menu de Opções\n1- Adicionar time ao campeonato\n2- Adicionar jogador em um time\n3- Adicionar técnico em um time\n4- Registrar partida do campeonato\n5- Listar jogadores de um time\n6- Listar pontuação de um time\n7- Ranking dos times\n0- Sair");

        Scanner sc = new Scanner(System.in);
        System.out.print("Digite a opção desejada: ");
        int opcao = sc.nextInt();
        sc.nextLine();

        List<Time> todosOsTimes = new ArrayList<>(); //a main será a responsável por armazenar todos os times, estando inscritos no campeonato ou não
        List<Campeonato> todosOsCampeonatos = new ArrayList<>();

        //declarando uma variável que eu vou usar em cases diferentes
        String nomeTime;
        boolean encontrado = false;
        Campeonato campeonatoSelecionado;

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    Campeonato campeonatoNovo = null;
                    campeonatoSelecionado = null;

                    if (todosOsCampeonatos.isEmpty()) {
                        System.out.println("Não há campeonatos cadastrados. Adicionar novo campeonato? y/n");
                        char op = sc.next().charAt(0); //para ler tipo char
                        sc.nextLine();
                        if (op == 'y' || op == 'Y') {
                            campeonatoNovo = Campeonato.adicionarCampeonato(sc);
                            todosOsCampeonatos.add(campeonatoNovo);
                            campeonatoSelecionado = campeonatoNovo;
                        } else {
                            break;
                        }
                    } else {
                        System.out.println("Campeonatos disponíveis");
                        for (Campeonato c : todosOsCampeonatos) {
                            System.out.println(c);
                        }

                        System.out.println("Digite o nome do campeonato ou digite 'novo' para criar novo campeonato");
                        String escolha = sc.nextLine();
                        if (escolha.equalsIgnoreCase("novo")) {
                            campeonatoNovo = Campeonato.adicionarCampeonato(sc);
                            todosOsCampeonatos.add(campeonatoNovo);
                            campeonatoSelecionado = campeonatoNovo;
                        } else {
                            for (Campeonato c : todosOsCampeonatos) {
                                if (c.getNome().equalsIgnoreCase(escolha)) { //se o usuário digitou certo
                                    campeonatoSelecionado = c; //armazeno o campeonato
                                    break;
                                }
                            }
                            if (campeonatoSelecionado == null) { //se não foi armazenado nada
                                System.out.println("Campeonato não encontrado.");
                                break;
                            }
                        }
                    }

                    //times
                    if (todosOsTimes.isEmpty()) {
                        System.out.println("Não há times cadastrados.");
                        break;
                    }

                    System.out.println("Times disponíveis");
                    for (Time t : todosOsTimes) {
                        System.out.println(t);
                    }

                    System.out.print("Digite o nome do time: ");
                    nomeTime = sc.nextLine();

                    encontrado = false;
                    for (Time t : todosOsTimes) {
                        if (t.getNome().equals(nomeTime.toUpperCase())) {
                            if (campeonatoSelecionado.adicionarTime(t)) {
                                System.out.println("Inscrição realizada com sucesso.");
                            }
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("Não existe o time inserido. Por favor, verifique na lista apresentada.");
                    }
                    break;
                case 2:
                    System.out.print("Digite o nome do time: ");
                    nomeTime = sc.nextLine();

                    Time timeEncontrado = null;

                    for (Time t : todosOsTimes) {
                        if (t.getNome().equalsIgnoreCase(nomeTime)) { //comparação do nome digitado pelo user com o nome do time ignorando maiusculas e minusculas
                            timeEncontrado = t;
                            break;
                        }
                    }
                    if (timeEncontrado == null) {
                        timeEncontrado = new Time(nomeTime.toUpperCase(), 0);
                        todosOsTimes.add(timeEncontrado);
                    }

                    System.out.print("Digite o nome do jogador: ");
                    String nome = sc.nextLine();

                    System.out.println("Posições:\n1- Levantador\n2- Oposto\n3- Ponteiro\n4- Central\n5- Libero");
                    System.out.print("Digite a posição do jogador: ");
                    int posicao = sc.nextInt();
                    sc.nextLine(); //o chat falou q tem que limpar

                    if (posicao < 1 || posicao > 5) {
                        System.out.println("Posição inválida.");
                        break;
                    }

                    Posicao[] posicoes = Posicao.values(); //criando um array do tipo Posicao (enum) que se chama posicoes; values faz com que as posicoes que se encontram no enum sejam armazenadas no vetor criado
                    Posicao posicaoEscolhida = posicoes[posicao - 1];//posicao escolhida é do tipo enum recebe opção (que foi digitada) -1 do vetor posicoes criado (o vetor começa de 0 e as opções começam de 1 - por isso subtrai

                    System.out.print("Digite o número do jogador: ");
                    Integer numeroEscolhido = sc.nextInt();
                    sc.nextLine();

                    Jogador jogador = new Jogador(nome, posicaoEscolhida, numeroEscolhido);
                    System.out.println(timeEncontrado.adicionarJogador(jogador));
                    break;
                case 3:
                    if (todosOsTimes.isEmpty()) { //isEmpty é o mesmo que .size() == 0
                        System.out.println("Não há times cadastrados.");
                        break;
                    } else {
                        System.out.println("Times disponíveis");
                        for (Time t : todosOsTimes) {
                            System.out.println(t.toString());
                        }
                    }

                    System.out.print("Digite o nome do time: ");
                    nomeTime = sc.nextLine();

                    for (Time t : todosOsTimes) {
                        if (t.getNome().equals(nomeTime.toUpperCase())) {

                            System.out.print("Digite o nome do técnico: ");
                            String nomeTecnico = sc.nextLine();

                            System.out.print("Digite o ano de entrada do técnico no time: ");
                            int anoEntrada = sc.nextInt();
                            sc.nextLine();

                            Tecnico tecnico = new Tecnico(nomeTecnico, anoEntrada);
                            t.setTecnico(tecnico);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) //se for falso
                        System.out.println("Não existe o time inserido. Por favor, verifique na lista apresentada.");
                    break;
                case 4:
                    campeonatoSelecionado = escolherCampeonato(sc, todosOsCampeonatos);
                    if (campeonatoSelecionado == null)
                        break;

                    Time time1 = escolherTime(sc, campeonatoSelecionado);
                    if (time1 == null)
                        break;

                    Time time2 = escolherTime(sc, campeonatoSelecionado);
                    if (time2 == null)
                        break;

                    if (time1.equals(time2)) {
                        System.out.println("Os times não podem ser iguais.");
                        break;
                    }

                    System.out.print("Digite a quantidade de sets ganhos do time "+ time1.getNome() +": ");
                    int setsTime1 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Digite a quantidade de sets ganhos do time "+ time2.getNome() +": ");
                    int setsTime2 = sc.nextInt();
                    sc.nextLine();

                    if (setsTime1 == setsTime2){
                        System.out.println("A partida deve ter somente um time vencedor.");
                        break;
                    }

                    Partida partida = new Partida(setsTime1, setsTime2, time1, time2);
                    System.out.println(campeonatoSelecionado.registrarPartida(partida));
                    break;
                case 5:
                    encontrado = false; // resetando a variavel
                    if (todosOsTimes.isEmpty()) { //isEmpty é o mesmo que .size() == 0
                        System.out.println("Não há times cadastrados.");
                        break;
                    } else {
                        System.out.println("Times disponíveis");
                        for (Time t : todosOsTimes) {
                            System.out.println(t.toString());
                        }
                    }

                    System.out.print("Digite o nome do time: ");
                    nomeTime = sc.nextLine();

                    for (Time t : todosOsTimes) {
                        if (t.getNome().equalsIgnoreCase(nomeTime.toUpperCase())) {
                            System.out.println(t.listarJogadores());
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) //se for falso
                        System.out.println("Não existe o time inserido. Por favor, verifique na lista apresentada.");
                    break;
                case 6:
                    campeonatoSelecionado = escolherCampeonato(sc, todosOsCampeonatos);
                    if (campeonatoSelecionado == null)
                        break;

                    Time time = escolherTime(sc, campeonatoSelecionado);
                    if (time == null)
                        break;

                    System.out.println(campeonatoSelecionado.listarResultados(time));
                    break;
                case 7:
                    campeonatoSelecionado  = escolherCampeonato(sc, todosOsCampeonatos);
                    if (campeonatoSelecionado == null)
                        break;

                    System.out.println(campeonatoSelecionado.gerarRanking());

                    break;
                default:
                    System.out.println("Opção inválida");
            }

            System.out.println("\nPara que o menu de opções seja exibido novamente, tecle Enter");
            sc.nextLine();

            System.out.println("Menu de Opções\n1- Adicionar time ao campeonato\n2- Adicionar jogador em um time\n3- Adicionar técnico em um time\n4- Registrar partida do campeonato\n5- Listar jogadores de um time\n6- Listar pontuação de um time\n7- Ranking dos times\n0- Sair");

            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();
        }
    }

    public static Campeonato escolherCampeonato (Scanner sc, List<Campeonato> campeonatos) {
        if (campeonatos.isEmpty()) {
            System.out.println("Não há campeonatos ativos no momento.");
            return null;
        } else {
            while (true) {
                System.out.println("Campeonatos disponíveis");
                for (Campeonato c : campeonatos) {
                    System.out.println(c);
                }

                System.out.print("Digite o nome do campeonato: ");
                String nomeCampeonato = sc.nextLine();

                for (Campeonato c : campeonatos) {
                    if (c.getNome().equalsIgnoreCase(nomeCampeonato)) {
                        return c;
                    }
                }

                System.out.println("Campeonato não encontrado, verifique a lista apresentada. \n");
            }
        }
    }

    public static Time escolherTime (Scanner sc, Campeonato campeonato){
        if (campeonato.getTimes().isEmpty()){
            System.out.println("O campeonato selecionado não possui times incritos.");
            return null;
        } else {
            while (true) {
                System.out.println("Times disponíveis");

                for (Time t: campeonato.getTimes()){
                    System.out.println(t);
                }

                System.out.print("Digite o nome do time: ");
                String nomeTime = sc.nextLine();

                for (Time t: campeonato.getTimes()){
                    if (t.getNome().equalsIgnoreCase(nomeTime)){
                        return t;
                    }
                }

                System.out.println("Time não encontrado, verifique a lista apresentada. \n");
            }
        }
    }
}
