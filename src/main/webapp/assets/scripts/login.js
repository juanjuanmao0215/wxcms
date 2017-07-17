var Login = function() {

	var handleLogin = function() {
		$('.login-form').validate({
			errorElement : 'span', // default input error message container
			errorClass : 'help-block', // default input error message class
			focusInvalid : false, // do not focus the last invalid input
			rules : {
				username : {
					required : true
				},
				password : {
					required : true
				}
			},

			messages : {
				username : {
					required : "用户名不能为空！"
				},
				password : {
					required : "密码不能为空！"
				}
			},

			invalidHandler : function(event, validator) { // display error
				// alert on form
				// submit
				$('.alert-error', $('.login-form')).show();
			},

			highlight : function(element) { // hightlight error inputs
				$(element).closest('.form-group').addClass('has-error'); // set
				// error
				// class
				// to
				// the
				// control
				// group
			},

			success : function(label) {
				label.closest('.form-group').removeClass('has-error');
				label.remove();
			},

			errorPlacement : function(error, element) {
				error.insertAfter(element.closest('.input-icon'));
			},

			submitHandler : function(form) {
				login();
			}
		});

		$('.login-form input').keypress(function(e) {
			if (e.which == 13) {
				if ($('.login-form').validate().form()) {
					login();
				}
				return false;
			}
		});

		function login() {
			var jsonData = {
				loginid : $("#username").val(),
				pwd : hex_md5($("#password").val())
			};
			var url = "sys/login.do";
			handleAjaxSimple(url, JSON.stringify(jsonData), 1, 2, loginsuccess, false);
		}
		
		function loginsuccess(data){
			if (data.code ==0){
				var paramsmap = new Map();
				paramsmap.put("userid",data.user.id);
  				var url = "menu/index.do";
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
  				$(formdom).submit();
			}else{
				$("#error-tip").html("<span class='help-block'>"+data.restr+"</span>");
			}
		}
		
	};

	return {
		// main function to initiate the module
		init : function() {
			handleLogin();
		}
	};

}();