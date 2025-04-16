package app.curs;

import app.enrolments.EnrolmentService;
import app.utile.Frecventa;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CursService {
    EnrolmentService enrolmentService=new EnrolmentService();
    private List<Curs>cursuri;

    public List<Curs>getCursuri(){
        return this.cursuri;
    }

    public CursService(){
        this.cursuri=new ArrayList<>();
        load();
    }

    public void load(){

        File file=new File("C:\\mycode\\probleme\\TeorieIncapsulare2\\src\\app\\curs\\curs.txt");
        try{
            Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()){
                String line=scanner.nextLine();
                this.cursuri.add(new Curs(line));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSave(){
        String text="";
        for(int i=0;i<cursuri.size()-1;i++){
            text+=this.cursuri.get(i).proprietati()+"\n";
        }
        text+=this.cursuri.get(this.cursuri.size()-1).proprietati();
        return text.trim();
    }

    public void save(){
        File file=new File("C:\\mycode\\probleme\\TeorieIncapsulare2\\src\\app\\curs\\curs.txt");
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);

            printWriter.print(this.toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Curs>afisareCursuri(){
        List<Curs>cursuri=new ArrayList<>();
        for(int i=0;i<this.cursuri.size();i++){
            System.out.println(this.cursuri.get(i).getNumeCurs());
        }
        return cursuri;
    }
    public void add(Curs curs){
        this.cursuri.add(curs);
    }


    public Curs getCursByName(String nume){
        for(int i=0;i<this.cursuri.size();i++){
            if(this.cursuri.get(i).getNumeCurs().equalsIgnoreCase(nume)){
                return this.cursuri.get(i);
            }
        }
        return null;
    }
    public List<Curs>cursHistory(List<Integer>idStudenti){
            List<Curs>cursuri=new ArrayList<>();
        for(int i=0;i<this.cursuri.size();i++){
            if(idStudenti.contains(this.cursuri.get(i).getIdCurs())){
                cursuri.add(this.cursuri.get(i));
            }
        }
        return cursuri;
    }

    //todo:get course by id
    public Curs getCursById(int id){
        for(int i=0;i<this.cursuri.size();i++){
            if(this.cursuri.get(i).getIdCurs() ==id){
                return this.cursuri.get(i);
            }
        }
        return null;
    }

}
