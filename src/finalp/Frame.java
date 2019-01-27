package finalp;

//Importuri
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.Formatter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frame extends javax.swing.JFrame {

    //Fila actuala care contine Contactele
    File filaActuala;
    //Lista userilor inregistrati
    File filaUseri = new File("listaUserilor.txt");

    //Agenda persoanelor
    private Agenda agenda;

    DefaultListModel modelLista = new DefaultListModel();

    //Lista persoanelor inregistrate
    List<User> listaUseri = new LinkedList<>();

    //Icons: reclame suc
    ImageIcon reclamaCola = new ImageIcon(this.getClass().getResource("Suc//cola.png"));
    ImageIcon reclamaFanta = new ImageIcon(this.getClass().getResource("Suc//fanta.jpg"));
    ImageIcon reclamaSprite = new ImageIcon(this.getClass().getResource("Suc//sprite.jpg"));
    ImageIcon reclamaNestea = new ImageIcon(this.getClass().getResource("Suc//nestea.jpg"));

    //Constructor
    public Frame(Agenda a) {
        initComponents();
        this.agenda = a;
        //Ascunderea unor elemente vizuale
        jFiltru.setVisible(false);
        labelFiltru.setVisible(false);
        panelProiect.setVisible(false);
        meniuDeschide.setEnabled(false);
        meniuSalveaza.setEnabled(false);

        //Setarea reclamelor: din 2 in 2 secunde
        timerReclame.schedule(afiseazaCola, 0, 8000);
        timerReclame.schedule(afiseazaFanta, 2000, 8000);
        timerReclame.schedule(afiseazaSprite, 4000, 8000);
        timerReclame.schedule(afiseazaNestea, 6000, 8000);

        //Ascunderea optiunilor de inregistrare
        ascundeOptiuniInregistrare();

        //Cirirea Userilor inregistrati din fisier si trecerea lor in lista
        citesteUseriiDinFila();
    }

    //Cirirea Userilor inregistrati din fisier si trecerea lor in lista
    private void citesteUseriiDinFila() {
        try {
            FileInputStream fis = new FileInputStream(filaUseri);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while (true) {
                listaUseri.add((User) ois.readObject());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Metoda pentru prelucrarea Icoanelor la dimensiunea potrivita si punerea lor in label
    private void puneReclamaInLabel(ImageIcon i) {
        Image img = i.getImage();
        Image imagineNoua = img.getScaledInstance(300, 200, Image.SCALE_SMOOTH);
        labelReclama.setIcon(new ImageIcon(imagineNoua));
    }

    //Timer pentru reclame
    Timer timerReclame = new Timer();

    //TimerTaskuri: Unu pentru fiecare reclama in parte
    TimerTask afiseazaCola = new TimerTask() {
        public void run() {
            puneReclamaInLabel(reclamaCola);
        }
    };
    TimerTask afiseazaFanta = new TimerTask() {
        public void run() {
            puneReclamaInLabel(reclamaFanta);
        }
    };
    TimerTask afiseazaSprite = new TimerTask() {
        public void run() {
            puneReclamaInLabel(reclamaSprite);
        }
    };
    TimerTask afiseazaNestea = new TimerTask() {
        public void run() {
            puneReclamaInLabel(reclamaNestea);
        }
    };

    //Timer pentru salvarea constanta a listei o data la 30 de secunde
    Timer salveazaConstantLa2Minute = new Timer();
    TimerTask salveazaContactele = new TimerTask() {
        public void run() {
            try {
                //Stergerea completa a continutului fisierului
                Formatter f = new Formatter(filaActuala);
                f.format("");
                //Rescrierea fisierului
                FileOutputStream fos = new FileOutputStream(filaActuala);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for (Contact c : agenda.listaContacte) {
                    oos.writeObject(c);
                }
                System.out.println("obiectele au fost rescrise");
                fos.close();
                oos.close();
            } catch (FileNotFoundException fnfe) {
            } catch (IOException ioe) {
            };
        }
    };

    //Actualizarea modelului listei
    public void actualizareModel() {
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        //Stergerea completa a continutului modelului
        model.getDataVector().removeAllElements();
        //Si repunerea elementelor inapoi in model
        for (Iterator<Contact> it = agenda.listaContacte.iterator(); it.hasNext();) {
            Contact c = it.next();
            model.addRow(new Object[]{c.getNume() + " " + c.getPrenume(), c.getDataNasterii(), c.getNr()});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        chooserSave = new javax.swing.JFileChooser();
        chooserLoad = new javax.swing.JFileChooser();
        panelAutentificare = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelPassword = new javax.swing.JPasswordField();
        labelUsername = new javax.swing.JTextField();
        bAutentificare = new javax.swing.JButton();
        bInregistrare = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        labelIntroduUser = new javax.swing.JLabel();
        labelIntroduParola = new javax.swing.JLabel();
        labelRescrieParola = new javax.swing.JLabel();
        fieldUsername = new javax.swing.JTextField();
        fieldParola = new javax.swing.JPasswordField();
        fieldParolaRepetata = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        butonInregistreazaTe = new javax.swing.JButton();
        butonInapoi = new javax.swing.JButton();
        informatiiInregistrare = new javax.swing.JLabel();
        labelReclama = new javax.swing.JLabel();
        labelAtentionare = new javax.swing.JLabel();
        panelProiect = new javax.swing.JPanel();
        bAdaugaContact = new javax.swing.JButton();
        bModifica = new javax.swing.JButton();
        bSterge = new javax.swing.JButton();
        labelOrdonare = new javax.swing.JLabel();
        alegeCriteriul = new javax.swing.JComboBox<>();
        bOrdoneaza = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        labelSortare = new javax.swing.JLabel();
        labelFiltru = new javax.swing.JLabel();
        tipFiltrare = new javax.swing.JComboBox<>();
        jFiltru = new javax.swing.JTextField();
        labelInfo = new javax.swing.JLabel();
        bBackAutentificare = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        meniuFisiere = new javax.swing.JMenu();
        meniuDeschide = new javax.swing.JMenuItem();
        meniuSalveaza = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        meniuAjutor = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        chooserSave.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAutentificare.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setText("Username:");

        jLabel2.setText("Password:");

        bAutentificare.setBackground(new java.awt.Color(0, 51, 51));
        bAutentificare.setForeground(new java.awt.Color(255, 255, 255));
        bAutentificare.setText("Autentificare");
        bAutentificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAutentificareActionPerformed(evt);
            }
        });

        bInregistrare.setBackground(new java.awt.Color(0, 51, 51));
        bInregistrare.setForeground(new java.awt.Color(255, 255, 255));
        bInregistrare.setText("Inregistrare");
        bInregistrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInregistrareActionPerformed(evt);
            }
        });

        jLabel3.setText("Nu ai cont?");

        labelIntroduUser.setText("Introduceti usernameul dorit:");

        labelIntroduParola.setText("Introduceti parola:");

        labelRescrieParola.setText("Rescrieti parola pentru confirmare:");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setText("Inregistrare");

        butonInregistreazaTe.setBackground(new java.awt.Color(0, 51, 51));
        butonInregistreazaTe.setForeground(new java.awt.Color(255, 255, 255));
        butonInregistreazaTe.setText("Inregistreaza-te");
        butonInregistreazaTe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonInregistreazaTeActionPerformed(evt);
            }
        });

        butonInapoi.setBackground(new java.awt.Color(0, 51, 51));
        butonInapoi.setForeground(new java.awt.Color(255, 255, 255));
        butonInapoi.setText("Inapoi");
        butonInapoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonInapoiActionPerformed(evt);
            }
        });

        informatiiInregistrare.setForeground(new java.awt.Color(255, 0, 51));

        labelAtentionare.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout panelAutentificareLayout = new javax.swing.GroupLayout(panelAutentificare);
        panelAutentificare.setLayout(panelAutentificareLayout);
        panelAutentificareLayout.setHorizontalGroup(
            panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutentificareLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAutentificareLayout.createSequentialGroup()
                        .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelAutentificareLayout.createSequentialGroup()
                                .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAutentificareLayout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelUsername))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelAutentificareLayout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelAutentificareLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bInregistrare, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bAutentificare, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 158, Short.MAX_VALUE))
                            .addComponent(labelReclama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRescrieParola)
                            .addComponent(fieldParolaRepetata, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelIntroduParola)
                            .addComponent(jLabel7)
                            .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(fieldParola, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(fieldUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelIntroduUser, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(97, 97, 97))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAutentificareLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAutentificareLayout.createSequentialGroup()
                                .addComponent(informatiiInregistrare, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAutentificareLayout.createSequentialGroup()
                                .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelAtentionare, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(butonInregistreazaTe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(butonInapoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(33, 33, 33))))))
        );
        panelAutentificareLayout.setVerticalGroup(
            panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAutentificareLayout.createSequentialGroup()
                .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelAutentificareLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)
                        .addGap(74, 74, 74))
                    .addGroup(panelAutentificareLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(labelUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(labelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAutentificareLayout.createSequentialGroup()
                        .addComponent(labelIntroduUser)
                        .addGap(3, 3, 3)
                        .addComponent(fieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelIntroduParola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldParola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelRescrieParola)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldParolaRepetata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(butonInregistreazaTe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(butonInapoi)
                        .addGap(22, 22, 22)
                        .addComponent(labelAtentionare, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAutentificareLayout.createSequentialGroup()
                        .addComponent(bAutentificare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelAutentificareLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bInregistrare)
                            .addComponent(jLabel3))
                        .addGap(38, 38, 38)
                        .addComponent(labelReclama, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informatiiInregistrare, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(panelAutentificare, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 410));

        panelProiect.setBackground(new java.awt.Color(0, 102, 102));
        panelProiect.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bAdaugaContact.setBackground(new java.awt.Color(0, 51, 51));
        bAdaugaContact.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bAdaugaContact.setForeground(new java.awt.Color(255, 255, 255));
        bAdaugaContact.setText("Adauga contact");
        bAdaugaContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdaugaContactActionPerformed(evt);
            }
        });
        panelProiect.add(bAdaugaContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 346, 181, 48));

        bModifica.setBackground(new java.awt.Color(0, 51, 51));
        bModifica.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bModifica.setForeground(new java.awt.Color(255, 255, 255));
        bModifica.setText("Modifica contact selectat");
        bModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificaActionPerformed(evt);
            }
        });
        panelProiect.add(bModifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 346, 181, 48));

        bSterge.setBackground(new java.awt.Color(0, 51, 51));
        bSterge.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bSterge.setForeground(new java.awt.Color(255, 255, 255));
        bSterge.setText("Sterge Contact Selectat");
        bSterge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStergeActionPerformed(evt);
            }
        });
        panelProiect.add(bSterge, new org.netbeans.lib.awtextra.AbsoluteConstraints(408, 346, 181, 48));

        labelOrdonare.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        labelOrdonare.setText("Ordonare");
        panelProiect.add(labelOrdonare, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, -1, -1));

        alegeCriteriul.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        alegeCriteriul.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dupa nume", "Dupa prenume", "Dupa varsta", "Dupa numarul de telefon" }));
        panelProiect.add(alegeCriteriul, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 141, 373, -1));

        bOrdoneaza.setBackground(new java.awt.Color(0, 51, 51));
        bOrdoneaza.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bOrdoneaza.setForeground(new java.awt.Color(255, 255, 255));
        bOrdoneaza.setText("Ordoneaza");
        bOrdoneaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bOrdoneazaActionPerformed(evt);
            }
        });
        panelProiect.add(bOrdoneaza, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 140, 100, -1));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nume", "Data Nasterii", "Numar Telefon"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabel);

        panelProiect.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 181, 559, 153));

        labelSortare.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        labelSortare.setText("Afisare");
        panelProiect.add(labelSortare, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 102, -1, -1));

        labelFiltru.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        labelFiltru.setText("Search:");
        panelProiect.add(labelFiltru, new org.netbeans.lib.awtextra.AbsoluteConstraints(412, 102, -1, -1));

        tipFiltrare.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Afiseaza Toate Contactele", "Search(Personalizat)", "Numar Fix", "Numar Mobil", "Nascuti Astazi", "Nascuti Luna Curenta(Dupa ziua curenta)" }));
        tipFiltrare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipFiltrareActionPerformed(evt);
            }
        });
        panelProiect.add(tipFiltrare, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 98, 292, -1));

        jFiltru.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFiltruKeyReleased(evt);
            }
        });
        panelProiect.add(jFiltru, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 101, 115, -1));

        labelInfo.setText("O lista existenta de contacte este deja in folderul acestui proiect ----  ( contacte.txt )");
        panelProiect.add(labelInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 12, 590, -1));

        bBackAutentificare.setBackground(new java.awt.Color(0, 51, 51));
        bBackAutentificare.setForeground(new java.awt.Color(255, 255, 255));
        bBackAutentificare.setText("Inapoi la Autentificare ( Log out)");
        bBackAutentificare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackAutentificareActionPerformed(evt);
            }
        });
        panelProiect.add(bBackAutentificare, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        getContentPane().add(panelProiect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 410));

        meniuFisiere.setText("Fisiere");

        meniuDeschide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalp/loadIcon.png"))); // NOI18N
        meniuDeschide.setText("Deschide");
        meniuDeschide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniuDeschideActionPerformed(evt);
            }
        });
        meniuFisiere.add(meniuDeschide);

        meniuSalveaza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalp/saveIcon.png"))); // NOI18N
        meniuSalveaza.setText("Salvare");
        meniuSalveaza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meniuSalveazaActionPerformed(evt);
            }
        });
        meniuFisiere.add(meniuSalveaza);

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finalp/exitIcon.png"))); // NOI18N
        jMenuItem3.setText("Iesire");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        meniuFisiere.add(jMenuItem3);

        jMenuBar1.add(meniuFisiere);

        meniuAjutor.setText("Ajutor");

        jMenuItem1.setText("Informatii");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        meniuAjutor.add(jMenuItem1);

        jMenuBar1.add(meniuAjutor);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Buton adaugare contact
    private void bAdaugaContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdaugaContactActionPerformed
        agenda.adaugaContact.setVisible(true);
        agenda.adaugaContact.hideButtonModifica();

    }//GEN-LAST:event_bAdaugaContactActionPerformed

    //Metoda pentru aflarea indexului selectat in tabel 
    public int getSelectedIndexTabel() {
        return tabel.getSelectedRow();
    }

    //Buton pentru modificare a unui Contact din lista
    private void bModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificaActionPerformed
        if (tabel.getSelectedRow() != -1) { //Atata timp cat un contact este selectat
            agenda.adaugaContact.setVisible(true);//Deschidem frameul de Adaugare(pentru MODIFICARE in cazul nostru)
            agenda.adaugaContact.hideButtonAdauga();//Ascundem butonul Adauga,pentru a ramane doar cel Modifica
            Contact c = agenda.listaContacte.get(tabel.getSelectedRow());
            String nume = c.getNume();
            String prenume = c.getPrenume();
            String zi;
            String luna;

            //Prelucrarea datelor datii nastere - int-String
            if (c.getZi() < 10) {
                zi = "0" + String.valueOf(c.getZi());
            } else {
                zi = String.valueOf(c.getZi());
            }
            if (c.getLuna() < 10) {
                luna = "0" + String.valueOf(c.getLuna());
            } else {
                luna = String.valueOf(c.getLuna());
            }
            String an = String.valueOf(c.getAn());
            String telefon = String.valueOf(c.getNr());

            //Punerea atributelor Contactului selectat in frameul pentru modificare
            agenda.adaugaContact.actualizeazaLabeluriPentruModificare(nume, prenume, zi, luna, an, telefon);
        }
    }//GEN-LAST:event_bModificaActionPerformed

    //Buton pentru stergere a contactului selectat
    private void bStergeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStergeActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Sigur doriti sa stergeti acest contact?", "Sunteti sigur?", JOptionPane.YES_NO_OPTION);

        if (x == JOptionPane.YES_OPTION) {
            int index = tabel.getSelectedRow();
            agenda.listaContacte.remove(index);
            actualizareModel();
        }

    }//GEN-LAST:event_bStergeActionPerformed

    //Butonul pentru ordonarea Contactelor in functie de criteriul selectat
    private void bOrdoneazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bOrdoneazaActionPerformed
        //Stabilim contactul
        int index = alegeCriteriul.getSelectedIndex();
        //Stabilim criteriul de clasificare
        switch (index) {
            case 0:
                agenda.setCriteriuOrdonare(CriteriuOrdonare.DUPA_NUME);
                break;
            case 1:
                agenda.setCriteriuOrdonare(CriteriuOrdonare.DUPA_PRENUME);
                break;
            case 2:
                agenda.setCriteriuOrdonare(CriteriuOrdonare.DUPA_VARSTA);
                break;
            case 3:
                agenda.setCriteriuOrdonare(CriteriuOrdonare.DUPA_NUMARTELEFON);
                break;
        }
        //Ordonam
        agenda.ordoneaza(agenda.criteriuDeOrdonare);
        actualizareModel();

    }//GEN-LAST:event_bOrdoneazaActionPerformed

    //Metoda pentru ascunderea butoanelor in timpul sortarii
    public void ascundeButoaneleSiFiltrele() {
        bAdaugaContact.setVisible(false);
        bModifica.setVisible(false);
        bSterge.setVisible(false);
        jFiltru.setVisible(false);
        labelFiltru.setVisible(false);
    }

    private void tipFiltrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipFiltrareActionPerformed
        int index = tipFiltrare.getSelectedIndex();
        System.out.println(index);
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.getDataVector().removeAllElements();
        LocalDateTime ldt = LocalDateTime.now();
        int lunaActuala = ldt.getMonthValue();
        int ziActuala = ldt.getDayOfMonth();

        //Afisarea contactelor in tabel in functie de criteriul de filtrare
        switch (index) {
            case 0: //Afisarea tuturor contactelor
                actualizareModel();
                ascundeButoaneleSiFiltrele();
                  bAdaugaContact.setVisible(true);
        bModifica.setVisible(true);
        bSterge.setVisible(true);
                break;
            case 1: //Afisarea optiunii filtrului pentru cautare personalizata
                 actualizareModel();
                ascundeButoaneleSiFiltrele();
                jFiltru.setVisible(true);
                labelFiltru.setVisible(true);
                break;
            case 2: //Afisarea contactelor care detin numar de telefon Fix
                agenda.listaContacte.stream()
                        .filter(c -> c.getNr() instanceof NrFix)
                        .forEach(c -> model.addRow(new Object[]{c.getNume() + " " + c.getPrenume(), c.getDataNasterii(), c.getNr()}));

                ascundeButoaneleSiFiltrele();
                break;
            case 3://Afisarea contactelor care detin numar de telefon Mobil
                agenda.listaContacte.stream()
                        .filter(c -> c.getNr() instanceof NrMobil)
                        .forEach(c -> model.addRow(new Object[]{c.getNume() + " " + c.getPrenume(), c.getDataNasterii(), c.getNr()}));

                ascundeButoaneleSiFiltrele();
                break;
            case 4: //Afisarea persoanelor nascute astazi
                agenda.listaContacte.stream()
                        .filter(c -> c.getLuna() == lunaActuala && c.getZi() == ziActuala)
                        .forEach(c -> model.addRow(new Object[]{c.getNume() + " " + c.getPrenume(), c.getDataNasterii(), c.getNr()}));
                ascundeButoaneleSiFiltrele();
                break;
            case 5: //Afisarea persoanelor nascute in luna actuala, dar dupa ziua de azi inclusiv
                agenda.listaContacte.stream()
                        .filter(c -> c.getLuna() == lunaActuala && c.getZi() >= LocalDateTime.now().getDayOfMonth())
                        .forEach(c -> model.addRow(new Object[]{c.getNume() + " " + c.getPrenume(), c.getDataNasterii(), c.getNr()}));
                ascundeButoaneleSiFiltrele();
                break;

        }
        repaintTable();
    }//GEN-LAST:event_tipFiltrareActionPerformed
