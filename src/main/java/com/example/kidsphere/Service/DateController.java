package com.example.kidsphere.Service;

import com.example.kidsphere.Model.LuDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
public class DateController
{
    @Autowired
    UserService service;

    @RequestMapping("/")
    public String index()
    {
        List<LuDate> lu = service.getAllDate();
        List<String> result = new ArrayList<String>();
        int count = 1;
        StringBuilder sb = new StringBuilder();

        if(lu.size()>0){
            sb.append("<br><b>").append("距离上次时间：").append(service.getDiff(lu.get(0).getTimestamp().getTime(), new Date().getTime())).append("<b/><br/>");
        }

        for(int i = 0; i < Math.min(10, lu.size()); i++){
            sb.append("<br>").append(" ").append(lu.get(i).toString()).append("<br/>");
            if(i != lu.size()-1){
                sb.append("<br>-----").append(service.getDiff(lu.get(i+1).getTimestamp().getTime(), lu.get(i).getTimestamp().getTime())).append("-----<br/>");
            }
        }

        sb.append("<br/><a href=\"/new\">I did it AGAIN!</a>");
        return sb.toString();
    }

    @RequestMapping("/new")
    public void newRecord()
    {
        service.newRecord();
    }
}
