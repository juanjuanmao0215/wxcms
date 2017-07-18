package cn.com.lzt.model;

public class TCodeinfo {
    private Integer id;

    private String codename;

    private String codeimg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename == null ? null : codename.trim();
    }

    public String getCodeimg() {
        return codeimg;
    }

    public void setCodeimg(String codeimg) {
        this.codeimg = codeimg == null ? null : codeimg.trim();
    }
}