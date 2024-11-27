import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import exercicis_raf.User;

public class UserDAO implements DAO<User>{
    private Connection conn;

    public UserDAO(Connection conn){
        this.conn = conn;
    }
    @Override
    public void add(User item) {
        // TODO Auto-generated method stub

                System.out.println("Aqui petaria perquè realment no estic connectat");
                if (conn == null) return;
                try (Statement statement = conn.createStatement()) {
                    
                  //  ResultSet resultSet = statement.executeQuery("INSERT  ...");


                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                throw new UnsupportedOperationException("Unimplemented method 'add'");
                
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    public boolean userExists(String name){
        return false;
    }

}
