package com.example.thymeleafspring.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
//auditing
@EntityListeners(AuditingEntityListener.class)/*
@JsonIgnoreProperties(value = {"created_date,updated_date"},allowGetters = true)*/
//hibernate jpa
@MappedSuperclass
//lombok
@Getter
@Setter
public class BaseEntity {

    @Id
    @Column(name="id",nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="created_by")
    @CreatedBy
    private String createdBy;
    @Column(name="created_date")
    @CreatedDate
    private Date createdDate;
    @Column(name="updated_by")
    @LastModifiedBy
    private String updatedBy;
    @Column(name="updated_date")
    @LastModifiedDate
    private Date updatedDate;
    @Column(name="system_auto_date")
    @Temporal(TemporalType.TIMESTAMP) //yıl ay gün saniye olarak ekle
    @CreationTimestamp
    private Date date;


}
