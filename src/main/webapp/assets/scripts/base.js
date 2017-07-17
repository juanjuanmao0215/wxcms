$("title").html("web后台管理系统");

/**
 * 进入新增或修改页面
 * 
 * @param url：请求地址
 * @param id：id
 */
function topage(url, id) {
	if (id != undefined && id != '') {
		var map = new Map();
		map.put("id", id);
	}
	handleForm(url, map);
}

/**
 * 提交表单
 * 
 * @param url
 * @param paramsmap
 */
function handleForm(url, paramsmap) {
	var formdom = $('<form action="' + url + '" method="post"></form>');
	if (paramsmap != undefined && paramsmap != '') {
		var array = paramsmap.keySet();
		// 循环添加参数到隐藏域
		for (i in array) {
			var dom = '<input type="hidden" name="' + array[i] + '" value="'
					+ paramsmap.get(array[i]) + '" />';
			$(formdom).append(dom);
		}
	}
	$("body").append(formdom);
	$("div[class='page-content']").load(url,$(formdom).serialize());
}

var findlisturl = "";
$(function() {
	findlisturl = $("form:first").attr("action");
	// 回退操作
	$(".back").click(function() {
		history.go(-1);
	});
	// 表单查询操作
	$(".searchbtn").click(function(e) {
		$("#masklayer").show();
		$(e.target.form).submit();
	});
	// 复选框全选
	$(".form-checkall").click(function() {
		$("[class='form-ckb']:checkbox").prop("checked",$(this).prop("checked"));
	});
});

/**
 * 删除
 * 
 * @param url：请求地址
 * @param id：删除的id
 */
function dodelete(url, id) {
	dialogConfirm("删除后数据无法恢复，您确定要删除？", function() {
		var data = {
			"id" : id
		};
		handleAjaxSimple(url, data, 2, 1, findlisturl);
	});
}

/**
 * 批量删除
 * 
 * @param url
 */
function batchdelete(url) {
	if ($("[type='checkbox'][class='form-ckb']:checked").size() != 0) {
		dialogConfirm("删除后数据无法恢复，您确定要删除？", function() {
			var id_array = new Array();
			$("[type='checkbox'][class='form-ckb']:checked").each(function() {
				id_array.push($(this).val());
			});
			var data = {
				"ids" : id_array.toString()
			};
			handleAjaxSimple(url, data, 2, 1, findlisturl);
		});
	} else {
		showDialog("请选择您要删除的项后再删除！");
	}
}

/**
 * 新增或修改
 * 
 * @param id：修改时候的id
 * @param url：请求url
 * @param callback：回调地址
 */
function dosave(id, url, callback) {
	var form = $("form:first");
	if ($.checkFormSubmit(form)) {
		if (id != undefined && id != '') {
			// 修改
			var iddom = '<input type="hidden" name="id" value="' + id + '" />';
			form.append(iddom);
		}
		handleAjaxSimple(url, form.serialize(), 2, 1, callback);
	}
}
