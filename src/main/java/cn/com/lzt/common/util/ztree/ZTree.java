package cn.com.lzt.common.util.ztree;

public class ZTree {

	private int id;
	private int pId;
	private String name;
	private boolean open;
	private boolean haschildren;
	private String treelevel;
	private boolean checked;

	public ZTree() {
		super();
	}

	public ZTree(int id, int pId, String name, boolean open,
			boolean haschildren, String treelevel, boolean checked) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.haschildren = haschildren;
		this.treelevel = treelevel;
		this.checked = checked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isHaschildren() {
		return haschildren;
	}

	public void setHaschildren(boolean haschildren) {
		this.haschildren = haschildren;
	}

	public String getTreelevel() {
		return treelevel;
	}

	public void setTreelevel(String treelevel) {
		this.treelevel = treelevel;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

}
