/**
 * 
 * @param url：请求地址
 * @param data：请求参数
 * @param contenttype：内容类型（1：json传输，2：表单字符串传输，3：文件类型传输）
 * @param callopertype：回调方式（1：回调地址，2：回调函数，0：不做任何操作）
 * @param callback：回调地址
 * @param showmasklayer：是否显示遮罩层（true：显示，false：不显示）
 */
function handleAjaxSimple(url, data, contenttype, callopertype, callback, showmasklayer) {
	var ctype = map.get("contentType" + contenttype);
	$.ajax({
		type : "post",
		url : url,
		data : data,
		contentType : ctype,
		dataType : "json",
		async : true,
		cache : false,
		success : function(data) {
			if (callopertype != 2) {
				showDialog(data.restr, function() {
					if (data.code == 0) {
						if (callopertype != 0) {
							if (callopertype == 1) {
								submitform(callback);
							}
						}
					}
				});
			} else {
				callback(data);
			}
		},
		beforeSend : function() {
			if (showmasklayer)
				$(".masklayer").show();
		},
		error : function() {
			showDialog("请求出现异常，请稍后重试！");
			if (showmasklayer)
				$(".masklayer").hide();
		},
		complete : function() {
			if (showmasklayer)
				$(".masklayer").hide();
		}
	});
}

/**
 * 
 * @param type：请求方式（get或post）
 * @param url：请求地址
 * @param data：请求参数，$(form).serialize()或JSON.stringify(params)
 * @param contenttype：内容类型（1：json传输，2：表单字符串传输，3：文件类型传输）
 * @param dataType：数据格式
 * @param async：异步方式
 * @param cache：是否缓存
 * @param callopertype：回调方式（1：回调地址，2：回调函数，0：不做任何操作）
 * @param callback：回调地址
 * @param showmasklayer：是否显示遮罩层（true：显示，false：不显示）
 */
function handleAjaxAdvance(type, url, data, contentType, dataType, async,
		cache, callopertype, callback, showmasklayer) {
	$.ajax({
		type : type,
		url : url,
		data : data,
		contentType : contentType,
		dataType : dataType,
		async : async,
		cache : cache,
		success : function(data) {
			if (callopertype != 2) {
				showDialog(data.restr, function() {
					if (data.code == 0) {
						if (callopertype != 0) {
							if (callopertype == 1) {
								submitform(callback);
							}
						}
					}
				});
			} else {
				callback(data);
			}
		},
		beforeSend : function() {
			if (showmasklayer)
				$(".masklayer").show();
		},
		error : function() {
			showDialog("请求出现异常，请稍后重试！");
			if (showmasklayer)
				$(".masklayer").hide();
		},
		complete : function() {
			if (showmasklayer)
				$(".masklayer").hide();
		}
	});
}

function submitform(url) {
	$("div[class='page-content']").load(url);
}

$.fn.serializeObject = function(obj) {
	if (obj == undefined || obj == '')
		obj = {};
	var formarray = this.serializeArray();
	$.each(formarray, function() {
		if (obj[this.name]) {
			if (!obj[this.name].push) {
				obj[this.name] = [ obj[this.name] ];
			}
			obj[this.name].push(this.value || '');
		} else {
			obj[this.name] = this.value || '';
		}
	});
	return obj;
};
