//playAlert = setInterval(function() {
//	add_row();
////	$("#list").append("<li>새로 추가된 아이템</li>");
//}, 2000);

function add_row() {
    var my_tbody = document.getElementById('my-tbody');
	var row = my_tbody.insertRow(0); // 상단에 추가
	//var row = my_tbody.insertRow(my_tbody.rows.length); // 하단에 추가
	var cell1 = row.insertCell(0);
	var cell2 = row.insertCell(1);
	var cell3 = row.insertCell(2);
	cell1.innerHTML = '추가항목';
	cell2.innerHTML = "Hello";
	cell3.innerHTML = new Date().toUTCString();
  }


let index = {
		init: function(){
			$("#addRows").on("click", ()=>{ //function(){} 쓰지 않고 , () => {} 쓰는 이유는 this를 바인딩하기 위해서!
				this.save();
			})
		},
	save: function(){
		// alert("user의 save함수 호출됨");
//		let data = {
//				title: $("#title").val(),
//				content: $("#content").val()
//		};
//		console.log(data);
//		
		// ajax 호출시 비동기 호출이 default
		$.ajax({
			type: "GET",
			url: "/blog/api/addRows",
//			data: JSON.stringify(data), //http body 데이터
			contentType: "application/json; charset=utf-8", //바디데이터가 어떤 타입인지
//			dataType: "json" //요청을 서버로해서 응답이 왔을때 기본적으로 모든 것이 문자열(생긴 것이  json이라면 js 오브젝트로 변경해줌
		}).done(function(res){
			add_row();
		}).fail(function(error){
			alert("error");
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	}
}

index.init();