const BASE_URL="http://localhost:8080";

$(document).ready(function() {
	console.log("Document loaded");
	$("#getScore").click(getScore);
	$("#postScore").click(postScore);
	$("#putScore").click(putScore);
	$("#delScore").click(delScore);
});

var getScore = function(event) {
	event.preventDefault();
	var scoreId = document.forms["getScore"]["scoreId"].value;
	if (scoreId == "") {
		alert("You need to enter an id");
		return false;
	}
	$.get(BASE_URL + "/score", {
		id : scoreId
	}, function(data) {
		console.log(data);
		$("#score-msg").text(data);
	});
};

var postScore = function(event) {
	event.preventDefault();
	var scoreId = document.forms["postScore"]["scoreId"].value;
	var scoreValue = document.forms["postScore"]["scoreValue"].value;
	if (scoreId == "" || scoreValue == "") {
		alert("You need to enter an id and/or a value");
		return false;
	}
	$.post(BASE_URL + "/score", {
		id : scoreId,
		value : scoreValue,
	}, function(data) {
		console.log(data);
		$("#score-msg").text(data);
	});
};

var putScore = function(event) {
	event.preventDefault();
	var scoreValue = document.forms["putScore"]["scoreValue"].value;
	if (scoreValue == "") {
		alert("You need to enter an id");
		return false;
	}
	$.ajax({
		url: BASE_URL + "/score",
		type: "PUT",
		data: {
		value : scoreValue
	}, success: function(data) {
//		console.log(JSON.parse(data));
		$("#score-msg").text(data);
	}
	});
};

var delScore = function(event) {
	event.preventDefault();
	var scoreId = document.forms["delScore"]["scoreId"].value;
	if (scoreId == "") {
		alert("You need to enter an id");
		return false;
	}
	$.ajax({
		url: BASE_URL + "/score?" + $.param({"id": scoreId})  ,
		type: "DELETE",
		success: function(data) {
		console.log(data);
		$("#score-msg").text(data);
	}
	});
};
