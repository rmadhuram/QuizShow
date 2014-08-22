<%
response.setHeader("Cache-Control","no-store"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%>
<html>
<head>
   <style type="text/css">
       body {
         font-size: 40px;
       }
       td,select,input {
         font-size: 40px;
       }       
       
       td {
          padding-bottom: 50px;
       }
       
       td input {
          margin-left: 100px;
       }
       
       .results {
          margin-bottom: 50px;
       }
       
   </style>
</head>
<body>
Quiz!<hr>
