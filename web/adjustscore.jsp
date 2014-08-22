<jsp:include page="header.jsp" />
Adjust Scores<hr>
<jsp:include page="formbegin.jsp" >
   <jsp:param name="command" value="adjust" /> 
</jsp:include>
<table>
 <tr><td>Team A</td>
 <td><input type="text" name="scoreA"></td>
 </tr>
 <tr><td>Team B</td>
 <td><input type="text" name="scoreB"></td>
 </tr>
</table>
<input type="submit" value="Adjust!">
</form>
</body>
</html>