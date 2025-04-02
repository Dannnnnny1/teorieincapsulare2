package app.students;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

public List<Student> students=new ArrayList<>();


    public void load(){
        Student student1=new Student();
        student1.id=1;
        student1.nume="Daniel";
        student1.varsta=21;
        student1.gen="Masculin";
        student1.password="daniel";


        Student student2=new Student();
        student2.id=2;
        student2.nume="Horatiu";
        student2.varsta=20;
        student2.gen="Masculin";
        student2.password="daniel";

        students.add(student1);
        students.add(student2);
    }

    public Student findById(int id){
        for(int i=0;i<this.students.size();i++){
            if(students.get(i).id==id){
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

        student.gen="neutru";
    }

    public Student getStudentByIdAndPassword(String nume,String password){
        for(int i=0;i<this.students.size();i++){
            if(this.students.get(i).nume.equalsIgnoreCase(nume)&&this.students.get(i).password.equalsIgnoreCase(password)){
                return this.students.get(i);
            }
        }
        return null;
    }

}
