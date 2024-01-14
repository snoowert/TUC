<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ include file="/WEB-INF/views/module/header.jsp"%>

<div class="wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>자료실</h1>
				</div>


				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="list.do"><i
								class="fa fa-dashboard"></i>자료실</a></li>
						<li class="breadcrumb-item active">상세보기</li>
					</ol>
				</div>
			</div>
		</div>
	</section>


	<!-- Main content -->
	<section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-primary">
					<div class="card-header">
						<h3 class="card-title">상세보기</h3>
					</div>
					<div class="card-body">
						<div class="form-group col-sm-12">
							<label for="title">제 목</label> <input type="text"
								class="form-control" id="title" value="${board.title }" readonly />
						</div>
						<div class="col-sm-12 row">
							<div class="form-group col-sm-4">
								<label for="writer">작성자</label> <input type="text"
									class="form-control" id="writer" value="${board.username }"
									readonly />
							</div>

							<div class="form-group col-sm-4">
								<label for="regDate">작성일</label> <input type="text"
									class="form-control" id="regDate"
									value="<fmt:formatDate value="${board.boarddate }" pattern="yyyy-MM-dd" />"
									readonly />
							</div>
							<div class="form-group col-sm-4">
								<label for="viewcnt">조회수</label> <input type="text"
									class="form-control" id="viewcnt" value="${board.viewcount }"
									readonly />
							</div>
						</div>
						<div class="form-group col-sm-12">
							<label for="content">내 용</label>
							<div>${board.content }</div>
						</div>
						<div class="form-group col-sm-12">
						
								<label for="comment">댓 글</label>
							<table class="table table-bordered">
								<c:forEach var="comment" items="${board.commentList }">
									<tr>
										<td>${comment.commenttext }</td>
										<td>${comment.username }</td>
										<td><fmt:formatDate value="${comment.commentdate }"
												pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>

					</div>
					<div class="card-footer">

						<button type="button" id="modifyBtn" class="btn btn-warning"
							onclick="location.href='modifyForm?pno=${pds.pno}';">Modify</button>
						<button type="button" id="removeBtn" class="btn btn-danger"
							onclick="location.href='remove?pno=${pds.pno}';">REMOVE</button>

						<button type="button" id="listBtn" class="btn btn-primary"
							onclick="CloseWindow();">CLOSE</button>
					</div>
				</div>
				<!-- end card -->
			</div>
			<!-- end col-md-12 -->
		</div>
		<!-- end row  -->

	</section>
</div>


<%@ include file="/WEB-INF/views/module/common_js.jsp"%>

<%@ include file="/WEB-INF/views/module/footer.jsp"%>