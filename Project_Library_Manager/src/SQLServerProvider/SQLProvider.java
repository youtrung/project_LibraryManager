/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLServerProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author trung
 */
public class SQLProvider  {
    String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String urlConnection="jdbc:sqlserver://localhost;databaseName=PROJECT_QLTHUVIEN;IntegratedSecurity=true;User=sa;password=sa12";
    Connection connection=null;
    
    public void Open() throws ClassNotFoundException, SQLException{
    Class.forName(driver);
    connection=DriverManager.getConnection(urlConnection);
    }
    
    // THỰC thi lệnh
    public ResultSet executeQuery(String sql) throws SQLException{
        Statement statement=connection.createStatement();
        ResultSet rs =statement.executeQuery(sql);
        return rs;
    }
    // đóng
    public void Close() throws SQLException{
        connection.close();
    }
    //thực thi lệnh sửa 
    public int executeUpdate(String sql) throws SQLException
    {
        int n=-1;
        Statement stm=connection.createStatement();
        n=stm.executeUpdate(sql);
        return n;
    }
}
