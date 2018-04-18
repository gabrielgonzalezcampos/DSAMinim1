package part1;

import java.util.ArrayList;

public class Instituto {
    private String nomInstitut;
    private ArrayList<Operacion> operacions;


    public Instituto(String nomInstitut) {
        this.nomInstitut = nomInstitut;
        operacions=new ArrayList<>();
    }

    public Instituto() {
        operacions=new ArrayList<>();
    }

    public String getNomInstitut() {
        return nomInstitut;
    }

    public ArrayList<Operacion> getOperacions() {
        return operacions;
    }

    public void setOperacions(ArrayList<Operacion> operacions) {
        this.operacions = operacions;
    }

    public void addOperacion(Operacion o){
        this.operacions.add(o);
    }
}
