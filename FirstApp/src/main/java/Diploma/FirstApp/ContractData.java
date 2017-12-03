package Diploma.FirstApp;

import com.querydsl.core.annotations.QueryEntity;
import org.springframework.boot.jackson.JsonComponent;

@QueryEntity
public class ContractData {

    private Customer customer;
    private SupplierInfo supplierInfo;
    private String urlOOS;

    protected ContractData(){}
    public ContractData(Customer customer, SupplierInfo supplierInfo, String urlOOS) {
        this.customer = customer;
        this.supplierInfo = supplierInfo;
        this.urlOOS = urlOOS;
    }
}
