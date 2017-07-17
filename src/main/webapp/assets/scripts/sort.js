$(function() {
	//隐藏遮罩层
	$(".masklayer").hide();
	//初始化表单数据
	initTableData(1);
	//表单查询
	$(".searchbtn").click(function(){
		initTableData(1);
	});
	$(".sorting,.sorting_desc,.sorting_asc").click(function(e) {
		var sorttype = "desc";
		var classnamestr = "," + $(this).attr("class").split(" ").join(",") + ",";
		if (classnamestr.indexOf(",sorting_desc,") > -1)
			sorttype = "asc";
		if (classnamestr.indexOf(",sorting_asc,") > -1)
			sorttype = "desc";
		if (classnamestr.indexOf(",sorting,") > -1)
			sorttype = "asc";
		var sortcolumn = $(this).attr("id");
		$("form:first").find("input[name='sortcolumn']").remove();
		$("form:first").find("input[name='sorttype']").remove();
		var sortcolumndom = '<input type="hidden" name="sortcolumn" value="' + sortcolumn + '" />';
		var sorttypedom = '<input type="hidden" name="sorttype" value="' + sorttype + '" />';
		$("form:first").append(sortcolumndom);
		$("form:first").append(sorttypedom);
		$(".sorting,.sorting_desc,.sorting_asc").removeClass("sorting sorting_desc sorting_asc").addClass("sorting");
		$("table>thead>tr>th[id='" + sortcolumn + "']").removeClass("sorting").addClass("sorting_"+sorttype);
		initTableData(1);
	});
});