<%--
  Created by IntelliJ IDEA.
  User: Mary
  Date: 27.10.2016
  Time: 4:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>

    <script>
        $(document).ready(function () {
            $('#play').click(function () {
                var Nick = $("#PlayerNick").val();
                if (Nick.length > 0) {
                    var url = "/loading?Nick=" + Nick;
                    $(location).attr('href', url);
                }
                else {
                    alert("Enter your Nickname");
                }
            });
        });
    </script>

    <title>TIC_TAC_TOE_LOGIN</title>
</head>
<body>
<div>
    <input id="PlayerNick" type="text" placeholder="Enter your Nick"/>
    <input id="play" class="button" type="button" value="Play"/>
</div>
</body>
</html>
