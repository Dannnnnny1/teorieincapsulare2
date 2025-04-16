package app.enrolments;

public class Enrolment {
    private int id;
    private int idStudent;
    private int idCurs;
    private String enrolmentDate;

    public Enrolment(int id, int idStudent, int idCurs, String enrolmentDate) {
        this.id = id;
        this.idStudent = idStudent;
        this.idCurs = idCurs;
        this.enrolmentDate = enrolmentDate;
    }

    public Enrolment(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.idStudent=Integer.parseInt(prop[1]);
        this.idCurs=Integer.parseInt(prop[2]);
        this.enrolmentDate=prop[3];
    }

    public Enrolment() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public String getEnrolmentDate() {
        return enrolmentDate;
    }

    public void setEnrolmentDate(String enrolmentDate) {
        this.enrolmentDate = enrolmentDate;
    }

    public String descriereEnrolment(){
        String text="";
        text+="Id "+this.id+"\n";
        text+="Id Student "+this.idStudent+"\n";
        text+="Id Curs "+this.idCurs+"\n";
        text+="Data Inscrierii "+this.enrolmentDate+"\n";
        return text;
    }

    public String proprietati(){
        return id+","+idStudent+","+idCurs+","+enrolmentDate;
    }
}
