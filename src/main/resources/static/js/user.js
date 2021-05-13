let preBeaconData;

let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ // function(){} 쓰지 않고 , () => {}
										// 쓰는 이유는 this를 바인딩하기 위해서!
				this.save();
			})
			// $("#btn-login").on("click", ()=>{ // function(){} 쓰지 않고 , () => {}
			// 							// 쓰는 이유는 this를 바인딩하기 위해서!
			// 	this.login();
			// })
		},
	save: function(){
		// alert("user의 save함수 호출됨");
		let data = {
				username: $("#username").val(),
				password: $("#password").val(),
				email: $("#email").val()
		};
		console.log(data);
		
		// ajax 호출시 비동기 호출이 default
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), // http body 데이터
			contentType: "application/json; charset=utf-8", // 바디데이터가 어떤 타입인지
			dataType: "json" // 요청을 서버로해서 응답이 왔을때 기본적으로 모든 것이 문자열(생긴 것이
								// json이라면 js 오브젝트로 변경해줌
		}).done(function(res){
			alert("회원가입 완료");
			console.log(res);
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	},
		
		// login: function(){
		// 	let data = {
		// 			username: $("#username").val(),
		// 			password: $("#password").val()
		// 	};
		// 	console.log(data);
			
		// 	// ajax 호출시 비동기 호출이 default
		// 	$.ajax({
		// 		type: "POST",
		// 		url: "/api/user/login",
		// 		data: JSON.stringify(data), // http body 데이터
		// 		contentType: "application/json; charset=utf-8", // 바디데이터가 어떤
		// 														// 타입인지
		// 		dataType: "json" // 요청을 서버로해서 응답이 왔을때 기본적으로 모든 것이 문자열(생긴 것이
		// 							// json이라면 js 오브젝트로 변경해줌
		// 	}).done(function(res){
		// 		alert("로그인 요청완료");
		// 		console.log(res);
		// 		location.href = "/";
		// 	}).fail(function(error){
		// 		alert(JSON.stringify(error));
		// 	}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
		// }
}

function getSomeData() {
    $.ajax({
        type: "GET",
        url: "/api/getUsers",
        data: JSON.stringify(data),
        async: true,
        cache: false,
        success: function (list, status) {
        	if(list.length > 0) {
// setRetainWallData(list);
        		console.log(list.username);
        		console.log(status);
        	}
        }
    });
}


function getData(){
    $.ajax({
        type: "GET",
        url: "//api/getBeacons",
        data: {},
        async: true,
        cache: false,
    }).done(function(res){
    	console.log("***********************************");
    	console.log(preBeaconData);
        for(let i=0;i<res.data.length;i++){
        	document.getElementById(res.data[i].id+"beacon").innerHTML = res.data[i].name;
        	document.getElementById(res.data[i].id+"section").innerHTML = res.data[i].section;
        	document.getElementById(res.data[i].id+"status").innerHTML = res.data[i].status;
        }
        preBeaconData = res.data[0].name;
// console.log(preBeaconData.data[0].name);
    }).fail(function(error){
        console.log("fail to load username");
    });
}


function getScannerData(){
    $.ajax({
        type: "GET",
        url: "http://seg.gsil.net/mesh/scanner/info?site_id=16",
        data: {},
        async: true,
        cache: false,
    }).done(function(res){
    	console.log(res);
    	console.log("***********************************");
    	for(let i =0;i<res.length;i++){
    		add_row(res[i]);
    	}
// console.log(preBeaconData.data[0].name);
    }).fail(function(error){
        console.log("fail to load username");
    });
}


function getWeather(){
    $.ajax({
        type: "GET",
        url: "http://api.openweathermap.org/data/2.5/weather?q=Gongju&appid=4a68402aa6ea333d84a9a7c92ef77e79",
        data: {},
        async: true,
        cache: false,
    }).done(function(resp){
    	console.log(resp.main.temp-273+"*C");
    	var imgURL = "http://openweathermap.org/img/w/" + resp.weather[0].icon + ".png";
    	 $("#wea").attr("src", imgURL);
    }).fail(function(error){
        console.log("fail to load weather Data");
    });
}

$(document).ready(function() {
	window.setInterval(function(){
		loopingTest();
		getData();
		getWeather();
	},2000);
});

function loopingTest(){
	var ramdom_val = Math.random();
	$("#btn-login").text(Math.floor(ramdom_val*10));
}

let data_name = ['section','delay','rssi_cut','o2','co2','co'
	,'h2s','ch4','time_out','writetime','button','button','button']

function add_row(data) {
	console.log(data['section_name']);
    let my_tbody = document.getElementById('dataTable');
    // var row = my_tbody.insertRow(0); // 상단에 추가
    let row = my_tbody.insertRow( my_tbody.rows.length ); // 하단에 추가
    let cells = [];
    for(let i=0;i<13;i++){
    	cells.push(row.insertCell(i));
    	if(i==1) cells[i].innerHTML = '0';
    	else if(i==10 || i==11) cells[i].innerHTML ="<span class = "+"cell"+i+">수정</span>"
    	else if(i==12) cells[i].innerHTML ="<span class = "+"cell"+i+">초기화</span>";
    	else cells[i].innerHTML = data[data_name[i]];
    }
  }

function delete_row() {
//    var my_tbody = document.getElementById('my-tbody');
//    if (my_tbody.rows.length < 1) return;
//    // my_tbody.deleteRow(0); // 상단부터 삭제
//    my_tbody.deleteRow( my_tbody.rows.length-1 ); // 하단부터 삭제
//	$("#dataTable").remove(); 
  }
getScannerData();
index.init();