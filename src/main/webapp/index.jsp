<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>用友超客</title>
    <link href="css/normalize.css" rel="stylesheet" type="text/css">
    <link href="addon/swiper/swiper.3.1.2.min.css" rel="stylesheet" type="text/css">
    <style type="text/css">
        html, body {
            position: relative;
            height: 100%;
        }

        body {
            font-family: "微软雅黑", "黑体";
            font-size: 14px;
            color: #000;
            margin: 0;
            padding: 0;
        }

        a {
            text-decoration: none;
        }

        img {
            vertical-align: middle;
        }

        .swiper-container {
            width: 100%;
            height: 100%;
        }

        .swiper-slide {
        }

        /*.swiper-slide { text-align: center; font-size: 18px; background: #fff;
        display: -webkit-box; display: -ms-flexbox; display: -webkit-flex; display: flex; -webkit-box-pack: center; -ms-flex-pack: center; -webkit-justify-content: center; justify-content: center; -webkit-box-align: center; -ms-flex-align: center; -webkit-align-items: center; align-items: center; }
        */
        .container {
            margin: 0 auto;
            width: 1200px;
        }

        .relative {
            position: relative;
        }

        .bg1 {
            background: url(images/bg1.jpg) no-repeat center center;
            background-size: cover;
        }

        .bg2 {
            background: url(images/bg2.jpg) no-repeat center center;
            background-size: cover;
        }

        .bg4 {
            background: url(images/bg4.jpg) no-repeat center center ;
            background-size: cover;
        }

        .header {
            position: absolute;
            top: 0px;
            left: 0px;
            width: 100%;
            z-index: 999;
            background: rgba(255, 255, 255, 0.9);
        }

        .nav {
            position: absolute;
            top: 0px;
            right: 0px;
        }

        .nav ul {
            padding: 0px;
            list-style: none;
        }

        .nav li {
            display: inline-block;
        }

        .nav li a {
            margin-left: 35px;
            font: 16px/36px "微软雅黑", "黑体";
            text-decoration: none;
            color: #000000;
        }

        .footer {
            position: absolute;
            bottom: 0px;
            left: 0px;
            padding: 10px 0;
            width: 100%;
            z-index: 999;
            background: rgba(0, 0, 0, 0.8);
        }

        .footer .left {
            position: relative;
            font: 16px/22px "微软雅黑", "黑体";
            color: #ffffff;
        }

        .left .tip {
            position: absolute;
            top: -140px;
            left: 0px;
            display: none;
        }

        .tipbox {
            display: inline-block;
        }

        .tipbox:hover .tip {
            display: block;
        }

        .footer .left img {
            vertical-align: middle;
            margin-right: 5px;
        }

        .footer .right {
            position: absolute;
            top: -5px;
            right: 0px;
            text-align: right;
            font: 12px/18px "宋体";
            color: #999999;
        }

        .footer .copy {
            font-family: Arial;
        }

        .part1 {
            position: absolute;
            top: 35%;
            width: 100%;
            text-align: center;
        }

        .part11 {
             position: absolute;
             top: 30%;
             margin-left: 6%;
         }

        .part12 {
            position: absolute;
            top: 45%;
            margin-left: 75%;
        }

        .part13 {
            position: absolute;
            top: 55%;
            margin-left: 2%;
        }


        .font1 {
            font: 45px/72px "微软雅黑", "黑体";
            color: #ffffff;
        }

        .font2 {
            font: 24px/42px "微软雅黑", "黑体";
            color: #ffffff;
        }

        .font3 {
            margin-top: 30px;
        }

        .font3 a {
            font: 18px/36px "微软雅黑", "黑体";
            color: #1fadff;
        }

        .font3 a img {
            margin-left: 5px;
            vertical-align: middle;
        }

        .part2 {
            position: absolute;
            left: 50%;
            top: 35%;
            padding-left: 50px;
            width: 50%;
        }

        .part3 {
            position: absolute;
            left: 60%;
            top: 30%;
            padding-left: 50px;
            width: 50%;
        }

        .font4 {
            font: 45px/72px "微软雅黑", "黑体";
            color: #49b5d0;
        }

        .font5 {
            font: 26px/42px "微软雅黑", "黑体";
            color: red;
        }

        .font6 {
            margin-top: 30px;
        }

        .font6 a {
            font: 18px/36px "微软雅黑", "黑体";
            color: #3d3d3d;
        }

        .font7 {
            font: 18px/36px "微软雅黑", "黑体";
            color: #3d3d3d;
        }

        /*video-dialog*/
        .ui-overlay {
            position: fixed;
            top: 0;
            left: 0;
            bottom: 0;
            right: 0;
            display: none;
            width: 100%;
            height: 100%;
            filter: progid:DXImageTransform.Microsoft.gradient(enabled='true', startColorstr='#99000000', endColorstr='#99000000');
            background-color: rgba(0, 0, 0, .6);
            z-index: 10000
        }

        .ui-dialog-video {
            position: absolute;
            top: 50px;
            left: 50%;
            z-index: 10001;
            display: none;
            margin-left: -430px;
            background-color: #fff
        }

        .ui-dialog-wrap {
            width: 860px;
            height: 524px
        }

        .ui-dialog-video span em,
        .ui-dialog-video span i {
            display: block;
            position: absolute;
            height: 0;
            width: 0;
            border-width: 11px;
            border-style: solid;
            border-color: #fff #000 red #0f0
        }

        .ui-dialog-video .ui-close {
            position: absolute;
            top: 0;
            right: -50px;
            width: 50px;
            height: 50px;
            background-color: #0a0a0a;
            z-index: 10002;
            cursor: pointer;
            text-align: center
        }

        .ui-dialog-video .ui-close:hover {
            background-color: #ffa414;
            color: #fff
        }

        .ui-dialog-video .ui-close span em,
        .ui-dialog-video .ui-close span i {
            border-width: 15px
        }

        .ui-dialog-video .ui-close .close-down,
        .ui-dialog-video .ui-close .close-up {
            display: block;
            position: absolute;
            top: 10px;
            left: 10px
        }

        .ui-dialog-video .ui-close:hover .close-up em {
            border-bottom-color: #fff
        }

        .ui-dialog-video .ui-close:hover .close-up i {
            border-bottom-color: #ffa414
        }

        .ui-dialog-video .ui-close:hover .close-down em {
            border-top-color: #fff
        }

        .ui-dialog-video .ui-close:hover .close-down i {
            border-top-color: #ffa414
        }

        .ui-dialog-video .arror-up em {
            border-color: transparent transparent #666
        }

        .ui-dialog-video .arror-up i {
            border-color: transparent transparent #0a0a0a;
            top: 2px
        }

        .ui-dialog-video .arror-down em {
            border-color: #666 transparent transparent;
            top: 2px
        }

        .ui-dialog-video .arror-down i {
            border-color: #0a0a0a transparent transparent;
            top: 0
        }

        .wh100 {
            display: block;
            width: 100%;
            height: 100%;
        }
    </style>
    <script src="http://siteapp.baidu.com/static/webappservice/uaredirect.js" type="text/javascript"
            charset="UTF-8"></script>
    <script type="text/javascript">uaredirect("http://c.yonyouup.com");</script>

