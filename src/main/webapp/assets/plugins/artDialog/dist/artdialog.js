function showDialog(content,callback){
	dialog({
		title: '消息',
		content: content,
		okValue: '确定',
		width: '20em',
		backdropOpacity:0,
		cancelValue:'取消',
		ok: function () {
			//回调函数
			if (callback != undefined)
				callback();
			return true;
		}
	}).showModal();	
}

function dialogConfirm(content,callback){
	dialog({
		title: '消息',
		content: content,
		okValue: '确定',
		width: '20em',
		backdropOpacity:0,
		ok: function () {
			//回调函数
			if (callback != undefined)
				callback();
			return true;
		},
		cancelValue:'取消',
		cancel: function () {
		}
	}).showModal();
}