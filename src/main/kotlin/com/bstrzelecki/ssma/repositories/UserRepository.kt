package com.bstrzelecki.ssma.repositories;

import com.bstrzelecki.ssma.entities.UserEntry
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface UserRepository : CrudRepository<UserEntry, Int> {
}