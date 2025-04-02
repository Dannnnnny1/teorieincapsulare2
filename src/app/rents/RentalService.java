package app.rents;

import app.books.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RentalService {
    public List<Rental>rentals=new ArrayList<>();
    public void load(){
        Rental rental1=new Rental();
        rental1.id=1;
        rental1.idStud=2;
        rental1.idBook=1;
        rental1.stare="returnata";


        Rental rental2=new Rental();
        rental2.id=2;
        rental2.idStud=1;
        rental2.idBook=1;
        rental2.stare="returnata";



        Rental rental3=new Rental();
        rental3.id=3;
        rental3.idStud=1;
        rental3.idBook=2;
        rental3.stare="returnata";

        Rental rental4=new Rental();
        rental4.id=4;
        rental4.idStud=3;
        rental4.idBook=1;
        rental4.stare="returnata";


        Rental rental5=new Rental();
        rental5.id=5;
        rental5.idStud=1;
        rental5.idBook=3;
        rental5.stare="returnata";



        rentals.add(rental1);
        rentals.add(rental2);
        rentals.add(rental3);
        rentals.add(rental4);
        rentals.add(rental5);


    }

    public void afisareRentals(){
        for(int i=0;i<this.rentals.size();i++){
            System.out.println(this.rentals.get(i).descriere());
        }
    }

    //todo:add rent

    public void addRent(Rental rental){
        this.rentals.add(rental);
    }


    //todo:functie getRentById

    //
    public Rental getRentById(int id){
        for(int i=0;i<rentals.size();i++){
            if(this.rentals.get(i).id==id){
                return rentals.get(i);
            }
        }
        return null;
    }


    //public void generare id

    public int generareId(){
        Random random= new Random();
        int id=random.nextInt(1000000)+1;
        while (getRentById(id)!=null){
            id=random.nextInt(1000000)+1;
        }
        return id;
    }

    public List<Integer>rentalHistory(int id){
        List<Integer>istoric=new ArrayList<>();
        for(int i=0;i<rentals.size();i++){
            if(rentals.get(i).idStud==id){
                istoric.add(this.rentals.get(i).idBook);
            }
        }
        return istoric;
    }

}
