/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugaspkl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
/**
 *
 * @author bill
 */
public class Tugaspkl {
static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
static final String DB_URL = "jdbc:mysql://localhost/cloudpos";
static final String USER = "root";
static final String PASS = "";

static Connection conn;
static Statement stmt;
static ResultSet rs;



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
        Class.forName(JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL,USER,PASS);
        stmt = conn.createStatement();
        String sql ="SELECT * FROM tbl_kab_kot";
        rs = stmt.executeQuery(sql);
        
        while(rs.next()){
        System.out.println("ID kabupaten kota"+rs.getInt("id_kabkot"));
        System.out.println("ID provinsi"+rs.getInt("id_provinsi"));
        System.out.println("kabkota"+rs.getString("kab_kota"));
        }
        stmt.close();
        conn.close();
        }catch(Exception e){
        e.printStackTrace();
        }
    }
    
}
