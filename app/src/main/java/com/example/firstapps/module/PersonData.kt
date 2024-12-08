package com.example.firstapps.module

import kotlin.properties.Delegates

class PersonData {

     var name: String
     var dob: String
     var profileImage: Int

    constructor(name: String, dob: String, profileImage: Int)
    {   this.name = name
        this.dob = dob
        this.profileImage = profileImage
    }
}