package cn.com.lzt.model.dto;

import cn.com.lzt.model.SysUser;

public class SysUserDto extends SysUser{

	private Integer roleid;
	private String startdate;
	private String enddate;
	private String sorttype;
	private String sortcolumn;
	private int pagenum = 1;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getSorttype() {
		return sorttype;
	}

	public void setSorttype(String sorttype) {
		this.sorttype = sorttype;
	}

	public String getSortcolumn() {
		return sortcolumn;
	}

	public void setSortcolumn(String sortcolumn) {
		this.sortcolumn = sortcolumn;
	}

	public int getPagenum() {
		return pagenum;
	}

	public void setPagenum(int pagenum) {
		this.pagenum = pagenum;
	}

}
