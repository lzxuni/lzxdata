<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/admin/path.jsp"%>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>${settings.title} - 基本表单</title>
	<meta name="keywords" content="${settings.keywords}">
	<meta name="description" content="${settings.keywords}">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>修改用户</title>
	<!--框架必需start-->
	<script src="static/Content/scripts/jquery/jquery-1.10.2.min.js"></script>
	<link href="static/Content/styles/font-awesome.min.css" rel="stylesheet" />
	<link href="static/Content/scripts/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet" />
	<script src="static/Content/scripts/plugins/jquery-ui/jquery-ui.min.js"></script>
	<!--框架必需end-->
	<!--bootstrap组件start-->
	<link href="static/Content/scripts/bootstrap/bootstrap.min.css" rel="stylesheet" />
	<link href="static/Content/scripts/bootstrap/bootstrap.extension.css" rel="stylesheet" />
	<script src="static/Content/scripts/bootstrap/bootstrap.min.js"></script>
	<!--bootstrap组件end-->
	<script src="static/Content/scripts/plugins/datepicker/WdatePicker.js"></script>
	<link href="static/Content/scripts/plugins/tree/css?v=H1Pw5_bJCpzF5OnxCweb5t4XUgVmB2SD2PT8UreOXFA1" rel="stylesheet"/>
	<link href="static/Content/scripts/plugins/datetime/css?v=R2gV65TRaqpUG53uer0IzYRSK0iOi8wNodWtNoeZPpQ1" rel="stylesheet"/>
	<link href="static/Content/scripts/plugins/wizard/css?v=W_wrFuN6q7PYaBxT6Agjqz3dwFYf6-aOJd-mk2R7Hvg1" rel="stylesheet"/>

	<link href="static/Content/styles/learun.css?v=Ty7LTzndRqV52dwtX2Mntj35r2jf8KW5SPI02pjLaKY1" rel="stylesheet"/>


	<link rel="stylesheet" href="static/js/plugins/zTree_v3-master/css/demo.css" type="text/css">
	<link rel="stylesheet" href="static/js/plugins/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<link rel="stylesheet" href="static/js/plugins/layer/skin/moon/style.css" type="text/css">

	<script src="static/Content/scripts/utils/learun.js?v=AfeCneuZAYcYQ_oDc_NcFhRe318AoiA7nEzz08vcf9E1"></script>
	<script src="static/Content/scripts/plugins/tree/js?v=juUOPsC80vp0oU0mDF6kU_w_oqCesh68O0OtnzL7Wk81"></script>
	<script src="static/Content/scripts/plugins/validator/js?v=znSfnIdhHxxCqs-Qu0ubgsaRj2oDtXtihP0fEoemDWs1"></script>
	<script src="static/Content/scripts/plugins/wizard/js?v=B2NDCyjwoq-6l3qQjPYTbrSsjg6SllBIwuY10rqKT5g1"></script>
	<script src="static/Content/scripts/plugins/datepicker/js?v=B0RLtvjnn7QkPWLaYcMEAeEpC0XCKigX6gEmWC4zrKk1"></script>
	<script src="static/js/plugins/layer/laydate/laydate.js" type="text/JavaScript"></script>
	<style>
		.line{
			position: static;
		}
	</style>
</head>
<body>
<div id="ajaxLoader" style="cursor: progress; position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #f1f1f1; z-index: 10000; overflow: hidden;">
</div>
<form id="myform">
	<input type="hidden" name="userId" id="userId" value="${user.userId}" >
	<input type="hidden" name="sex" id="sex" value="男">
	<div id="form-body" style="overflow: auto;">
		<div style="margin-top: 20px; margin-right: 30px;">
			<table class="form" style="table-layout: auto;">
				<tr>
					<th class="formTitle">账号<font face="宋体">*</font></th>
					<td class="formValue custmerTd" >
						<input type="hidden" name="companyId" id="companyId" value="${user.companyId}" >
						<input type="text" class="form-control" name="username" id="username" value="${user.username}" readonly >
					</td>
					<th class="formTitle">姓名<font face="宋体">*</font></th>
					<td class="formValue custmerTd">
						<input type="text" class="form-control" name="realName" id="realName" value="${user.realName}" >
					</td>
				</tr>
				<tr>
					<th class="formTitle">ERP工号</th>
					<td class="formValue custmerTd">
						<input type="text" class="form-control" name="enCode" id="enCode" value="${user.enCode}" >
					</td>
					<th class="formTitle">手机<font face="宋体">*</font></th>
					<td class="formValue custmerTd" >
						<input type="text" class="form-control" name="mobile" id="mobile" value="${user.mobile}" >
					</td>
				</tr>
				<tr>
					<th class="formTitle">内网QQ</th>
					<td class="formValue custmerTd">
						<input type="text" class="form-control" name="qq" id="qq" value="${user.qq}" >
					</td>
					<th class="formTitle">微信</th>
					<td class="formValue custmerTd">
						<input type="text" class="form-control" name="weChat" id="weChat" value="${user.weChat}" >
					</td>
				</tr>
				<tr>
                    <c:if test="${user.company.parentId!='-1'}">
                        <th class="formTitle">部门</th>
                        <td class="formValue custmerTd" >
                            <input type="hidden" name="deptIds" id="deptIds" value="${deptIds}"/>
                            <div>
                                <button class="btn btn-primary" type="button" onclick="showDept();"  style="float:left;">选择</button>
                            </div>
                            <div id="deptNames" style="margin-left:15px;margin-top:5px;float:left;">${deptNames}</div>
                        </td>
                    </c:if>
					<c:if test="${user.company.parentId!='-1'}">
						<th class="formTitle">岗位</th>
						<td class="formValue custmerTd" >
							<input type="hidden" name="postIds" id="postIds" value="${postIds}"/>
							<div>
								<button class="btn btn-primary" type="button" onclick="showPost();"  style="float:left;">选择</button>
							</div>
							<div id="postNames" style="margin-left:15px;margin-top:5px;float:left;">${postNames}</div>
						</td>
					</c:if>
				</tr>
                <tr>
                    <th class="formTitle">角色</th>
                    <td class="formValue custmerTd">
                        <input type="hidden" name="roleIds" id="roleIds" value="${roleIds}"/>
                        <div>
                            <button class="btn btn-primary" type="button" onclick="showMenu();"  style="float:left;">选择</button>
                        </div>
                        <div id="roleNames" style="margin-left:15px;margin-top:5px;float:left;">${roleNames}</div>
                    </td>
                </tr>
			</table>
		</div>
	</div>
	<div class="form-button" id="wizard-actions">
		<a class="btn btn-success" onclick="AcceptClick('Y')">提交</a>
	</div>
	</div>
