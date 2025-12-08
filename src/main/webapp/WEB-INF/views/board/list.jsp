<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
<div class="container-sm p-5">
    <!-- search -->
    <div class="container-fluid m-2">
   	  <form class="d-flex" role="search">
		<select class="form-select" aria-label="Default select example">
		  <option selected>Open this select menu</option>
		  <option value="1">One</option>
		  <option value="2">Two</option>
		  <option value="3">Three</option>
		</select>
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
  	</div>
	<table class="table table-hover">
  		<thead>
    		<tr>
		      <th scope="col">#</th>
		      <th scope="col">title</th>
		      <th scope="col">writer</th>
		      <th scope="col">reg_date</th>
		      <th scope="col">read_count</th>
		    </tr>
  		</thead>
  		<tbody>
  			<c:forEach items="${list}" var="b">
  				<tr>
  					<td>${b.bno}</td>
  					<td><a href="/board/detail?bno=${b.bno}">${b.title}</a></td>
  					<td>${b.writer}</td>
  					<td>${b.regDate}</td>
  					<td>${b.readCount}</td>
  				</tr>
  			</c:forEach>
  		</tbody>
	</table>
	<nav aria-label="Page navigation example">
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
	<a href="/">
	<button type="button" class="btn btn-primary">index</button>
	</a>
</div> 
<jsp:include page="../layout/footer.jsp"/>
