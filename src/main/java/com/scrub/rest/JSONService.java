package com.scrub.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.scrub.Game;
import com.scrub.User;
import com.scrub.util.CRUD;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataBodyPart;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.FormDataParam;

import java.io.InputStream;
import java.util.List;

@Path("/json/scrub/image")
public class JSONService {

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Game getTrackInJSON() {

		Game game = new Game();

		return game;

	}


	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response createTrackInJSON(Game game) {

		String result = "Game saved : " + game;
        User user = CRUD.readUser(game.getUser().getEmail());
        if(user == null){
            user = new User();
            user.setName(game.getUser().getName());
            user.setEmail(game.getUser().getEmail());
            user = CRUD.saveUser(user);
        }
        Game gameObj = new Game();
        gameObj.setName(game.getName());
        gameObj.setUser(user);
        gameObj.setAnswer(game.getAnswer());
        gameObj.setHint(game.getHint());
        gameObj.setCategory(game.getCategory());
        //gameObj.setBestGuesser(CRUD.readUser(game.getUser().getEmail()));
        CRUD.saveGame(gameObj);
        return Response.status(200).entity(game).build();

	}

    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) {

        String uploadedFileLocation = "d://uploaded/" + fileDetail.getFileName();

        // save it
        //writeToFile(uploadedInputStream, uploadedFileLocation);

        String output = "File uploaded to : " + uploadedFileLocation;

        return Response.status(200).entity(output).build();

    }
    @POST
    @Path("/test")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response test( @FormDataParam("test") InputStream uploadedInputStream,
                          @FormDataParam("test") FormDataContentDisposition fileDetail,FormDataMultiPart multiPart) {
        List<FormDataBodyPart> fields = multiPart.getFields("test");

        for(FormDataBodyPart field : fields){
            handleInputStream(field.getValueAs(InputStream.class));
        }
        return Response.status(201).entity(fileDetail.getFileName()).build();

    }
    private void handleInputStream(InputStream is){
        //read the stream any way you want
        System.out.println(is.getClass());
    }
}