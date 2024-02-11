package com.temporal.resources;

import com.temporal.addUserWorker;
import com.temporal.core.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("/userprofile")
public class userProfile{

    @GET
    public String showForm() {
        return "<html><body>" +
                "<h1>Welcome to the User Profile Page!</h1>" +
                "<form action='/userprofile' method='post'>" +
                "   <label for='username'>Enter your name:</label>" +
                "   <input type='text' id='username' name='username' required><br>" +
                "   <label for='emailid'>Enter your email ID:</label>" +
                "   <input type='email' id='emailid' name='emailid' required><br>" +
                "   <input type='submit' value='Submit'>" +
                "</form>" +
                "</body></html>";
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String processForm(@FormParam("username") String username, @FormParam("emailid") String emailid) {
        User user = new User(username, emailid);

//        addUserWorker addUserWorker = new addUserWorker();
//        addUserWorker.startWorker();

        //start workflow
        startAddUser startAddUser = new startAddUser();
        startAddUser.start(user);

        System.out.println("User data is saved");
        return "Hello, " + user.getUsername() + "! Thanks for submitting your information.";
    }
}
