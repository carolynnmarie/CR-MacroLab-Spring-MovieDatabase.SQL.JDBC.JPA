package io.zipcoder.persistenceapp.service.jdbc.extractors;

import io.zipcoder.persistenceapp.entity.Person;
import io.zipcoder.persistenceapp.service.jdbc.mappers.PersonRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class PersonExtractor implements ResultSetExtractor<Map<String,List<Person>>> {

    @Override
    public Map<String,List<Person>> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<String, List<Person>> lastNameMap = new HashMap<>();
        PersonRowMapper prm = new PersonRowMapper();

        while(resultSet.next()){
            String surname = resultSet.getString("last_name");
            Person person = prm.mapRow(resultSet, resultSet.getRow());
            if(!lastNameMap.containsKey(surname)){
                lastNameMap.put(surname, new LinkedList<Person>(Arrays.asList(person)));
            } else {
                List<Person> listKey = new LinkedList<>(lastNameMap.get(surname));
                List<Person> newListKey = new LinkedList<>(listKey);
                newListKey.add(person);
                lastNameMap.replace(surname, listKey, newListKey);
            }
        }
        return lastNameMap;
    }

}
