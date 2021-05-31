package rest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import dao.EhdokkaatDao;
import data.Ehdokkaat;

@Path("/ehdokkaatservice")
public class EhdokkaatService {
    @POST
    @Path("/addehdokas")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveEhdokkaat(Ehdokkaat ehdokkaat) {
        EhdokkaatDao.addEhdokas(ehdokkaat);
    }
   

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ehdokkaat> getAll(){
        return EhdokkaatDao.getEhdokkaat();
    }

    @DELETE
    @Path("/deleteehdokas/{id}")
    public boolean deleteEhdokas(@PathParam("id") int id) {
        return EhdokkaatDao.deleteEhdokkaat(id);
    }
}