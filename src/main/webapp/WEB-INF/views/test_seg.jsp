<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style type="text/css">
td {
	text-align: center;
}

tr {
	text-align: center;
}

table {
	vertical-align: middle;
}
</style>

<!DOCTYPE html>
<html lang="en">

<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/blog/css/manage.css">
    <title>Document</title> 
</head>

<body>
    <div class="warpper">
        <input class="radio" id="one" name="group" type="radio" checked>
        <input class="radio" id="two" name="group" type="radio">
        <input class="radio" id="three" name="group" type="radio">
        <div class="tabs">
            <label class="tab" id="one-tab" for="one">비콘</label>
            <label class="tab" id="two-tab" for="two">스캐너</label>
            <label class="tab" id="three-tab" for="three">RSSI</label>
        </div>
        <div class="panels">
            <div class="panel" id="one-panel">
                
            </div>
            <div class="panel" id="two-panel">
                <table>
                    <thead>
                        <th>section</th>
                        <th>DELAY</th>
                        <th>RSSI_CUT</th>
                        <th>산소</th>
                        <th>이산화탄소</th>
                        <th>일산화탄소</th>
                        <th>황화수소</th>
                        <th>가연성가스<br>(LEL)</th>
                        <th>초기화
                            시간
                        <th>수집시간</th>
                        <th>RSSI 보정</th>
                        <th>환경센서<br>보정</th>
                        <th>초기화</th>
                    </thead>
                    <tbody id = "dataTable_scanner">
                    </tbody>
                </table>
            </div>
            <div class="panel" id="three-panel">
                <div class="panel-title">Note on Prerequisites</div>
                <p>We recommend that you complete Learn HTML before learning CSS.</p>
            </div>
        </div>
    </div>

</body>

    <script src="/blog/js/manager.js"></script>
</html>