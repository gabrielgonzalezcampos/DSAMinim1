package part1;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class MathManagerImpl implements MathManager{
    private static MathManagerImpl ourInstance;
    private ArrayList<Alumno> alumnos;
    private ArrayList<Instituto> institutos;
    private Queue<Operacion> operacions;
    private ReversePolishNotationImpl impl;
    private ArrayList<Operacion> operacionesProcesadas;
    final static Logger log = Logger.getLogger(MathManagerImpl.class);

    public static MathManagerImpl getInstance(){
        if (ourInstance==null)
            ourInstance=new MathManagerImpl();
        return ourInstance;
    }
    private MathManagerImpl() {
        this.alumnos=new ArrayList<Alumno>();
        this.operacions=new Queue<Operacion>() {
            public boolean add(Operacion operacion) {
                return false;
            }

            public boolean offer(Operacion operacion) {
                return false;
            }

            public Operacion remove() {
                return null;
            }

            public Operacion poll() {
                return null;
            }

            public Operacion element() {
                return null;
            }

            public Operacion peek() {
                return null;
            }

            public int size() {
                return 0;
            }

            public boolean isEmpty() {
                return false;
            }

            public boolean contains(Object o) {
                return false;
            }

            public Iterator<Operacion> iterator() {
                return null;
            }

            public Object[] toArray() {
                return new Object[0];
            }

            public <T> T[] toArray(T[] a) {
                return null;
            }

            public boolean remove(Object o) {
                return false;
            }

            public boolean containsAll(Collection<?> c) {
                return false;
            }

            public boolean addAll(Collection<? extends Operacion> c) {
                return false;
            }

            public boolean removeAll(Collection<?> c) {
                return false;
            }

            public boolean retainAll(Collection<?> c) {
                return false;
            }

            public void clear() {

            }
        };
        this.institutos=new ArrayList<Instituto>();
        this.operacionesProcesadas=new ArrayList<Operacion>();
        this.impl=new ReversePolishNotationImpl();
        org.apache.log4j.BasicConfigurator.configure();
    }


    public Integer hacerOperacion(Operacion o) {
        log.info("Operacion: "+o.getOperacion()+" del alumno: "+o.getNomAlumne()+" del instituto: "+o.getNomInstitut());

        boolean encontrado=false;
        int i=0;
        while (i<alumnos.size()&&!encontrado){
            if(alumnos.get(i).getNomAlumno()==o.getNomAlumne()){
                encontrado=true;
            }
            else
            i++;
        }
        if (encontrado==false)
        {
            log.error("No se ha encontrado el alumno");
            return null;
        }
        encontrado=false;
        int j=0;
        while (j<institutos.size()&&!encontrado){
            if(institutos.get(j).getNomInstitut()==o.getNomInstitut()){

                encontrado=true;
            }
            else
            j++;
        }
        if (encontrado==false)
        {
            log.error("No se ha encontrado el instituto");
            return null;
        }
        Operacion res=impl.procesarOperacion(o);
        if (res==null)
        {
            log.error("Error al procesar Operacion");
            return null;
        }
        alumnos.get(i).addOperacion(res);
        operacionesProcesadas.add(res);
        institutos.get(j).addOperacion(res);
        log.info("Resultat: "+res.getResultat());
        return res.getResultat();
    }

    public ArrayList<Operacion> listaOperacionesInstituto(String nomInstitut) {
        log.info("Institut: "+nomInstitut);
        boolean encontrado=false;
        int j=0;
        while (j<institutos.size()&&!encontrado){
            if(institutos.get(j).getNomInstitut()==nomInstitut){
                encontrado=true;
            }
            else
            j++;
        }
        if (encontrado==false)
        {
            log.error("No se ha encontrado el instituto");
            return null;
        }
        log.info("Operaciones del instituto: "+institutos.get(j).getOperacions().size());
        return institutos.get(j).getOperacions();
    }

    public ArrayList<Operacion> listaOperacionesAlumno(String nomAlumno) {
        log.info("Alumno: "+nomAlumno);
        boolean encontrado=false;
        int j=0;
        while (j<alumnos.size()&&!encontrado){
            if(alumnos.get(j).getNomAlumno()==nomAlumno){
                encontrado=true;
            }
            else
                j++;
        }
        if (encontrado==false)
        {
            log.error("No se ha encontrado el alumno");
            return null;
        }
        log.info("Operaciones del alumno: "+institutos.get(j).getOperacions().size());
        return institutos.get(j).getOperacions();
    }

    public ArrayList<Instituto> listaInstitutos() {
        ArrayList<Instituto> ins=this.institutos;
        log.info("Hay "+ins.size()+" institutos");
        if (ins.size()==0)
        {
            log.error("Lista de institutos vacia");
            return null;
        }

        Instituto p=new Instituto();
        int o;
        int pos=0;


        for(int i=0;i<ins.size();i++) {
            o= ins.get(i).getOperacions().size();
            for(int j=1;(i+j)<ins.size();j++){
                if (ins.get(i+j).getOperacions().size()>o) {
                    o = ins.get(i+j).getOperacions().size();
                    pos = i+j;
                }
            }
            p=ins.get(i);
            ins.set(i,ins.get(pos));
            ins.set(pos,p);
        }
        log.info("Institutos ordenados: "+ins.size()+"institutos");
        return ins;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public ArrayList<Instituto> getInstitutos() {
        return institutos;
    }

    public void setInstitutos(ArrayList<Instituto> institutos) {
        this.institutos = institutos;
    }

    public Queue<Operacion> getOperacions() {
        return operacions;
    }

    public void setOperacions(Queue<Operacion> operacions) {
        this.operacions = operacions;
    }

    public ReversePolishNotationImpl getImpl() {
        return impl;
    }
    public void clear(){ourInstance=new MathManagerImpl();}
}
