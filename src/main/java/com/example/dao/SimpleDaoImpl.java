package com.example.dao;

import com.example.model.SimpleUser;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 */
@Named
public class SimpleDaoImpl implements ISimpleDao {

    final List<SimpleUser> users = new ArrayList<>();

    public SimpleDaoImpl() {
        fillSampleDate();
    }

    private void fillSampleDate() {
        users.add(new SimpleUser(1L, "John", "Galt"));
        users.add(new SimpleUser(2L, "Dagny", "Taggart"));
        users.add(new SimpleUser(3L, "Hank", "Rearden"));
    }

    @Override
    public Optional<SimpleUser> findById(long id) {
        return users.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public List<SimpleUser> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void deleteById(long id) {
        findById(id).map(users::remove);
    }

    @Override
    public void save(SimpleUser user) {
        findById(user.getId()).orElseGet(() -> { users.add(user); return user; });
    }
}
