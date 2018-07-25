package com.ich.dictionary.pojo;

public class IAddresscn {

    /** ID */
    private Long id;
    /** 区域名称 */
    private String name;
    /** 首字母大写 */
    private String letter;
    /**  上级ID */
    private Long parentid;
    /** 级别 */
    private Integer type;
    /** 状态（1：可用，0：不可用） */
    private Integer status;
    /** 自定义排序 */
    private Integer onum;

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

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public Long getParentid() {
        return parentid;
    }

    public void setParentid(Long parentid) {
        this.parentid = parentid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getOnum() {
        return onum;
    }

    public void setOnum(Integer onum) {
        this.onum = onum;
    }
}
