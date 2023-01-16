package Dao;

import Model.Librarian;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DaoLibrarian extends Librarian implements implLibrarian {
    
    private String[][] data;
    private String[] column;

    public DaoLibrarian(){super();}

    public DaoLibrarian(String name, String password) {
        super(name, password);
    }
    public DaoLibrarian(String name, String password, String email, String address, String city, Integer contact){
        super(name, password, email, address, city, contact);
    }

    @Override
    public int add() {
        int status=0;
        try{
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into librarian(name, password, email, address, city, contact) values(?,?,?,?,?,?)");
            ps.setString(1,getName());
            ps.setString(2, getPassword());
            ps.setString(3, getEmail());
            ps.setString(4, getAddress());
            ps.setString(5, getCity());
            ps.setInt(6, getContact());
            status = ps.executeUpdate();
            conn.close();
        }catch(Exception e){e.printStackTrace();}
            
        return status;
    }

    @Override
    public void view() {
        try{
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from librarian",ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
           
            int cols = rsmd.getColumnCount();
            column = new String[cols];
            for(int i=1; i<=cols ; i++){
                column[i-1]= rsmd.getColumnName(i);
            }

            rs.last();
            int rows = rs.getRow();
            rs.beforeFirst();

            data = new String[rows][cols];
            int counts = 0;
            while(rs.next()){
                for(int i=1; i<=cols; i++){
                    data[counts][i-1]=rs.getString(i);
                }
                counts++;
            }
            conn.close();

        }catch(Exception e){ e.printStackTrace(); }

    }

    @Override
    public int update() {
        int status=0;
        return status;
    }

    @Override
    public int delete(int id) {
        int status =0;
        
        try{
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement("delete from librarian where id=?");
            ps.setInt(1,id);

            status = ps.executeUpdate();
            conn.close();

        }catch(Exception ex){ ex.printStackTrace(); }
        return status;
    }

    public boolean verify(String name, String password){
        boolean status = false;
        
        try{
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from librarian where name=? and password=?");
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            status = rs.next();
            conn.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public void setData(String[][] data){ this.data = data;}
    public void setColumn(String[] column ){ this.column = column; }
    public String[][] getData(){return data;}
    public String[] getColumn(){return column;}
    
}
