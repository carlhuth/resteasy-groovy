package com.rockt5.server

import com.rockt5.UserResource

import javax.ws.rs.ApplicationPath
import javax.ws.rs.core.Application

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





