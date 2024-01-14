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
										<td class="col-sm-6">${comment.commenttext }</td>
										<td class="col-sm-2">${comment.username }</td>
										<td class="col-sm-2"><fmt:formatDate value="${comment.commentdate }"
												pattern="yyyy-MM-dd" /></td>
										<td class="col-sm-1"><button type="button" id="modifyCommentBtn" class="btn btn-warning" style="margin:0 0;"
							onclick="location.href='modifyCommentForm?commentid=${comment.commentid}';">수정</button></td>
										<td class="col-sm-1"><button type="button" id="removeCommentBtn" class="btn btn-danger" style="margin:0 0;;"
							onclick="location.href='deleteComment?commentid=${comment.commentid}&boardid=${comment.boardid }';">삭제</button></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<div class="form-group col-sm-12">
							<form method="post" action="registComment">
								<table class="table table-striped"
									style="text-align: center; border: 1px solid #dddddd">
									<tr>
										<td class="col-sm-1" style="margin:0 auto" valign="middle">${board.username }</td>
										<td><input type="text" style="height: 50px; margin:0 auto;"
											class="form-control col-sm-8" placeholder="댓글을 입력해주세요."
											name="commentText"></td>
										<td class="col-sm-1" style="margin:0 auto;"><input type="submit" class="" value="댓글 작성"></td>
										
									</tr>
								</table>
								<input type="hidden" value="${board.boardid }" name="boardid">
								<input type="hidden" value="${board.username }" name="username">
							</form>

						</div>
					</div>
					<div class="card-footer">

						<button type="button" id="modifyBtn" class="btn btn-warning"
							onclick="location.href='modifyForm?boardid=${board.boardid}';">Modify</button>
						<button type="button" id="removeBtn" class="btn btn-danger"
							onclick="location.href='delete?boardid=${board.boardid}';">DELETE</button>

						<button type="button" id="listBtn" class="btn btn-primary"
							onclick="location='list'">CLOSE</button>
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