package part1;

import java.util.ArrayList;

public class Alumno {
    private String nomAlumno;
    private String nomInstituto;
    private ArrayList<Operacion> operacions;

    public Alumno(String nomAlumno,String nomInstituto) {
        this.nomAlumno = nomAlumno;
        this.nomInstituto=nomInstituto;
        this.operacions=new ArrayList<Operacion>();
    }

    public Alumno() {
        this.operacions=new ArrayList<Operacion>();
    }

    public String getNomAlumno() {
        return nomAlumno;
    }

    public void setNomAlumno(String nomAlumno) {
        this.nomAlumno = nomAlumno;
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
