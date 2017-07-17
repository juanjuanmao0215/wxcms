String.prototype.trim = function() {
	return this.replace(/(^\s*)|(\s*$)/g, "");
};

/**
 * 检测整型
 */
$("input.int").blur(function() {
	var tempValue = $(this).val();
	if (tempValue == "") {
		return false;
	}
	var regu = /[^0-9]/g;
	var re = new RegExp(regu);
	if (re.test(tempValue.trim()))
		return true;
});

/**
 * 表单提交验证
 */
$.checkFormSubmit = function(objForm) {
	var isOK = true;
	// 判断表单的非空项
	$("input.required,select.required,textarea.required", objForm).each(function() {
		var tempValue = $(this).val();
		tempValue = $.trim(tempValue);
		if (tempValue.length < 1) {
			// 获取必须输入项的label名称，弹出提示消息。
			var idLabel = "#lb" + $(this).attr("name");
			var labelValue = $(idLabel).html();
			if (labelValue.endWith("：") || labelValue.endWith(":")) {
				labelValue = labelValue.substring(0,
						labelValue.length - 1);
			}
			$(this).focus();
			showDialog(labelValue + "不能为空！");
			isOK = false;
			return false;
		}
	});
	if (!isOK)
		return isOK;
	// 手机号
	$("input.mobile", objForm).each(function() {
		var tempValue = $(this).val();
		if (tempValue.length < 1) {
			return false;
		}
		tempValue = $.trim(tempValue);
		if (!$.checkMobile(tempValue)) {
			// 弹出提示消息。
			var idLabel = "#lb" + $(this).attr("name");
			var labelValue = $(idLabel).html();
			if (labelValue.endWith("：") || labelValue.endWith(":")) {
				labelValue = labelValue.substring(0, labelValue.length - 1);
			}
			$(this).focus();
			showDialog("请输入合法的" + labelValue + "！");
			isOK = false;
			return false;
		}
	});
	if (!isOK)
		return isOK;
	// 身份证号
	$("input.idcard", objForm).each(function() {
		var tempValue = $(this).val();
		if (tempValue.length < 1) {
			return false;
		}
		tempValue = $.trim(tempValue);
		if (!$.checkIdCard(tempValue)) {
			// 弹出提示消息。
			var idLabel = "#lb" + $(this).attr("name");
			var labelValue = $(idLabel).html();
			if (labelValue.endWith("：") || labelValue.endWith(":")) {
				labelValue = labelValue.substring(0, labelValue.length - 1);
			}
			$(this).focus();
			showDialog("请输入合法的" + labelValue + "！");
			isOK = false;
			return false;
		}
	});
	if (!isOK)
		return isOK;
	// 邮箱
	$("input.email", objForm).each(function() {
		var tempValue = $(this).val();
		if (tempValue.length < 1) {
			return false;
		}
		tempValue = $.trim(tempValue);
		if (!$.checkEmail(tempValue)) {
			// 弹出提示消息。
			var idLabel = "#lb" + $(this).attr("name");
			var labelValue = $(idLabel).html();
			if (labelValue.endWith("：") || labelValue.endWith(":")) {
				labelValue = labelValue.substring(0, labelValue.length - 1);
			}
			$(this).focus();
			showDialog("请输入合法的" + labelValue + "！");
			isOK = false;
			return false;
		}
	});
	return isOK;
};

$.checkMobile = function(mobile) {
	var regu = /((\d{11})|^((\d{7,8})|(\d{4}|\d{3})-(\d{7,8})|(\d{4}|\d{3})-(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1})|(\d{7,8})-(\d{4}|\d{3}|\d{2}|\d{1}))$)/;
	var re = new RegExp(regu);
	if (re.test(mobile)) {
		return true;
	} else {
		return false;
	}
};

// 身份证验证
$.checkIdCard = function(idcard) {
	idcard = idcard.toUpperCase();
	// 15位数身份证正则表达式
	var arg1 = /^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;
	// 18位数身份证正则表达式
	var arg2 = /^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[X])$/;
	if (idcard.match(arg2) == null) {
		return false;
	} else {
		var birthday = idcard.substr(6, 4) + "-" + idcard.substr(10, 2) + "-"
				+ idcard.substr(12, 2);
		if ($.checkDate(birthday) == false) {
			// 非法日期（比如1970-02-30）
			return false;
		}
		return true;
	}
};
// 日期验证
$.checkDate = function(strDate) {
	if (/^(\d{4})-(\d{2})-(\d{2})$/.test(strDate)) {
		var nYear = parseInt(strDate.substring(0, 4));
		var nMonth = parseInt(strDate.substring(5, 7));
		var nDay = parseInt(strDate.substring(8, 10));
		var dtDate = new Date(nYear, nMonth - 1, nDay);
		if (nYear != dtDate.getFullYear() || (nMonth - 1) != dtDate.getMonth()
				|| nDay != dtDate.getDate()) {
			return false;
		}
		return true;
	} else {
		return false;
	}
};
// 邮箱验证
$.checkEmail = function(email) {
	var regu = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	var re = new RegExp(regu);
	if (re.test(email)) {
		return true;
	} else {
		return false;
	}
};

String.prototype.endWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length)
		return false;
	if (this.substring(this.length - str.length) == str)
		return true;
	else
		return false;
	return true;
}

String.prototype.startWith = function(str) {
	if (str == null || str == "" || this.length == 0
			|| str.length > this.length)
		return false;
	if (this.substr(0, str.length) == str)
		return true;
	else
		return false;
	return true;
}

function formatValue(str){
	if (str == undefined || str == null) return "";
	else return str;
}
