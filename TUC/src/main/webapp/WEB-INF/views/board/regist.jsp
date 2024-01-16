<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/module/header.jsp"%>
<div class="wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<div class="container-fluid">
			<div class="row mb-2">
				<div class="col-sm-6">
					<h1>레시피 공유</h1>
				</div>
				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="list.do"><i
								class="fa fa-dashboard"></i>레시피 공유</a></li>
						<li class="breadcrumb-item active">글 작성</li>
					</ol>
				</div>
			</div>
		</div>
	</section>

	<section class="content container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="card card-outline card-info">
					<div class="card-header">
						<h4>글등록</h4>
					</div>
					<!--end card-header  -->
					<div class="card-body">
						<form enctype="multipart/form-data" role="form" method="post" action="regist" name="registForm">
							<div class="form-group row">
								<label for="category" class="col-sm-3" style="font-size: 0.9em;">카테고리</label>
								<div class="col-sm-9">
									<select id="category" name="category" class="form-control"
										style="font-size: 0.9em;">
										<option value="korean">한식</option>
										<option value="japanese">일식</option>
										<option value="chinese">중식</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="writer">작성자</label> <input type="text" id="writer"
									readonly name="writer" class="form-control" value="king">
							</div>
							<div class="form-group">
								<label for="title">제 목</label> <input type="text" id="title"
									name='title' class="form-control" placeholder="제목을 쓰세요">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea class="form-control" name="content" id="content"
									rows="5" placeholder="1000자 내외로 작성하세요."></textarea>
							</div>
							<div class="input-group mb-3">
								<label for="thumnail">썸네일</label>
								<div class="mailbox-attachment-icon has-img" id="thumnailView"
									style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto;"></div>
								<div class="mailbox-attachment-info" style="width: 100%;">
									<div class="input-group input-group-sm">
										<label for="inputFile"
											class=" btn btn-warning btn-sm btn-flat input-group-addon">파일선택</label>
										<input id="inputFileName" class="form-control" type="text" name="tempThumnail" disabled /> 
										<input type="file" id="inputFile" name="Picture" style="display: none;" onchange="thumnail_go();" />
									</div>
								</div>
							</div>
						</form>
					</div>
					<!--end card-body  -->
					<div class="card-footer">
						<button type="button" class="btn btn-primary" id="registBtn"
							onclick="regist_go();">등 록</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn" id="cancelBtn"
							onclick="history.go(-1)">취 소</button>
					</div>
					<!--end card-footer  -->
				</div>
				<!-- end card -->
			</div>
			<!-- end col-md-12 -->
		</div>
		<!-- end row -->
	</section>
</div>

<%@ include file="/WEB-INF/views/module/common_js.jsp"%>
<script>
	function thumnail_go() {
		//alert("change");
		let thumnailInput = document.querySelector("input[name='Picture']");
		let file = thumnailInput.files[0];

		//이미지 확장자 jpg 확인
		var fileFormat = file.name.substr(file.name.lastIndexOf(".") + 1)
				.toUpperCase();
		if (!(fileFormat == "JPG" || fileFormat == "JPEG" || fileFormat == "PNG")) {
			alert("이미지는 jpg/jpeg/png 형식만 가능합니다.");
			thumnailInput.value = "";
			return;
		}

		//이미지 파일 용량 체크
		if (file.size > 1024 * 1024 * 4) {
			alert("사진 용량은 4MB 이하만 가능합니다.");
			thumnailInput.value = "";
			return;
		}
		;

		let thumnailView = document.querySelector("#thumnailView");
		document.querySelector('#inputFileName').value = file.name;
		console.log(file);
		if (file) {
			var reader = new FileReader();

			reader.onload = function(e) {
				//이미지 미리보기	        	
				thumnailView.style.backgroundImage = "url(" + e.target.result
						+ ")";
				thumnailView.style.backgroundPosition = "center";
				thumnailView.style.backgroundSize = "cover";
				thumnailView.style.backgroundRepeat = "no-repeat";
			}
			reader.readAsDataURL(file);
		}
	}

	function regist_go() {
		if ($("input[name='title']").val() == "") { //form.title.value
			alert("제목은 필수입니다.");
			$("input[name='title']").focus();
			return;
		}

		if ($("#content").val() == "") { //form.content.value
			alert("내용은 필수입니다.");
			$("#content").focus();
			return;
		}
		
		if(!$('input[name="Picture"]').val()){
			 alert("썸네일은 필수입니다.");
			 $('input[name="Picture"]').click();
			 return;
		}
		var form = $('form[role="form"]');
		form.submit();

	}
</script>


<%@ include file="/WEB-INF/views/module/footer.jsp"%>