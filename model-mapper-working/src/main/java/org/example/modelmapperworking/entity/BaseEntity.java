package org.example.modelmapperworking.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {
    private Date createdAt;
    private Date updatedAt;
    private String createdBy;
    private String updatedBy;
}
