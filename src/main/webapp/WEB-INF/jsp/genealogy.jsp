<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn"  uri="jakarta.tags.functions" %>

<!Doctype html>
<html lang="en">
<head>
	<meta name="Author" content="Yannick Brocart">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Genealogy</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	
	<table class="table table-striped table-hover align-middle">
	   <thead class="table-dark">
	      <tr>
	         <th scope="col">#</th>
	         <th scope="col">name</th>
	         <th scope="col">sex</th>
	         <th scope="col">birth date</th>
	         <th scope="col">death date</th>
	      </tr>
	   </thead>
	   <tbody class="table-group-divider">
	      <c:forEach var="individual" items="${individuals}" varStatus="loop">
	         <tr>
	            <td> <c:out value="${loop}" /> </td>
	            <td> <c:out value="${individual.getNames().getNamePieces().getGiven() +
	            	                 individual.getNames().getNamePieces().getSurname()}" /> </td>
	            <td> <c:out value="${individual.sex}" /> </td>
	            <td> <fmt:formatDate value="${individual.getIndividualEvents().getBirthDetail().getDate()}" type="date" /> </td>
	            <td> <fmt:formatDate value="${individual.getIndividualEvents().getDeathDetail().getDate()}" type="date" /> </td>
	         </tr>
	      </c:forEach>
	   </tbody>
	</table>
		
</body>
</html>
