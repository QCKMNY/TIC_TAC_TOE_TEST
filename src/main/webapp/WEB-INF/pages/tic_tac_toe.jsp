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

            $('#newGame').click(function(){
                var Nick=$('#Nickname').text();

                $.ajax({
                            type: 'POST',
                            url: document.location.pathname+"/new",
                            //dataType: 'json',
                            data: {'nick': Nick},
                            success: function (json_response) {
                                $('.space').each(function(){
                                    this.innerText = ' ';//замена содержимого таблицы
                                });
                                $('.hide').each(function(){
                                    console.log(this);
                                    $(this).show(); // раскрываем
                                });
                                $('#RadioChoise').html("");
                                },

                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log(textStatus, errorThrown);
                            }
                        }
                );
            });

            $(document).on('click', '.space', function () { //функция при нажатии на ячейку
                $('.hide').each(function(){
                    console.log(this);
                    $(this).hide(); // скрываем элемент
                });
                var Nick = $('#Nickname').text();//TODO make Cookie
                var clickID = this.id; // получаем ид ячейки
                var val = $(this).text();//значение ячейки
                var XorO = $("input[name='XorO']:checked").val();// значение чек бокса
                $('#RadioChoise').html("You are "+XorO);
                if (!(val == "X") && !(val == "O") && XorO.length > 0) {// блок если еще не выставлен х или о
                    $('#PlayerSteps').append("My Step: Click_ID="
                                                + clickID + "; Val=" + val + ": XorO=" + XorO+"<br>");// Проверка данных
                    var name_input = document.getElementById(clickID);
                    name_input.innerText = XorO;//замена содержимого таблицы
                    ajaxComputerTurnRequest(Nick, clickID, XorO); // функция ПОСТ
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
                                var response = jQuery.parseJSON(json_response);
                                if (response.ID !== null && response.compXorO !== null) {
                                    var name_input = document.getElementById(response.ID);
                                    name_input.innerText = response.compXorO;
                                    $('#ComputerSteps').append("Click_ID=" + response.ID +
                                                                    ": XorO=" + response.compXorO+"<br>");
                                }
                            },
                            error: function (jqXHR, textStatus, errorThrown) {
                                console.log(textStatus, errorThrown);
                            }
                        }
                );
            }
        });
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
<div class="hide">
    Choose your side:<br>
    <input class="radio" type="radio" name="XorO" value="X"> X<br>
    <input class="radio" type="radio" name="XorO" value="O"> O<br>
</div>
<div>
 <input class="button" type="button" id="newGame" value="New Game"> <br>
</div>

<div id="Steps">
    <table border="0" width="600">
        <tr width="600">
            <td id="RadioChoise"  align="left" width=""></td>
        </tr>
        <tr width="600">
            <td  align="left" width="300">Player Steps<br></td>
            <td  align="left" width="300">Computer Steps<br></td>
        </tr>
        <tr width="600">
            <td class="space" id="PlayerSteps" align="left" width="300" aria-disabled="true"><br></td>
            <td class="space" id="ComputerSteps" align="left" width="300" aria-disabled="true"><br></td>
        </tr>
    </table>
</div>

</body>

</html>

