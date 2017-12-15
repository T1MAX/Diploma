package Diploma.FirstApp.model;



public class Customer {
    private MainInfo mainInfo;

    protected Customer(){}
    public Customer(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }

    public MainInfo getMainInfo() {
        return mainInfo;
    }

    public void setMainInfo(MainInfo mainInfo) {
        this.mainInfo = mainInfo;
    }
}
