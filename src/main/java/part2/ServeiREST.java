package part2;

import part1.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/service")
public class ServeiREST {

    MathManagerImpl implement;

    public ServeiREST() {
        this.implement= MathManagerImpl.getInstance();
    }
    @GET
    @Path("/addinstituto/{nomInstitut}")
    public Response addInstituto(@PathParam("nomInstitut")String nomInstitut){
        implement.getInstitutos().add(new Instituto(nomInstitut));
        return Response.ok().entity("OK").build();
    }

    @POST
    @Path("/addalumno")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAlumno(Alumno a){
        implement.getAlumnos().add(a);
        return Response.ok().entity("OK").build();
    }

    @POST
    @Path("/hacerOperacion")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hacerOperacion(Operacion o){
    Integer res=implement.hacerOperacion(o);
    if (res==null){
        return Response.ok().entity("Alumno o instituto incorrectos").build();
    }
    else
        return Response.ok().entity("El resultado es "+res.toString()).build();
    }

    @GET
    @Path("/operacionesInstituto/{nomInstitut}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Operacion> listaOperacionesInstituto(@PathParam("nomInstitut") String nomInstitut){
        ArrayList<Operacion> o=implement.listaOperacionesInstituto(nomInstitut);
        return o;
    }

    @GET
    @Path("/operacionesAlumno/{nomAlumno}")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Operacion> listaOperacionesAlumno(@PathParam("nomAlumno") String nomAlumno){
        ArrayList<Operacion> o=implement.listaOperacionesInstituto(nomAlumno);
        return o;
    }

    @GET
    @Path("/listaInstitutos")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Instituto> listaInstitutos(){
        ArrayList<Instituto> i=implement.listaInstitutos();
        return  i;
    }
}
