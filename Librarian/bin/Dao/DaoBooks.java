package Dao;

import Model.Books;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DaoBooks extends Books implements implBook{

    private String[][] data;
    private String[] column;


    public static void main(String[] args){
        DaoBooks d = new DaoBooks();
        d.view();
        System.out.println( d.getData() +" "+ d.getColumn());
        String[][] data = d.getData();
        for(String[] str : data){
            for(String s: str){
                System.out.print(s+" ");
            }
            System.out.println();
        }
        System.out.println("============");
        String[] c = d.getColumn();
        for(String s : c){
            System.out.print(s+" ");
        }
    }

    public DaoBooks(){
        super();
    }
    public DaoBooks(String callno, String name, String author, String publisher, Integer quantity) {
        super(callno, name, author, publisher, quantity);
    }

    @Override
    public int add() {
        
        int status=0;
        try{
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into books( callno, name, author, publisher, quantity, issued) values(?,?,?,?,?,?)");
            ps.setString(1, getCallno());
            ps.setString(2, getName());
            ps.setString(3, getAuthor());
            ps.setString(4, getPublisher());
            ps.setInt(5, getQuantity());
            ps.setInt(6, getIssued());
            status = ps.executeUpdate();
            conn.close();
        }catch(Exception e){ e.printStackTrace(); }

        
        return status;
    }

    @Override
    public void view() {
        
        

        try{
            //connection
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement(" select * from books", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE );
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            //第一列
            int cols = rsmd.getColumnCount();//數量(總比數)
            column=new String[cols];
            // 塞資料
            for(int i=1; i<=cols; i++){
                column[i-1] = rsmd.getColumnName(i);
            }
            // setColumn(column);
            
            rs.last();
            int rows=rs.getRow();
            rs.beforeFirst();

            //第n+1列 
            data = new String[rows][cols];
            int count=0;
            while(rs.next()){
                for(int i=1; i<=cols; i++){
                    data[count][i-1]=rs.getString(i);
                }
                count++;
            }
            // setData(data);
            conn.close();
            
            
        }catch(Exception e){ e.printStackTrace(); }


    }

    @Override
    public int update(String bookcallno, String target) {
        int status =0;
        int quantity=0, issued=0;
        
        try{
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement("select quantity, issued from books where callno=?");
            ps.setString(1, bookcallno);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                quantity=rs.getInt("quantity");
                issued = rs.getInt("issued");
            }

            if(issued>0 && target.equals("return") ){
                PreparedStatement ps2 = conn.prepareStatement("update books set quantity=?, issued=? where callno=? ");
                ps2.setInt(1, quantity+1);
                ps2.setInt(2, issued-1);
                ps2.setString(3, bookcallno);

                status = ps2.executeUpdate();
            }
            if(quantity>0 && target.equals("addissue")){
                PreparedStatement ps2 = conn.prepareStatement("update books set quantity=?, issued=? where callno=? ");
                ps2.setInt(1, quantity-1);
                ps2.setInt(2, issued+1);
                ps2.setString(3, bookcallno);

                status = ps2.executeUpdate();
            }
            conn.close();

        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    

    @Override
    public int delete(int id) {
        return 0;
    }

    public void setData(String[][] data){
        this.data = data;
    }
    public void setColumn(String[] column){
        this.column = column;
    }
    public String[][] getData(){
        return data;
    }
    public String[] getColumn(){
        return column;
    }

    
    
}
