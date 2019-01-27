package finalp;

import java.io.Serializable;

public class Contact implements Serializable {

    //Atributele contactului
    private String nume;
    private String prenume;
    private String dataNasterii;
    private NrTel nr;

    //Spargerea datei in elemente marunte
    private String[] data1;
    private int an1;
    private int luna1;
    private int zi1;

    //Constructor
    public Contact(String nume, String prenume, String dataNasterii, NrTel nr) {
        this.nume = nume;
        this.prenume = prenume;
        this.dataNasterii = dataNasterii;
        this.nr = nr;
        data1 = dataNasterii.split("-");
        an1 = Integer.parseInt(data1[2]);
        luna1 = Integer.parseInt(data1[1]);
        zi1 = Integer.parseInt(data1[0]);
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public NrTel getNr() {
        return nr;
    }

    public String getDataNasterii() {
        return dataNasterii;
    }

    public int getLunaNasterii() {
        return luna1;
    }

    public int getZiuaNasterii() {
        return zi1;
    }

    public int getZi() {
        return zi1;
    }

    public int getLuna() {
        return luna1;
    }

    public int getAn() {
        return an1;
    }

    //Metoda pentru compararea varstelor a doua contacte
    public int comparaVarsta(Contact c) { // 1 daca c1 mai mare ca c2  , 0 daca s egale ,  -1 daca c2 e mai mare ca c1

        String[] data2 = c.getDataNasterii().split("-");

        int an2 = Integer.parseInt(data2[2]);
        int luna2 = Integer.parseInt(data2[1]);
        int zi2 = Integer.parseInt(data2[0]);

        int decisiv = 0;
        if (an1 > an2) {
            decisiv = -1;
        } else if (an2 > an1) {
            decisiv = 1;
        } else if (an1 == an2) {
            if (luna1 > luna2) {
                decisiv = -1;
            } else if (luna2 > luna1) {
                decisiv = 1;
            } else if (luna1 == luna2) {
                if (zi1 > zi2) {
                    decisiv = -1;
                } else if (zi2 > zi1) {
                    decisiv = 1;
                }
            }
        }
        return decisiv;
    }

    @Override
    public boolean equals(Object o) {
        boolean esteEgal = false;
        Contact c = (Contact) o;
        if (this.nume.equals(c.getNume())
                || this.prenume.equals(c.getPrenume())
                || this.nr.equals(c.getNr())
                || this.dataNasterii.equals(c.getDataNasterii())) {
            esteEgal = true;
        }
        return esteEgal;
    }

    @Override
    public String toString() {
        return nume + prenume + nr + dataNasterii;
    }

}
