package cn.com.lzt.model;

import java.util.Date;

public class TSysmenu {
    private Integer id;

    private Integer parentid;

    private String menuname;

    private String menuurl;

    private String menuimg;

    private Integer sortnum;

    private String sortlevel;

    private Integer isused;

    private String menulevel;

    private Integer parentflag;

    private Date createdate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getMenuurl() {
        return menuurl;
    }

    public void setMenuurl(String menuurl) {
        this.menuurl = menuurl == null ? null : menuurl.trim();
    }

    public String getMenuimg() {
        return menuimg;
    }

    public void setMenuimg(String menuimg) {
        this.menuimg = menuimg == null ? null : menuimg.trim();
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public String getSortlevel() {
        return sortlevel;
    }

    public void setSortlevel(String sortlevel) {
        this.sortlevel = sortlevel == null ? null : sortlevel.trim();
    }

    public Integer getIsused() {
        return isused;
    }

    public void setIsused(Integer isused) {
        this.isused = isused;
    }

    public String getMenulevel() {
        return menulevel;
    }

    public void setMenulevel(String menulevel) {
        this.menulevel = menulevel == null ? null : menulevel.trim();
    }

    public Integer getParentflag() {
        return parentflag;
    }

    public void setParentflag(Integer parentflag) {
        this.parentflag = parentflag;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    private Integer checkedid;

    public Integer getCheckedid() {
        return checkedid;
    }

    public void setCheckedid(Integer checkedid) {
        this.checkedid = checkedid;
    }
}