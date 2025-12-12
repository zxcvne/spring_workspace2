<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<jsp:include page="../layout/header.jsp" />
<div class="container-sm p-5">
	<h3>Board Register Page</h3>
	
	<!-- 로그인이 되었을 때만 들어올 수 있는 페이지 -->
	<sec:authentication property="principal.userVO.nickName" var="authNick"/>
	
	<form action="/board/insert" method="post" enctype="multipart/form-data">
	<!-- CSRF 토큰 추가 -->
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
	<div class="mb-3">
	  <label for="t" class="form-label">Title</label>
	  <input type="text" class="form-control" id="t" name="title" placeholder="title... ">
	</div>
	<div class="mb-3">
	  <label for="w" class="form-label">Writer</label>
	  <input type="text" class="form-control" id="w" name="writer" value="${authNick}" readonly="readonly">
	</div>
	<div class="mb-3">
	  <label for="c" class="form-label">Content</label>
	  <textarea class="form-control" id="c" name="content" placeholder="content..." rows="3"></textarea>
	</div>
	<!-- 파일 업로드 라인 -->
	<div class="mb-3">
	  <label for="file" class="form-label"></label>
	  <!-- multiple : 한번에 여러개의 파일 업로드 가능 -->
	  <input type="file" class="form-control" id="file" name="files" multiple="multiple" style="display: none;">
	  <button type="button" class="btn btn-outline-dark" id="trigger">file</button>
	</div>
	
	<!-- 파일 목록 라인 -->
	<div class="mb-3" id="fileZone"></div>
	<button type="submit" class="btn btn-primary" id="regBtn">Register</button>
	</form>
	<script src="/resources/js/boardRegisterFile.js" type="text/javascript"></script>
</div>
<jsp:include page="../layout/footer.jsp"/>