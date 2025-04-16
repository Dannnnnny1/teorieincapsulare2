package app.books;

public class Book {
    private int id;
    private String title;
    private String Author;
    private boolean inchiriat;

    public Book(int id, String title, String author, boolean inchiriat) {
        this.id = id;
        this.title = title;
        Author = author;
        this.inchiriat = inchiriat;
    }

    public Book(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.title=prop[1];
        this.Author=prop[2];
        this.inchiriat=Boolean.parseBoolean(prop[3]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public boolean isInchiriat() {
        return inchiriat;
    }

    public void setInchiriat(boolean inchiriat) {
        this.inchiriat = inchiriat;
    }

    public String descriere(){
        String text="";
        text+="ID "+this.id+"\n";
        text+="Titlu "+this.title+"\n";
        text+="autor "+this.Author+"\n";
        text+="inchiriat "+this.inchiriat+"\n";
        return text;
    }

    public String proprietati(){
        return id+","+title+","+Author+","+inchiriat;
    }

}
