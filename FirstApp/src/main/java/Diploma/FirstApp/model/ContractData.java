package Diploma.FirstApp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "contracts")
public class ContractData {

    @Id
    private String id;
    private Customer customer;
    private SupplierInfo supplierInfo;
    private String urlOOS;
    private Long price;
    private Integer digitalPurchaseCode;

    protected ContractData(){}
    public ContractData(Customer customer, SupplierInfo supplierInfo, String urlOOS, Long price, Integer digitalPurchaseCode) {
        this.customer = customer;
        this.supplierInfo = supplierInfo;
        this.urlOOS = urlOOS;
        this.price = price;
        this.digitalPurchaseCode = digitalPurchaseCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public SupplierInfo getSupplierInfo() {
        return supplierInfo;
    }

    public void setSupplierInfo(SupplierInfo supplierInfo) {
        this.supplierInfo = supplierInfo;
    }

    public String getUrlOOS() {
        return urlOOS;
    }

    public void setUrlOOS(String urlOOS) {
        this.urlOOS = urlOOS;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getDigitalPurchaseCode() {
        return digitalPurchaseCode;
    }

    public void setDigitalPurchaseCode(Integer digitalPurchaseCode) {
        this.digitalPurchaseCode = digitalPurchaseCode;
    }
}
