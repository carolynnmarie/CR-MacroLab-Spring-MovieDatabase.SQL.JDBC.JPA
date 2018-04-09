package io.zipcoder.persistenceapp.service.jdbc;

import io.zipcoder.persistenceapp.entity.Person;
import io.zipcoder.persistenceapp.service.jdbc.extractors.FirstNameExtractor;
import io.zipcoder.persistenceapp.service.jdbc.extractors.PersonExtractor;
import io.zipcoder.persistenceapp.service.jdbc.mappers.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class PersonService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String ADD_PERSON = "INSERT INTO PERSON (LAST_NAME, FIRST_NAME, MOBILE, BIRTHDAY) VALUES (?,?,?,?);";
    private static final String UPDATE_PERSON_BY_ID = "UPDATE person SET ? WHERE id = ?";
    private static final String DELETE_PERSON_BY_ID = "DELETE FROM person WHERE id = ?";
    private static final String DELETE_LIST_OF_PEOPLE = "DELETE FROM person WHERE last_name = ? AND first_name = ? AND mobile = ? AND birthday = ?";
    private static final String GET_PERSON_BY_ID = "SELECT * FROM person WHERE id = ?";
    private static final String GET_ALL_PEOPLE = "SELECT * FROM person";
    private static final String GET_PEOPLE_WITH_FIRSTNAME = "SELECT * FROM person WHERE first_name = ?";
    private static final String GET_PEOPLE_WITH_BIRTHDAY = "SELECT * FROM person WHERE birthday = ?";
    private static final String GET_PEOPLE_WITH_LASTNAME = "SELECT * FROM person WHERE last_name = ?";
    private static final String GET_PEOPLE_WITH_MOBILE = "SELECT * FROM person WHERE mobile = ?";



    public int addPerson(Person person){
        String lastN = person.getLast_name();
        String firstN = person.getFirst_name();
        String mobile = person.getMobile();
        String birthday = person.getBirthday();
        return jdbcTemplate.update(ADD_PERSON, lastN, firstN, mobile, birthday);
    }

    public int updatePerson(Person person, Integer id){
        return jdbcTemplate.update(UPDATE_PERSON_BY_ID, person, id);
    }

    public int removePerson(Integer id){
        return jdbcTemplate.update(DELETE_PERSON_BY_ID, id);
    }

    public int[] removeListOfPeople(List<Person> people) {
        List<Object[]> personFields = new LinkedList<>();
        for(Person person: people){
            Object[] fields = new Object[4];
            fields[0] = person.getLast_name();
            fields[1] = person.getFirst_name();
            fields[2] = person.getMobile();
            fields[3] = person.getBirthday();
            personFields.add(fields);
        }
        return jdbcTemplate.batchUpdate(DELETE_LIST_OF_PEOPLE, personFields);
    }
    public List<Person> getAll(){
        return jdbcTemplate.query(GET_ALL_PEOPLE, new PersonRowMapper());
    }

    public List<Person> findById(Integer id){
        return jdbcTemplate.query(GET_PERSON_BY_ID, new PersonRowMapper(), id);
    }

    public List<Person> findAllWithFirstName(String firstName){
        return jdbcTemplate.query(GET_PEOPLE_WITH_FIRSTNAME, new PersonRowMapper(), firstName);
    }

    public List<Person> findAllWithLastName(String lastName){
        return jdbcTemplate.query(GET_PEOPLE_WITH_LASTNAME, new PersonRowMapper(), lastName);
    }

    public List<Person> findAllWithBirthday(Date birthday){
        return jdbcTemplate.query(GET_PEOPLE_WITH_BIRTHDAY, new PersonRowMapper(), birthday);
    }

    public List<Person> findAllWithMobile(String mobile){
        return jdbcTemplate.query(GET_PEOPLE_WITH_MOBILE, new PersonRowMapper(), mobile);
    }

    public Map<String, List<Person>> mapSurnames(){
        return jdbcTemplate.query(GET_ALL_PEOPLE, new PersonExtractor());
    }

    public Map<String, Long> mapFirstNameOccurrences(){
        return jdbcTemplate.query(GET_ALL_PEOPLE, new FirstNameExtractor());
    }

}
