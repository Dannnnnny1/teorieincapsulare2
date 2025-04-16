package app.view;

import app.students.StudentService;
import app.students.Student;
import java.util.Scanner;
public class ViewLogin {
    //todo: logarea studentului
    public StudentService studentService1 = new StudentService();
    public Scanner scanner = new Scanner(System.in);


    public Student login() {
        System.out.println("Introduceti numele");
        scanner.nextLine();
        String nume = scanner.nextLine();
        System.out.println("Introduceti parola");
        String parola = scanner.nextLine();
        Student student = studentService1.getStudentByIdAndPassword(nume, parola);

        if (student!=null) {
            System.out.println("Autentificare cu succes!");
            System.out.println("Bun venit "+ student.getNume());
            return student;
        } else {
            System.out.println("Autentificare esuata!");
        }
        return null;
    }











}
