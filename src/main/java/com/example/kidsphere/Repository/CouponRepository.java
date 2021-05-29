package com.example.kidsphere.Repository;

import com.example.kidsphere.Model.LuDate;

import java.util.*;

public class CouponRepository{


    TreeMap<Integer, LuDate> database;

    int uuid = 0;

    public CouponRepository(){
        database = new TreeMap<Integer, LuDate>((a,b) -> (a-b));
        uuid = 0;
    }

    public Collection<LuDate> findAll(){
        return database.values();
    }

    public void newRecord(){
        database.put(uuid, new LuDate(uuid++));
    }

    public void deleteById(int uuid){
        database.remove(uuid);
    }

}
