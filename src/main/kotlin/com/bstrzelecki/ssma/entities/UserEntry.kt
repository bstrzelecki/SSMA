package com.bstrzelecki.ssma.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class UserEntry {
    @Id
    val id: Int
    val name:String
    @OneToMany(mappedBy = "user")
    val images: Collection<Image>


    constructor(){
        id = -1
        name = ""
        images = ArrayList()
    }
    constructor(id: Int, name: String) {
        this.id = id
        this.name = name
        this.images = ArrayList()
    }
    constructor(id: Int, name: String, images: Collection<Image>) {
        this.id = id
        this.name = name
        this.images = images
    }
}
