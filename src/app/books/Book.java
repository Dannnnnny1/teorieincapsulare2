package app.books;

public class Book {
    public int id;
    public String title;
    public String Author;
    public boolean inchiriat;

    public String descriere(){
        String text="";
        text+="ID "+this.id+"\n";
        text+="Titlu "+this.title+"\n";
        text+="autor "+this.Author+"\n";
        text+="inchiriat "+this.inchiriat+"\n";
        return text;
    }

}
