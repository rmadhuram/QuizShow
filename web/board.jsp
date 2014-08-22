<jsp:include page="header.jsp" />
 <% 
   String done = (String) request.getAttribute("finished");
   int wagers[][] = (int[][]) request.getAttribute("wagers");
   net.raj.quiz.model.Quiz quiz = (net.raj.quiz.model.Quiz) request.getAttribute("quizObject");
   net.raj.quiz.model.Round round = (net.raj.quiz.model.Round) request.getAttribute("round");
   
   done = "test";
 %>
 <table>
 <%
   for (int i=0; i<round.getSectionCount(); i++ )
   {
      net.raj.quiz.model.Section section = round.getSection(i);
 %>

<tr>
<jsp:include page="formbegin.jsp" >
   <jsp:param name="command" value="showQuestion" /> 
</jsp:include>
<input type="hidden" name="section" value="<%=i%>">
<td><%=section.getName()%></td>
<td>
<select name="wager">
<% for (int j=0; j<5; j++) {
	if (wagers[i][j] > 0 ) {
%>
     <option value="<%=j%>"><%=wagers[i][j]%></option>
<%
	}
} %>

</select>
</td>
<td><input type="submit" value="Go"></td>
</form>
</tr>
<% } %>
</table>

<jsp:include page="formbegin.jsp" >
   <jsp:param name="command" value="adjustscore" /> 
</jsp:include>
<input type="submit" value="Adjust Score">
</form>

<% if (done != null) { %>
	<jsp:include page="formbegin.jsp" >
   		<jsp:param name="command" value="roundOver" /> 
	</jsp:include>
	<input type="submit" value="Round over">
	</form>
<% } %>


</body>
</html>