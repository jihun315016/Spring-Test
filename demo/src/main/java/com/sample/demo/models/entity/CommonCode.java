package com.sample.demo.models.entity;

import com.sample.demo.models.key.CommonCodePK;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@NoArgsConstructor(access = AccessLevel.PROTECTED) 
@AllArgsConstructor
@Builder
@Getter
@Entity
@IdClass(CommonCodePK.class)
@Table(name="common_code")
public class CommonCode {
    @Id
    @Column(name = "code_group")
    private String codeGroup;

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

     @Column(name = "description")
    private String description;
}
