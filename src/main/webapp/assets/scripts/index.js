function loadpage(e,url){
	$(".masklayer").show();
	$("ul[class='page-sidebar-menu']").children().find("a").attr("status","off");
	$(e).attr("status","on");
	$("div[class='page-content']").load(url);
}

var Index = function () {
	
	var handleMenu = function() {
		$("ul[class='page-sidebar-menu']>li:eq(1)").addClass("open");
		$("ul[class='page-sidebar-menu']>li:eq(1)>ul[class='sub-menu']").css("display","block");
		$("li ul[class='sub-menu']>li:first>a").click();
	};
	
    return {
        //main function
        init: function () {
        	handleMenu();
        }
    };

}();