//Daca nu folosim aceasta metoda in cazul filtrarii,tabelul nu isi va da refresh automat si se va bugui vizual

    public void repaintTable() {
        //Daca nu folosim aceste 2 metode,tabelul nu isi va da refresh automat si se va bugui vizual
        tabel.revalidate();
        tabel.repaint();
    }

    //Metoda Key released pentru cautarea in lista a filtrului nostru
    private void jFiltruKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFiltruKeyReleased
        DefaultTableModel model = (DefaultTableModel) tabel.getModel();
        model.getDataVector().removeAllElements();
        tabel.setBackground(Color.white);
        String filtru = jFiltru.getText();
        agenda.listaContacte.stream().filter(c -> c.toString().toLowerCase().contains(filtru.toLowerCase())).forEach(c -> model.addRow(new Object[]{c.getNume() + " " + c.getPrenume(), c.getDataNasterii(), c.getNr()}));
        repaintTable();
    }//GEN-LAST:event_jFiltruKeyReleased

    //Meniu button:iesire
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "Sigur doriti sa iesiti?", "Sunteti sigur?", JOptionPane.YES_NO_OPTION);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    //MeniuButton:salvare
    private void meniuSalveazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniuSalveazaActionPerformed
        if (chooserSave.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            filaActuala = chooserSave.getSelectedFile();
            File filaSalvata = new File(filaActuala.getAbsolutePath(), "contacte.txt");
            if (!filaActuala.isDirectory()) {
                JOptionPane.showMessageDialog(null, "Nu ati selectat un folder", "Incercati din nou", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    FileOutputStream fos = new FileOutputStream(filaSalvata);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    for (Contact c : agenda.listaContacte) {
                        oos.writeObject(c);
                    }
                    fos.close();
                    oos.close();
                    filaSalvata.createNewFile();
                } catch (FileNotFoundException fnfe) {
                } catch (IOException ioe) {
                };
            }
        }
    }//GEN-LAST:event_meniuSalveazaActionPerformed

    //MeniuButton:Incarcare
    private void meniuDeschideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meniuDeschideActionPerformed
        if (chooserLoad.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            filaActuala = chooserLoad.getSelectedFile();
            if (!filaActuala.getAbsolutePath().endsWith(".txt")) {
                JOptionPane.showMessageDialog(null, "Nu ati selectat un fisier text", "Incercati din nou", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    FileInputStream fis = new FileInputStream(filaActuala);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    agenda.listaContacte.removeAll(agenda.listaContacte);
                    while (true) {
                        agenda.listaContacte.add((Contact) ois.readObject());
                        actualizareModel();
                    }

                } catch (FileNotFoundException ex) {
                } catch (IOException ioe) {
                } catch (ClassNotFoundException cnfe) {
                }
            }
        }
        //Pornim timerul de salvare constanta a filei
        salveazaConstantLa2Minute.schedule(salveazaContactele, 1000, 30000);
        //rescrise o data la 30 de secunde
    }//GEN-LAST:event_meniuDeschideActionPerformed

    //Afisarea in meniul de Autentificare/Inregistrare a labelurilor de inregistrare
    public void afiseazaOptiuniInregistrare() {
        labelIntroduUser.setVisible(true);
        labelIntroduParola.setVisible(true);
        labelRescrieParola.setVisible(true);
        fieldUsername.setVisible(true);
        fieldParola.setVisible(true);
        fieldParolaRepetata.setVisible(true);
        jLabel7.setVisible(true);
        butonInregistreazaTe.setVisible(true);
        butonInapoi.setVisible(true);
        informatiiInregistrare.setVisible(false);
    }

    //Butonul de inregistrare
    private void bInregistrareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInregistrareActionPerformed
        afiseazaOptiuniInregistrare();
        jLabel1.setVisible(false);
        jLabel2.setVisible(false);
        labelPassword.setVisible(false);
        labelUsername.setVisible(false);
        bAutentificare.setVisible(false);
        bInregistrare.setVisible(false);
        jLabel3.setVisible(false);
    }//GEN-LAST:event_bInregistrareActionPerformed
