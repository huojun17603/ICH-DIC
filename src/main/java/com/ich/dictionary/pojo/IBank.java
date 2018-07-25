package com.ich.dictionary.pojo;

public class IBank {

    /**`id` bigint(20) NOT NULL AUTO_INCREMENT,*/
    private Long id;
    /** `code` varchar(16) DEFAULT NULL COMMENT '银行编码',*/
    private String code;
    /**`name` varchar(64) DEFAULT NULL COMMENT '银行名称：农业银行',*/
    private String name;
    /**`status` int(11) DEFAULT '1' COMMENT '状态：1-可用，0-禁用',*/
    private Integer status;
    /**`themecode` varchar(32) DEFAULT NULL COMMENT '颜色编码：（#00ccFF）#+颜色代码',*/
    private String themecode;
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

    public String getThemecode() {
        return themecode;
    }

    public void setThemecode(String themecode) {
        this.themecode = themecode;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }
}
