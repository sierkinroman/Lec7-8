package dev.profitsoft.intern.service.impl;

import dev.profitsoft.intern.model.User;
import dev.profitsoft.intern.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class UserServiceImpl implements UserService {

    private final static Map<String, User> users = new ConcurrentHashMap<>();
    static {
        users.put("dru", new User("dru", "123456", "Andriy"));
        users.put("roma", new User("roma", "123", "Roma"));
        users.put("dmtr", new User("dmtr", "1234", "Dmitro"));
        users.put("al.ex", new User("al.ex", "12345", "Alex"));
        users.put("mike", new User("mike", "123456", "Mike"));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.ofNullable(users.get(username));
    }

    @Override
    public Set<User> findAll() {
        return new HashSet<>(users.values());
    }
}
