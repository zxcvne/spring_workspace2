<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
<div class="container-sm p-5">
    <!-- search -->
    <div class="container-fluid m-2">
   	  <form class="d-flex" role="search" action="/board/list" method="get">
		<select class="form-select" name="type" aria-label="Default select example">
		  <option ${ph.pgvo.type eq null ? 'selected' : ''} >Choose...</option>
		  <option ${ph.pgvo.type eq 't' ? 'selected' : ''} value="t">title</option>
		  <option ${ph.pgvo.type eq 'w' ? 'selected' : ''} value="w">writer</option>
		  <option ${ph.pgvo.type eq 'c' ? 'selected' : ''} value="c">content</option>
		  <option ${ph.pgvo.type eq 'tc' ? 'selected' : ''} value="tc">title&content</option>
		  <option ${ph.pgvo.type eq 'wc' ? 'selected' : ''} value="wc">writer&content</option>
		  <option ${ph.pgvo.type eq 'tw' ? 'selected' : ''} value="tw">title&writer</option>
		  <option ${ph.pgvo.type eq 'twc' ? 'selected' : ''} value="twc">all</option>
		</select>
        <input class="form-control me-2" type="search" name="keyword" value="${ph.pgvo.keyword}" placeholder="Search" aria-label="Search"/>
        <input type="hidden" name="pageNo" value="1">
        <input type="hidden" name="qty" value="${ph.pgvo.qty}">
		<button type="submit" class="btn btn-success position-relative">
		  search
		  <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
		    ${ph.totalCount}
		    <span class="visually-hidden">unread messages</span>
		  </span>
		</button>
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
  					<td><a href="/board/detail?bno=${b.bno}" style="text-decoration: none;">${b.title} 
  					<c:if test="${b.fileQty ne 0}">
  						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="gray" class="bi bi-paperclip" viewBox="0 0 16 16">
 						<path d="M4.5 3a2.5 2.5 0 0 1 5 0v9a1.5 1.5 0 0 1-3 0V5a.5.5 0 0 1 1 0v7a.5.5 0 0 0 1 0V3a1.5 1.5 0 1 0-3 0v9a2.5 2.5 0 0 0 5 0V5a.5.5 0 0 1 1 0v7a3.5 3.5 0 1 1-7 0z"/>
						</svg>
  					</c:if>
  					<c:if test="${b.fileQty ne 0}">
  						<span class="badge text-primary">[${b.fileQty}]</span>
  					</c:if>
  					<c:if test="${b.cmtQty ne 0}">
  						<span class="badge text-danger">[${b.cmtQty}]</span>
  					</c:if>
  					</a></td>
  					<td>${b.writer}</td>
  					<td>${b.regDate}</td>
  					<td>${b.readCount}</td>
  				</tr>
  			</c:forEach>
  		</tbody>
	</table>
	<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item ${ph.prev eq false ? 'disabled' : ''}">
      <a class="page-link" href="/board/list?pageNo=${ph.startPage-1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <c:forEach begin="${ph.startPage}" end="${ph.endPage}" var="i">
    <li class="page-item"><a class="page-link" href="/board/list?pageNo=${i}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}">${i}</a></li>
    </c:forEach>
    <li class="page-item ${ph.next eq false ? 'disabled' : ''}">
      <a class="page-link" href="/board/list?pageNo=${ph.endPage+1}&qty=${ph.pgvo.qty}&type=${ph.pgvo.type}&keyword=${ph.pgvo.keyword}" aria-label="Next">
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
