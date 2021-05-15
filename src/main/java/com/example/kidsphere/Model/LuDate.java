package com.example.kidsphere.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Entity
@Table(name = "lu_date")
public class LuDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uuid;

    private Timestamp timestamp;

    public LuDate(){
        uuid = 0;
        timestamp = new Timestamp(new Date().getTime()+4*60*60*1000);
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