</form>
<div id="menuContent" class="menuContent" style="display:none; position: absolute;z-index:99999;">
	<ul id="treeDemo" class="ztree" style="margin-top:0; width:197px; height: 300px;"></ul>
</div>
<div id="deptMenu" class="menuContent1" style="display:none; position: absolute;z-index:99999;">
	<ul id="deptTree" class="ztree" style="margin-top:0; width:197px; height: 300px;"></ul>
</div>
<div id="postMenu" class="menuContent2" style="display:none; position: absolute;z-index:99999;">
    <ul id="postTree" class="ztree" style="margin-top:0; width:197px; height: 300px;"></ul>
</div>
<!-- ztreejs -->
<script type="text/javascript" src="static/js/plugins/zTree_v3-master/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="static/js/plugins/zTree_v3-master/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="static/js/plugins/zTree_v3-master/js/jquery.ztree.exedit.js"></script>
</body>
</html>
<SCRIPT type="text/javascript">
    <!--
    var settingRole = {
        async: {
            enable: true,
            url:"${pageContext.request.contextPath}/admin/system/user/roleUserList_o.html",
            autoParam:["id"],
            otherParam:{"userId":""},
            dataFilter: filter
        },

        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                rootPId: "0"
            }
        },
        view: {
            dblClickExpand: false,
            nameIsHTML:true
        },
        callback: {
            onClick: onClick,
            onCheck: onCheck
        }
    };
    function filter(treeId, parentNode, childNodes) {
        if (!childNodes) return null;
        for (var i=0, l=childNodes.length; i<l; i++) {
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
        }
        return childNodes;
    }
    //
    function onClick(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }
    function onCheck(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
            nodes = zTree.getCheckedNodes(true);
        if(nodes!=""){
            var roleNames="";
            var roleIds="";
            for(var i=0;i<nodes.length;i++){
                roleNames=roleNames+nodes[i].name+",";
                roleIds=roleIds+nodes[i].id+",";
            }
            $("#roleNames").html(roleNames.substring(0,roleNames.length-1));
            $("#roleIds").val(roleIds.substring(0,roleIds.length-1));
        }else{
            $("#roleNames").html('');
            $("#roleIds").val('');
        }
    }

    function showMenu() {
        var cityObj = $("#roleNames");
        var cityOffset = $("#roleNames").offset();
        //$("#menuContent").css({left:"157.167px", top:"195px"}).slideDown("fast");
        $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
        $("body").bind("mousedown", onBodyDown);
    }
    function hideMenu() {
        $("#menuContent").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
    }
    function onBodyDown(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "roleNames" || event.target.id == "roleNames" || $(event.target).parents("#menuContent").length>0)) {
            hideMenu();
        }
    }
    //
    function setCheck() {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
        type = {"Y" : "ps", "N" : "ps"};
        zTree.setting.check.chkboxType = type;
    }



    /*部门树形菜单*/
    var setting1 = {
        async: {
            enable: true,
            url:"${pageContext.request.contextPath}/admin/system/dept/list_o.html?companyId="+$("#companyId").val(),
            autoParam:["id"],
            otherParam:{"checkIds":$("#deptIds").val()},
            dataFilter: filter1
        },
        check: {
            enable: true
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: "-1"
            }
        },
        view: {
            dblClickExpand: false,
            nameIsHTML:true
        },
        callback: {
            onClick: onClick1,
            onCheck: onCheck1
        }
    };
    function filter1(treeId, parentNode, childNodes) {
        if (!childNodes) return null;
        for (var i=0, l=childNodes.length; i<l; i++) {
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
        }
        return childNodes;
    }
    //
    function onClick1(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("deptTree");
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }
    function setCheck1() {
        var zTree = $.fn.zTree.getZTreeObj("deptTree");
        type = { "Y" : "", "N" : "" };
        zTree.setting.check.chkboxType = type;
    }
    function onCheck1(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("deptTree"),
            nodes = zTree.getCheckedNodes(true);

        if(nodes!=""){
            var deptNames ="";
            var deptIds ="";
            for(var i=0;i<nodes.length;i++){
                deptNames=deptNames+nodes[i].name+",";
                deptIds=deptIds+nodes[i].id+",";
            }
            $("#deptNames").html(deptNames.substring(0,deptNames.length-1));
            $("#deptIds").val(deptIds.substring(0,deptIds.length-1));
        }else{
            $("#deptNames").html('');
            $("#deptIds").val('');
        }

    }

    function showDept() {
        var cityObj = $("#deptNames");
        var cityOffset = $("#deptNames").offset();
        $("#deptMenu").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
        $("body").bind("mousedown", onBodyDown1);
    }
    function hideMenu1() {
        $("#deptMenu").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown1);
    }
    function onBodyDown1(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "deptNames" || event.target.id == "deptMenu" || $(event.target).parents("#deptMenu").length>0)) {
            hideMenu1();
        }
    }
    /*岗位树形菜单*/
    var setting2 = {
        async: {
            enable: true,
            url:"${pageContext.request.contextPath}/admin/system/post/list_o.html?companyId="+$("#companyId").val(),
            autoParam:["id"],
            otherParam:{"checkIds":$("#postIds").val()},
            dataFilter: filter2
        },
        check: {
            enable: true//,
            // chkStyle: "radio",
            // radioType: "all"
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: "-1"
            }
        },
        view: {
            dblClickExpand: false,
            nameIsHTML:true
        },
        callback: {
            onClick: onClick2,
            onCheck: onCheck2
        }
    };
    function filter2(treeId, parentNode, childNodes) {
        if (!childNodes) return null;
        for (var i=0, l=childNodes.length; i<l; i++) {
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
        }
        return childNodes;
    }
    //
    function onClick2(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("postTree");
        zTree.checkNode(treeNode, !treeNode.checked, null, true);
        return false;
    }
    function setCheck2() {
        var zTree = $.fn.zTree.getZTreeObj("postTree");
        type = { "Y" : "", "N" : "" };
        zTree.setting.check.chkboxType = type;
    }
    function onCheck2(e, treeId, treeNode) {
        var zTree = $.fn.zTree.getZTreeObj("postTree"),
            nodes = zTree.getCheckedNodes(true);

        if(nodes!=""){
            var postNames ="";
            var postIds ="";
            for(var i=0;i<nodes.length;i++){
                postNames=postNames+nodes[i].name+",";
                postIds=postIds+nodes[i].id+",";
            }
            $("#postNames").html(postNames.substring(0,postNames.length-1));
            $("#postIds").val(postIds.substring(0,postIds.length-1));
        }else{
            $("#postNames").html('');
            $("#postIds").val('');
        }

    }

    function showPost() {
        var cityObj = $("#postNames");
        var cityOffset = $("#postNames").offset();
        $("#postMenu").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
        $("body").bind("mousedown", onBodyDown2);
    }
    function hideMenu2() {
        $("#postMenu").fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown2);
    }
    function onBodyDown2(event) {
        if (!(event.target.id == "menuBtn" || event.target.id == "postNames" || event.target.id == "postMenu" || $(event.target).parents("#postMenu").length>0)) {
            hideMenu2();
        }
    }
    $(document).ready(function(){
        $.fn.zTree.init($("#treeDemo"), settingRole);
        $.fn.zTree.init($("#deptTree"), setting1);
        $.fn.zTree.init($("#postTree"), setting2);
        setCheck();
        setCheck1();
        setCheck2();
    });
    //-->
</SCRIPT>
<script>
    //保存表单
    function AcceptClick(sendStatus) {
        if ($("#username").val() == "") {
            top.dialogTop('请填写账号', 'error');
            return false;
        }
        if ($("#realName").val() == "") {
            top.dialogTop('请填写姓名', 'error');
            return false;
        }
        if ($("#mobile").val() == "") {
            top.dialogTop('请填写手机', 'error');
            return false;
        }
        <c:if test="${company.parentId!='-1'}">
        if ($("#deptId").val() == "") {
            top.dialogTop('请选择部门', 'error');
            return false;
        }
        </c:if>
        $.SaveForm({
            url: "${pageContext.request.contextPath}/admin/system/user/update_o.html",
            param: $('#myform').serialize(),
            loading: "提交",
            success: function () {
                $.currentIframe().$("#gridTable").trigger("reloadGrid");
            }
        })
    }
</script>
<script>
    $(function () {
        learun.childInit();
    })
</script>