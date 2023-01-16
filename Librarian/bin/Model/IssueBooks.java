package Model;

public class IssueBooks{
    private Integer id;
    private String bookcallno;
    private Integer studentid;
    private String studentname;
    private Integer studentcontact;

    public IssueBooks(){
        bookcallno=null;
        studentname=null;
        studentid=null;
        studentcontact=null;
    }

    public IssueBooks(String call,int sId, String name, int contact){
        bookcallno = call;
        studentid = sId;
        studentname=name;
        studentcontact=contact;
    }

    public void setID(int id){ this.id = id;}
    public void setBookcallno(String n){ bookcallno=n;}
    public void setStudentname(String name){ studentname = name; }
    public void setStudentcontact(int contact){ studentcontact=contact;}
    public void setStudentId(int id){ studentid = id; }

    public Integer getID(){ return id;}
    public Integer getStudentId(){ return studentid; }
    public String getBookcallno(){ return bookcallno;}
    public String getStuentname(){ return studentname;}
    public Integer getStudentcontact(){ return studentcontact; }
}