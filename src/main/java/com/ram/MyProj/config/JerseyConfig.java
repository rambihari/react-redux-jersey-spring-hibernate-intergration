package com.ram.MyProj.config;


import com.ram.MyProj.resource.ChildResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

//changing the rootapplication path to which jersey servlet is mapped to
@Component
@ApplicationPath("/root")
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        registerEndPoints();
    }

    private void registerEndPoints() {
        register(ChildResource.class);
    }
}
