package com.example.kidsphere.Model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LuDate {


    private int uuid;

    private Timestamp timestamp;

    public LuDate(int uuid){
        this.uuid = uuid;
        this.timestamp = new Timestamp(new Date().getTime());
    }

    public int getUuid()
    {
        return uuid;
    }

    public void setUuid(int uuid)
    {
        this.uuid = uuid;
    }

    public Timestamp getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp)
    {
        this.timestamp = timestamp;
    }

    @Override
    public String toString(){
        long epochTime = timestamp.getTime() - 4*3600000;
        Date date = new Date(epochTime);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm EEEE");
        return formatter.format(date);
    }
}
