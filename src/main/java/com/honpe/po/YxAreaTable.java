package com.honpe.po;

public class YxAreaTable {
    private Integer yatId;

    private Integer yatParentId;

    private String yatPath;

    private Integer yatLevel;

    private String yatCnname;

    private String yatEnname;

    private String yatCnpinyin;

    private String yatCode;

    public Integer getYatId() {
        return yatId;
    }

    public void setYatId(Integer yatId) {
        this.yatId = yatId;
    }

    public Integer getYatParentId() {
        return yatParentId;
    }

    public void setYatParentId(Integer yatParentId) {
        this.yatParentId = yatParentId;
    }

    public String getYatPath() {
        return yatPath;
    }

    public void setYatPath(String yatPath) {
        this.yatPath = yatPath == null ? null : yatPath.trim();
    }

    public Integer getYatLevel() {
        return yatLevel;
    }

    public void setYatLevel(Integer yatLevel) {
        this.yatLevel = yatLevel;
    }

    public String getYatCnname() {
        return yatCnname;
    }

    public void setYatCnname(String yatCnname) {
        this.yatCnname = yatCnname == null ? null : yatCnname.trim();
    }

    public String getYatEnname() {
        return yatEnname;
    }

    public void setYatEnname(String yatEnname) {
        this.yatEnname = yatEnname == null ? null : yatEnname.trim();
    }

    public String getYatCnpinyin() {
        return yatCnpinyin;
    }

    public void setYatCnpinyin(String yatCnpinyin) {
        this.yatCnpinyin = yatCnpinyin == null ? null : yatCnpinyin.trim();
    }

    public String getYatCode() {
        return yatCode;
    }

    public void setYatCode(String yatCode) {
        this.yatCode = yatCode == null ? null : yatCode.trim();
    }
}