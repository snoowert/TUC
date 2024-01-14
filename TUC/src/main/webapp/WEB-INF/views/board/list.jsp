<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ include file="/WEB-INF/views/module/header.jsp" %>

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
			        <li class="breadcrumb-item">
			        	<a href="list.do">
				        	<i class="fa fa-dashboard"></i>레시피
				        </a>
			        </li>
			        <li class="breadcrumb-item active">
			        	목록
			        </li>		        
	    	  </ol>
	  			</div>
	  		</div>
	  	</div>
	</section>
	 
	 
   	<section class="content">
   		<div class="card">
   			<div class="card-header with-border">
   				<button type="button" class="btn btn-primary" onclick="OpenWindow('registForm','글작성',700,800);" >회원등록</button>
   				<div id="keyword" class="card-tools" style="width:550px;">
   					 <div class="input-group row">
   					 	<!-- search bar -->
   					 	<!-- sort num -->
					  	<select class="form-control col-md-3" name="perPageNum" id="perPageNum" onchange="">					  		  		
					  		<option value="10">정렬개수</option>
					  		<option value="2" ${pageMaker.perPageNum eq 2 ? 'selected':'' }>2개씩 정렬</option>
					  		<option value="3" ${pageMaker.perPageNum eq 3 ? 'selected':'' }>3개씩 정렬</option>
					  	</select>
					  	
					  	<!-- search bar -->
					 	<select class="form-control col-md-3" name="searchType" id="searchType">
					 		<option value=""  >검색구분</option>
					 		<option value="t" ${pageMaker.searchType eq 't' ? 'selected':'' } >아이디</option>
							<option value="u" ${pageMaker.searchType eq 'u' ? 'selected':'' }>이 름</option>
							<option value="c" ${pageMaker.searchType eq 'c' ? 'selected':'' }>전화번호</option>			 									
						</select>
						<!-- keyword -->
   					 	<input  class="form-control" type="text" name="keyword" 
   					 			placeholder="검색어를 입력하세요." value="${pageMaker.keyword }"/>
						<span class="input-group-append">
							<button class="btn btn-primary" type="button" onclick="search_list(1);"
									id="searchBtn" data-card-widget="search" >
								<i class="fa fa-fw fa-search"></i>
							</button>
						</span>
					<!-- end : search bar -->		 
   					 </div>
   				</div>   			
   			</div>
   			<div class="card-body" style="text-align:center;">
    		  <div class="row">
	             <div class="col-sm-12">	
		    		<table class="table table-bordered">
		    			<tr>
		    				<th></th>
		                	<th>제목</th>
		                	<th>작성자</th>
		                	<th>조회수</th>
		                	<th>작성일자</th>
		               	</tr>
		               	<c:if test="${not empty recipeList }">
		              	<c:forEach var="recipe" items="${recipeList }">
		              		<tr onclick="OpenWindow('detail?boardid=${recipe.boardid}','상세보기',700,800);" style="cursor:pointer;">
		              			<td style="margin:0;padding:0;padding-top:5px;">
		              				
		              			</td>
		              			<td>${recipe.title }</td>
		              			<td>${recipe.username }</td>
		              			<td>${recipe.viewcount }</td>
		              			<td>
		              				<fmt:formatDate value="${recipe.boarddate }" pattern="yyyy-MM-dd"/>
		              			</td>
		              		</tr>
		              	</c:forEach>
		              	</c:if>
		              	<c:if test="${empty recipeList }">
		              		<tr>
		            			<td colspan="7" class="text-center">
		            				해당내용이 없습니다.
		            			</td>
		            		</tr>
		              	</c:if>
		            </table>
    		     </div> <!-- col-sm-12 -->
    	       </div> <!-- row -->
    		</div> <!-- card-body -->
    		<div class="card-footer">
    			<!-- pagination -->
    			<%@ include file="/WEB-INF/views/module/pagination.jsp" %>
    		</div>
	     </div>
   	</section>

</div>
<!-- ./wrapper -->


<%@ include file="/WEB-INF/views/module/common_js.jsp" %>
<!-- REQUIRED SCRIPTS -->
<script>

</script>

<%@ include file="/WEB-INF/views/module/footer.jsp" %>





