<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<jsp:include page="navbar.jsp" />
<table class="live">
	<thead>
		<tr>

			<th class="left" colspan="6" style="background-color: goldenrod" >Livescore </th>
		</tr>
	</thead>
	<tbody id="livescores">
	</tbody>
</table>
 <script>

   $( document ).ready(function() {
	   setInterval(function() {
		   loadScore();
		 }, 1000*10); 
	});

 function loadScore(){
	 $.ajax({
			url : 'livescore',
			type : 'get',
			success : function(scores) {
				$('#livescores').empty();
				 for (i = 0; i <scores.length; i++) {
					 $('#livescores').append(
							 ' <tr class="tr0 play" id="g_520989">'
							+'	<td class="time">'+scores[i].status+'</td>'
							+'	<td class="status">'+scores[i].currentTime+'<span class="blink">"</span></td>'
							+'  <td class="home">'+scores[i].homeTeam+'</td>'
							+'	<td class="result">'+scores[i].score+'</td>'
							+'	<td class="away">'+scores[i].awayTeam+' </td>'
							+'	<td class="prev">('+scores[i].halfTimeScore+')</td>'
							+'  </tr>'
							 		 
					 );
				 }
			

			}
	  });
	 
	};
  </script>
</body>
</html>