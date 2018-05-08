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
    <title>外出登记</title>
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

    <script src="static/Content/scripts/utils/learun.js?v=AfeCneuZAYcYQ_oDc_NcFhRe318AoiA7nEzz08vcf9E1"></script>
    <script src="static/Content/scripts/plugins/tree/js?v=juUOPsC80vp0oU0mDF6kU_w_oqCesh68O0OtnzL7Wk81"></script>
    <script src="static/Content/scripts/plugins/validator/js?v=znSfnIdhHxxCqs-Qu0ubgsaRj2oDtXtihP0fEoemDWs1"></script>
    <script src="static/Content/scripts/plugins/wizard/js?v=B2NDCyjwoq-6l3qQjPYTbrSsjg6SllBIwuY10rqKT5g1"></script>
    <script src="static/Content/scripts/plugins/datepicker/js?v=B0RLtvjnn7QkPWLaYcMEAeEpC0XCKigX6gEmWC4zrKk1"></script>
    <script src="static/js/plugins/layer/laydate/laydate.js" type="text/JavaScript"></script>
    <link href="static/Content/jquery/plugin/scrollbar/jquery.mCustomScrollbar.min.css" rel="stylesheet" />
    <script src="static/Content/jquery/plugin/scrollbar/jquery.mCustomScrollbar.concat.min.js"></script>
    <style>html{width:100%;height:100%}body{margin:0;padding:0;width:100%;height:100%;font-family:微软雅黑,宋体,Arial,Helvetica,Verdana,sans-serif;color:#000;font-size:12px;background-color:initial;overflow:hidden}ul,li{list-style:none;margin:0;padding:0}a{color:#000;text-decoration:none}a:hover{color:#000;text-decoration:none}a:focus{outline:0;-moz-outline:0;color:#000;text-decoration:none}.form-control[disabled],.form-control[readonly],fieldset[disabled] .form-control{background-color:#fff;opacity:1}.btn-primary{color:#fff;background-color:#039cfd;border-color:#039cfd}.btn-primary:hover{color:#fff;background-color:#027dcb;border-color:#0277c1}.btn-primary:focus,.btn-primary.focus{color:#fff;background-color:#027dcb;border-color:#0277c1}.btn-primary:active,.btn-primary.active,.open>.btn-primary.dropdown-toggle{color:#fff;background-color:#027dcb;border-color:#0277c1;background-image:none}.btn-primary:active:hover,.btn-primary:active:focus,.btn-primary:active.focus,.btn-primary.active:hover,.btn-primary.active:focus,.btn-primary.active.focus,.open>.btn-primary.dropdown-toggle:hover,.open>.btn-primary.dropdown-toggle:focus,.open>.btn-primary.dropdown-toggle.focus{color:#fff;background-color:#0167a8;border-color:#014e7f}.btn-primary.disabled:focus,.btn-primary.disabled.focus,.btn-primary:disabled:focus,.btn-primary:disabled.focus{background-color:#039cfd;border-color:#039cfd}.btn-primary.disabled:hover,.btn-primary:disabled:hover{background-color:#039cfd;border-color:#039cfd}.btn-default{color:#373a3c;background-color:#fff;border-color:#ccc}.btn-default:hover{color:#373a3c;background-color:#e6e6e6;border-color:#adadad}.btn-default:focus,.btn-default.focus{color:#373a3c;background-color:#e6e6e6;border-color:#adadad}.btn-default:active,.btn-default.active,.open>.btn-default.dropdown-toggle{color:#373a3c;background-color:#e6e6e6;border-color:#adadad;background-image:none}.btn-default:active:hover,.btn-default:active:focus,.btn-default:active.focus,.btn-default.active:hover,.btn-default.active:focus,.btn-default.active.focus,.open>.btn-default.dropdown-toggle:hover,.open>.btn-default.dropdown-toggle:focus,.open>.btn-default.dropdown-toggle.focus{color:#373a3c;background-color:#d4d4d4;border-color:#8c8c8c}.btn-default.disabled:focus,.btn-default.disabled.focus,.btn-default:disabled:focus,.btn-default:disabled.focus{background-color:#fff;border-color:#ccc}.btn-default.disabled:hover,.btn-default:disabled:hover{background-color:#fff;border-color:#ccc}.btn-success{color:#fff;background-color:#1bb99a;border-color:#1bb99a}.btn-success:hover{color:#fff;background-color:#158c75;border-color:#13846e}.btn-success:focus,.btn-success.focus{color:#fff;background-color:#158c75;border-color:#13846e}.btn-success:active,.btn-success.active,.open>.btn-success.dropdown-toggle{color:#fff;background-color:#158c75;border-color:#13846e;background-image:none}.btn-success:active:hover,.btn-success:active:focus,.btn-success:active.focus,.btn-success.active:hover,.btn-success.active:focus,.btn-success.active.focus,.open>.btn-success.dropdown-toggle:hover,.open>.btn-success.dropdown-toggle:focus,.open>.btn-success.dropdown-toggle.focus{color:#fff;background-color:#106d5b;border-color:#0b4a3d}.btn-success.disabled:focus,.btn-success.disabled.focus,.btn-success:disabled:focus,.btn-success:disabled.focus{background-color:#1bb99a;border-color:#1bb99a}.btn-success.disabled:hover,.btn-success:disabled:hover{background-color:#1bb99a;border-color:#1bb99a}.btn-warning{color:#fff;background-color:#f1b53d;border-color:#f1b53d}.btn-warning:hover{color:#fff;background-color:#eaa211;border-color:#e19b10}.btn-warning:focus,.btn-warning.focus{color:#fff;background-color:#eaa211;border-color:#e19b10}.btn-warning:active,.btn-warning.active,.open>.btn-warning.dropdown-toggle{color:#fff;background-color:#eaa211;border-color:#e19b10;background-image:none}.btn-warning:active:hover,.btn-warning:active:focus,.btn-warning:active.focus,.btn-warning.active:hover,.btn-warning.active:focus,.btn-warning.active.focus,.open>.btn-warning.dropdown-toggle:hover,.open>.btn-warning.dropdown-toggle:focus,.open>.btn-warning.dropdown-toggle.focus{color:#fff;background-color:#c98b0e;border-color:#a3700c}.btn-warning.disabled:focus,.btn-warning.disabled.focus,.btn-warning:disabled:focus,.btn-warning:disabled.focus{background-color:#f1b53d;border-color:#f1b53d}.btn-warning.disabled:hover,.btn-warning:disabled:hover{background-color:#f1b53d;border-color:#f1b53d}.btn-danger{color:#fff;background-color:#ff5d48;border-color:#ff5d48}.btn-danger:hover{color:#fff;background-color:#ff3015;border-color:#ff270b}.btn-danger:focus,.btn-danger.focus{color:#fff;background-color:#ff3015;border-color:#ff270b}.btn-danger:active,.btn-danger.active,.open>.btn-danger.dropdown-toggle{color:#fff;background-color:#ff3015;border-color:#ff270b;background-image:none}.btn-danger:active:hover,.btn-danger:active:focus,.btn-danger:active.focus,.btn-danger.active:hover,.btn-danger.active:focus,.btn-danger.active.focus,.open>.btn-danger.dropdown-toggle:hover,.open>.btn-danger.dropdown-toggle:focus,.open>.btn-danger.dropdown-toggle.focus{color:#fff;background-color:#f01c00;border-color:#c81700}.btn-danger.disabled:focus,.btn-danger.disabled.focus,.btn-danger:disabled:focus,.btn-danger:disabled.focus{background-color:#ff5d48;border-color:#ff5d48}.btn-danger.disabled:hover,.btn-danger:disabled:hover{background-color:#ff5d48;border-color:#ff5d48}.col-lg-1,.col-lg-10,.col-lg-11,.col-lg-12,.col-lg-2,.col-lg-3,.col-lg-4,.col-lg-5,.col-lg-6,.col-lg-7,.col-lg-8,.col-lg-9,.col-md-1,.col-md-10,.col-md-11,.col-md-12,.col-md-2,.col-md-3,.col-md-4,.col-md-5,.col-md-6,.col-md-7,.col-md-8,.col-md-9,.col-sm-1,.col-sm-10,.col-sm-11,.col-sm-12,.col-sm-2,.col-sm-3,.col-sm-4,.col-sm-5,.col-sm-6,.col-sm-7,.col-sm-8,.col-sm-9,.col-xs-1,.col-xs-10,.col-xs-11,.col-xs-12,.col-xs-2,.col-xs-3,.col-xs-4,.col-xs-5,.col-xs-6,.col-xs-7,.col-xs-8,.col-xs-9{padding:0}.form-control{color:#000;border-radius:0;box-shadow:none;font-size:9pt;height:28px;padding-top:0;padding-bottom:1px;padding-right:0;padding-left:5px;resize:none}.form-control:focus{border-color:#039cfd;box-shadow:none}.btn.disabled,.btn[disabled],fieldset[disabled] .btn{pointer-events:none;cursor:not-allowed;filter:alpha(opacity=65);-webkit-box-shadow:none;box-shadow:none;opacity:.65}.dropdown-menu a{cursor:pointer}.mCSB_inside>.mCSB_container{margin-right:0}.mCSB_container{min-height:100%}.mCS-minimal-dark.mCSB_scrollTools_vertical{width:10px}.mCSB_container_wrapper>.mCSB_container{padding-right:0;padding-bottom:0}body{background-color:initial}.lr-form-bg{position:absolute;top:0;left:0;height:100%;width:100%;background-color:#fff;z-index:100}.lr-form-wrap{position:relative;width:100%;height:100%;padding:15px 30px 0 0}.lr-form-item{position:relative;min-height:38px;padding:5px 0 5px 100px}.lr-form-item-title{position:absolute;top:0;left:0;width:100px;height:100%;line-height:38px;text-align:right;padding-right:10px}.lr-form-item-title>font{position:absolute;top:0;right:2px;color:red}.lr-form-item .checkbox,.lr-form-item .radio{moz-user-select:none;-webkit-user-select:none;-ms-user-select:none;-khtml-user-select:none;user-select:none;margin-top:6px;margin-bottom:initial}.lr-form-item .checkbox input[type=checkbox],.lr-form-item .radio input[type=radio]{margin-top:3px;margin-left:-15px}.lr-form-item-grid{padding:10px 0 10px 40px;z-index:0}.lr-form-item-grid .jfgrid-layout{border:1px solid #ddd}.lr-input-underline{border:0;border-bottom:1px solid #ccc}.lr-select-underline{border-color:#fff!important;border-bottom:1px solid #ccc!important}.lr-input-button{position:absolute;right:0;top:0;width:16px;height:100%;line-height:28px;cursor:pointer;overflow:hidden;z-index:10}.lr-input-wdatepicker{background:url(/Content/images/datepicker_icon.png) right 0 no-repeat #FFF}.lr-input-wdatepicker.lr-field-error{background:0}.lr-form-btnitem{padding-right:80px}.lr-form-item-btn{position:absolute;top:4px;right:0;padding:4px 8px}.lr-form-layout{position:relative;width:100%;height:100%}.lr-form-layout-top-bottom{padding-top:44px}.lr-form-layout-header{position:absolute;top:0;left:0;height:44px;width:100%;padding:5px}.lr-form-layout-body{position:relative;width:100%;height:100%}.lr-form-layout-body-title{position:absolute;top:0;left:0;width:100%;height:30px;line-height:29px;background-color:#F5F5F5;border-bottom:1px solid #ccc;text-align:right;padding-right:10px;font-weight:bold;color:#676a6c}.lr-form-jfgrid-btns{position:absolute;height:100%;line-height:24px;top:0;left:0;padding-left:5px}.lr-form-jfgrid-btns .btn{padding:1px 4px}.lr-form-bottom-button{moz-user-select:none;-webkit-user-select:none;-ms-user-select:none;-khtml-user-select:none;user-select:none;position:absolute;height:39px;width:100%;left:0;bottom:0;text-align:right;padding:5px 5px 0 0;border-top:1px solid #eee;border-radius:0 0 4px 4px;background-color:#F8f8f8;z-index:3}.lr-form-bottom-button>.btn{padding:3px 10px}.lr-form-area>div{padding-right:2px}.lr-form-tab a{moz-user-select:none;-webkit-user-select:none;-ms-user-select:none;-khtml-user-select:none;user-select:none;cursor:pointer!important}.sys_spec_text{padding-left:15px;-moz-user-select:none;-webkit-user-select:none;-ms-user-select:none;-khtml-user-select:none;user-select:none}.sys_spec_text li{position:relative;outline:0;display:inline;float:left;height:46px;position:relative;margin:10px 10px 0 0;outline:0}.sys_spec_text li a{cursor:pointer;vertical-align:middle;text-align:center;word-break:keep-all;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;height:39px;line-height:38px;width:100px;text-align:center;padding:0;border:1px solid #ccc;border-radius:3px;background:#fff;display:inline-block;outline:0}.sys_spec_text li a:hover{padding:0;text-decoration:none}.sys_spec_text li.active a{color:#ff5d5b;border:1px solid #ff5d5b;padding:0;background:url(${pageContext.request.contextPath}/static/Content/images/selected_red.png) right top no-repeat}.lr-field-error{border-color:#ff5d48!important}.lr-field-error-info{position:absolute;top:8px;right:3px;color:#ff5d48;font-size:16px;background-color:#fff;cursor:pointer}.lr-form-btnitem .lr-field-error-info{right:83px}.lr-form-tabs{position:absolute;width:100%;height:44px;top:0;left:0;padding:5px 5px 0 5px}.lr-form-tabs li{white-space:nowrap;display:inline-block!important;float:initial;cursor:pointer}.lr-form-tabs .nav-tabs{white-space:nowrap}.lr-form-tabs .mCS-minimal-dark.mCSB_scrollTools_horizontal{top:32px}.lr-tab-content,.lr-tab-content>div{position:relative;width:100%;height:100%}.wizard{-moz-user-select:none;-webkit-user-select:none;-ms-user-select:none;-khtml-user-select:none;user-select:none;border:1px solid #ccc;border-radius:0;background-clip:padding-box;background-color:#fff;position:relative;overflow:hidden}.wizard.wizard-tabbed{background:#fbfbfb}.wizard.wizard-tabbed ul li{padding:0 30px;background-color:#fbfbfb}.wizard.wizard-tabbed ul li .chevron{display:none}.wizard.wizard-tabbed ul li .chevron:before{display:none}.wizard.wizard-tabbed ul li.complete{background-color:#fbfbfb}.wizard.wizard-tabbed ul li.active{background:#fff}.wizard.wizard-wired{padding-top:10px;display:block;background:#fff;text-align:center;-webkit-box-shadow:none;-moz-box-shadow:none;box-shadow:none;border-bottom:1px solid #eee}.wizard.wizard-wired ul{display:table;width:100%;position:relative}.wizard.wizard-wired ul li{display:table-cell;text-align:center;background-color:#fff;width:20%;padding:0;margin:0;-webkit-transition:all 1s ease;-moz-transition:all 1s ease;-o-transition:all 1s ease;transition:all 1s ease}.wizard.wizard-wired ul li .chevron{display:none}.wizard.wizard-wired ul li .chevron:before{display:none}.wizard.wizard-wired ul li.complete{background-color:#fff}.wizard.wizard-wired ul li.complete .step:before{font-size:22px;line-height:36px}.wizard.wizard-wired ul li.complete:hover{background-color:#fff}.wizard.wizard-wired ul li.active{background-color:#fff}.wizard.wizard-wired ul li .step{border-width:2px;width:40px;height:40px;line-height:34px;font-size:15px;z-index:2;background-color:#fff}.wizard.wizard-wired ul li .title{display:block;margin-top:4px;margin-bottom:6px;max-width:100%;font-size:14px;line-height:20px;z-index:104;text-align:center;table-layout:fixed;-ms-word-wrap:break-word;word-wrap:break-word}.wizard.wizard-wired ul li:before{display:block;content:"";width:100%;height:2px!important;font-size:0;overflow:hidden;background-color:#e5e5e5;position:relative!important;top:25px;z-index:1!important}.wizard.wizard-wired ul li:first-child:before{max-width:51%;left:50%}.wizard.wizard-wired ul li:last-child:before{max-width:50%;width:50%}.wizard ul{list-style:none outside none;padding:0;margin:0;width:4000px}.wizard ul.previous-disabled li.complete{cursor:default}.wizard ul.previous-disabled li.complete:hover{background:#f3f3f3;cursor:default}.wizard ul.previous-disabled li.complete:hover .chevron:before{border-left-color:#f3f3f3}.wizard ul li{float:left;margin:0;padding:0 20px 0 30px;line-height:46px;position:relative;background:#f5f5f5;color:#d0d0d0;font-size:16px;cursor:default;-webkit-transition:all .218s ease;-moz-transition:all .218s ease;-o-transition:all .218s ease;transition:all .218s ease}.wizard ul li .step{border:2px solid #e5e5e5;color:#ccc;font-size:13px;border-radius:100%;position:relative;z-index:2;display:inline-block;width:24px;height:24px;line-height:20px;text-align:center;margin-right:10px}.wizard ul li .chevron{border:24px solid transparent;border-left:14px solid #d4d4d4;border-right:0;display:block;position:absolute;right:-14px;top:0;z-index:1}.wizard ul li .chevron:before{border:24px solid transparent;border-left:14px solid #f5f5f5;border-right:0;content:"";display:block;position:absolute;right:1px;top:-24px;-webkit-transition:all .218s ease;-moz-transition:all .218s ease;-o-transition:all .218s ease;transition:all .218s ease}.wizard ul li.complete{background:#f5f5f5;color:#444}.wizard ul li.complete:before{display:block;content:"";position:absolute;bottom:0;left:0;right:-1px;height:2px;max-height:2px;overflow:hidden;background-color:#449d44;z-index:10}.wizard ul li.complete:hover{background:#eee;cursor:pointer}.wizard ul li.complete:hover .chevron:before{border-left:14px solid #eee}.wizard ul li.complete .chevron:before{border-left:14px solid #f5f5f5}.wizard ul li.complete .step{color:#449d44;border-color:#449d44}.wizard ul li.complete .step:before{display:block;position:absolute;top:0;left:0;bottom:0;right:0;line-height:20px;text-align:center;border-radius:100%;content:"";background-color:#fff;z-index:3;font-family:FontAwesome;font-size:12px;color:#449d44}.wizard ul li.active{background:#fff;color:#262626}.wizard ul li.active .step{border-color:#337ab7;color:#337ab7}.wizard ul li.active:before{display:block;content:"";position:absolute;bottom:0;left:0;right:-1px;height:2px;max-height:2px;overflow:hidden;background-color:#337ab7;z-index:10}.wizard ul li.active .chevron:before{border-left:14px solid #fff}.wizard ul li .badge{margin-right:8px}.wizard ul li:first-child{-webkit-border-radius:2px 0 0 0;-webkit-background-clip:padding-box;-moz-border-radius:2px 0 0 0;-moz-background-clip:padding;border-radius:2px 0 0 0;background-clip:padding-box;padding-left:20px}.actions{z-index:1000;position:absolute;right:0;line-height:42px;float:right;padding-left:8px;padding-right:8px;padding-bottom:4px;vertical-align:middle;border-left:1px solid #d4d4d4}.actions a{line-height:45px;font-size:12px;margin-right:8px}.actions .btn-prev i{margin-right:5px}.actions .btn-next i{margin-left:5px}.actions.actions-footer{margin-top:-10px;position:relative;float:none;text-align:right;border:0;background-color:#fff;-webkit-box-shadow:0 0 4px rgba(0,0,0,.3);-moz-box-shadow:0 0 4px rgba(0,0,0,.3);box-shadow:0 0 4px rgba(0,0,0,.3)}.step-content{border-top:0;background-clip:padding-box;padding:0;border:1px solid #ccc;border-top:0}.step-content .step-pane{display:none}.step-content .active{display:block}.step-content .active .btn-group .active{display:inline-block}.chart{height:220px;margin:5px}.chart-sm{height:100px}.chart-lg{height:250px}.chart-xl{height:350px}.widget-body{position:relative;height:100%;width:100%;padding:47px 0 39px 0;border-radius:0 0 4px 4px}.wizard{position:absolute;top:0;left:0;border:0;border-bottom:1px solid #eee;width:100%;height:47px;overflow:initial}.wizard ul li .chevron{top:-1px}.wizard ul li.active:before{bottom:-1px;background-color:#3498DB}.wizard ul li.complete:before{bottom:-1px;background-color:#1bb99a}.wizard ul li.complete .step{color:#1bb99a;border-color:#1bb99a}.wizard ul li.complete .step:before{color:#1bb99a}.wizard ul li.active .step{border-color:#3498DB;color:#3498DB}.step-content{border:0;position:relative;height:100%;width:100%}.step-pane{position:relative;height:100%;width:100%}.lr-tree{overflow-y:auto}.lr-tree ul,.lr-tree li{list-style-type:none;margin:0;padding:0}.lr-tree-icon,.lr-tree-ec-icon,.lr-tree-node-cb,.lr-tree-node-icon{border:0 none;height:18px;margin:0;padding:0;margin-top:3px;vertical-align:top;width:16px;background-repeat:no-repeat}.lr-tree-node-cb{height:16px;padding:2px;margin-top:4.5px;margin-right:5px}ul.lr-tree-node-ct{line-height:0;zoom:1}.lr-tree-node-expanded>.lr-tree-ec-icon{background-image:url(/Content/images/learuntree/arrows.gif)!important;background:transparent no-repeat -16px 0}.lr-tree-node-expanded>.lr-tree-ec-icon:hover{background:transparent no-repeat -48px 0}.lr-tree-node-collapsed>.lr-tree-ec-icon{background-image:url(/Content/images/learuntree/arrows.gif)!important;background:transparent no-repeat 0 0}.lr-tree-node-collapsed>.lr-tree-ec-icon:hover{background:transparent no-repeat -32px 0}.lr-tree-node{white-space:nowrap;color:#000}.lr-tree-node{color:#000}.lr-tree-node i{font-size:13px;width:13px;color:#666}.lr-tree-node a{text-decoration:none;-moz-user-select:none;-webkit-user-select:none;-ms-user-select:none;-khtml-user-select:none;user-select:none;-kthml-user-focus:normal;-moz-user-focus:normal;-moz-outline:0 none;outline:0 none}.lr-tree-node a span{text-decoration:none;padding:1px 3px 1px 2px}.lr-tree-node a:hover{text-decoration:none}.lr-tree-node .lr-tree-selected{background-color:#3498DB!important;color:#fff}.lr-tree-node .lr-tree-selected a span{color:#fff}.lr-tree-node .lr-tree-selected i{color:#fff}.lr-tree-node-el{position:relative;line-height:25px;cursor:default;cursor:pointer}.lr-tree-node-el:hover{background-color:#eee}.lr-tree-loading{position:absolute;top:3px;right:5px;display:none}.lr-tree-loading>img{height:14px;width:14px}.lr-select{position:relative;cursor:pointer;width:100%;height:28px;line-height:26px;border:1px solid #ccc;background:#fff url(/Content/images/learunselect/icon.png) no-repeat right center;padding-left:4px}.lr-select.lr-select-focus{border:1px solid #039cfd}.lr-select-placeholder{-moz-user-select:none;-webkit-user-select:none;-ms-user-select:none;-khtml-user-select:none;user-select:none;color:#999;overflow:hidden;white-space:nowrap;text-overflow:ellipsis}.lr-select-option{position:absolute;border:1px solid #dedede;width:100%;background:#fff;z-index:1;top:28px;left:-1px}.lr-select-option-content{position:relative;width:100%;overflow:auto}.lr-select-option .lr-selectitem-li{min-height:26px;line-height:26px;overflow:hidden;cursor:pointer;padding:0 5px;overflow:hidden;white-space:nowrap;text-overflow:ellipsis}.lr-select-option .lr-selectitem-li:hover{background-color:#eee}.lr-selectitem-li.selected{background-color:#3498DB!important;color:#fff}.lr-select-option-search{border-top:1px solid #ccc;position:absolute;border-bottom:0;left:0;height:25px;width:100%;line-height:24px}.lr-select-option-search>input{color:#000;border-radius:0;border:0;box-shadow:none;font-size:9pt;height:28px;padding-top:0;padding-bottom:1px;padding-right:0;padding-left:5px;resize:none;background-color:#fff;background-image:none;height:24px;line-height:1.42857143;margin:0;-webkit-transition:border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;-o-transition:border-color ease-in-out .15s,box-shadow ease-in-out .15s;transition:border-color ease-in-out .15s,box-shadow ease-in-out .15s;width:100%;outline:0;padding:0;padding-left:10px}.lr-select-option-search .input-query{position:absolute;right:4px;top:0;color:#ccc;font-size:16px;cursor:default}.lr-select-node-cb{border:0 none;margin:0;vertical-align:top;width:16px;height:16px;background-repeat:no-repeat;padding:2px;margin-top:4.5px;margin-right:5px}.lr-timeline{position:relative;width:100%;height:100%;padding:5px}.lr-timeline-allwrap{position:relative;width:100%;height:100%;padding:10px;background-color:#f0f3f4;color:#58666e}.lr-timeline ul{padding:0;margin:0}.lr-timeline-header,.lr-timeline-ender{display:block;width:290px;text-align:center}.lr-timeline-ender>div,.lr-timeline-header>div{display:inline-block;background-color:#5bc0de;padding:6px 12px;margin-bottom:0;font-size:14px;font-weight:400;line-height:1.42857143;text-align:center;white-space:nowrap;vertical-align:middle;-ms-touch-action:manipulation;touch-action:manipulation;cursor:pointer;-webkit-user-select:none;-moz-user-select:none;-ms-user-select:none;user-select:none;background-image:none;border:1px solid transparent;border-radius:4px;color:#fff}.lr-timeline-ender>div{background-color:#5cb85c}.lr-timeline-item{display:block}.lr-timeline-item:before,.lr-timeline-item:after{display:table;content:" "}.lr-timeline-wrap{display:block;position:relative;padding:15px 0 15px 20px;margin-left:143px;border-color:#dee5e7;border-style:solid;border-width:0 0 0 4px}.lr-timeline-wrap:hover:before{background:transparent;border-color:#fff}.lr-timeline-current{border-color:#5bc0de}.lr-timeline-wrap:before,.lr-timeline-wrap:after{display:table;content:" "}.lr-timeline-wrap:before{position:relative;top:15px;float:left;width:10px;height:10px;margin-left:-27px;background:#edf1f2;border-color:inherit;border-style:solid;border-width:3px;border-radius:50%;content:"";box-shadow:0 0 0 4px #f0f3f4}.lr-timeline-wrap:after{clear:both}.lr-timeline-date{display:block;position:absolute;top:25px;left:-143px;width:123px;text-align:right}.lr-timeline-content{position:relative;display:inline-block;padding:10px 15px;padding-bottom:0;background-color:#fff;border:1px solid #dee5e7;border-radius:2px;-webkit-box-shadow:0 1px 1px rgba(0,0,0,.05);box-shadow:0 1px 1px rgba(0,0,0,.05)}.lr-timeline-content .arrow{position:absolute;display:block;z-index:10;border-width:9px;border-color:transparent;border-style:solid;width:0;height:0;top:19px;left:-9px;margin-top:-9px;border-right-color:rgba(0,0,0,0.1);border-left-width:0}.lr-timeline-content .arrow:after{position:absolute;display:block;width:0;height:0;border-color:transparent;border-style:solid;border-width:8px;content:"";bottom:-8px;left:1px;border-right-color:#fff;border-left-width:0}.lr--timeline-title{margin-bottom:10px;color:#333}.lr--timeline-body{margin-left:-15px;margin-right:-15px;padding:15px;border-top:1px solid #edf1f2}.lr--timeline-body>span{color:#5bc0de;cursor:pointer}.lr-formselect{position:relative;width:100%;height:28px;line-height:26px;border:1px solid #ccc;padding-left:4px;cursor:pointer;color:#999}.lr-formselect.selected{color:#000}.lr-formselect>i{position:absolute;top:8px;right:2px;font-size:12px;color:#666}.clear-btn{position:absolute;top:0;right:0;height:100%;width:40px;background-color:#ccc;text-align:center;display:none}.clear-btn:hover{color:#666}.lr-formselect:hover>i{display:none}.lr-formselect:hover .clear-btn{display:block}.lr-isearch{position:relative;width:100%;height:100%}.lr-isearch-panel{position:absolute;top:28px;left:0;width:100%;border:1px solid #ccc;border-top:0;z-index:1;background:#fff;display:none}.lr-isearch-panel li{min-height:26px;line-height:26px;overflow:hidden;cursor:pointer;padding:0 5px}.lr-isearch-panel li:hover{background-color:#eee}.lrUploader-wrap{position:relative;height:30px;width:100%;padding-right:118px}.lrUploader-input{position:relative;height:100%;line-height:28px;width:100%;border:1px solid #ccc;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;padding-left:10px}.lrUploader-btn-group{position:absolute;top:0;right:0}.lrUploader-input-btn{padding:4px 12px;margin-left:5px}</style>
    <style>.form-warp{position:relative;width:100%;height:100%;padding-left:200px}.form-warp-left{position:absolute;left:0;top:0;width:200px;height:100%;padding-top:28px}.company-select{position:absolute;top:0;left:0;height:28px;width:100%;border:1px solid #ddd;border-top:0;border-left:0}.learun-select.learun-select-focus{border:1px solid #ddd;border-top:0;border-left:0}.learun-select-placeholder{padding-left:15px}.learun-select-option{border:0;border-bottom:1px solid #ddd}.department-tree{position:relative;height:100%;width:100%;border-right:1px solid #ddd}.form-warp-main{position:relative;height:100%;width:100%;padding-top:28px}.user-search{position:absolute;top:0;left:0;width:100%;height:28px;border-bottom:1px solid #ddd}.user-list{position:relative;height:100%;width:100%}.card-box{position:relative;float:left;width:185px;height:60px;border:1px solid #ccc;background-color:#fff;border-radius:3px;margin:10px 0 0 10px;padding-left:65px;padding-top:4px;overflow:hidden;-moz-user-select:none;-webkit-user-select:none;-ms-user-select:none;-khtml-user-select:none;user-select:none;cursor:pointer}.card-box.active{border:2px solid #ff5d5b;background:url(${pageContext.request.contextPath}/static/Content/images/selected_red.png) right top no-repeat}.card-box-img{position:absolute;left:0;top:0;width:59px;height:58px;line-height:58px;padding-left:9px;background-color:#ebebeb;border-right:1px solid #ccc}.card-box-img img{border-radius:45px}.card-box-content p{overflow:hidden;white-space:nowrap;text-overflow:ellipsis;margin:0}.form-warp-right{position:absolute;top:0;right:-180px;height:100%;width:180px;border-left:1px solid #ddd;padding-top:28px;background-color:#fff;z-index:10}.form-warp-right-close{position:absolute;top:7px;right:4px;width:12px;height:13px;display:block;background:url(${pageContext.request.contextPath}/static/Content/images/tab_close.png) no-repeat;cursor:pointer}.form-warp-right-close:hover{background-position:0 -12px}.form-warp-right-title{position:absolute;top:0;left:0;height:28px;line-height:27px;padding-left:10px;width:100%;border-bottom:1px solid #ddd;padding-right:80px}.selected-user-list-warp{position:relative;height:100%;width:100%}.user-selected-box{position:relative;width:160px;height:44px;border:1px solid #ccc;border-radius:4px;margin:auto;margin-top:10px;padding:5px 0 0 10px}.user-selected-box p{overflow:hidden;white-space:nowrap;text-overflow:ellipsis;margin:0}.user-reomve{position:absolute;top:2px;right:2px;width:12px;height:13px;display:block;background:url(${pageContext.request.contextPath}/static/Content/images/tab_close.png) no-repeat;cursor:pointer}.user-reomve:hover{background-position:0 -12px}.user-selected-btn{position:absolute;top:0;right:0;height:100%;width:80px;line-height:27px;text-align:center;border-left:1px solid #ddd;cursor:pointer;background-color:#eee;color:#666}.user-selected-btn:hover{color:#333}.form-control{border:0;height:100%}.input-query{position:absolute;right:86px;top:2px;color:#ccc;font-size:16px;cursor:pointer}</style>
    <link rel="stylesheet" href="static/js/plugins/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <style>
        .card-box-content{
            padding: 0;
        }
        .card-box.active{
            padding: 0 64px;
            padding-top: 4px;
        }

        .profile-nav li {
            line-height: 0px;
            padding-left: 3px;
            border-left: none;
        }
        .ztree li{
            margin-bottom: 5px;
        }
        .ztree li ul{
            margin-top: 5px;
        }
        .ztree li a.curSelectedNode {
            background-color:#5965b1;
            border:1px #5965b1 solid;
            color: #fff;
        }
        .line{
            position: static;
        }
        .company-select{
            line-height: 28px;
            width: 100%;
            padding-left: 5%;
        }
    </style>
</head>
<body class="Firefox 59.0 lr-uitheme-top">
<div id="ajaxLoader" style="cursor: progress; position: fixed; top: -50%; left: -50%; width: 200%; height: 200%; background: #f1f1f1; z-index: 10000; overflow: hidden;">
</div>
<form id="myform">
    <input type="hidden" name="id" id="id" value="${post.id}" >
    <input type="hidden" name="companyId" id="companyId" value="${company.id}" >
    <input type="hidden" name="companyName" id="companyName" value="${company.name}" >
    <div id="lr_form_bg" class="lr-form-bg">
    <div class="form-warp">
        <div class="form-warp-left" style="width:250px;">
            <div id="company_select" class="company-select">${company.name}</div>
            <div style="height:90%;" id="treeDemoHd">
                <div id="treeDemo" class="ztree department-tree"></div>
            </div>

            <%--<div id="department_tree" class="department-tree">
                <ul id="treeDemo" class="ztree" style="height:600px;border:none;width:100%"></ul>
            </div>--%>
            <%--<ul id="treeDemo" class="ztree" style="height:600px;border:none;width:100%"></ul>--%>
        </div>
        <div class="form-warp-main" style="padding-left:6%">
            <div class="user-search">
                <div class="user-selected-btn" id="user_selected_btn">已选人员</div>
            </div>
            <div id="user_list_warp" class="user-list" style="height:90%;">
                <div id="user_list">

                </div>
            </div>
        </div>
        <div class="form-warp-right" id="form_warp_right">
            <div class="form-warp-right-title">已选人员<span class="form-warp-right-close" id="user_selected_btn_close" title="关闭"></span></div>
            <div class="selected-user-list-warp" id="selected_user_list_warp" style="height:90%;">
                <div id="selected_user_list" >
                    <c:forEach items="${post.userList}"  begin="0" var="item" varStatus="status">
                        <div class="user-selected-box" data-value="${item.userId }">
                            <p><span data-id="${post.companyId}">${post.company.name}</span></p>
                            <p><span data-id="${post.deptId}">${post.dept.name}</span>【${item.realName}】</p>
                            <span class="user-reomve" title="移除选中人员"></span>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

    </div>

    <div class="form-button" id="wizard-actions">
        <a class="btn btn-success" onclick="AcceptClick('Y')">提交</a>
    </div>
 </div>
</form>
<!-- 上传js -->
<script type="text/javascript" src="static/js/mywebupload/upload.js"></script>
<script type="text/javascript" src="static/js/plugins/zTree_v3-master/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="static/js/plugins/zTree_v3-master/js/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="static/js/plugins/zTree_v3-master/js/jquery.ztree.exedit.js"></script>
</body>
</html>
<script>
    //保存表单
    function AcceptClick(sendStatus) {
        var userIds ="";
        $("#selected_user_list").find(".user-selected-box").each(function(){
            userIds += $(this).attr("data-value")+",";
        });
        if(userIds.length>0){
            userIds=userIds.substring(0,userIds.length-1) ;
        }
        $.SaveForm({
            url: "${pageContext.request.contextPath}/admin/system/post/addUser_o.html?userIds="+userIds,
            param: $('#myform').serialize(),
            loading: "提交",
            success: function () {
                $.currentIframe().$("#gridTable").trigger("reloadGrid");
            }
        })
        //dialogClose();
    }

    $("#user_selected_btn").on("click", function() {
        $("#form_warp_right").animate({
            right: "0px"
        }, 300)
    });
    $("#user_selected_btn_close").on("click", function() {
        $("#form_warp_right").animate({
            right: "-180px"
        }, 300)
    });
    $("#user_list_warp").mCustomScrollbar({
        theme: "minimal-dark"
    });
    $("#treeDemoHd").mCustomScrollbar({
        theme: "minimal-dark"
    });
    $("#selected_user_list_warp").mCustomScrollbar({
        theme: "minimal-dark"
    })
</script>
<script>
    $(function () {
        learun.childInit();
    })
</script>
<script>
    (function ($, learun) {
        $(function () {
            learun.childInit();
            $.fn.zTree.init($("#treeDemo"), setting);
        })
    })(window.jQuery, window.learun)
    var setting = {
        async: {
            enable: true,
            url:"${pageContext.request.contextPath}/admin/system/dept/list_o.html?companyId="+$("#companyId").val(),
            autoParam:["id"],
            dataFilter: filter
        },

        check: {
            //enable: true,
            //chkStyle: "radio",
            //radioType: "all"
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "parentId",
                rootPId: "-1"
            }
        },
        callback: {
            onAsyncSuccess : ztreeOnAsyncSuccess,//异步加载成功后执行的方法
            onClick: onClick
        },

        view:{
            nameIsHTML:true
        }
    };
    function filter(treeId, parentNode, childNodes) {
        if (!childNodes) return null;
        for (var i=0, l=childNodes.length; i<l; i++) {
            childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
        }
        return childNodes;
    }

    function setCheck() {
        var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
            type = {"Y" : "ps", "N" : "ps"};
        zTree.setting.check.chkboxType = type;
    }

    function onClick(event, treeId, treeNode, clickFlag) {
        //如果选中
        if(clickFlag=='1'){
            reloadList(treeNode.id);
        }
    }

    //获取树成功后进行的回调操作
    function ztreeOnAsyncSuccess(event, treeId, treeNode) {
        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
        var nodes = treeObj.getNodes();
        var node = nodes[0];
        if(node!=null){
            treeObj.selectNode(node);
            reloadList(node.id);
        }
    }
    function reloadList(deptId){
        var content ="";
        $.ajax({
            url: "${pageContext.request.contextPath}/admin/system/user/getList_o.html",
            data:'deptId='+deptId+'&time='+new Date(),
            type:'post',
            dataType: "json",
            success: function(data, status, xhr){
                if(data!=null && data.length>0){
                    $.each(data, function(index, obj){
                        var sexPath="${pageContext.request  .contextPath}/static/Content/images/UserCard01.png";
                        if(obj.sex && obj.sex=='男'){
                            sexPath="${pageContext.request  .contextPath}/static/Content/images/UserCard02.png";
                        }
                        var divClass="card-box";
                        var flag =false ;
                        //判断已选用户列表是否存在，存在的话有active样式，并且不追加到已选列表
                        $("#selected_user_list").find(".user-selected-box").each(function(){
                            if($(this).attr("data-value")==obj.userId){
                                flag =true ;
                                return false ;
                            }
                        });
                        if(flag){
                            divClass="card-box active";
                        }

                        content = content+"<div class='"+divClass+"' data-value='"+obj.userId+"'>" +
                            "<div class='card-box-img'> <img src='"+sexPath+"'> </div><div class='card-box-content'>" +
                            "<p>账户："+obj.username+"</p><p>姓名："+obj.realName+"</p>" +
                            // "<p>部门：<span data-id='"+"123"+"'>"+"123"+"</span>" +
                            "</p></div></div>";
                        $("#user_list").html(content);
                    });
                }else{
                    $("#user_list").html("");
                }
                $('.card-box').on('click',function(){
                    var userId = $(this).attr('data-value') ;
                    var realName =  (($(this).find("p").eq(1).html()).split("："))[1].trim() ;
                    var deptId =  $(this).find("p").eq(2).find("span").attr("data-id") ;
                    var deptName =  $(this).find("p").eq(2).find("span").html() ;
                    var companyId = $("#companyId").val() ;
                    var companyName = $("#companyName").val() ;

                    //判断是否选中
                    if(!$(this).hasClass("active")){
                        //添加选中
                        $(this).addClass("active")
                        //给选中用户div赋值
                        var content = "<div class='user-selected-box' data-value='"+userId+"'>" +
                            "<p><span data-id='"+companyId+"'>"+companyName+"</span></p>" +
                            "<p>" +
                            //"<span data-id='"+deptId+"'>"+deptName+"</span>" +
                            "【"+realName+"】</p>" +
                            "<span class='user-reomve' title='移除选中人员' ></span></div>";
                        $("#selected_user_list").append(content) ;
                        //已选用户列表退回到初选状态
                        $('.user-reomve').on('click',function(){
                            var selectUserid = $(this).parent().attr("data-value").trim();
                            //判断用户列表是否拥有，有的话移除active 样式
                            $("#user_list").find(".card-box").each(function(){
                                if($(this).attr("data-value")==selectUserid){
                                    $(this).removeClass("active") ;
                                }
                            });
                            //移除
                            $(this).parent().remove() ;
                        });
                    }else{
                        //移除选中
                        $(this).removeClass("active");
                        //移除元素
                        $("#selected_user_list").find(".user-selected-box").each(function(){
                            if($(this).attr("data-value")==userId){
                                $(this).remove() ;
                            }
                        });
                    }
                });
            }
        });
    }
    $('.user-reomve').on('click',function(){
        var selectUserid = $(this).parent().attr("data-value").trim();
        //判断用户列表是否拥有，有的话移除active 样式
        $("#user_list").find(".card-box").each(function(){
            if($(this).attr("data-value")==selectUserid){
                $(this).removeClass("active") ;
            }
        });
        //移除
        $(this).parent().remove() ;
    });
</script>
