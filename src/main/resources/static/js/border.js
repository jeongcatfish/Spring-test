let index = {
		init: function(){
			$("#btn-save").on("click", ()=>{ //function(){} 쓰지 않고 , () => {} 쓰는 이유는 this를 바인딩하기 위해서!
				console.log("save clickced");
				this.save();
			})
		},
	save: function(){
		alert("함수 호출됨");
		let data = {
				title: $("#title").val(),
				content: $("#content").val()
		};
		console.log(data);
		
		// ajax 호출시 비동기 호출이 default
		$.ajax({
			type: "POST",
			url: "/api/board",
			data: JSON.stringify(data), //http body 데이터
			contentType: "application/json; charset=utf-8", //바디데이터가 어떤 타입인지
			dataType: "json" //요청을 서버로해서 응답이 왔을때 기본적으로 모든 것이 문자열(생긴 것이  json이라면 js 오브젝트로 변경해줌
		}).done(function(res){
			alert("글쓰기 완료");
			console.log(res);
			location.href = "/";
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); // ajax통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	}
}

$("#btn-save").on("click",()=>{
	console.log("TESTET");
})

index.init();