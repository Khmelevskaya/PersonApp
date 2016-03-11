package ua.org.oa.khmelevskayas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.org.oa.khmelevskayas.jdbc.MySqlConnectionProvider;
import ua.org.oa.khmelevskayas.model.Person;

public class PersonDaoImpl implements PersonDao {

    MySqlConnectionProvider mySqlConnectionProvider = new MySqlConnectionProvider();

    @Override
    public void addPerson(Person person) {
	try (PreparedStatement prs = mySqlConnectionProvider.getConnection().prepareStatement(SQLs.SQL_INSERT);) {
	    prs.setString(1, person.getName());
	    prs.setInt(2, person.getAge());
	    prs.setString(3, person.getEmail());
	    prs.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    @Override
    public boolean isEmailExist(String email) {
	try (PreparedStatement prs = mySqlConnectionProvider.getConnection().prepareStatement(SQLs.SQL_SELECT_BY_EMAIL);
		){
	    prs.setString(1, email);
	    ResultSet rs = prs.executeQuery();
	    if (rs.next()) {
		rs.close();
		return true;
	    }
	    rs.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return false;
    }
    
    public List<Person> findPerson(String name, Integer age, String email) {
	List<Person> personResult = new ArrayList<>();
	StringBuilder sqlBuilder = new StringBuilder("SELECT name, age, email FROM person WHERE TRUE ");
	if (name != null && !name.isEmpty()) {
	    sqlBuilder.append(" AND  name = ?");
	}
	if (age != null) {
	    sqlBuilder.append(" AND  age = ?");
	}
	if (email != null && !email.isEmpty()) {
	    sqlBuilder.append(" AND  email = ?");
	}
	Person person = null;
	try (PreparedStatement prs = mySqlConnectionProvider.getConnection().prepareStatement(sqlBuilder.toString());) {
	    int index = 0;
	    if (name != null && !name.isEmpty()) {
		prs.setString(++index, name);
	    }
	    if (age != null) {
		prs.setInt(++index, age);
	    }
	    if (email != null && !email.isEmpty()) {
		prs.setString(++index, email);
	    }
	    ResultSet rs = prs.executeQuery();
	    while (rs.next()) {
		person = new Person(rs.getString(1), rs.getInt(2), rs.getString(3));
		personResult.add(person);
	    }
	    rs.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	return personResult;
    }

}
