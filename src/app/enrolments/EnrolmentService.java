package app.enrolments;

import app.utile.Frecventa;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EnrolmentService {
    private List<Enrolment> enorlements;

    public List<Enrolment>getEnorlements(){
        return this.enorlements;
    }
    public EnrolmentService(){
        this.enorlements=new ArrayList<>();
        load();
    }
    public void load(){
        File file=new File("C:\\mycode\\probleme\\TeorieIncapsulare2\\src\\app\\enrolments\\enrolments.txt");
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.enorlements.add(new Enrolment(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void addEnrolment(Enrolment enrolment){
        this.enorlements.add(enrolment);

    }

    public String toSave(){
        String text="";
        for(int i=0;i<this.enorlements.size()-1;i++){
            text+=this.enorlements.get(i).proprietati()+"\n";
        }
        text+=this.enorlements.get(this.enorlements.size()-1).proprietati();
        return text.trim();
    }

    public void save(){
        File file=new File("C:\\mycode\\probleme\\TeorieIncapsulare2\\src\\app\\enrolments\\enrolments.txt");
        try{
            FileWriter filewriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(filewriter);

            printWriter.print(this.toSave());
            printWriter.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public void afisareEnrolments(){
        for(int i=0;i<this.enorlements.size();i++){
            System.out.println(this.enorlements.get(i).descriereEnrolment());
        }
    }







    public Enrolment getEnrolmentById(int id){
        for(int i=0;i<enorlements.size();i++){
            if(this.enorlements.get(i).getId() ==id){
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
            if(this.enorlements.get(i).getIdStudent() ==id){
                istoricInscrieri.add(this.enorlements.get(i).getIdCurs());
            }
        }
        return istoricInscrieri;
    }


    public List<Frecventa>frecventaCursurilor(){
        List<Frecventa>frecvente=new ArrayList<>();
        for (int i=0;i<enorlements.size();i++){
             int idCurs= enorlements.get(i).getIdCurs();
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
