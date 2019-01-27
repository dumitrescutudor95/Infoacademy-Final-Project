package finalp;

import java.io.Serializable;

public abstract class NrTel implements Comparable,Serializable{
private String numarTelefon;

    public NrTel(String n) throws NumberFormatException {
        if (n.length()>=10) {
              this.numarTelefon=n;
        }
    }

    public String getNumarTelefon() {
        return numarTelefon;
    }
    public abstract boolean validareNumar();

    @Override
    public int compareTo(Object t) {
        NrTel nrt=(NrTel)t;
    return this.numarTelefon.compareTo(nrt.getNumarTelefon());
    }

    @Override
    public String toString() {
        return numarTelefon;
    }
    
    
    
}
