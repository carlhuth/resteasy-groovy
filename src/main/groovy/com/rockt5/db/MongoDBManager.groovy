package com.rockt5.db

import com.mongodb.MongoClient

import javax.enterprise.context.ApplicationScoped
import javax.enterprise.inject.Produces
import org.mongodb.morphia.Morphia
import org.mongodb.morphia.Datastore


@ApplicationScoped
class MongoDBManager {
    

    Datastore datastore


    MongoDBManager() {
        
        final Morphia morphia = new Morphia()

        morphia.mapPackage('com.rockt5.model')


        datastore = morphia.createDatastore(new MongoClient(), 'rockt5-resteasy')


        datastore.ensureIndexes()
        
    }



    @Produces
    Datastore getDatastore() {
        return datastore    
    }
    
    
}




