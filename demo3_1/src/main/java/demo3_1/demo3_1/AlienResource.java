package demo3_1.demo3_1;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/aliens")
public class AlienResource {
	
	AlienRepository ar = new AlienRepository();
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<Alien> getAlien() throws ClassNotFoundException
	{
		//System.out.println("yo");
		
		return ar.getAliens();
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Alien getAlien(@PathParam("id") int id) throws ClassNotFoundException
	{
		//System.out.println("yo");
		
		return ar.getAlien(id);
	}
	
	@POST
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	 public Alien createAlien(Alien a1) throws ClassNotFoundException
	 {
		 System.out.println(a1);
		 ar.create(a1);
		 return a1;
	 }
	
	@PUT
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	 public Alien updateAlien(Alien a1) throws ClassNotFoundException
	 {
		 System.out.println(a1);
		 if(ar.getAlien(a1.getId()).getId()==0)
		 {
			 ar.create(a1);
		 }
		 else
		 {
			 ar.update(a1);
		 }
		 return a1;
	 }
	
	@DELETE
	@Path("alien/{id}")
	public Alien killAlien(@PathParam("id") int id) throws ClassNotFoundException
	{
		Alien a = ar.getAlien(id);
		if(a.getId()!=0)
		{
			ar.delete(id);
		}
		return a;
		
	}
	
	@PATCH
	@Path("alien")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	 public Alien updateAlienPatch(Alien a1) throws ClassNotFoundException
	 {
		 System.out.println(a1);
		 if(ar.getAlien(a1.getId()).getId()==0)
		 {
			 ar.create(a1);
		 }
		 else
		 {
			 ar.update(a1);
		 }
		 return a1;
	 }
	
}
