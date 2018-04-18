package part1;

import java.util.ArrayList;

public interface MathManager {
    public Integer hacerOperacion(Operacion o);
    public ArrayList<Operacion> listaOperacionesInstituto(String nomInstitut);
    public ArrayList<Operacion> listaOperacionesAlumno(String nomAlumno);
    public ArrayList<Instituto> listaInstitutos();
}
