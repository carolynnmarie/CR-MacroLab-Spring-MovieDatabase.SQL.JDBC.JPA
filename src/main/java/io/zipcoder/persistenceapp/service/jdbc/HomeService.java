package io.zipcoder.persistenceapp.service.jdbc;

import io.zipcoder.persistenceapp.entity.Home;
import io.zipcoder.persistenceapp.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class HomeService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public int addHome(Home home){
        return jdbcTemplate.update("INSERT INTO home(address, homenumber) VALUES (?,?)", home.getAddress(), home.getHome_number());
    }

//    public int addPersonToHome(Person person, Home home){
//        return jdbcTemplate.update()
//    }

    public
}
