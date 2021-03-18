package service;

import domain.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class UserService {

    public void insert() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cadastros", "root", "17121982Vale@");

            String sql = "insert into users (name, email, password, dtCreation) " +
                    "VALUES (?, ?, ?, ?)";

            User user = new User();

            System.out.println("Qual o nome do usuário?");
            Scanner name = new Scanner(System.in);
            String name2 = name.next();

            user.setName(name2);

            System.out.println("Qual o E-mail do usuário?");
            Scanner email = new Scanner(System.in);
            String email2 = email.next();

            user.setEmail(email2);

            System.out.println("Qual a senha do usuário?");
            Scanner password = new Scanner(System.in);
            String password2 = password.next();

            user.setPassword(password2);

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(System.currentTimeMillis());

            user.setDtCreation(date);

            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, formatter.format(user.getDtCreation()));
            statement.executeUpdate();

            System.out.println("Usuário criado com sucesso!");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public User select() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cadastros", "root", "17121982Vale@");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select * from users");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3)
                        + "  " + rs.getString(4) + "  " + rs.getString(5));
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Busca realizada com sucesso");

        return null;
    }

    public void update() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cadastros", "root", "17121982Vale@");

            System.out.println("TELA DE USUÁRIOS CADASTRADOS");
            System.out.println("--------------------------------------");
            select();

            System.out.println("PASSE O ID DO USUÁRIO QUE DESEJA ATUALIZAR PARA PROSSEGUIR: ");
            Scanner id = new Scanner(System.in);
            String id2 = id.next();

            System.out.println("Qual o nome do usuário?");
            Scanner name = new Scanner(System.in);
            String name2 = name.next();

            System.out.println("Qual o E-mail do usuário?");
            Scanner email = new Scanner(System.in);
            String email2 = email.next();

            System.out.println("Qual a senha do usuário?");
            Scanner password = new Scanner(System.in);
            String password2 = password.next();

            String sql = "update users set name=?, email=?, password=? where id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, name2);
            statement.setString(2, email2);
            statement.setString(3, password2);
            statement.setString(4, id2);

            statement.executeUpdate();
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }

        System.out.println("Atualizado com sucesso");
    }


    public void delete() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/cadastros", "root", "17121982Vale@");

            System.out.println("Qual o id do registro que deseja excluir?");
            Scanner input = new Scanner(System.in);

            String sql = "delete from users where id=?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, input.nextInt());
            statement.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Deletado com sucesso");
    }
}