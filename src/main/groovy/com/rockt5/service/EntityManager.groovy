package com.rockt5.service

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
