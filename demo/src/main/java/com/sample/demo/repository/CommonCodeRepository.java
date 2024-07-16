package com.sample.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.demo.models.entity.CommonCode;
import com.sample.demo.models.key.CommonCodePK;

import java.util.List;

public interface CommonCodeRepository extends JpaRepository<CommonCode, CommonCodePK> {
    List<CommonCode> findByCodeGroup(String codeGroup);
}
