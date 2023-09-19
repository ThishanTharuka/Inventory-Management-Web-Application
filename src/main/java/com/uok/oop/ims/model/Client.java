package com.uok.oop.ims.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "client_details")
public class Client {
    @Id
    private String client_id;
    private String client_NIC;
    private String client_name;
    private String client_address;
    private String client_contact;
    private String client_email;
}
