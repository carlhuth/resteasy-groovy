package com.roledemoto.resources

import org.mongodb.morphia.query.Query
import org.mongodb.morphia.Datastore

import javax.enterprise.context.RequestScoped
import javax.ws.rs.core.MediaType
import javax.ws.rs.*
import javax.enterprise.context.ApplicationScoped
import javax.ejb.Stateless

import javax.inject.Named
import javax.inject.Inject

import javax.servlet.ServletContext
import javax.servlet.http.HttpServlet
import javax.ws.rs.core.Context

import com.roledemoto.service.EntityManager
import com.roledemoto.server.JaxRsApplication

import com.roledemoto.model.User


@Path('/user')
@ApplicationScoped
class UserResource {


    @Inject
    private Datastore datastore


    @GET
    @Path('/get')
    @Produces(MediaType.APPLICATION_JSON)
    User findOneUser() {
        Query<User> query = datastore.createQuery(User)
        
        User u = query.filter('firstName', 'Florisbelto').get()

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
    User findUser() {
        User user = new User(
            firstName: 'Florisbelto',
            lastName: 'Worberstadt'
        )

        
        datastore.save(user)


        return user
    }

    
}
