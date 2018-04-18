package part1;

public class Operacion {
    private String operacion;
    private String nomInstitut;
    private String nomAlumne;
    private int resultat;

    public Operacion(String operacion, String nomInstitut, String nomAlumne) {
        this.operacion = operacion;
        this.nomInstitut = nomInstitut;
        this.nomAlumne = nomAlumne;
    }

    public Operacion() {
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getNomInstitut() {
        return nomInstitut;
    }

    public void setNomInstitut(String nomInstitut) {
        this.nomInstitut = nomInstitut;
    }

    public String getNomAlumne() {
        return nomAlumne;
    }

    public void setNomAlumne(String nomAlumne) {
        this.nomAlumne = nomAlumne;
    }

    public int getResultat() {
        return resultat;
    }

    public void setResultat(int resultat) {
        this.resultat = resultat;
    }
}
