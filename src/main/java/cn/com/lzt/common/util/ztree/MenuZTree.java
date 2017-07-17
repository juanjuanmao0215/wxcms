package cn.com.lzt.common.util.ztree;

public class MenuZTree extends ZTree {

	private String menuurl;
	private String menuimg;
	private Integer sortnum;
	private Integer isused;

	public MenuZTree() {
		super();
	}

	public MenuZTree(int id, int pid, String name, boolean open,
			boolean haschildren, String treelevel, boolean checked,
			String menuurl, String menuimg, Integer sortnum, Integer isused) {
		super(id, pid, name, open, haschildren, treelevel, checked);
		this.menuurl = menuurl;
		this.menuimg = menuimg;
		this.sortnum = sortnum;
		this.isused = isused;
	}

	public String getMenuurl() {
		return menuurl;
	}

	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}

	public String getMenuimg() {
		return menuimg;
	}

	public void setMenuimg(String menuimg) {
		this.menuimg = menuimg;
	}

	public Integer getSortnum() {
		return sortnum;
	}

	public void setSortnum(Integer sortnum) {
		this.sortnum = sortnum;
	}

	public Integer getIsused() {
		return isused;
	}

	public void setIsused(Integer isused) {
		this.isused = isused;
	}

}
