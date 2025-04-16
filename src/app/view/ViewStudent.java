package app.view;

import app.books.Book;
import app.books.BookService;
import app.curs.Curs;
import app.curs.CursService;
import app.enrolments.Enrolment;
import app.enrolments.EnrolmentService;
import app.rents.Rental;
import app.rents.RentalService;
import app.students.Student;
import app.students.StudentService;
import app.utile.Frecventa;

import java.util.List;
import java.util.Scanner;

public class ViewStudent {

     private BookService bookService;
     private RentalService rentalService;
     private CursService cursService;
     private EnrolmentService enrolmentService;
     public Scanner scanner;
     private ViewLogin viewLogin;
     public StudentService studentService;

     public ViewStudent(){
         this.bookService=new BookService();
         this.rentalService=new RentalService();
         this.cursService=new CursService();
         this.enrolmentService=new EnrolmentService();
         this.scanner=new Scanner(System.in);
         this.studentService=new StudentService();
         this.viewLogin=new ViewLogin();
         this.play();
     }


     public Student student=null;
    //todo:afisarea cartiilor

    public void meniuStudent(){
        System.out.println("1.->Afisarea cartilor");
        System.out.println("2.->Inchiriaza carte");
        System.out.println("3-> Istoricul inchirierilor");
        System.out.println("4-> Returneaza Cartea");
        System.out.println("5->Inscrie-te la un curs");
        System.out.println("6->Arata istoricul inscrierilor la cursuri");
        System.out.println("7->Arata cel mai popular curs");


    }

    public void meniuLogin(){
        System.out.println("1->LOGIN");
        System.out.println("0->EXIT");
    }
    public void play(){
        boolean run=true;
        while(run) {
            if (student == null) {
                this.meniuLogin();
                int alegere = scanner.nextInt();
                switch (alegere) {
                    case 1:
                        student = viewLogin.login();
                        break;
                    case 0:
                        run = false;
                        System.out.println("La revedere");
                        break;
                }

            } else {
                this.meniuStudent();
                int alegere=scanner.nextInt();

                switch (alegere) {
                    case 1:
                        this.bookService.afisareCarti();
                        break;
                    case 2:
                        rent();
                        break;
                    case 3:
                        rentalHistory();
                        break;
                    case 4:
                        returneazaCartea();
                        break;
                    case 5:
                        inscriereLaCurs();
                        break;
                    case 6:
                        istoriculCursurilor();
                        break;
                    case 7:
                        afisareCelMaiPopularCurs();
                }
            }
        }

    }



    //todo:inchiriere carte
    public void rent(){
        //todo:intreaba ce carte doreste sa inchirieze
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ce carte doriti sa inchiriati?");
        String carte=scanner.nextLine();
        Book book= bookService.getBookByTitle(carte);
        if(book!=null&&!book.isInchiriat()){
            Rental rental = new Rental();
            rental.id=this.rentalService.generareId();
            rental.idStud= this.student.getId();
            rental.idBook= book.getId();
            this.rentalService.addRent(rental);
            System.out.println("Cartea a fost inchiriata cu succes");
            book.setInchiriat(true);
            rental.stare="Inchiriata";
        }
        else {
            System.out.println("Titlul introdus nu exista");
        }


    }
    public void rentalHistory(){

        List<Integer>idInchiriate=rentalService.rentalHistory(student.getId());
        List<Book>carti=bookService.bookHistory(idInchiriate);
        for(int i=0;i<carti.size();i++){
            System.out.println(carti.get(i).descriere());
        }

    }
    public void returneazaCartea(){
        System.out.println("Introdu cartea pe care vrei sa o returnezi");
        String titlu=scanner.nextLine();
        Book carte=bookService.bookReturnal(titlu);
        if(carte!=null){
            System.out.println("Cartea"+ carte.getTitle() +" a fost returnata cu succes");
            carte.setInchiriat(false);
        }
        else{
            System.out.println("Aceasta carte nu este inchiriata");
        }

    }
    public void inscriereLaCurs(){
        Scanner scanner1=new Scanner(System.in);
        System.out.println("La ce curs vreti sa va inscrieti?");
        String curs=scanner1.nextLine();
        Curs curs1=cursService.getCursByName(curs);
        if(curs1!=null){
            Enrolment enrolment=new Enrolment();
            enrolment.setId(this.enrolmentService.generareIdEnrolment());
            enrolment.setId(this.student.getId());
            this.enrolmentService.addEnrolment(enrolment);
            System.out.println("V-ati inscris cu succes la cursul de "+curs);
        }
        else{
            System.out.println("Acest curs nu exista");
        }

    }
    public void istoriculCursurilor(){
        List<Integer>idCursuri=enrolmentService.enrolmentHistory(student.getId());
        List<Curs>cursuri=cursService.cursHistory(idCursuri);
        if(cursuri.size()>0){
            System.out.println("Pana acum v-ati inscris la urmatoarele cursuri:");
            for(int i=0;i<cursuri.size();i++){
                System.out.println(cursuri.get(i).getNumeCurs());
            }
        }
        else{
            System.out.println("Nu v-ati inscris la niciun curs");
        }

    }
    public void afisareCelMaiPopularCurs(){
        Frecventa frecventa=enrolmentService.ceaMaiMareFrecventa();
        int id=frecventa.idCurs;
        Curs curs=cursService.getCursById(id);
        System.out.println("Cel mai frecventat curs este: ");
        System.out.println(curs.getNumeCurs());
    }

}
