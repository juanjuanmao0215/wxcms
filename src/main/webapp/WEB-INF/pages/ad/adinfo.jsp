<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@ include file="/include/maincss.jsp"%>
	
  </head>
  
  <body>
  	<%@ include file="/include/jslib.jsp"%>
  	<div class="form-cd-div">
		<form class="form-horizontal" action="<%=basePath%>ad/saveAd.do" name="adform" id="adform" method="post">
			<div class="form-group">
				<label for="sortnum" class="col-sm-2 control-label">显示顺序：</label>
				<div class="col-sm-2">
					<select class="form-select" name="sortnum" id="sortnum">
						<option value="1" <c:if test="${1 == ad.sortnum }">selected="selected"</c:if>>第一张</option>
						<option value="2" <c:if test="${2 == ad.sortnum }">selected="selected"</c:if>>第二张</option>
						<option value="3" <c:if test="${3 == ad.sortnum }">selected="selected"</c:if>>第三张</option>
						<option value="4" <c:if test="${4 == ad.sortnum }">selected="selected"</c:if>>第四张</option>
						<option value="5" <c:if test="${5 == ad.sortnum }">selected="selected"</c:if>>第五张</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="showtitle" class="col-sm-2 control-label" id="lbshowtitle">广告标题：</label>
				<div class="col-sm-5">
					<input type="text" class="form-control required" name="showtitle" id="showtitle" value="${ad.showtitle }" placeholder="请输入广告标题" />
				</div>
				<div class="div-warn">*</div>
			</div>
			<div class="form-group">
				<label for="showurl" class="col-sm-2 control-label">广告链接：</label>
				<div class="col-sm-5">
					<input type="text" class="form-control" name="showurl" id="showurl" value="${ad.showurl }" />
				</div>
			</div>
			<div class="form-group">
				<label for="showcontent" class="col-sm-2 control-label" id="lbshowcontent">广告描述：</label>
				<div class="col-sm-5">
					<textarea class="form-control required" rows="3" name="showcontent" id="showcontent" placeholder="请输入广告描述">${ad.showcontent }</textarea>
				</div>
				<div class="div-warn">*</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" id="lbimgurl">广告图片：</label>
				<div class="col-sm-5">
					<div id="imgs" class="imgs"></div>
					<input type="file" class="input-file" id="imgfile" accept="image/*" size="1" />
					<img class="uploadimg" id="uploadimg" src="<%=basePath %>assets/img/upload.png" />
					<span>(请上传1248*702像素的图片，格式为JPG或PNG)</span>
				</div>
			</div>
			<c:if test="${ad.id !=null }">
				<div class="form-group">
					<label class="col-sm-2 control-label">创建时间：</label>
					<div class="col-sm-5">
						<label class="form-label">
							<fmt:formatDate value="${ad.intime }" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
						</label>
					</div>
				</div>
			</c:if>
			<div class="form-group">
				<label class="col-sm-2"></label>
				<div>
					<input type="button" class="btn btn-primary" id="savebtn" value="保存" />
					<input type="button" class="btn btn-primary back" value="返回" class="back"/>
				</div>
			</div>
		</form>
	</div>
	<script src="<%=basePath %>assets/js/exif.js"></script>
	<script src="<%=basePath %>assets/js/imgupload.js"></script>
	<script>
		var adid = '${ad.id}';
		var upad = adid !=undefined && adid !='' ? true : false;
		var imgurl = '${ad.imgurl}';
		var ifupdateimg = true;
		$(function(){
			if (upad){
				var $div = $('<div class="img-upload"></div>');
				var $showimg = $('<img class="upload-showimg" src="' + imgurl + '" />');
				var $img = $('<img class="imgclass" style="display:none;" src="' + imgurl + '" />');
				var basePath = $("base").attr("href");
				var $deldiv = '<div class="imgdelete"><img src="' + basePath
						+ 'assets/img/imgdelete.png" onclick="deleteimg(this);" /></div>';
				$div.append($showimg).append($img).append($deldiv);
				$("#imgs").append($div);
			}
			$("#uploadimg").click(function(){
				if ($(".imgclass").size() == 1){
					showDialog("广告图片最多上传一张，请先删除后在重新上传！");
					return;
				}
				$("#imgfile").click();
			});
		});
		$("#imgfile").change(function(){
			handleImage();
		});
		$("#savebtn").click(function(e){
			if (upad){
				if (imgurl == $(".imgclass").attr("src"))
					ifupdateimg = false;
			}
			var form = $(e.target.form);
			if ($.checkFormSubmit(form)) {
				if ($(".imgclass").size() == 0){
					showDialog("请上传广告图片！");
					return;
				}
				if (ifupdateimg){
					doUpload('ad');	
				}else{
					post();
				}
			}
		});
		function post(imagedatas){
			var imgdata = {
				"imgs":imagedatas
			};
			if (imagedatas ==undefined || imagedatas == '')
				imgdata = {};
			if (upad){
				var adiddom = '<input type="hidden" name="id" value="'+adid+'" />';
				$("form:first").append(adiddom);	
			}
			var obj = $("form:first").serializeObject(imgdata);
			var url = "<%=basePath%>ad/saveAd.do";
			var callback = "<%=basePath%>ad/findAds.do";
			handleAjaxSimple(url, JSON.stringify(obj), 1, 1, callback);
		}
	</script>
  </body>
</html>
