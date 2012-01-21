<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>                                                                  
	<head>                                                                  
		<script type="text/javascript" src="jquery-1.4.2.js"></script>
		<script>
			function calcTitle() {
				return "\"title\":\"" + $(".title").val() + "\"";
			}
			
			function calcAdjectives() {
				var adjectives = "";
	
				$.each(
					$(".adjective"),
					function adjective(i, element) {
						adjectives += "\"" + $(element).val() + "\"" + ",";
					}
				);
	
				return "\"adjectives\":[" + adjectives.substr(0, adjectives.length - 1) + "]";
			}
	
			function calcHeadings() {
				var headings = "";
	
				$.each(
					$(".heading"),
					function heading(i, element) {
						headings += "\"" + $(element).val() + "\"" + ",";
					}
				);
	
				return "\"headings\":[" + headings.substr(0, headings.length - 1) + "]";
			}

			function calcTales() {
				var tales = "";

				$.each(
					$(".talesRow"),
					function(i, row) {
						var taleRow = "";
						$.each(
							$(row).find(".tale"),
							function(i, tale) {
								taleRow += "\"" + $(tale).val() + "\","
							}
						);
						taleRow = "[" + taleRow.substr(0, taleRow.length - 1) + "]";
						tales += taleRow + ",";
					}
				);

				return "\"tales\":[" + tales.substr(0, tales.length - 1) + "]";
			}
	
			$(document).ready(function() {
				$("#submit").click(function() {
					var matrixTable = $("#matrixTable"); 
					matrixTable.html("");

					// Build header row
					var width = $("#width").val();
					var headerRowString = "<thead><tr><th><input class=\"title\" size=\"2\" tabindex=\"1\"></th>";
					for (var i=0; i < width; i++)
					{
						headerRowString += "<th><input class=\"heading\" size=\"10\" tabindex=\"2\"></th>";
					}
					headerRowString += "</tr></thead>";
					matrixTable.append(headerRowString);

					// Build additional data rows
					var height = $("#height").val();
					var tableRowString = "<tbody>";
					for (i = 0; i < height; i++)
					{
						tableRowString += "<tr class=\"talesRow\"><td><input class=\"adjective\" size=\"20\" tabindex=\"3\"></td>";

						for (var j = 0; j < width; j++)
						{
							tableRowString += "<td><input class=\"tale\" size=\"6\" tabindex=\"4\"></td>";
						}

						tableRowString += "</tr>";
					}
					tableRowString += "</tbody>";

					matrixTable.append(tableRowString);

					return false;
				});

				$("#process").click(function() {
					$("#result").text(
						"{" + 
							calcTitle() + "," + 
							calcAdjectives() + "," + 
							calcHeadings() + "," + 
							calcTales() + 
						"}"
					);
				});
			});
		</script>          
	</head>                                                                 
	<body>
		<s:form>
			<s:textfield id="width" label="Width" tabindex="0"/>
			<s:textfield id="height" label="Height" tabindex="0"/>
			<s:submit id="submit" tabindex="0"/>
		</s:form>
		<table id="matrixTable">
		</table>
		
		<button id="process" type="button" tabindex="5">Process</button>
		<div style="display:none" id="title"></div>
		<div style="display:none" id="adjectives"></div>
		<div style="display:none" id="headings"></div>
		<div style="display:none" id="tales"></div>
		
		<div id="result"></div>
	</body>                                                                 
</html>
 