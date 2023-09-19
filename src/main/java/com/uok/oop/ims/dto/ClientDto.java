package com.uok.oop.ims.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientDto {
    private String client_id;
    private String client_NIC;
    private String client_name;
    private String client_address;
    private String client_contact;
    private String client_email;
}
