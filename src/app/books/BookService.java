package app.books;

import app.rents.Rental;
import app.rents.RentalService;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookService {
    private List<Book> books;

    public List<Book> getBooks(){
        return this.books;
    }

    public BookService() {
        this.books = new ArrayList<>();
        load();
    }

    public void load() {
        File file = new File("C:\\mycode\\probleme\\TeorieIncapsulare2\\src\\app\\books\\books.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                this.books.add(new Book(line));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void add(Book book){
        this.books.add(book);
    }

    public String toSave(){
        String text="";
        for(int i=0;i<this.books.size()-1;i++){
            text+=this.books.get(i).proprietati()+"\n";
        }
        text+=this.books.get(this.books.size()-1).proprietati();
        return text.trim();
    }

    public void save(){
        File file=new File("C:\\mycode\\probleme\\TeorieIncapsulare2\\src\\app\\books\\books.txt");
        try{
            FileWriter fileWriter=new FileWriter(file);
            PrintWriter printWriter=new PrintWriter(fileWriter);

            printWriter.print(this.toSave());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void afisareCarti(){
        for(int i=0;i<this.books.size();i++){
            System.out.println(this.books.get(i).descriere());
        }
    }

    //todo: getBookByTitle

    public Book getBookByTitle(String title){
        for(int i=0;i<books.size();i++){
            if(this.books.get(i).getTitle().equals(title)){
                return this.books.get(i);
            }
        }
        return null;
    }

    public List<Book> bookHistory(List<Integer>idBooks){
        List<Book>books=new ArrayList<>();
        for(int i=0;i<this.books.size();i++){
          if(idBooks.contains(this.books.get(i).getId())){
              books.add(this.books.get(i));
          }
        }
        return books;
    }
    public Book bookReturnal(String titlu){
        for(int i=0;i<this.books.size();i++){
            if(this.books.get(i).getTitle().equals(titlu)&& this.books.get(i).isInchiriat() ==false){
                return this.books.get(i);
            }
        }
        return null;
    }
}