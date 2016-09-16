package com.roledemoto.service

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton
import javax.inject.Inject
import javax.ws.rs.ext.Provider


import com.roledemoto.server.JaxRsApplication



class EntityManager {


    // TODO inject the MongoDB driver connection


    public EntityManager() {}



    Object save(Object obj) {
        return obj    
    }
    

    Object update(Object obj) {
        // TODO set the object property and return it
        obj['username'] = 'wstadt'
        
        return obj    
    }


    void remove(Object obj) {}

}
