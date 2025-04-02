package app.enrolments;

import app.utile.Frecventa;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnrolmentService {
    public List<Enrolment> enorlements=new ArrayList<>();
    public void load(){
        Enrolment enrolment1=new Enrolment();
        enrolment1.id=1;
        enrolment1.idCurs=1;
        enrolment1.idStudent=1;
        enrolment1.enrolmentDate="17-05-2024";

        Enrolment enrolment2=new Enrolment();
        enrolment2.id=2;
        enrolment2.idCurs=3;
        enrolment2.idStudent=2;
        enrolment2.enrolmentDate="11-05-2024";


        Enrolment enrolment3=new Enrolment();
        enrolment3.id=3;
        enrolment3.idCurs=1;
        enrolment3.idStudent=2;
        enrolment3.enrolmentDate="17-05-2024";



        Enrolment enrolment4=new Enrolment();
        enrolment4.id=1;
        enrolment4.idCurs=4;
        enrolment4.idStudent=2;
        enrolment4.enrolmentDate="17-05-2024";



        Enrolment enrolment5=new Enrolment();
        enrolment5.id=5;
        enrolment5.idCurs=2;
        enrolment5.idStudent=1;
        enrolment5.enrolmentDate="17-05-2024";

        enorlements.add(enrolment1);
        enorlements.add(enrolment2);
        enorlements.add(enrolment3);
        enorlements.add(enrolment4);
        enorlements.add(enrolment5);

    }
    public void addEnrolment(Enrolment enrolment){
        this.enorlements.add(enrolment);

    }
    public Enrolment getEnrolmentById(int id){
        for(int i=0;i<enorlements.size();i++){
            if(this.enorlements.get(i).id==id){
                return this.enorlements.get(i);
            }
        }
        return null;
    }

    public int generareIdEnrolment(){
        Random random= new Random();
        int id=random.nextInt(1000000)+1;
        while (getEnrolmentById(id)!=null){
            id=random.nextInt(1000000)+1;
        }
        return id;
    }

    public List<Integer>enrolmentHistory(int id){
        List<Integer>istoricInscrieri=new ArrayList<>();
        for(int i=0;i<enorlements.size();i++){
            if(this.enorlements.get(i).idStudent==id){
                istoricInscrieri.add(this.enorlements.get(i).idCurs);
            }
        }
        return istoricInscrieri;
    }


    public List<Frecventa>frecventaCursurilor(){
        List<Frecventa>frecvente=new ArrayList<>();
        for (int i=0;i<enorlements.size();i++){
             int idCurs=enorlements.get(i).idCurs;
             Frecventa frecventa= getPozitieFrecventa(idCurs,frecvente);
             if(frecventa==null){
                 Frecventa frecventa1= new Frecventa();
                 frecventa1.idCurs=idCurs;
                 frecventa1.frecventa++;
                 frecvente.add(frecventa1);
             }else{
                 frecventa.frecventa++;
             }
        }
        return  frecvente;
    }

    public Frecventa  getPozitieFrecventa(int idCurs,List<Frecventa> frecvente){
        for(int i=0;i<frecvente.size();i++){
             if(frecvente.get(i).idCurs==idCurs){
                 return  frecvente.get(i);
             }
        }
        return null;
    }


    public Frecventa ceaMaiMareFrecventa(){
        List<Frecventa>frecvente=frecventaCursurilor();
        Frecventa max=frecvente.get(0);
        for(int i=0;i<frecvente.size();i++){
            if(frecvente.get(i).frecventa>max.frecventa){
                max=frecvente.get(i);
            }
        }
        return max;
    }

}
