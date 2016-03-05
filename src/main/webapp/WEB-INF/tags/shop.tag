<%@tag pageEncoding="utf-8" %>
<%@ attribute name="title" %>
<%@ attribute name="navbar" fragment="true" required="true" %>
<%@ attribute name="body" fragment="true" required="true" %>
<%@ attribute name="script" fragment="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="keywords" content="美食社交,美食商店,Moon Plan,收藏,精选"/>
    <meta name="description" content="Moon Plan 是一款专注于美食发现,分享,购买的软件产品."/>
    <title>${title}</title>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/img/index.png"
          rel="shortcut icon" type="image/vnd.microsoft.icon">
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/bootstrap.min.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/font-awesome.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/se7en-font.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/isotope.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/jquery.fancybox.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/fullcalendar.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/wizard.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/select2.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/morris.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/datatables.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/datepicker.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/timepicker.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/colorpicker.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/bootstrap-switch.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/daterange-picker.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/typeahead.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/summernote.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/pygments.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/style.css"
          media="all" rel="stylesheet" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/color/green.css"
          media="all" rel="alternate stylesheet" title="green-theme" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/color/orange.css"
          media="all" rel="alternate stylesheet" title="orange-theme" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/color/magenta.css"
          media="all" rel="alternate stylesheet" title="magenta-theme" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/color/gray.css"
          media="all" rel="alternate stylesheet" title="gray-theme" type="text/css"/>
    <link href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/css/responsive-nav.css"
          media="all" rel="alternate stylesheet" title="gray-theme" type="text/css"/>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery-ui.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/raphael.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/selectivizr-min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.mousewheel.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.vmap.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.vmap.sampledata.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.vmap.world.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.bootstrap.wizard.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/fullcalendar.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/gcal.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.dataTables.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/datatable-editable.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.easy-pie-chart.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/excanvas.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.isotope.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/isotope_extras.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/modernizr.custom.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.fancybox.pack.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/select2.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/styleswitcher.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/wysiwyg.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/summernote.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.inputmask.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.validate.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap-fileupload.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap-datepicker.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap-timepicker.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap-colorpicker.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/bootstrap-switch.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/typeahead.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/daterange-picker.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/date.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/morris.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/skycons.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/fitvids.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/jquery.sparkline.min.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/main.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/respond.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/echarts.js"
            type="text/javascript"></script>
    <script src="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/js/responsive-nav.js"
            type="text/javascript"></script>
    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" name="viewport">
</head>
<body>
<div id="moonShopNav">
    <jsp:invoke fragment="navbar"/>
</div>
<div id="moonShopBody">
    <jsp:invoke fragment="body"/>
</div>
<body>

