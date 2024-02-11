package com.temporal.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/homepage")
public class homePage {

    @GET
    public String get(){
        return "Welcome to the Homepage";
    }

}
