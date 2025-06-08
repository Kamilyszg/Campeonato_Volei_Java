package model;

public class Partida {
    private int setsT1;
    private int setsT2;
    private Time[] timesPartida;

    public Partida(int setsT1, int setsT2, Time time1, Time time2) {
        this.setsT1 = setsT1;
        this.setsT2 = setsT2;
        this.timesPartida = new Time[2]; // instanciar o vetor antes de atribuir valores nas posições
        this.timesPartida[0] =  time1;
        this.timesPartida[1] =  time2;
    }

    public Time[] getTimesPartida() {
        return timesPartida;
    }

    public void setTimesPartida(Time[] timesPartida) {
        this.timesPartida = timesPartida;
    }

    public int getSetsT1() {
        return setsT1;
    }

    public void setSetsT1(int setsT1) {
        this.setsT1 = setsT1;
    }

    public int getSetsT2() {
        return setsT2;
    }

    public void setSetsT2(int setsT2) {
        this.setsT2 = setsT2;
    }
}
