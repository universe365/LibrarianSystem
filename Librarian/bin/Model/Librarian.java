package Model;

public class Librarian {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private String address;
    private String city;
    private Integer contact;

    public Librarian(){}

    public Librarian(String name, String password){
        this.name = name;
        this.password=password;
    }

    public Librarian(String name, String password, String email, String address, String city, Integer contact){
        this.name=name;
        this.password=password;
        this.email=email;
        this.address=address;
        this.city=city;
        this.contact=contact;
    }

    //setter
    public void setName(String n){
        name =n;
    }
    public void setPassword(String p){
        password=p;
    }
    public void setEmail(String e){
        email =e;
    }
    public void setAddress(String a){
        address=a;
    }
    public void setCity(String c){
        city=c;
    }
    public void setContact(int c){
        contact=(Integer)c;
    }
    public void setID(int id){
        this.id=id;
    }

    //getter
    public String getName(){ return name; }
    public String getPassword(){ return password; }
    public String getEmail(){ return email; }
    public String getAddress(){ return address; }
    public String getCity() { return city; }
    public Integer getContact() { return contact; }
    public Integer getID(){ return id; }
}
