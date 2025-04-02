package app.books;

import app.rents.Rental;
import app.rents.RentalService;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    public List<Book> books=new ArrayList<>();
    public void load(){
        Book book1=new Book();
        book1.Author="Ion Creanga";
        book1.id=1;
        book1.title="Amintiri din Copilarie";
        book1.inchiriat=false;

        Book book2=new Book();
        book2.Author="J.K.Rowling";
        book2.id=2;
        book2.title="Harry Potter";
        book2.inchiriat=false;

        Book book3=new Book();
        book3.Author="Slavici";
        book3.id=3;
        book3.title="Moara cu Noroc";
        book3.inchiriat=false;

        Book book4=new Book();
        book4.Author="Dumas";
        book4.id=4;
        book4.title="Robin Hood";
        book4.inchiriat=false;

        Book book5=new Book();
        book5.Author="Eminescu";
        book5.id=5;
        book5.title="Poezii";
        book5.inchiriat=false;

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);


    }
    public void afisareCarti(){
        for(int i=0;i<this.books.size();i++){
            System.out.println(this.books.get(i).descriere());
        }
    }

    //todo: getBookByTitle

    public Book getBookByTitle(String title){
        for(int i=0;i<books.size();i++){
            if(this.books.get(i).title.equals(title)){
                return this.books.get(i);
            }
        }
        return null;
    }

    public List<Book> bookHistory(List<Integer>idBooks){
        List<Book>books=new ArrayList<>();
        for(int i=0;i<this.books.size();i++){
          if(idBooks.contains(this.books.get(i).id)){
              books.add(this.books.get(i));
          }
        }
        return books;
    }
    public Book bookReturnal(String titlu){
        for(int i=0;i<this.books.size();i++){
            if(this.books.get(i).title.equals(titlu)&&this.books.get(i).inchiriat==false){
                return this.books.get(i);
            }
        }
        return null;
    }
}