package ex05;

public class Engine {
    private String maker;
    private int valve;
    private boolean isDisel;
    
    public Engine() {
        System.out.println("Engine() 호출됨!");
    }
    
    public Engine(String maker, int valve, boolean isDisel) {
        this.maker = maker;
        this.valve = valve;
        this.isDisel = isDisel;
        System.out.println("Engine(String, int, boolean) 호출됨!");
    }
    
    public String getMaker() {
        return maker;
    }
    public void setMaker(String maker) {
        System.out.println("Engine.setMaker()");
        this.maker = maker;
    }
    public int getValve() {
        return valve;
    }
    public void setValve(int valve) {
        System.out.println("Engine.setValve()");
        this.valve = valve;
    }
    public boolean isDisel() {
        return isDisel;
    }
    public void setDisel(boolean isDisel) {
        System.out.println("Engine.setDisel()");
        this.isDisel = isDisel;
    }

    @Override
    public String toString() {
        return "Engine [maker=" + maker + ", valve=" + valve 
                + ", isDisel=" + isDisel + "]";
    }
    
}
