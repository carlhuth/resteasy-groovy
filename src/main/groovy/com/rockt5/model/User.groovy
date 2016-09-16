package com.rockt5.model

import org.bson.types.ObjectId
import org.mongodb.morphia.annotations.Entity
import org.mongodb.morphia.annotations.Id


/**
 * The user model class
 */
@Entity
class User {


    @Id
    private ObjectId id


    String username


    String firstName


    String lastName


    // TODO how to model this class to adapt
    // to the FB login flow?

    // e.g. an embedded model like FBAccount for data
    //      or a relationship




    public getId() {
        return id
    }

}
