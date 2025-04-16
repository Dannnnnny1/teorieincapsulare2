package app.students;

public class Student {
    private int id;
    private String nume;
    private int varsta;
    private  String gen;
    private String password;

    public Student(int id, String nume, int varsta, String gen, String password) {
        this.id = id;
        this.nume = nume;
        this.varsta = varsta;
        this.gen = gen;
        this.password = password;
    }

    public Student(String text){
        String[]prop=text.split(",");
        this.id=Integer.parseInt(prop[0]);
        this.nume=prop[1];
        this.varsta=Integer.parseInt(prop[2]);
        this.gen=prop[3];
        this.password=prop[4];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String descriere(){
        String text="";
        text+="ID "+this.id+"\n";
        text+="NUME "+this.nume+"\n";
        text+="VASRSTA "+this.varsta+"\n";
        text+="GEN "+this.gen+"\n";
        return text;
    }

    public String proprietati(){
        return id+","+nume+","+varsta+","+gen+","+password;
    }

}
