<%--
  Created by IntelliJ IDEA.
  User: Mary
  Date: 27.10.2016
  Time: 2:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
        <script>
            $(document).ready(function () {
                $('.space').on ('click', function() {
                    var clickId = this.id;
                    var val=clickId.valueOf();
                    var radio=findSelection("group1");
                    alert("Hoora1");
                    if (!(val=="X")&&!(val=="O")){
                        //ajaxComputerTurnRequest(filmName);
                        ('#XorO').append("Click_ID="+clickId+"; Val="+val+": Radio="+radio);
                    alert("Hoora2");
                    };

                });
             });
            function ajaxFilmRequest(term){
                $.ajax({
                    type: 'POST',
                    url: 'http://localhost:8080/loading',
                    data: {'field': clickId,'type':radio},
                    success: function(data){

                    }
                }
            else
                {
                    alert("Нет такого фильма:(")
                }
            }
            //


        </script>

        <title>TIC-TAC-TOE</title>

    </head>

                <body>
                Hello ${Nick}
                <div id="XorO">
                </div>
                <table border="4" bordercolor="#000000" cellspacing="0" cellpadding="0"
                width="300" height="300">

                        <caption>TIC-TAC-TOE</caption>

                        <tr><td class="space" id="1x1" align="center">${board[0][0]}</td>
                            <td class="space" id="1x2">${board[0][1]}</td>
                            <td class="space" id="1x3">${board[0][2]}</td></tr>

                        <tr><td class="space" id="2x1">${board[1][0]}</td>
                            <td class="space" id="2x2">${board[1][1]}</td>
                            <td class="space" id="2x3">${board[1][2]}</td></tr>

                        <tr><td class="space" id="3x1" >${board[2][0]}</td>
                            <td class="space" id="3x2">${board[2][1]}</td>
                            <td class="space" id="3x3">${board[2][2]}</td></tr>

                </table>
                <div>
                    Choose your side:<br>
                    <input type="radio" name="group1" value="X"> X<br>
                    <input type="radio" name="group1" value="O" checked> O
                </div>
                </body>

                </html>

