package app.enrolments;

public class Enrolment {
    public int id;
    public int idStudent;
    public int idCurs;
    public String enrolmentDate;


    public void descriereEnrolment(){
        String text="";
        text+="Id "+this.id+"\n";
        text+="Id Student "+this.idStudent+"\n";
        text+="Id Curs "+this.idCurs+"\n";
        text+="Data Inscrierii "+this.enrolmentDate+"\n";

    }
}
