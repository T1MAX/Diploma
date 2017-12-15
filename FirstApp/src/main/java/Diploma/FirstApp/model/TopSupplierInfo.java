package Diploma.FirstApp.model;


public class TopSupplierInfo {

    private Long inn;
    private String name;
    private Integer count;

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public TopSupplierInfo() {

    }

    public TopSupplierInfo(Long inn, String name, Integer count) {

        this.inn = inn;
        this.name = name;
        this.count = count;
    }

    @Override
    public String toString() {
        return "TopSupplierInfo{" +
                "inn=" + inn +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
