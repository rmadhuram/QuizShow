<jsp:include page="header.jsp" />
Displaying Question<hr>
<jsp:include page="formbegin.jsp" >
   <jsp:param name="command" value="showAnswer" /> 
</jsp:include>

<%
    net.raj.quiz.model.Qa qa = net.raj.quiz.QuizGame.getInstance().getStateMachine().getCurrentQA();
%>
Question:<br>
<%=qa.getQuestion()%>
<hr>
Answer:<br>
<%=qa.getAnswer()%>
<hr>
Notes:<br>
<%=qa.getMasterNotes()%>
<hr>
<div class="results">
<label for="teamA">Team A Correct</label>
<input type="radio" name="option" id="teamA" value="A"/>
</div>
<br>
<div class="results">
<label for="teamB">Team B Correct</label>
<input type="radio" name="option" id="teamB" value="B"/>
</div>
<br>
<div class="results">
<label for="pass">Pass</label>
<input type="radio" id="pass" name="option" value="P"/>
</div>
<hr>
<input type="submit" value="Submit">
</form>

<jsp:include page="formbegin.jsp" >
   <jsp:param name="command" value="stopAudio" /> 
</jsp:include>
<input type="submit" value="Stop Audio">
</form>
</body>
</html>