package service;

import domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;


public class UserServiceTest {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    User user = new User();

    @Before
    public void setUp() throws Exception {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cadastros", "root", "17121982Vale@");
        UserService userService = new UserService();
        User user = new User();

    }

    @Test
    @DisplayName("connection data base")
    public void testOpenConnection() throws SQLException {
        System.out.println("OpenConnection");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cadastros", "root", "17121982Vale@");
        Assert.assertEquals(con != null, true);
    }

    @Test
    @DisplayName("save users")
    public void save_Users() {
        try {
            String sql = "insert into users (name, email, password, dtCreation) " +
                    "values (Pamela , pamela@gmail.com, 152361, 2021-03-18)";


            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, formatter.format(user.getDtCreation()));
            preparedStatement.executeUpdate();

            System.out.println("Usuário(a) " + user.getName() + " criado(a) com sucesso");
        } catch (Exception e) {
            System.out.println("save user " + e);

        }
        Assert.assertEquals(connection != null, false);
        System.out.println("Salvo com sucesso");

    }

    @Test
    @DisplayName("list all users")
    public void find_All_Users() {
        String sqlSelect = "SELECT * FROM users;";
        ResultSet resultSet;

        try {
            preparedStatement = connection.prepareStatement(sqlSelect);
            resultSet = preparedStatement.executeQuery();
            assertNotNull("Lista de usuarios recebida com sucesso", resultSet);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("update user")
    public void update_Users() {
        String sqlUpdate = ("UPDATE users SET nome= '" + user.getName() + "', email = '" + user.getEmail() + "' WHERE id =  " + user.getId() + ";");
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.executeUpdate();

            if (idNotExist()) {
                assertFalse("Usuário [" + user.getId() + "] não encontrado!", preparedStatement.getMoreResults());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean idNotExist() throws SQLException {
        String sql = "SELECT MAX(id) AS ULTIMOID FROM users";
        ResultSet result;
        boolean retorno = false;

        preparedStatement = connection.prepareStatement(sql);
        result = preparedStatement.executeQuery();
        if (result.next()) {
            int finalId = result.getInt("Final Id");
            if (finalId < user.getId()) {
                fail("Id inexistente");
                retorno = true;
            }
        }
        return retorno;
    }

    @Test
    @DisplayName("delete user")
    public void deleteId() {
        String sql = ("DELETE FROM users WHERE id = '" + user.getId() + "';");
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

            if (idNotExist()) {
                assertFalse("Usuário [" + user.getId() + "] não encontrado!", preparedStatement.getMoreResults());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}