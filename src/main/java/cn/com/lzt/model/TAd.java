package cn.com.lzt.model;

import java.util.Date;

public class TAd {
    private Integer id;

    private String imgurl;

    private String showurl;

    private String showtitle;

    private String showcontent;

    private Integer sortnum;

    private Date intime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getShowurl() {
        return showurl;
    }

    public void setShowurl(String showurl) {
        this.showurl = showurl == null ? null : showurl.trim();
    }

    public String getShowtitle() {
        return showtitle;
    }

    public void setShowtitle(String showtitle) {
        this.showtitle = showtitle == null ? null : showtitle.trim();
    }

    public String getShowcontent() {
        return showcontent;
    }

    public void setShowcontent(String showcontent) {
        this.showcontent = showcontent == null ? null : showcontent.trim();
    }

    public Integer getSortnum() {
        return sortnum;
    }

    public void setSortnum(Integer sortnum) {
        this.sortnum = sortnum;
    }

    public Date getIntime() {
        return intime;
    }

    public void setIntime(Date intime) {
        this.intime = intime;
    }
}