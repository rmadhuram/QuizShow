<jsp:include page="header.jsp" />
Displaying Answer<hr>
<%
    net.raj.quiz.model.Qa qa = net.raj.quiz.QuizGame.getInstance().getStateMachine().getCurrentQA();
%>
Answer:<br>
<%=qa.getAnswer()%>
<hr>
Notes:<br>
<%=qa.getMasterNotes()%>
<hr>

<jsp:include page="formbegin.jsp" >
   <jsp:param name="command" value="showBoard" /> 
</jsp:include>
<input type="submit" value="Show Board">
</form>

<jsp:include page="formbegin.jsp" >
   <jsp:param name="command" value="stopAudio" /> 
</jsp:include>
<input type="submit" value="Stop Audio">
</form>
</body>
</html>