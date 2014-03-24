package com.example.dao;

import com.example.model.SimpleUser;
import com.google.inject.ImplementedBy;

import java.util.List;
import java.util.Optional;

/**
 *
 */
@ImplementedBy(SimpleDaoImpl.class)
@SuppressWarnings("unused")
public interface ISimpleDao {

    Optional<SimpleUser> findById(long id);

    List<SimpleUser> findAll();

    void deleteById(long id);

    void save(SimpleUser user);
}
