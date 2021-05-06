package com.example.demo.JDKproxy;

/**
 * @author gino
 * 2021-04-29
 */
public class UserServiceImpl implements UserService,Log{
    @Override
    public void delete(long id) {
        System.out.println("delete user"+id);
    }

    @Override
    public void update() {
        System.out.println("update user");
    }

    @Override
    public boolean savelog() {
        System.out.println("save Log");
        return false;
    }
}
