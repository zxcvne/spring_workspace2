<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
	<div class="container-sm p-5">
		<h3>Board Detail Page</h3>
		<div class="mb-3">
		  <label for="b" class="form-label">Bno</label>
		  <input type="text" class="form-control" 
		  id="b" name="bno" value="${board.bno}" readonly="readonly">
		</div>
		<div class="mb-3">
		  <label for="t" class="form-label">Title</label>
		  <input type="text" class="form-control" 
		  id="t" name="title" value="${board.title}" readonly="readonly">
		</div>
		<div class="mb-3">
		  <label for="w" class="form-label">Writer</label>
		  <input type="text" class="form-control" 
		  id="w" name="writer" value="${board.writer}" readonly="readonly">
		</div>
		<div class="mb-3">
		  <label for="r" class="form-label">regDate</label>
		  <input type="text" class="form-control" 
		  id="r" name="regDate" value="${board.regDate}" readonly="readonly">
		</div>
		<div class="mb-3">
		  <label for="rc" class="form-label">readCount</label>
		  <input type="text" class="form-control" 
		  id="rc" name="readCount" value="${board.readCount}" readonly="readonly">
		</div>
		<div class="mb-3">
		  <label for="c" class="form-label">Content</label>
		  <textarea class="form-control" id="c" name="content" rows="3" readonly="readonly">${board.content}</textarea>
		</div>
		<a href="/board/list"><button type="button" class="btn btn-primary">list</button></a>
		<a href="/board/modify?bno=${board.bno}"><button type="button" class="btn btn-warning">modify</button></a>
		<a href="/board/delete?bno=${board.bno}"><button type="button" class="btn btn-danger">delete</button></a>
		
		<!-- comment-->
		<!-- post -->
		<div class="input-group mb-3 my-3">
		  <span class="input-group-text" id="cmtWriter">tester</span>
		  <input type="text" class="form-control" id="cmtText" placeholder="Add Comment..." aria-label="Username" aria-describedby="basic-addon1">
		  <button type="button" id="cmtAddBtn" class="btn btn-success">post</button>
		</div>
		<!-- print -->
		<ul class="list-group list-group-flush" id="cmtListArea">
		  <li class="list-group-item">
		  	<div class="mb-3">
		  		<div class="fw-bold">writer</div>
		  		content
		  	</div>
		  	<span class="badge text-bg-primary">regDate</span>
		  </li>
		</ul>
		
	</div>
<jsp:include page="../layout/footer.jsp"/>
