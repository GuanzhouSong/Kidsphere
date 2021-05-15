package com.example.kidsphere.Service;

import com.example.kidsphere.Model.LuDate;
import com.example.kidsphere.Repository.CouponRepository;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Service
public class UserService {

    @Autowired
    CouponRepository couponRepository;

    public List<LuDate> getAllDate() {
        List<LuDate> list = new ArrayList<>();
        couponRepository.findAll().forEach(list::add);
        list.sort((a,b) -> {
            if(a.getTimestamp().equals(b.getTimestamp())){
                return 0;
            }
            return a.getTimestamp().before(b.getTimestamp())?1:-1;
        });

        return list;
    }

    public void newRecord() {
        couponRepository.newRecord();
    }

    public String getDiff(long time1, long time2){

//        Timestamp prev = dates.get(0).getTimestamp();
//        Timestamp cur = new Timestamp(new Date().getTime());

        long milliseconds = time2- time1;
        int seconds = (int) milliseconds / 1000;

        int days = seconds / 3600 / 24;
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = (seconds % 3600) % 60;

        StringBuilder sb = new StringBuilder();
        if(days != 0){
            sb.append(days).append(" Days ");
        }
        if(hours != 0){
            sb.append(hours).append(" Hours ");
        }
        if(minutes != 0){
            sb.append(minutes).append(" Minutes ");
        }

        sb.append(seconds).append(" Seconds ");


        return sb.toString();
    }


}

