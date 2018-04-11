package com.ram.MyProj.resource;


import com.ram.MyProj.model.Child;
import com.ram.MyProj.service.ChildService;
import org.springframework.stereotype.Component;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Component
@Path("/child")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ChildResource {

    @Inject
    private ChildService childService;
    //Initialize ProfileResource so jersey can forward profile uri to be handlded in ProfileResource
    @Inject
    ProfileResource profileResource;

    @GET
    public List<Child> listChild(){
        List<Child> allChildren = childService.getAllChildren();
        return  allChildren;
    }

    @GET
    @Path("/{childId}")
    public Child getSingleChild(@PathParam("childId") int childId){
        Child child = childService.getSingleChild(childId);
        return  child;
    }

    @POST
    public Child addChild(Child child) {
        if(child.getId() == 0)
            childService.addChild(child);
        else
            childService.updateChild(child);
        return child;
    }

    @DELETE
    public int deleteChild(@QueryParam("childId") int childId) {
        childService.deleteChild(childId);
        return childId;
    }

    //Forwarding the uri to ProfilResource
    @Path("/{childId}/profile")
    public ProfileResource goToProfileResource(){
        return profileResource;
    }

}
