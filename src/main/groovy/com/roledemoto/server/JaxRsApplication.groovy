package com.roledemoto.server

import javax.inject.Singleton;

import java.util.LinkedHashSet
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject
import javax.inject.Named
import javax.ws.rs.core.Context
import org.jboss.resteasy.core.Dispatcher

import javax.ws.rs.ApplicationPath

import com.mongodb.MongoClient
import javax.ws.rs.core.Application

import com.roledemoto.resources.UserResource
import com.roledemoto.service.EntityManager
import com.roledemoto.service.ResourcesProducer




/**
 *  The main JAX-RS application class
 */
@ApplicationPath('/')
class JaxRsApplication extends Application {

    /*
    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new LinkedHashSet<Object>()

         // singletons.add(new EntityManager())

        return singletons
    } */


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes =  new LinkedHashSet<Class<?>>()
        // classes.add(ResourcesProducer)
        classes.add(UserResource)

        return classes
    }
    
}





