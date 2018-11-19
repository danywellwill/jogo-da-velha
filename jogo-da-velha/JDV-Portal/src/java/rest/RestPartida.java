/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Jr
 */
@Path("partida")
public class RestPartida {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestPartida
     */
    public RestPartida() {
    }

    /**
     * Retrieves representation of an instance of rest.RestPartida
     * @return an instance of java.lang.String
     */
    @Path("/read")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String read() {
        return "Método que retornara um ou mais resultados";
    }

    /**
     * PUT method for updating or creating an instance of RestPartida
     * @param content representation for the resource
     */
    @Path("/create")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(String content) {
    }
}
