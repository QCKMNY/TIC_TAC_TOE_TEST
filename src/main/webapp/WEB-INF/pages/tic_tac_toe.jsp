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
            $(document).on('click', '.space', function () { //функция при нажатии на ячейку
                var Nick = $('#Nickname').text();//TODO make Cookie
                console.log(Nick);
                var clickID = this.id; // получаем ид ячейки
                console.log(clickID);
                var val = $(this).text();//значение ячейки
                var XorO = $("input[name='XorO']:checked").val();// значение чек бокса
                console.log("Hoora1");// тестовый
                if (!(val == "X") && !(val == "O") && XorO.length > 0) {// блок если еще не выставлен х или о
                    $('#Steps').append("My Step: Click_ID=" + clickID + "; Val=" + val + ": XorO=" + XorO);// Проверка данных
                    var name_input = document.getElementById(clickID);
                    name_input.innerText = XorO;//замена содержимого таблицы
                    console.log("Hoora2");
                    ajaxComputerTurnRequest(Nick, clickID, XorO); // будет реализована функция делающая ПОСТ
                    console.log(document.location.pathname);//check
                }
                ;

            });

            function ajaxComputerTurnRequest(Nick, clickID, XorO) { //TODO функционал

                var step = {'nick': Nick, 'field': clickID, 'type': XorO};
                console.log(step);
                $.ajax({
                            type: 'POST',
                            url: document.location.pathname,
                            //dataType: 'json',
                            data: step,
                            success: function (json_response) {
                                console.log("Success");
                                console.log(json_response);
                                var response = jQuery.parseJSON(json_response);
                                console.log("Success1");
                                if (response.ID !== null && response.compXorO !== null) {
                                    console.log("Success2");
                                    console.log(response.compXorO);
                                    console.log(response.ID);
                                    var name_input = document.getElementById("'" + response.ID + "'");
                                    console.log(name_input + "!");
                                    name_input.innerText = response.compXorO
                                    if (!(response.compXorO === "X") && !(response.compXorO === "O")) {// блок если еще не выставлен х или о
                                        console.log("Success3");
                                        var name_input = document.getElementById(response.ID);
                                        name_input.innerText = response.XorO;//замена содержимого таблицы
                                        $('#Steps').append("Computer Step: Click_ID=" + data.clickID + ": XorO=" + data.XorO);// Проверка данных

                                    }
                                }
                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log(textStatus, errorThrown);
                            }
                        }
                );
            }
        });


        //


    </script>

    <title>TIC-TAC-TOE</title>

</head>

<body>
Hello
<div id="Nickname">${Nick}</div>
<font size="4">
    <table border="4" bordercolor="#000000" cellspacing="0" cellpadding="0"
           width="300" height="300">

        <caption>TIC-TAC-TOE</caption>

        <tr width="100" height="100">
            <td class="space" id="1x1" align="center" width="100" height="100">${board[0][0]}</td>
            <td class="space" id="1x2" align="center" width="100" height="100">${board[0][1]}</td>
            <td class="space" id="1x3" align="center" width="100" height="100">${board[0][2]}</td>
        </tr>

        <tr width="100" height="100">
            <td class="space" id="2x1" align="center" width="100" height="100">${board[1][0]}</td>
            <td class="space" id="2x2" align="center" width="100" height="100">${board[1][1]}</td>
            <td class="space" id="2x3" align="center" width="100" height="100">${board[1][2]}</td>
        </tr>

        <tr width="100" height="100">
            <td class="space" id="3x1" align="center" width="100">${board[2][0]}</td>
            <td class="space" id="3x2" align="center" width="100">${board[2][1]}</td>
            <td class="space" id="3x3" align="center" width="100">${board[2][2]}</td>
        </tr>

    </table>
</font>
<div>
    Choose your side:<br>
    <input type="radio" name="XorO" value="X"> X<br>
    <input type="radio" name="XorO" value="O"> O
</div>

<div id="Steps">
</div>

</body>

</html>

