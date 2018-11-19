/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import controller.ControladorUsuario;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.Usuario;

/**
 * REST Web Service
 *
 * @author Jr
 */
@Path("usuario")
public class RestUsuario {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of JdvPortalWebService
     */
    public RestUsuario() {
    }

    
    @GET
    @Produces("application/text")
    public String getJson() {
        return "Teste RESTful";
    }
    
    /**
     * Retrieves representation of an instance of sw.RestUsuario
     * @return an instance of java.lang.String
     */
    @Path("/read")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String read() {
        ControladorUsuario ctrlUsr = new ControladorUsuario();
        List<Usuario> usrs = new ArrayList<>();
        usrs = ctrlUsr.read(1);
        
        /*
        Usuario u = new Usuario();
        u.setCdUsuariId(10);
        u.setDeLogin("login.login");
        u.setDeSenhaAcesso("123456");
        u.setDeSexo("M");
        */
        
        Gson g = new Gson();
        
        return g.toJson(usrs);
    }

    /**
     * PUT method for updating or creating an instance of RestUsuario
     * @param content representation for the resource
     */
    @Path("/create")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String content) {
        
    }
}