</head>

<body>
<!--header-->
<div class="header">
    <div class="container relative">
        <div class="logo"><a href="index.html"><img src="http://chaoke.yonyouup.com/images/logo.png" width="101"
                                                    height="73" alt=""/></a></div>
        <div class="nav">
            <ul>
                <li><a href="/yongyouy/index.jsp">首页</a></li>
                <li><a href="http://upesn.com/s/index/index/?s=0bme4g" target="_blank">企业空间</a></li>
                <li><a href="http://chaoke.yonyouup.com/yingxiao.html">超客营销</a></li>
                <!--<li><a href="system/index.php?s=/Home/Article/lists/category/default_news.html">新闻活动</a></li>-->
                <li><a href="http://chaoke.yonyouup.com/guanyuwomen.html">关于我们</a></li>
                <!--<li><a href="zhaomu.html">伙伴招募</a></li>-->
            </ul>
        </div>
    </div>
</div>
<!-- Swiper -->
<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide bg1">
            <div class="part1">
                <div class="font1">社会化商业平台 企业空间</div>
                <div class="font2">链接企业内部、上下游伙伴与客户的社会化协同工作和商业平台
                </div>
                <div class="font3"><a href="http://upesn.com/s/index/index/?s=0bme4g" target="_blank">了解详情<img src="http://chaoke.yonyouup.com/images/icon4.png" width="18" height="18" alt=""/></a></div>
            </div>
            <div class="part11" >
                <img src="images/111.jpg" style="height: 200px;width: 200px">
                <div class="font2">&nbsp;&nbsp;扫一扫立即体验</div>
            </div>
        </div>
        <div class="swiper-slide bg2">
            <div class="part2">
                <div class="font4">连接我的客户 超客营销</div>
                <div class="font5" style="color: #49b5d0;">快感 · 社交 · 实时</div>
                <div class="font6"><a href="http://chaoke.yonyouup.com/yingxiao.html">了解详情 &gt;</a></div>
                <br/>
                <br/>
                <div class="font7">扫一扫右侧二维码<br/>
                    马上体验超客营销
                </div>
            </div>
            <div class="part12" >
                <img src="images/yixiao.png" style="height: 220px;width: 220px">

            </div>
        </div>
        <div class="swiper-slide bg4">
            <div class="part13">
                <div class="font5" style="color:black">诚邀代理：<br/>
                    联系人：杨先生 <br/>
                    联系电话：13605704346 <br/>
                    联系邮箱：yangmings@yonyou.com
                </div>

            </div>
           <%-- <a href="" class="wh100"></a>--%>
        </div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
