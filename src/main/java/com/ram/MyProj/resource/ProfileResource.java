package com.ram.MyProj.resource;


import com.ram.MyProj.model.Profile;
import com.ram.MyProj.service.ProfileService;
import com.ram.MyProj.service.ProfileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {

    @Inject
    private ProfileService profileService;

    @GET
    public Profile getProfile(@PathParam("childId") int childId) {
        //retrieving the childId from the uri path
        Profile profile = profileService.getProfile(childId);
        return profile;
    }

    @POST
    public Profile saveProfile(@PathParam("childId") int childId, Profile profileToBeSaved) {
        Profile profile = profileService.saveProfile(childId ,profileToBeSaved);
        return profile;
    }
}
