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

import dao.EhdokasDao;
import data.Ehdokkaat;

@Path("/ehdokaservice")
public class EhdokasService {
    @POST
    @Path("/addoneehdokas")
    @Consumes(MediaType.APPLICATION_JSON)
    public void saveEhdokas(Ehdokkaat ehdokkaat) {
        EhdokasDao.addEhdokas(ehdokkaat);
    }
   

    @GET
    @Path("/getall")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ehdokkaat> getAll(){
        return EhdokasDao.getEhdokas();
    }

    @DELETE
    @Path("/delete/{id}")
    public boolean deleteEhdokas(@PathParam("id") int id) {
        return EhdokasDao.deleteEhdokas(id);
    }
}