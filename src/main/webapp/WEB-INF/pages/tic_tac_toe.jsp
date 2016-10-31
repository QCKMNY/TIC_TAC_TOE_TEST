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
                var clickID = this.id; // получаем ид ячейки
                var val = $(this).text();//значение ячейки
                //var radio = findSelection("group1");// значение чек бокса
                var XorO=$("input[name='XorO']:checked").val();
                $('#XorO').append("Click_ID="+clickID+"; Val="+val+": XorO="+XorO);// Проверка данных
                alert("Hoora1");// тестовый
                if (!(val == "X") && !(val == "O")&&XorO.length>0) {// блок если уже выставлен х или о
                    var name_input = document.getElementById(clickID);
                    name_input.innerText=XorO;
                    //$("div#"+clickID).val(val);
                    //ajaxComputerTurnRequest(); // будет реализована функция делающая ПОСТ
                    alert("Hoora2");
                }
                ;

            });
        });
        /*function ajaxComputerTurnRequest(term){ TODO функционал
         $.ajax({
         type: 'POST',
         url: 'http://localhost:8081/loading',
         data: {'field': clickId,'type':radio},
         success: function(data){

         }
         }
         else
         {
         alert(":(")
         }
         }
         */
        //


    </script>

    <title>TIC-TAC-TOE</title>

</head>

<body>
Hello ${Nick}
<div id="XorO">
</div>
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
</body>

</html>

