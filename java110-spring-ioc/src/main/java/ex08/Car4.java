package ex08;

import java.sql.Date;

import javax.annotation.Resource;

// @Resource 사용법
public class Car4 {
    private int no;
    private String model;
    private String maker;
    private int cc;
    private Date createdDate;
    
    @Resource(name="e2") // => @Autowired @Qualifier("e2")
    private Engine engine;
    
    public Car4() {
        System.out.println("Car() 호출됨!");
    }
    
    public Car4(String model, int cc) {
        this.model = model;
        this.cc = cc;
        System.out.println("Car(String model, int cc) 호출됨!");
    }
    public Car4(int cc, String maker) {
        this.maker = maker;
        this.cc = cc;
        System.out.println("Car(int cc, String maker) 호출됨!");
    }
    public Car4(String model, int cc, Engine engine) {
        this.model = model;
        this.cc = cc;
        this.engine = engine;
        System.out.println("Car(String model, int cc, Engine engine) 호출됨!");
    }
    
    
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        this.maker = maker;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Engine getEngine() {
        return engine;
    }

    @Override
    public String toString() {
        return "Car [no=" + no + ", model=" + model + ", maker=" + maker + ", cc=" + cc + ", createdDate=" + createdDate
                + ", engine=" + engine + "]";
    }
    
}
