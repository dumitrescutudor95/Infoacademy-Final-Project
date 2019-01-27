package finalp;

import java.io.Serializable;

public class NrMobil extends NrTel implements Serializable {

    public NrMobil(String n) throws NumberFormatException {
        super(n);
    }

    public boolean validareNumar() {
        if (!this.getNumarTelefon().startsWith("07")) {
            return false;
        } else {
            return true;
        }
    }
}
