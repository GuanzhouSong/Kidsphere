package com.example.kidsphere.Controller;

import com.example.kidsphere.Model.LuDate;
import com.example.kidsphere.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
        return service.buildIndex();
    }

    @RequestMapping("/new")
    public String newRecord()
    {
        return "<br/><a href=\"/new/yes\">YES</a><br/><br/><a href=\"/\">NO</a><br/>";
    }

    @RequestMapping("/new/yes")
    public String newRecordYes()
    {
        service.newRecord();
        return "<br/><a href=\"/\">Return To Home</a>";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id)
    {
        //service.deleteByUUID(id);
        return String.format("<br/><a href=\"/delete/yes/%d\">YES</a><br/><br/><a href=\"/\">NO</a><br/>", id);
    }

    @RequestMapping("/delete/yes/{id}")
    public String deleteYes(@PathVariable("id") int id)
    {
        service.deleteByUUID(id);
        return "<br/><a href=\"/\">Return To Home</a>";
    }
}
