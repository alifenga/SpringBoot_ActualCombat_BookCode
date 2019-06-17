<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSE Demo</title>
</head>
<body>
<div id="msgFrompPush"></div>
<script src="/assets/jquery.js" type="text/javascript"></script>
<script type="text/javascript">
    //SSE对象只有新式的浏览器支持,EventSource是SSE的客户端
    if (!!window.EventSource) {
        var source = new EventSource('push');
        var s = '';
        //添加监听,获得服务端推送的消息
        source.addEventListener('message', function (evt) {
            s += evt.data + "<br/>";
            $("#msgFrompPush").html(s);
        });

        source.addEventListener('open', function (evt) {
            console.log("连接打开");
        }, false);

        source.addEventListener('error', function (evt) {
            if (evt.readyState == EventSource.CLOSED) {
                console.log("连接关闭");
            } else {
                console.log(evt.readyState);
            }
        }, false);

    } else {
        console.log("你的浏览器不支持SSE");
    }
</script>
</body>
</html>
