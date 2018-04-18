package part1;
import org.junit.*;

import java.util.ArrayList;

public class MathManagerTest {
    private MathManagerImpl MathManager;

    @Before
    public void setUp()throws java.io.IOException{
        MathManagerImpl impl =MathManagerImpl.getInstance();
        ArrayList<Alumno> a=new ArrayList<Alumno>();
        Alumno p1=new Alumno("Juan","i1");
        Alumno p2=new Alumno("Gabri", "Calamot");
        Alumno p3=new Alumno("Pepe","i3");
        a.add(p1);
        a.add(p2);
        a.add(p3);
        impl.setAlumnos(a);
        ArrayList<Instituto> i=new ArrayList<Instituto>();
        Instituto i1=new Instituto("i1");
        Instituto i2=new Instituto( "Calamot");
        Instituto i3=new Instituto("i3");
        i.add(i1);
        i.add(i2);
        i.add(i3);
        impl.setInstitutos(i);
    }

    @org.junit.Test
    public void testrealizarOperacion(){
        MathManagerImpl impl =MathManagerImpl.getInstance();
        Operacion o =new Operacion("2 3 + 7 * 5 -", "Calamot", "Maria");
        Alumno a=new Alumno("Maria", "Calamot");
        Assert.assertEquals(null, impl.hacerOperacion(o));
        impl.getAlumnos().add(a);
        Integer i =30;
        Assert.assertEquals(i, impl.hacerOperacion(o));

    }
    @org.junit.Test
    public void testProcesarOperacion(){
        MathManagerImpl impl =MathManagerImpl.getInstance();
        Operacion o =new Operacion("2 3 + 7 * 5 -", "Calamot", "Maria");
        Alumno a=new Alumno("Maria", "Calamot");
        impl.getAlumnos().add(a);
        o.setResultat(0);
        //impl.getOperacions().add(o);
        Operacion res= o;
        res.setResultat(30);
        Assert.assertEquals(res, impl.getImpl().procesarOperacion(o));
    }
    @org.junit.After
    public void tearDown(){
    MathManagerImpl.getInstance().clear();
    }
}
