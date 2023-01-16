package Model;

public class Books {
    private Integer id;
    private String callno;
    private String name;
    private String author;
    private String publisher;
    private Integer quantity;
    private Integer issued;


    public Books(){}
    
    public Books(String callno, String name, String author, String publisher, Integer quantity){
        this.callno=callno;
        this.name=name;
        this.author=author;
        this.publisher=publisher;
        this.quantity=quantity;
        this.issued=0;
    }

    public void setID(int id){this.id=id;}
    public void setCallno(String n ){callno=n;}
    public void setName(String name){this.name=name;}
    public void setAuthor(String author){this.author=author;}
    public void setPublisher(String publisher){this.publisher=publisher;}
    public void setQuantity(int quantity){this.quantity=quantity;}
    public void setIssued(int issued){this.issued=issued;};

    public Integer getID(){return id;}
    public String getCallno(){return callno;}
    public String getName(){return name;}
    public String getAuthor(){return author;}
    public String getPublisher(){return publisher;}
    public Integer getQuantity(){return quantity;}
    public Integer getIssued(){return issued;}
    
}
