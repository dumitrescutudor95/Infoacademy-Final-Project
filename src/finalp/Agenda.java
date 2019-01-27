
package finalp;

//Importuri
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Agenda implements Serializable {
    
    //Lista tuturor contactelor
    public List<Contact> listaContacte = new LinkedList<>();
  
     
    //Filtru
    public String filtruCurent="";

   //Enum object-poate fi modificat pe parcurs
    public CriteriuOrdonare criteriuDeOrdonare=CriteriuOrdonare.DUPA_NUME;
     
    //Frame pentru adaugarea unui nou contact.va fi declarat in main.
    public AdaugaContact adaugaContact;
    
    //Constructor
 
    
    //Metoda folosita in main
    public void setAdaugaContact(AdaugaContact c){
        this.adaugaContact=c;
    }
    
    //Metoda pentru adaugarea unui nou contact in lista(daca nu exista deja)
    public void adaugaContact(Contact c){
        for(Contact existent:listaContacte){
            if (existent.equals(c)) {
                return;
            }
            else{
                listaContacte.add(c);
            }
        }
    }
    
  //Setarea criteriului de ordonare
    public void setCriteriuOrdonare(CriteriuOrdonare x){
        criteriuDeOrdonare=x;
    }
    
   
    //Selectarea criteriului d eordonare in functie de enumul selectat
    public void ordoneaza(CriteriuOrdonare c){
        switch (c){
            case DUPA_NUME:
                Collections.sort(listaContacte, (c1,c2)->c1.getNume().compareTo(c2.getNume()));
                break;
            case DUPA_PRENUME:
                 Collections.sort(listaContacte, (c1,c2)->c1.getPrenume().compareTo(c2.getPrenume()));
                break;
            case DUPA_VARSTA:
                 Collections.sort(listaContacte, (c1,c2)->c1.comparaVarsta(c2));
                break;
            case DUPA_NUMARTELEFON:
                Collections.sort(listaContacte,(c1,c2)->c1.getNr().compareTo(c2.getNr()));
                        break;
        }
    }
}
