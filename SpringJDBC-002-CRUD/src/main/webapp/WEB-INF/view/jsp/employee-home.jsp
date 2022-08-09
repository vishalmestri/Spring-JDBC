<%@ page isELIgnored = "false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <title>Hello, world!111</title>
  </head>
  <body>
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Employee Managerment</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Employee <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Student</a>
      </li>
     
     
    </ul>
    
  </div>
  
  
  
  
  
</nav>
<form action="newemployee"><button type="submit"  name="New Employee">New Employee</button></form>



  <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Name</th>
      <th scope="col">Gender</th>
      <th scope="col">Address</th>
       <th scope="col">Active</th>
       <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach  var="employee" items="${users}" >
    <tr>
       <td> <c:out value="${employee.id}"/></td>
      <td> <c:out value="${employee.name}"/></td>
      <td><c:out value="${employee.gender}"/></td>
      <td><c:out value="${employee.address}"/></td>
      <td><c:out value="${employee.status}"/></td>
      <td>
      <button type="submit" onclick="window.location.href='delete/${employee.id}'" >
      <i class="fa fa-trash"></i>
      </button>
      
      <button type="submit" onclick="window.location.href='edit/${employee.id}'" >
      <i class="fa fa-edit"></i>
      </button>
      </td>
    </tr>
    </c:forEach>
    
  </tbody>
</table>

<%-- pagination start --%>
  
  
<div id="pagination">

<c:url value="employeeHome" var="first">
        <c:param name="page" value="1"/>
    </c:url>
    <c:if test="${lastPageInPagination-NUMBER_OF_PAGES > 1}">
    <a href='<c:out value="${first}" />' class="pn first">First</a>
    </c:if>
    

    <c:url value="employeeHome" var="prev">
        <c:param name="page" value="${page-1}"/>
    </c:url>
    <c:if test="${page > 1}">
        <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
    </c:if>

    <c:forEach begin="${firstPageInPagination}" end="${lastPageInPagination}" step="1" varStatus="i">
   
        <c:choose>
            <c:when test="${page == i.index}">
                <span>${i.index}</span>
            </c:when>
            <c:otherwise>
                <c:url value="employeeHome" var="url">
                    <c:param name="page" value="${i.index}"/>
                </c:url>
                <a href='<c:out value="${url}" />'>${i.index}</a>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    <c:url value="employeeHome" var="next">
        <c:param name="page" value="${page + 1}"/>
    </c:url>
    <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />' class="pn next">Next</a>
    </c:if>
    
    <c:url value="employeeHome" var="last">
        <c:param name="page" value="${maxPages}"/>
    </c:url>
     <c:if test="${maxPages-lastPageInPagination > NUMBER_OF_PAGES}">
    <a href='<c:out value="${last}" />' class="pn last">Last</a>
    </c:if>
</div>

<%-- pagination end--%>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  </body>
</html>





