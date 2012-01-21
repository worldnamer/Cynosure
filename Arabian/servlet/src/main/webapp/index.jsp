<%@ page import="javax.ejb.*,cynosure.arabian.ejbs.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>                                                                  
	<head>
		<link rel="stylesheet" type"text/css" href="arabianNights.css"/>
		<script type="text/javascript" src="jquery-1.4.2.js"></script>          
		<script type="text/javascript">
			function createTale(heading, tale) {
				$("#taleBox").children(".title").text(heading);
				$("#tale").text(tale);
			}

			function headingClick() {
				var loading = $("#loading");
				loading.show();
				$("#card").hide();
				$("#encounterTable").hide();
				$("#reactionMatrix").hide();

				var taleUrl = $(this).data('data');
				$.getJSON(
					"rest-services/reactionMatricies/" + taleUrl,
					function(tale) {
						createTale(taleUrl, tale);
						$("#taleBox").show();
						loading.hide();
					}
				);
			}
		
			function createReactionMatrix(matrix, adjective) {
				$("#reactionMatrix").children(".title").text(matrix.title);
				
				var reactionMatrixString = "";
				var interval = 3.25 / (matrix.headings.length + 1);
				for (var i = 0; i < (matrix.headings.length); i++) {
					var coloring = "heading";
					if (i % 2 == 0) 
						coloring = "headingAlt";
						
					reactionMatrixString += "<div class=\"" + coloring + " heading" + i + "\" style=\"top:" + (i+1) * interval + "in;\">" + matrix.headings[i] + "</div>";
				}

				var headingsDiv = $("#headings");				
				headingsDiv.html(reactionMatrixString);
				
				for (var i = 0; i < (matrix.headings.length); i++) {
					var heading = headingsDiv.children(".heading" + i);
					heading.data('data', matrix.title + "/" + adjective + "/" + matrix.headings[i]);
					heading.click(headingClick); 
				}
			}

			function renderNMatrix() {
				var loading = $("#loading");
				loading.show();
				$("#card").hide();
				$("#encounterTable").hide();
				
				var adjective = $(this).data('data');
				$.getJSON(
					"rest-services/reactionMatricies/N",
					function(matrix) {
				    	createReactionMatrix(matrix, adjective);
						$("#reactionMatrix").show();
						loading.hide();
					}
				);
			}
			
			function encounterTableClick() {
				var loading = $("#loading");
				loading.show();
				$("#card").hide();
				$("#encounterTable").hide();
				
				var entry = $(this).data('data');
				$.getJSON(
					"rest-services/reactionMatricies/" + entry.reactionMatrix,
					function(matrix) {
				    	createReactionMatrix(matrix, entry.adjective);
						$("#reactionMatrix").show();
						loading.hide();
					}
				);
			}

			function createTable(table) {
				var tableDiv = $("#encounterTable");
				
				tableDiv.children(".title").text(table.title);
				
				for (var i = 0; i < 12; i++) {
					var rowDiv = tableDiv.find(".row" + i);
					rowDiv.text(table.entries[i].adjective + " " + table.entries[i].description + " (" + table.entries[i].reactionMatrix + ")");
					rowDiv.data('data', table.entries[i]);
					rowDiv.click(encounterTableClick);
				}
			}

			function cardOptionClick() {
				var loading = $("#loading")
				loading.show();
				$("#card").hide();
				
				$.getJSON(
					"rest-services/tables/" + $(this).data('data'),
					function(table) {
						createTable(table);
						$("#encounterTable").show();
						loading.hide();
	    		    }
     			);
 			}

			function setOptionData(div, card, option) {
				if (option.value == 'N') {
					div.data('data', card.title);
					div.click(renderNMatrix);
				}
				else {
					div.data('data', option.value);
					div.click(cardOptionClick);
				}
			}

			function createOptionDivString(option, className, style) {
				return "<div class=\"cardElement " + className + "\" style=\"" + style + "\">" + option.type + " (" + option.value + ")</div>";
			}
			
			function createCard(card) {
				var cardDiv = $("#card");
				var cardElements = cardDiv.children("#cardElements");
				
				cardDiv.children(".title").text(card.title);

				switch (card.type) {
					case "CITY":
						cardElements.html(createOptionDivString(card.options[0], "cityColors", "top:50%;"));

						break;
					case "CHARACTER":
						cardElements.html(
							createOptionDivString(card.options[0], "morningColors", "top:30%;") +
							createOptionDivString(card.options[1], "noonColors", "top:50%;") +
							createOptionDivString(card.options[2], "nightColors", "top:70%;")
						);

						break;
					case "TERRAIN":
						cardElements.html(
							createOptionDivString(card.options[0], "mountainColors", "top:30%;") +
							createOptionDivString(card.options[1], "desertColors", "top:40%;") +
							createOptionDivString(card.options[2], "seaColors", "top:50%;") +
							createOptionDivString(card.options[3], "forestColors", "top:60%;") +
							createOptionDivString(card.options[4], "cityColors", "top:70%;") +
							createOptionDivString(card.options[5], "islandColors", "top:80%;")
						);

						break;
				}

				var i = 0;
				$.each(
					cardElements.children(".cardElement"),
					function(i, element) {
						setOptionData($(element), card, card.options[i++]);
					}
				);
			}
			
			$(document).ready(function() {
				$.getJSON(
					"<s:url action="drawFromDeck"/>",
 					function(card) {
						createCard(card);
						$("#card").show();
						$("#loading").hide();
	 				}
				);
			});
		</script>                                                               
	</head>                                                                 
	<body>
		<div class="card" id="loading">
			<div class="cardElement" style="top:47%">Loading...</div>
		</div>
		<div class="card" style="display:none;" id="card">
			<div class="title" style="top:10%;"></div>
			<div id="cardElements"></div>
		</div>
		<div class="encounterTable" style="display:none;" id="encounterTable">
			<div class="title" style="top:0;"></div>
			<div id="entries">
				<div class="rowNumber" style="top:0.25in;">1</div><div class="entry row0" style="top:0.25in;"></div>
				<div class="rowNumber" style="top:0.50in;">2</div><div class="entry row1" style="top:0.50in;"></div>
				<div class="rowNumber" style="top:0.75in;">3</div><div class="entry row2" style="top:0.75in;"></div>
				<div class="rowNumber" style="top:1.00in;">4</div><div class="entry row3" style="top:1.00in;"></div>
				<div class="rowNumber" style="top:1.25in;">5</div><div class="entry row4" style="top:1.25in;"></div>
				<div class="rowNumber" style="top:1.50in;">6</div><div class="entry row5" style="top:1.50in;"></div>
				<div class="rowNumber" style="top:1.75in;">7</div><div class="entry row6" style="top:1.75in;"></div>
				<div class="rowNumber" style="top:2.00in;">8</div><div class="entry row7" style="top:2.00in;"></div>
				<div class="rowNumber" style="top:2.25in;">9</div><div class="entry row8" style="top:2.25in;"></div>
				<div class="rowNumber" style="top:2.50in;">10</div><div class="entry row9" style="top:2.50in;"></div>
				<div class="rowNumber" style="top:2.75in;">11</div><div class="entry row10" style="top:2.75in;"></div>
				<div class="rowNumber" style="top:3.00in;">12</div><div class="entry row11" style="top:3.00in;"></div>
			</div>
		</div>
		<div class="reactionMatrix" style="display:none;" id="reactionMatrix">
			<div class="title" style="top:0;"></div>
			<div id="headings"></div>
		</div>
		<div class="taleBox" style="display:none;" id="taleBox">
			<div class="title" style="top:0;"></div>
			<div class="tale" id="tale"></div>
		</div>
	</body>                                                                 
</html>
