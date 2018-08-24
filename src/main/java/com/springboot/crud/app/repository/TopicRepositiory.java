package com.springboot.crud.app.repository;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.Query;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.app.entity.Topic;

/**
 * TopicRepositiory.java
 * Purpose:Acts as a layer which interacts with database and
 *         provide custom in-built functions
 * @author @anshul
 * @version 1.0 8/24/18
 */
@Repository
@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "topic")
public interface TopicRepositiory extends CouchbaseRepository<Topic, Integer>{

}
