package io.zipcoder.persistenceapp.service.jdbc.mappers;

import io.zipcoder.persistenceapp.entity.Person;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Person(
                resultSet.getString("last_name"),
                resultSet.getString("first_name"),
                resultSet.getString("mobile"),
                resultSet.getString("birthday"),
                resultSet.getInt("home_id"),
                resultSet.getInt("id")
        );
    }

}


//    @Override
//    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
//        return
//                new Car(
//                        resultSet.getString("Make"),
//                        resultSet.getString("Model"),
//                        resultSet.getString("Year")
//                );
//    }
