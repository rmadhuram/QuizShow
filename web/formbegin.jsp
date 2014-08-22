<form name="input" action="/quiz">
<%
  java.util.Random rand = new java.util.Random();
  long x = rand.nextLong();
%>
<input type="hidden" name="rnd" value="<%=x%>" >
<input type="hidden" name="quiz:command" value="<%=request.getParameter("command")%>">