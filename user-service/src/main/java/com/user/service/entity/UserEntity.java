package com.user.service.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name ="user_table2", schema ="demo2")
public class UserEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String userFirstName;
    private String userLastAddress;
    private String email;
    private Long departmentId;

}
