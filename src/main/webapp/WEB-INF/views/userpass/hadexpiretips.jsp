<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>密码已过期</title>
    <style type="text/css">
        html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p, blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn, em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var, b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend, table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas, details, embed, figure, figcaption, footer, header, hgroup, menu, nav, output, ruby, section, summary, time, mark, audio, video {
            margin: 0;
            padding: 0;
            border: 0;
            font-size: 100%;
            font: inherit;
            vertical-align: baseline;
        }

        article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section {
            display: block;
        }

        body, html {
            background: #fff;
        }

        ol, ul {
            list-style: none;
        }

        blockquote, q {
            quotes: none;
        }

        blockquote:before, blockquote:after, q:before, q:after {
            content: "";
            content: none;
        }

        table {
            border-collapse: collapse;
            border-spacing: 0;
        }

        th, td {
            font-weight: 400;
        }

        em {
            font-style: normal;
        }

        strong {
            font-weight: 700;
        }

        body {
            font: normal 12px/1.5 arial, sans-serif;
            background: #fff;
            color: #333;
            -webkit-font-smoothing: antialiased;
            -webkit-text-size-adjust: 100%;
        }

        h1, h2, h3, h4, h5, h6 {
            font-size: 100%;
            font-weight: 400;
        }

        a {
            color: #0069ca;
            text-decoration: none;
            cursor: pointer;
        }

        a:hover {
            color: #f60;
            text-decoration: none;
        }

        html, body {
            background: #effbff;
        }

        .login {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 400px;
            padding: 20px 10px;
            margin: -50px 0 0 -200px;
            border: 1px solid #b9e0f0;
            background: #fff;
            line-height: 140%;
        }

        .login .msg {
            text-align: center;
            padding: 5px;
            margin: 0 20px;
            border: 1px solid #ffb2b2;
            background: #fff3f3;
            color: #f00;
        }

        .login .btns {
            text-align: center;
        }

        .login .timer {
            text-align: center;
        }

        .login .loginbtn {
            display: inline-block;
            margin-top: 20px;
            padding: 2px 15px;
            color: #cfebf3;
            font: 16px/140% 'Microsoft Yahei', sans-serif;
            border: 1px solid #095B7E;
            border-radius: 10px;
            -moz-border-radius: 10px;
            -webkit-border-radius: 10px;
            background: #00A0D1;
            background: -moz-linear-gradient(top, #00A0D1 0%, #008DB8 100%);
            background: -webkit-gradient(linear, left top, left bottom, color-stop(0%, #00A0D1), color-stop(100%, #008DB8));
            background: -webkit-linear-gradient(top, #00A0D1 0%, #008DB8 100%);
            background: -o-linear-gradient(top, #00A0D1 0%, #008DB8 100%);
            background: -ms-linear-gradient(top, #00A0D1 0%, #008DB8 100%);
            background: linear-gradient(top, #00A0D1 0%, #008DB8 100%);
            _filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00A0D1', endColorstr='#008DB8', GradientType=0);
            cursor: pointer;
        }
    </style>
</head>
<body>
<div class="login">
    <!-- 有倒计时的 -->
    <div class="msg">您的密码已过期，请修改密码</div>
    <div class="btns">
        <a class="loginbtn" href="${url}" id="j_url" onclick="return doHref(this);">修改密码</a>
    </div>
    <div class="timer"><span id="j_timer">5</span>秒后自动跳转修改密码页面</div>
    <script>
        function doHref(obj) {
            top.location.href = obj.href;
            return false;
        }
        var timer = 5;
        function $E(id) {
            return document.getElementById(id);
        }
        function timerCount() {
            if (timer == 0) {
                top.location.href = $E('j_url').href;
                return;
            } else {
                $E('j_timer').innerHTML = timer;
                setTimeout(timerCount, 1000);
            }
            timer--;
        }
        timerCount();
    </script>
</div>
</body>
</html>