</div>
<!--footer-->
<div class="footer">
    <div class="container relative">
        <div class="left">
            <div class="tipbox">
                <img src="http://chaoke.yonyouup.com/images/icon1.png" width="27" height="27" alt=""/>

                <div class="tip"><img src="http://chaoke.yonyouup.com/images/erweima.png"/></div>
            </div>
            <img src="http://chaoke.yonyouup.com/images/icon2.png" width="27" height="27" alt=""/>Tel: 0571-87178126
        </div>
        <div class="right">用友超客网络科技有限公司浙江区
            总经理 曹运金
            联系电话：0571-87178126
            邮箱：cyj@yonyou.com
            公司地址：浙江省杭州市西湖区西溪路浙大科技园A楼东区5楼
            <br><span class="copy">&copy;</span> Copyright 2015 用友超客网络科技有限公司
            京ICP备号
        </div>
    </div>
</div>

<div class="ui-overlay"></div>
<div class="ui-dialog-video">
    <div id="youkuplayer" class="ui-dialog-wrap"></div>
    <div class="ui-close"><span class="close-down arror-down"><em></em><i></i></span> <span
            class="close-up arror-up"><em></em><i></i></span></div>
</div>

<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script type="text/javascript" src="addon/swiper/swiper.3.1.2.jquery.min.js"></script>
<script type="text/javascript" src="http://player.youku.com/jsapi"></script>
<script type="text/javascript" language="javascript">
    var swiper = new Swiper('.swiper-container', {
        pagination: '.swiper-pagination',
        paginationClickable: true,
        direction: 'vertical',
        mousewheelControl: true
    });

    var $overlay = $('.ui-overlay'),
            $video = $('.ui-dialog-video'),
            ykuPlayer;

    $('.ui-overlay, .ui-close').click(function () {
        hideVideo();
    });
    $(".j-video").click(function () {
        ykuPlayer || (ykuPlayer = new YKU.Player('youkuplayer', {
            styleid: '0',
            client_id: '333c365a139d6332',
            vid: 'XMTI1NDQ4NDI0NA',
            autoplay: true
        }));
        showVideo();
    });
    function showVideo() {
        $overlay.show();
        $video.show();
    }
    function hideVideo() {
        $overlay.hide();
        $video.hide();
    }
</script>
</body>
</html>
