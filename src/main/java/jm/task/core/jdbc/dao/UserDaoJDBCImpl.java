package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Connection con = Util.getMySQLConnection(); Statement statement = con.createStatement()) {
            statement.execute("CREATE TABLE IF NOT EXISTS user " +
                    "(id BIGINT PRIMARY KEY AUTO_INCREMENT, " +
                    "name VARCHAR(45) NOT NULL, " +
                    "lastname VARCHAR(45) NOT NULL, " +
                    "age TINYINT NOT NULL)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Connection con = Util.getMySQLConnection(); Statement statement = con.createStatement()) {
            statement.execute("DROP TABLE IF EXISTS user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (Connection con = Util.getMySQLConnection(); Statement statement = con.createStatement()) {
            statement.execute("INSERT INTO user (name, lastname, age) " +
                    "VALUES ('" + name + "', '" + lastName + "', " + age + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Connection con = Util.getMySQLConnection(); Statement statement = con.createStatement()) {
            statement.execute("DELETE FROM user WHERE id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection con = Util.getMySQLConnection(); Statement statement = con.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try (Connection con = Util.getMySQLConnection(); Statement statement = con.createStatement()) {
            statement.execute("DELETE FROM user");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
