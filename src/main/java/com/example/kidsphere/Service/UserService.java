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

    public String buildIndex(){
        List<LuDate> lu = this.getAllDate();
        StringBuilder sb = new StringBuilder();

        if(lu.size()>0){
            sb.append("<br><b>").append("距离上次时间：").append(this.getDiff(lu.get(0).getTimestamp().getTime(), new Date().getTime())).append("<b/><br/>");
        }

        for(int i = 0; i < Math.min(10, lu.size()); i++){
            sb.append("<br>").append(" ").append(lu.get(i).toString()).append("   <a href=\"/delete/").append(lu.get(i).getUuid()).append("\">DELETE</a>").append("<br/>");
            if(i != lu.size()-1){
                sb.append("<br>-----").append(this.getDiff(lu.get(i+1).getTimestamp().getTime(), lu.get(i).getTimestamp().getTime())).append("-----<br/>");
            }
        }

        sb.append("<br/><a href=\"/new\">I did it AGAIN!</a><br/>");
        return sb.toString();
    }

    public void deleteByUUID(int id){
        couponRepository.deleteById(id);
    }


}

