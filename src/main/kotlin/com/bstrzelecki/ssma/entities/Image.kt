package com.bstrzelecki.ssma.entities

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity
class Image {
    @Id
    var id:String;
    @JoinColumn
    @ManyToOne
    var user: UserEntry?
    var title:String
    var desc:String

    fun getDescription() = desc
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Image

        if (id != other.id) return false
        if (user != other.user) return false
        if (title != other.title) return false
        if (desc != other.desc) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (user?.hashCode() ?: 0)
        result = 31 * result + title.hashCode()
        result = 31 * result + desc.hashCode()
        return result
    }

    constructor(id: String, user: UserEntry?, title: String, desc: String) {
        this.id = id
        this.user = user
        this.title = title
        this.desc = desc
    }

    constructor(){
        id = ""
        user = null
        title = ""
        desc = ""
    }

}