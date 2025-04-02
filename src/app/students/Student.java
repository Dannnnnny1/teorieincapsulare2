package app.students;

public class Student {
    public int id;
    public String nume;
    public int varsta;
    public  String gen;
    public String password;

    public String descriere(){
        String text="";
        text+="ID "+this.id+"\n";
        text+="NUME "+this.nume+"\n";
        text+="VASRSTA "+this.varsta+"\n";
        text+="GEN "+this.gen+"\n";
        return text;
    }

}
