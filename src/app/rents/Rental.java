package app.rents;

public class Rental {
    public int id;
    public String rentDate;
    public int idBook;
    public int idStud;
    public String stare;


    public String descriere(){
        String text="";
        text+="ID "+this.id+"\n";
        text+="NUME "+this.rentDate+"\n";
        text+="VASRSTA "+this.idBook+"\n";
        text+="GEN "+this.idStud+"\n";
        text+="Stare"+this.stare+"\n";
        return text;
    }
}
