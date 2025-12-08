<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../layout/header.jsp" />
	<div class="container-sm p-5">
		<h3>Board Modify Page</h3>
		<form action="/board/update" method="post">
		<div class="mb-3">
		  <label for="b" class="form-label">Bno</label>
		  <input type="text" class="form-control" 
		  id="b" name="bno" value="${board.bno}" readonly="readonly">
		</div>
		<div class="mb-3">
		  <label for="t" class="form-label">Title</label>
		  <input type="text" class="form-control" 
		  id="t" name="title" value="${board.title}">
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
		  <textarea class="form-control" id="c" name="content" rows="3">${board.content}</textarea>
		</div>
		<button class="btn btn-success">update</button>
		<a href="/board/list"><button type="button" class="btn btn-primary">list</button></a>
		</form>
		
	</div>
<jsp:include page="../layout/footer.jsp"/>
