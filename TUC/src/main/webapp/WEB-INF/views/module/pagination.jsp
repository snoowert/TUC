<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form id="jobForm">
	<input type='hidden' name="page" value="" /> <input type='hidden'
		name="category" value="" /> <input type='hidden' name="searchType"
		value="" /> <input type='hidden' name="keyword" value="" />
		<input type="hidden" name="perPageNum" value=""/>
</form>

<nav aria-label="Navigation">
	<ul class="pagination justify-content-center m-0">
		<li class="page-item"><a class="page-link"
			href="javascript:search_list(1);"> <i
				class="fas fa-angle-double-left"></i>
		</a></li>

		<li class="page-item"><a class="page-link"
			href="javascript:search_list(${pageMaker.prev ? pageMaker.startPage-1 : pageMaker.startPage});">
				<i class="fas fa-angle-left"></i>
		</a></li>
		<c:forEach var="pageNum" begin="${pageMaker.startPage }"
			end="${pageMaker.endPage }">
			<li class="page-item ${pageMaker.page == pageNum?'active':''}">
				<a class="page-link" href="javascript:search_list(${pageNum });">
					${pageNum } </a>
			</li>
		</c:forEach>
		<li class="page-item"><a class="page-link"
			href="javascript:search_list(${pageMaker.next ? pageMaker.endPage+1 : pageMaker.endPage});">
				<i class="fas fa-angle-right"></i>
		</a></li>
		<li class="page-item"><a class="page-link"
			href="javascript:search_list(${pageMaker.realEndPage});"> <i class="fas fa-angle-double-right"></i>
		</a></li>
	</ul>
</nav>


<script>
	function search_list(page) {
		//alert(page);
		let category = document.querySelector('select[name="category"]').value;
		let searchType = document.querySelector('select[name="searchType"]').value;
		let keyword = document.querySelector('input[name="keyword"]').value;

		//alert(category+":"+searchType+":"+keyword);

		let form = document.querySelector("#jobForm");
		form.page.value = page;
		form.category.value = category;
		form.searchType.value = searchType;
		form.keyword.value = keyword;
		form.perPageNum.value=10;
		//console.log(page, searchType, keyword, category, totalCount);
		//console.log($(form).serialize());

		//form.action="";
		//form.method="get";
		form.submit();
	}
</script>