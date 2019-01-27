package finalp;

import java.io.Serializable;

public class NrFix extends NrTel implements Serializable {

    public NrFix(String n) throws NumberFormatException {
        super(n);
    }

    public boolean validareNumar() {
        if (!this.getNumarTelefon().startsWith("02") || !this.getNumarTelefon().startsWith("03")) {
            return false;
        } else {
            return true;
        }
    }

}
