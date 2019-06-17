<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HttpMessageConverter Demo</title>
</head>
<body>
<div id="resp"></div>
<input type="button" onclick="req()" value="请求"/>
<script src="/assets/jquery.js" type="text/javascript"></script>
<script>
    function req() {
        $.ajax({
            url: "convert",
            data: "1-lifeng",//数据格式"-"隔开
            type: "POST",
            contentType: "application/x-wisely", //自定义的媒体类型
            success: function (data) {
                $("#resp").html(data);
            }
        });
    }
</script>
</body>
</html>
