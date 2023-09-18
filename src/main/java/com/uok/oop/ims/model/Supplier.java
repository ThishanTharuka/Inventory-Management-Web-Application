package com.uok.oop.ims.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "suppliier_id")
    private String supplierId;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "suppliier_nic")
    private String supplierNIC;
    @Column(name = "contact_number")
    private String supplierContactNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, String supplierNIC, String supplierContactNumber, String email, String address) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierNIC = supplierNIC;
        this.supplierContactNumber = supplierContactNumber;
        this.email = email;
        this.address = address;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierNIC() {
        return supplierNIC;
    }

    public void setSupplierNIC(String supplierNIC) {
        this.supplierNIC = supplierNIC;
    }

    public String getSupplierContactNumber() {
        return supplierContactNumber;
    }

    public void setSupplierContactNumber(String supplierContactNumber) {
        this.supplierContactNumber = supplierContactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
