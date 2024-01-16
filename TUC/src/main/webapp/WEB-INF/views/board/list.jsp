<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%@ include file="/WEB-INF/views/module/header.jsp"%>

<div class="wrapper">
	<!-- Content Wrapper. Contains page content -->

	<!-- Main content -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row md-2">
				<div class="col-sm-6">
					<h1>레시피 공유 게시판</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="list.do"> <i
								class="fa fa-dashboard"></i>레시피
						</a></li>
						<li class="breadcrumb-item active">목록</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<section class="content">
		<div class="card">
			<div class="card-header with-border">
				<button type="button" class="btn btn-primary"
					onclick="location='registForm'">글작성</button>
				<div id="keyword" class="card-tools" style="width: 550px;">
					<div class="input-group row">
						<!-- search bar -->
						<!-- select category -->
						<select class="form-control col-md-3" name="category"
							id="category" onchange="search_list(1);">
							<option value="">카테고리</option>
							<option value="korean" ${pageMaker.category eq 'korean' ? 'selected':'' }>한식</option>
							<option value="japanese" ${pageMaker.category eq 'japanese' ? 'selected':'' }>일식</option>
							<option value="chinese" ${pageMaker.category eq 'chinese' ? 'selected':'' }>중식</option>
						</select>

						<!-- search bar -->
						<select class="form-control col-md-3" name="searchType"
							id="searchType">
							<option value="">검색구분</option>
							<option value="t" ${pageMaker.searchType eq 't' ? 'selected':'' }>제목</option>
							<option value="u" ${pageMaker.searchType eq 'u' ? 'selected':'' }>작성자</option>
							<option value="c" ${pageMaker.searchType eq 'c' ? 'selected':'' }>내용</option>
						</select>
						<!-- keyword -->
						<input class="form-control" type="text" name="keyword"
							placeholder="검색어를 입력하세요." value="${pageMaker.keyword }" /> <span
							class="input-group-append">
							<button class="btn btn-primary" type="button"
								onclick='search_list(1);' id="searchBtn"
								data-card-widget="search">
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
						<!-- end : search bar -->
					</div>
				</div>
			</div>
			<div class="card-body" style="text-align: center;">
				<div class="row">
					<div class="col-sm-12">
						<table class="table table-bordered">
							<tr>
								<th>카테고리</th>
								<th></th>
								<th>제목</th>
								<th>작성자</th>
								<th>조회수</th>
								<th>작성일자</th>
							</tr>
							<c:if test="${not empty recipeList }">
								<c:forEach var="recipe" items="${recipeList }">
									<tr
										onclick="location='detail?boardid=${recipe.boardid}&from=list'"
										style="cursor: pointer;">
										<td class="col-sm-1">${recipe.category }</td>
										<td style="margin: 0; padding: 0; padding-top: 5px;"><span
											class="manPicture" data-id="${recipe.boardid }"
											style="display: block; width: 100px; height: 100px; margin: 0 auto;"></span>
										</td>
										<td class="col-sm-4">${recipe.title }</td>
										<td class="col-sm-2">${recipe.username }</td>
										<td class="col-sm-1">${recipe.viewcount }</td>
										<td class="col-sm-1"><fmt:formatDate value="${recipe.boarddate }"
												pattern="yyyy-MM-dd" /></td>
									</tr>
								</c:forEach>
							</c:if>
							<c:if test="${empty recipeList }">
								<tr>
									<td colspan="7" class="text-center">해당내용이 없습니다.</td>
								</tr>
							</c:if>
						</table>
					</div>
					<!-- col-sm-12 -->
				</div>
				<!-- row -->
			</div>
			<!-- card-body -->
			<div class="card-footer">
    			<!-- pagination -->
    			<%@ include file="/WEB-INF/views/module/pagination.jsp" %>
    		</div>
		</div>
	</section>
</div>
<!-- ./wrapper -->


<%@ include file="/WEB-INF/views/module/common_js.jsp"%>
<!-- REQUIRED SCRIPTS -->
<script>
	BoardPictureThumb('');
</script>

<%@ include file="/WEB-INF/views/module/footer.jsp"%>





