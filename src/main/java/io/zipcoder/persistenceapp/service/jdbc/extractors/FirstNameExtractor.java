package io.zipcoder.persistenceapp.service.jdbc.extractors;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class FirstNameExtractor implements ResultSetExtractor<Map<String, Long>>{
    @Override
    public Map<String,Long> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<String, Long> firstNames = new HashMap<>();
        while(resultSet.next()){
            String first = resultSet.getString("first_name");
            if(!firstNames.containsKey(first)){
                firstNames.put(first, (long)1);
            } else{
                firstNames.replace(first, firstNames.get(first)+1);
            }
        }
        return firstNames;
    }

}
