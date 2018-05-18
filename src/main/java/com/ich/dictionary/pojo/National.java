package com.ich.dictionary.pojo;

public class National {

    /**`id` bigint(20) NOT NULL AUTO_INCREMENT,*/
    private Long id;
    /** `code` varchar(16) DEFAULT NULL COMMENT '国家编码',*/
    private String code;
    /**`name` varchar(64) DEFAULT NULL COMMENT '国家名称',*/
    private String name;
    /**`status` int(11) DEFAULT '1' COMMENT '状态：1-可用，0-禁用',*/
    private Integer status;
    /**`onum` int(5) DEFAULT NULL COMMENT '自定义排序，数字大的排前面',*/
    private Integer onum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }
}
