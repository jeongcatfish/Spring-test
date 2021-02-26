function getBeaconData(){
    $.ajax({
        type: "GET",
        url: "http://seg.gsil.net/mesh/locations?site_id=16&active=1",
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


function getRSSIData(){
    $.ajax({
        type: "GET",
        url: "http://seg.gsil.net/mesh/rssiBlock?site_id=16",
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

$(document).ready(function() {
	window.setInterval(function(){
//		getScannerData();
	},2000);
});

let data_name = ['section','delay','rssi_cut','o2','co2','co'
	,'h2s','ch4','time_out','last_update_time','button','button','button']

function add_row(data) {
	console.log(data['section_name']);
    let my_tbody = document.getElementById('dataTable_scanner');
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

function add_row2(data) {
	console.log(data['section_name']);
    let my_tbody = document.getElementById('dataTable_scanner');
    // var row = my_tbody.insertRow(0); // 상단에 추가
//    let row = my_tbody.insertRow( my_tbody.rows.length ); // 하단에 추가
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