package com.rockt5

import com.rockt5.model.User
import org.mongodb.morphia.Datastore
import org.mongodb.morphia.query.Query

import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path('/user')
@ApplicationScoped
class UserResource {


    @Inject
    private Datastore datastore


    @GET
    @Path('/get')
    @Produces(MediaType.APPLICATION_JSON)
    User findOneUser(@PathParam("q") String q) {
        Query<User> query = datastore.createQuery(User)
        
        User u = query.filter('firstName', q).get()

        return u
    }


    @POST
    @Path('/create')
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    User create(User user) {
        
        // TODO validate user before saving it...
        
        // creating user
        datastore.save(user)

        return user
    }

   
    @GET
    @Path('/find')
    @Produces(MediaType.APPLICATION_JSON)
    User findUser(@QueryParam("q") String q) {
        Query<User> query = datastore.createQuery(User)

        User u = query.filter('firstName', q).get()

        return u
    }

    
}
