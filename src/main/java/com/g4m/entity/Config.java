package com.g4m.entity;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author haosenwei[haosenwei@dubmic.com]
 * @date 9/19/19 10:11
 * <p>Copyright 2008-2019 snsndk.com</p>
 */
@Table(name = "config")
public class Config {
    @Id
    private Long id;
    private String name;
    private String code;
    private String configValue;
    private String preValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getConfigValue() {
        return configValue;
    }

    public void setConfigValue(String configValue) {
        this.configValue = configValue;
    }

    public String getPreValue() {
        return preValue;
    }

    public void setPreValue(String preValue) {
        this.preValue = preValue;
    }
}
