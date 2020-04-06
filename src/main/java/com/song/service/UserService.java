package com.song.service;

import com.song.entity.User;
import com.song.repository.UserRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Song on 2017/2/15.
 * User业务逻辑
 */
@Service
public class UserService {
    @Autowired
    private UserRepositoty userRepositoty;

    public User findUserByName(String name){
        Map<String ,String> map = new HashMap<String, String>();
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        List<String> list = new ArrayList<String>();
        list.forEach(x->{

        });
        User user = null;
        try{
            user = userRepositoty.findByUserName(name);
        }catch (Exception e){}
        return user;
    }
}
