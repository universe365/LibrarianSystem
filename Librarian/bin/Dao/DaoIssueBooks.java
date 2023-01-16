package Dao;

import Model.IssueBooks;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DaoIssueBooks extends IssueBooks implements implssueBook{

    private String[][] data;
    private String[] column;

    public static void main(String [] args){
        
        DaoIssueBooks ib = new DaoIssueBooks();
        ib.view();

        String[][] d = ib.getData();
        String[] c = ib.getColumn();

        for(String[] str:d){
            for(String s:str){
                System.out.print(s+" ");
            }
        }
        System.out.print("\nColumn: ");
        for(String s:c){ System.out.print(s+" "); }

    }

    public DaoIssueBooks(){
        super();
    }
    
    public DaoIssueBooks(String call,int id, String name, int contact) {
        super(call, id, name, contact);
    }

    @Override
    public int add()
     {
        int status=0;
        //connection
        try{
            Connection conn = DB.getConnection();

            //add sql語法:
           
                PreparedStatement ps = conn.prepareStatement(" insert into issuebooks (bookcallno,studentid, studentname, studentcontact) values(?,?,?,?) ");
                ps.setString(1, getBookcallno());
                ps.setInt(2, getStudentId());
                ps.setString(3, getStuentname());
                ps.setInt(4, getStudentcontact());
                status = ps.executeUpdate();
                System.out.println("Issued book added ["+ status +"]");
           
            //end connection
            conn.close();
        }catch(Exception e){e.printStackTrace();}
        
        return status;
    }

    @Override
    public void view() {
        
        try{
            //connectin
            Connection conn = DB.getConnection();
            PreparedStatement ps = conn.prepareStatement("select * from issuebooks", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();

            //1. get column data
            int cols = rsmd.getColumnCount();
            column = new String[cols];
                //塞資料
            for(int i=0; i<cols; i++){
                column[i] = rsmd.getColumnName(i+1);
            }

            //2. 空格
            rs.last();
            int rows= rs.getRow();//給 data 塞資料
            rs.beforeFirst();

            //3. 撈資料
            data = new String[rows][cols];

            int count=0;
            while(rs.next()){
                for(int i=0; i<cols; i++){
                    data[count][i] = rs.getString(i+1);
                }
                count++;
            }
            conn.close();

        }catch(Exception e){e.printStackTrace();}

    }


    @Override
    public int delete(String bookcallno, int studentid) {
        int status=0;
        Connection conn = DB.getConnection();
        status = new DaoBooks().update(bookcallno, "return");

        try{
            if(status>0){
               
                PreparedStatement ps = conn.prepareStatement("delete from issuebooks where bookcallno=? and studentid=? ");
                ps.setString(1, bookcallno);
                ps.setInt(2, studentid);
                status = ps.executeUpdate();
            }

            conn.close();
        }catch(Exception e){e.printStackTrace();}
        
        return status;
    }
    

    public void setData(String[][] data){ this.data = data; }
    public void setColumn(String[] column){ this.column = column; }
    public String[][] getData(){ return data; }
    public String[] getColumn(){ return column;}

}