//Ascunderea optiunilor de inregistrare

    public void ascundeOptiuniInregistrare() {
        labelIntroduUser.setVisible(false);
        labelIntroduParola.setVisible(false);
        labelRescrieParola.setVisible(false);
        fieldUsername.setVisible(false);
        fieldParola.setVisible(false);
        fieldParolaRepetata.setVisible(false);
        jLabel7.setVisible(false);
        butonInregistreazaTe.setVisible(false);
        butonInapoi.setVisible(false);
    }

    public void afiseazaAutentificare() {
        jLabel1.setVisible(true);
        jLabel2.setVisible(true);
        labelPassword.setVisible(true);
        labelUsername.setVisible(true);
        bAutentificare.setVisible(true);
        bInregistrare.setVisible(true);
        jLabel3.setVisible(true);
    }

    //Buton-Trecerea de la Inregistrare inapoi la Autentificare
    private void butonInapoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonInapoiActionPerformed
        ascundeOptiuniInregistrare();
        afiseazaAutentificare();
        labelAtentionare.setText("");

    }//GEN-LAST:event_butonInapoiActionPerformed

    //Rescrierea filei userilor
    private void rescriereaFileiUserilor() {
        try {
            Formatter f = new Formatter(filaUseri);
            f.format("");

            FileOutputStream fos = new FileOutputStream(filaUseri);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (User user : listaUseri) {
                oos.writeObject(user);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Buton de inregistrare.
    private void butonInregistreazaTeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonInregistreazaTeActionPerformed
        String username = fieldUsername.getText();
        String parola = fieldParola.getText();
        String parolaRepetata = fieldParolaRepetata.getText();
        //Verificari
        for (User user : listaUseri) {
            if (username.equals(user.getUsername())) {
                labelAtentionare.setText("Acest username exista deja");
                return;
            }
        }
        if (!username.equals("")) {
            if (parola.equals(parolaRepetata)) {
                listaUseri.add(new User(username, parola));
                rescriereaFileiUserilor();
                informatiiInregistrare.setText("");
                ascundeOptiuniInregistrare();
                afiseazaAutentificare();
                labelAtentionare.setText("");
                JOptionPane.showMessageDialog(this, "V-ati inregistrat cu succes!");
            } else {
                labelAtentionare.setText("Parolele nu se potrivesc");
            }
        } else {
            labelAtentionare.setText("Nu ati introdus usernameul");
        }

    }//GEN-LAST:event_butonInregistreazaTeActionPerformed

    //Butonul de autentificare
    private void bAutentificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAutentificareActionPerformed
        String username = labelUsername.getText();
        String password = labelPassword.getText();
        boolean sePoateIntra = false;
        for (User user : listaUseri) {
            if (user.getUsername().equals(username) && user.getParola().equals(password)) {
                sePoateIntra = true;
            }
        }
        if (sePoateIntra) {
            JOptionPane.showMessageDialog(this, "V-ati logat cu succes");
            panelProiect.setVisible(true);
            panelAutentificare.setVisible(false);
            labelUsername.setText("");
            labelPassword.setText("");
            meniuDeschide.setEnabled(true);
            meniuSalveaza.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(this, "Userul sau parola sunt incorecte", "Eroare", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_bAutentificareActionPerformed

    //Butonul de Log out
    private void bBackAutentificareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackAutentificareActionPerformed
        panelProiect.setVisible(false);
        panelAutentificare.setVisible(true);
        labelUsername.setText("");
        labelPassword.setText("");
        meniuDeschide.setEnabled(false);
        meniuSalveaza.setEnabled(false);
    }//GEN-LAST:event_bBackAutentificareActionPerformed

    //Butonul de ajutor:informatii
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed

    new Ajutor().setVisible(true);
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> alegeCriteriul;
    private javax.swing.JButton bAdaugaContact;
    private javax.swing.JButton bAutentificare;
    private javax.swing.JButton bBackAutentificare;
    private javax.swing.JButton bInregistrare;
    private javax.swing.JButton bModifica;
    private javax.swing.JButton bOrdoneaza;
    private javax.swing.JButton bSterge;
    private javax.swing.JButton butonInapoi;
    private javax.swing.JButton butonInregistreazaTe;
    private javax.swing.JFileChooser chooserLoad;
    private javax.swing.JFileChooser chooserSave;
    private javax.swing.JPasswordField fieldParola;
    private javax.swing.JPasswordField fieldParolaRepetata;
    private javax.swing.JTextField fieldUsername;
    private javax.swing.JLabel informatiiInregistrare;
    private javax.swing.JTextField jFiltru;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelAtentionare;
    private javax.swing.JLabel labelFiltru;
    private javax.swing.JLabel labelInfo;
    private javax.swing.JLabel labelIntroduParola;
    private javax.swing.JLabel labelIntroduUser;
    private javax.swing.JLabel labelOrdonare;
    private javax.swing.JPasswordField labelPassword;
    private javax.swing.JLabel labelReclama;
    private javax.swing.JLabel labelRescrieParola;
    private javax.swing.JLabel labelSortare;
    private javax.swing.JTextField labelUsername;
    private javax.swing.JMenu meniuAjutor;
    private javax.swing.JMenuItem meniuDeschide;
    private javax.swing.JMenu meniuFisiere;
    private javax.swing.JMenuItem meniuSalveaza;
    private javax.swing.JPanel panelAutentificare;
    private javax.swing.JPanel panelProiect;
    private javax.swing.JTable tabel;
    private javax.swing.JComboBox<String> tipFiltrare;
    // End of variables declaration//GEN-END:variables
}
