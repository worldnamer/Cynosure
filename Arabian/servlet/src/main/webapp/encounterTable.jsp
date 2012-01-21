<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<style>
			.matrix {
				text-align:center;
			}
		</style>                                                                  
		<script type="text/javascript" src="jquery-1.4.2.js"></script>
		<script>
			$(document).ready(function() {
				$("#process").click(function() {
					var entries = "";
					$.each(
						$("tbody tr"),
						function(i, row) {
							rowObject = $(row);
							entries += "{\"adjective\":\"" + rowObject.find(".adjective").val() + "\"," +
							            "\"description\":\"" + rowObject.find(".description").val() + "\"," +
							            "\"reactionMatrix\":\"" + rowObject.find(".matrix").val() + "\"},";
						}
					);
					entries = entries.substr(0, entries.length - 1);
					
					var encounterTable = "{\"title\":\"" + $(".title").val() + "\",\"entries\":[" + entries + "]}";

					$("#result").text(encounterTable);
				});
			});
		</script>
	</head>                                                                 
	<body>
		<table>
			<thead>
				<tr>
					<th></th>
					<th colspan="3"><input class="title" size="1" style="text-align:center"></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>2</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>3</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>4</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>5</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>6</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>7</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>8</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>9</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>10</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>11</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
				<tr>
					<td>12</td>
					<td><input class="adjective"></td>
					<td><input class="description"></td>
					<td>(<input class="matrix" size="1">)</td>
				</tr>
			</tbody>
		</table>
		<button id="process" type="button" tabindex="5">Process</button>
		
		<div id="result"></div>
	</body>                                                                 
</html>