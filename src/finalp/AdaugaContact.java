package finalp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class AdaugaContact extends javax.swing.JFrame {

    //Obiecte declarate pentru modificare atributelor lor si folosirea metodelor
    private Agenda agenda;
    private Frame frame;

    //Elementele contactului
    private String nume;
    private String prenume;
    private boolean ready = true;
    private String dataNasterii;
    private NrTel nr;
    private boolean dateZileNastereValide = true;
    private boolean dateNumeValide = true;

    //Constructor
    public AdaugaContact(Agenda x) {
        initComponents();
        this.agenda = x; //Setarea agendei in care va introduce / modifica contacte
    }

    //Metoda folosita in Main pentru setarea Frameului aplicatiei
    public void setFrame(Frame f) {
        this.frame = f;
    }

    //Acest frame va fi folosit in doua contexte:
    //-pentru a adauga contacte si pentru a le modifica pe cele deja existente
    //Pentru a modifica
    public void hideButtonAdauga() {
        bAdauga.setVisible(false);
        bModifica.setVisible(true);
    }

    //Pentru a adauga
    public void hideButtonModifica() {
        bModifica.setVisible(false);
        bAdauga.setVisible(true);
    }

    //Verificarea datelor introduse
    private void verificareDate() {
        //Refresh
        ready = true;
        dateZileNastereValide = true;
        dateNumeValide = true;

        //Stocarea datelor in variabile
        nume = jNume.getText();
        prenume = jPrenume.getText();
        char[] numereZi = jZi.getText().toCharArray();
        char[] numereLuna = jLuna.getText().toCharArray();
        char[] numereAn = jAn.getText().toCharArray();
        dataNasterii = jZi.getText() + "-" + jLuna.getText() + "-" + jAn.getText();

        if (caseMobil.isSelected()) {
            nr = new NrMobil(jTelefon.getText());
        } else {
            nr = new NrFix(jTelefon.getText());
        }

        //Validarea numelui si a prenumelui
        if (nume.length() < 3 || nume.length() < 3) {
            dateNumeValide = false;
        } else if (prenume.length() < 3 || prenume.length() < 3) {
            dateNumeValide = false;
        }

        //Validarea Zilei de nastere
        if ((jLuna.getText().equals("02") && Integer.parseInt(jZi.getText()) > 28)
                || jZi.getText().length() != 2
                || jLuna.getText().length() != 2
                || jAn.getText().length() != 4
                || Integer.parseInt(jAn.getText()) > LocalDate.now().getYear()
                || Integer.parseInt(jZi.getText()) > 31
                || Integer.parseInt(jLuna.getText()) > 12) {
            dateZileNastereValide = false;
            System.out.println("De aici");
        }
        for (char c : numereZi) {
            if (!Character.isDigit(c)) {
                dateZileNastereValide = false;
            }
        }
        for (char c : numereLuna) {
            if (!Character.isDigit(c)) {
                dateZileNastereValide = false;
            }
        }
        for (char c : numereAn) {
            if (!Character.isDigit(c)) {
                dateZileNastereValide = false;
            }
        }

        if (nume.length() < 2 && prenume.length() < 2) {
            JOptionPane.showMessageDialog(null, "Nu ati introdus un nume sau un prenume valid", "Eroare", JOptionPane.ERROR_MESSAGE);
            ready = false;
        } else if (!dateNumeValide) {
            JOptionPane.showMessageDialog(null, "Datele numelui sunt invalide", "EROARE", JOptionPane.ERROR_MESSAGE);
            ready = false;
        } else if (!dateZileNastereValide) {
            JOptionPane.showMessageDialog(null, "Datele zilei de nastere sunt invalide", "EROARE", JOptionPane.ERROR_MESSAGE);
            ready = false;
        } //Verificarea numerelor de telefon introduse
        else if (caseFix.isSelected()) {
            if ((!jTelefon.getText().startsWith("02") && !jTelefon.getText().startsWith("03")) || jTelefon.getText().length() != 10) {
                JOptionPane.showMessageDialog(null, "Numarul Fix de telefon a fost introdus gresit", "EROARE", JOptionPane.ERROR_MESSAGE);
                ready = false;
            }
        } else if (caseMobil.isSelected()) {
            if (!jTelefon.getText().startsWith("07") || jTelefon.getText().length() != 10) {
                JOptionPane.showMessageDialog(null, "Numarul Mobil de telefon a fost introdus gresit", "EROARE", JOptionPane.ERROR_MESSAGE);
                ready = false;
            }
        }
        char[] cifreNumarTelefon = nr.toString().toCharArray();
        for (char c : cifreNumarTelefon) {
            if (!Character.isDigit(c)) {
                ready = false;
                JOptionPane.showMessageDialog(null, "Numarul de telefon nu contine in totalitate numere!", "EROARE", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipTelefon = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        caseFix = new javax.swing.JRadioButton();
        caseMobil = new javax.swing.JRadioButton();
        jNume = new javax.swing.JTextField();
        jPrenume = new javax.swing.JTextField();
        jZi = new javax.swing.JTextField();
        jLuna = new javax.swing.JTextField();
        jAn = new javax.swing.JTextField();
        jTelefon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bAdauga = new javax.swing.JButton();
        bModifica = new javax.swing.JButton();
        butonClose = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nume:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 26, -1, -1));

        jLabel2.setText("Prenume:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 63, -1, -1));

        jLabel3.setText("Data Nasterii:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 100, -1, -1));

        jLabel4.setText("Numar de telefon:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 204, -1, -1));

        tipTelefon.add(caseFix);
        caseFix.setText("Fix");
        getContentPane().add(caseFix, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 200, -1, -1));

        tipTelefon.add(caseMobil);
        caseMobil.setText("Mobil");
        getContentPane().add(caseMobil, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 200, -1, -1));
        getContentPane().add(jNume, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 24, 92, -1));
        getContentPane().add(jPrenume, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 61, 92, -1));
        getContentPane().add(jZi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 98, 45, -1));
        getContentPane().add(jLuna, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 129, 45, -1));
        getContentPane().add(jAn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 163, 45, -1));
        getContentPane().add(jTelefon, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 231, 143, -1));

        jLabel5.setText("Zi:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 100, -1, -1));

        jLabel6.setText("An:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 165, -1, -1));

        jLabel7.setText("Luna:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 131, -1, -1));

        bAdauga.setBackground(new java.awt.Color(0, 51, 51));
        bAdauga.setForeground(new java.awt.Color(255, 255, 255));
        bAdauga.setText("Adauga");
        bAdauga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdaugaActionPerformed(evt);
            }
        });
        getContentPane().add(bAdauga, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 45, 90, 83));

        bModifica.setBackground(new java.awt.Color(0, 51, 51));
        bModifica.setForeground(new java.awt.Color(255, 255, 255));
        bModifica.setText("Modifica");
        bModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificaActionPerformed(evt);
            }
        });
        getContentPane().add(bModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 146, 90, 79));

        butonClose.setBackground(new java.awt.Color(0, 51, 51));
        butonClose.setForeground(new java.awt.Color(255, 255, 255));
        butonClose.setText("Close");
        butonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonCloseActionPerformed(evt);
            }
        });
        getContentPane().add(butonClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 230, 90, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 270, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Adaugarea in agenda a noului contact
    private void bAdaugaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdaugaActionPerformed
//Se verifica datele introduse
        verificareDate();
//Daca datele sunt valide,
        if (ready) {
            Contact deAdaugat = new Contact(nume, prenume, dataNasterii, nr);
            boolean existaDuplicat = false;
            //Stabilim daca contactul este sau nu deja in lista
            for (Contact c : agenda.listaContacte) {
                if (c.toString().toLowerCase().equals(deAdaugat.toString().toLowerCase())) {
                    existaDuplicat = true;
                }
            }

            if (!existaDuplicat) {

                //Daca azi e ziua contactului,afisam
                LocalDateTime ldt = LocalDateTime.now();
                int month = ldt.getMonthValue();
                int day = ldt.getDayOfMonth();
                if (month == Integer.parseInt(jLuna.getText()) && day == Integer.parseInt(jZi.getText())) {
                    JOptionPane.showMessageDialog(null, "Astazi este ziua de nastere a lui " + nume, "Informare", JOptionPane.PLAIN_MESSAGE);
                }

                agenda.listaContacte.add(deAdaugat);

                //Refresh
                this.setVisible(false);
                frame.actualizareModel();
                jNume.setText("");
                jPrenume.setText("");
                jZi.setText("");
                jLuna.setText("");
                jAn.setText("");
                jTelefon.setText("");
                caseFix.setSelected(false);
                caseMobil.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(null, "Acest contact este deja existent", "Contact existent", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bAdaugaActionPerformed

    //Modificarea contactului selectat din tabel 
    private void bModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificaActionPerformed
        int index = frame.getSelectedIndexTabel();
        //Se preiau datele modificate ale obiectului
        verificareDate();
        //Si daca sunt valide,verificam daca contactul modificat exista deja in lista
        if (ready) {
            boolean existaDuplicat = false;
            Contact contactModificat = new Contact(nume, prenume, dataNasterii, nr);
            for (Contact c : agenda.listaContacte) {
                if (c.toString().toLowerCase().equals(contactModificat.toString().toLowerCase())) {
                    existaDuplicat = true;
                }
            }
            //Daca nu,
            if (!existaDuplicat) {
                //Stergem elementul de pe pozitia selectata
                agenda.listaContacte.remove(index);
                //Si il inlocuim cu contactul modificat
                agenda.listaContacte.add(index, new Contact(nume, prenume, dataNasterii, nr));
                this.setVisible(false);
                //Refresh
                frame.actualizareModel();
                golesteLabeluri();
                caseFix.setSelected(false);
                caseMobil.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(null, "Acest contact este deja existent", "Contact existent", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bModificaActionPerformed

    //Anularea adaugarii/modificarii contactului
    private void butonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonCloseActionPerformed
        this.setVisible(false);
        golesteLabeluri();
    }//GEN-LAST:event_butonCloseActionPerformed

    //Punerea atributelor Contactului selectat in Frameul pentru modificare
    public void actualizeazaLabeluriPentruModificare(String nume, String prenume, String zi, String luna, String an, String telefon) {
        jNume.setText(nume);
        jPrenume.setText(prenume);
        jZi.setText(zi);
        jLuna.setText(luna);
        jAn.setText(an);
        jTelefon.setText(telefon);

    }

    //Refresh labeluri
    public void golesteLabeluri() {
        jNume.setText("");
        jPrenume.setText("");
        jZi.setText("");
        jLuna.setText("");
        jAn.setText("");
        jTelefon.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdauga;
    private javax.swing.JButton bModifica;
    private javax.swing.JButton butonClose;
    private javax.swing.JRadioButton caseFix;
    private javax.swing.JRadioButton caseMobil;
    private javax.swing.JTextField jAn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jLuna;
    private javax.swing.JTextField jNume;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jPrenume;
    private javax.swing.JTextField jTelefon;
    private javax.swing.JTextField jZi;
    private javax.swing.ButtonGroup tipTelefon;
    // End of variables declaration//GEN-END:variables
}
