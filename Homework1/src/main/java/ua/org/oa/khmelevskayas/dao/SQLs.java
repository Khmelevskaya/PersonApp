package ua.org.oa.khmelevskayas.dao;

public class SQLs {
    public static final String SQL_INSERT = "INSERT INTO person(name, age, email) VALUES(?, ?, ?)";
    public static final String SQL_SELECT_BY_EMAIL = "SELECT * FROM person WHERE email = ?";
}
