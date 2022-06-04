
import jakarta.ws.rs.*;

@Path("/hello-world")
public class Usuario {
  @GET
  @Produces("text/plain")
  public String hello() {
    return "Hello, World!";
  }
}