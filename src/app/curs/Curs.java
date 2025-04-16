package app.curs;

public class Curs {
    private int idCurs;
    private String numeCurs;

    public Curs(int idCurs, String numeCurs) {
        this.idCurs = idCurs;
        this.numeCurs = numeCurs;
    }

    public Curs(String text){
        String[]prop=text.split(",");
        this.idCurs=Integer.parseInt(prop[0]);
        this.numeCurs=prop[1];
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public String getNumeCurs() {
        return numeCurs;
    }

    public void setNumeCurs(String numeCurs) {
        this.numeCurs = numeCurs;
    }
    public String proprietati(){
        return idCurs+","+numeCurs;
    }
}
