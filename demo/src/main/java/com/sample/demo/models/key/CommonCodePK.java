package com.sample.demo.models.key;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class CommonCodePK implements Serializable {
    private String codeGroup;

    private String code;
}
