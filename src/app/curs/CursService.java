package app.curs;

import app.enrolments.EnrolmentService;
import app.utile.Frecventa;

import java.util.ArrayList;
import java.util.List;

public class CursService {
    EnrolmentService enrolmentService=new EnrolmentService();
    List<Curs>cursuri=new ArrayList<>();
    public void load(){
        Curs curs1=new Curs();
        curs1.idCurs=1;
        curs1.numeCurs="Matematica";

        Curs curs2=new Curs();
        curs2.idCurs=2;
        curs2.numeCurs="Romana";

        Curs curs3=new Curs();
        curs3.idCurs=3;
        curs3.numeCurs="Fizica";

        Curs curs4=new Curs();
        curs4.idCurs=4;
        curs4.numeCurs="Chimie";

        Curs curs5=new Curs();
        curs5.idCurs=5;
        curs5.numeCurs="Sport";

        cursuri.add(curs1);
        cursuri.add(curs2);
        cursuri.add(curs3);
        cursuri.add(curs4);
        cursuri.add(curs5);
    }
    public Curs getCursByName(String nume){
        for(int i=0;i<this.cursuri.size();i++){
            if(this.cursuri.get(i).numeCurs.equalsIgnoreCase(nume)){
                return this.cursuri.get(i);
            }
        }
        return null;
    }
    public List<Curs>cursHistory(List<Integer>idStudenti){
            List<Curs>cursuri=new ArrayList<>();
        for(int i=0;i<this.cursuri.size();i++){
            if(idStudenti.contains(this.cursuri.get(i).idCurs)){
                cursuri.add(this.cursuri.get(i));
            }
        }
        return cursuri;
    }

    //todo:get course by id
    public Curs getCursById(int id){
        for(int i=0;i<this.cursuri.size();i++){
            if(this.cursuri.get(i).idCurs==id){
                return this.cursuri.get(i);
            }
        }
        return null;
    }

}
