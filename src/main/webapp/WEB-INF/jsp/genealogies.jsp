<%@ taglib prefix="c"   uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn"  uri="jakarta.tags.functions" %>

<!Doctype html>
<html lang="en">
<head>
	<meta name="Author" content="Yannick Brocart">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Genealogies</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" />
</head>
<body>
	<div class="genealogies-list">
		<div class="genealogies-list-header">
			<div class="title"><p>Genealogies list</p></div>
			<div class="input-group">
				<input class="form-control border" type="search" id="search-input" placeholder="Type something..." />
				<span class="input-group-append">
        			<button class="btn btn-outline-secondary" type="button">
        				<i class="fa fa-search"></i>
        			</button>
        		</span>				
			</div>
			<div class="sorting">
				<div class="filter-by">
					<select class="form-select" aria-label="Filter by">
					  <option selected>Filter by</option>
					  <option value="1">Name</option>
					  <option value="2">Creation</option>
					  <option value="3">Creator</option>
					</select>
		        </div>
		        <div class="sort-by">
					<select class="form-select" aria-label="Sort by">
					  <option selected>Sort by</option>
					  <option value="1">Name</option>
					  <option value="2">Creation</option>
					  <option value="3">Creator</option>
					</select>
		        </div>
		    </div>
			<div class="add-genealogy">
				<a href="#" class="btn btn-primary" role="button" aria-disabled="true">
	            	Add new genealogy
	            </a>
	        </div>
	    </div>
		<table class="table table-striped table-hover align-middle">
		   <thead class="table-light">
		      <tr>
		         <th scope="col">Genealogy name</th>
		         <th scope="col">Creation</th>
		         <th scope="col">Last access</th>
		         <th scope="col">Last modified</th>
		         <th scope="col">Created by</th>
		         <th scope="col">Last modified by</th>
		         <th scope="col">Status</th>
		         <th></th>
			     <th></th>
				 <th></th>
		      </tr>
		   </thead>
		   <tbody class="table-group-divider">
		      <c:forEach var="genealogy" items="${genealogies}" varStatus="loop">
		         <tr>
		            <td> <c:out value="${genealogy.name}" /> </td>
		            <fmt:parseDate value="${genealogy.creationTime}" pattern="yyyy-MM-dd" var="genealogyCreationTime" type="both" />
					<td> <fmt:formatDate pattern="dd MMM yyyy" value="${genealogyCreationTime}" /> </td>
					<fmt:parseDate value="${genealogy.lastAccessTime}" pattern="yyyy-MM-dd" var="genealogyLastAccessTime" type="both" />
					<td> <fmt:formatDate pattern="dd MMM yyyy" value="${genealogyLastAccessTime}" /> </td>
					<fmt:parseDate value="${genealogy.lastModifiedTime}" pattern="yyyy-MM-dd" var="genealogyLastModifiedTime" type="both" />
					<td> <fmt:formatDate pattern="dd MMM yyyy" value="${genealogyLastModifiedTime}" /> </td>
					<td> <c:out value="${genealogy.createdBy.login}" /> </td>
		            <td> <c:out value="${genealogy.lastModifiedBy.login}" /> </td>
		            <td> <c:out value="${genealogy.status}" /> </td>
		            <td>
						<a href="#" class="btn btn-primary" role="button" aria-disabled="true">
                            <i class="fa fa-eye"></i>
                        </a>
                    </td>
		            <td>
                        <a href="#" class="btn btn-success disabled" role="button" aria-disabled="true">
                            <i class="fa fa-edit"></i>
                        </a>
                    </td>
                    <td>
                        <a href="#" class="btn btn-danger disabled" role="button" aria-disabled="true">
                            <i class="fa fa-trash"></i>
                        </a>
                    </td>
		         </tr>
		      </c:forEach>
		   </tbody>
		   <c:choose>
		      <c:when test="${fn:length(genealogies)>=16}">
		         <tfoot>
		            <tr>
			           <th scope="col">Genealogy name</th>
			           <th scope="col">Creation</th>
			           <th scope="col">Last access</th>
			           <th scope="col">Last modified</th>
			           <th scope="col">Created by</th>
			           <th scope="col">Last modified by</th>
			           <th scope="col">Status</th>
			           <th></th>
					   <th></th>
					   <th></th>
		            </tr>
		        </tfoot>
		     </c:when>
		  </c:choose>
		</table>
	</div>
</body>
</html>
