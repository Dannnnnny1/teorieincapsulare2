package app.students;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService {

private List<Student> students;

public List<Student>getStudents(){
    return this.students;
    }

    public StudentService(){
    this.students=new ArrayList<>();
    load();
    }


    public void load(){
    File file=new File("C:\\mycode\\probleme\\TeorieIncapsulare2\\src\\app\\students\\students.txt");
    try{
        Scanner scanner=new Scanner(file);
        while(scanner.hasNextLine()){
            String line=scanner.nextLine();
            this.students.add(new Student(line));
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    }
    public void add(Student student){
    this.students.add(student);
    }

    public String toSave(){
    String text="";
    for(int i=0;i<this.students.size()-1;i++){
        text+=this.students.get(i).proprietati()+"\n";
    }
    text+=this.students.get(students.size()-1).proprietati();
    return text.trim();
    }

    public void save(){
    File file=new File("C:\\mycode\\probleme\\TeorieIncapsulare2\\src\\app\\students\\students.txt");
    try{
        FileWriter fileWriter=new FileWriter(file);
        PrintWriter printWriter=new PrintWriter(fileWriter);

        printWriter.print(this.toSave());
        printWriter.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    }

    public Student findById(int id){
        for(int i=0;i<this.students.size();i++){
            if(students.get(i).getId() ==id){
                return students.get(i);
            }
        }

        return null;

    }

    public void afisareStudenti(){
        for(int i=0;i<students.size();i++){
            System.out.println(this.students.get(i).descriere());
        }
    }


    public  void change(){
        Student student=this.findById(1);

        student.setGen("neutru");
    }

    public Student getStudentByIdAndPassword(String nume,String password){
        for(int i=0;i<this.students.size();i++){
            if(this.students.get(i).getNume().equalsIgnoreCase(nume)&& this.students.get(i).getPassword().equalsIgnoreCase(password)){
                return this.students.get(i);
            }
        }
        return null;
    }

}
