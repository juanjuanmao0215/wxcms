/**
 * 初始化分页控件
 * @param totalCount：总数
 * @param limit：每页条数
 * @param showPage：页签显示个数
 */
function initPagination(totalCount,limit){
	$('#datatablepaginate').extendPagination({
        totalCount: totalCount,
        showPage: 5,
        limit: limit,
        callback: function (pagenum) {
        	//创建表格
            createTable(pagenum);
        }
    });
}

/**
 * 初始化表单数据
 * @param pagenum：当前页
 */
function initTableData(pagenum){
	var url = $("form:first").attr("action");
	$("form:first").find("input[name='pagenum']").remove();
    var pagedom = '<input type="hidden" name="pagenum" value="'+pagenum+'" />';
    $("form:first").append(pagedom);
    var params = $("form:first").serialize();
    handleAjaxSimple(url,params,2,2,function(data){
    	if (data.code == 0){
    		//初始化分页控件
    		initPagination(data.pageResult.total,data.pageResult.pageSize);
    		//初始化表单数据
			createTable(pagenum,data);
    	}
    },true);
}

/**
 * 创建表单
 * @param pagenum：当前页
 * @param data：表单数据
 */
function createTable(pagenum,data) {
	var html = [];
	if (data !=undefined && data !=''){
		filltable(data,html);
	}else{
		var url = $("form:first").attr("action");
		$("form:first").find("input[name='pagenum']").remove();
        var pagedom = '<input type="hidden" name="pagenum" value="'+pagenum+'" />';
        $("form:first").append(pagedom);
        var params = $("form:first").serialize();
        handleAjaxSimple(url,params,2,2,function(data){
        	if (data.code == 0){
        		filltable(data,html);
        	}
        },true);
	}
}
