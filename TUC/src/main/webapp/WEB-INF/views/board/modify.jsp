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
					<h1>레시피 공유 게시판</h1>
				</div>


				<div class="col-sm-6">
					<ol class="breadcrumb float-sm-right">
						<li class="breadcrumb-item"><a href="list.do"><i
								class="fa fa-dashboard"></i>자료실</a></li>
						<li class="breadcrumb-item active">리스트</li>
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
						<h3>글 수정</h3>
					</div>
					<!--end card-header  -->
					<div class="card-body">

						<form enctype="multipart/form-data" role="form" method="post"
							action="modify.do" name="modifyForm">
							<input name="boardid" value="${board.boardid }" type="hidden">
							<div class="form-group row">
								<label for="category" class="col-sm-3" style="font-size: 0.9em;">카테고리</label>
								<div class="col-sm-9">
									<select id="category" name="category" class="form-control"
										style="font-size: 0.9em;">
										<option value="korean"
											${board.category eq 'korean'? 'selected':'' }>한식</option>
										<option value="japanese"
											${board.category eq 'japanese'? 'selected':'' }>일식</option>
										<option value="chinese"
											${board.category eq 'chinese'? 'selected':'' }>중식</option>
									</select>
								</div>
							</div>
							<input type="hidden" name="boardid" value="${board.boardid }" />

							<div class="form-group">
								<label for="writer">작성자</label> <input type="text" id="writer"
									readonly name="writer" class="form-control"
									value="${board.username }">
							</div>
							<div class="form-group">
								<label for="title">제 목</label> <input type="text" id="title"
									value="${board.title }" name='title' class="form-control"
									placeholder="제목을 쓰세요">
							</div>
							<div class="form-group">
								<label for="content">내 용</label>
								<textarea id="content" class="form-control" rows="5"
									name="content">${board.content}</textarea>
							</div>
							<div class="row">
								<label for="thumnail">썸네일</label> <input type="file"
									id="inputFile" name="Picture" style="display: none"
									onchange="picture_go();"/> <input type="hidden"
									name="oldPicture" value="${board.thumnail}" />
								<div class="input-group col-md-12">
									<div class="col-md-12" style="text-align: center;">
										<div class="manPicture" data-id="${board.boardid}"
											id="pictureView"
											style="border: 1px solid green; height: 200px; width: 140px; margin: 0 auto; margin-bottom: 5px;"></div>
										<div class="input-group input-group-sm">
											<label for="inputFile"
												class=" btn btn-warning btn-sm btn-flat input-group-addon">썸네일변경</label>
											<input id="inputFileName" class="form-control" type="text"
												name="tempThumnail" disabled
												value="${board.thumnail.split('\\$\\$')[1]}" />
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
					<!--end card-body  -->
					<div class="card-footer">
						<button type="button" class="btn btn-warning" id="modifyBtn"
							onclick="modify_go();">수 정</button>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<button type="button" class="btn" id="cancelBtn"
							onclick="history.go(-1);">취 소</button>
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
	console.log($('input[name="tempThumnail"]').val())
	BoardPictureThumb('');
	function picture_go() {
		let inputFile = document.querySelector("input[name='Picture']").files[0];
		let fileFormat = inputFile.name.substr(
				inputFile.name.lastIndexOf(".") + 1).toUpperCase();

		//이미지 확장자 jpg 확인
		if (!(fileFormat == "JPG" || fileFormat == "JPEG" || fileFormat == "PNG")) {
			alert("이미지는 jpg/png 형식만 가능합니다.");
			return;
		}

		//이미지 파일 용량 체크
		if (inputFile.size > 1024 * 1024 * 4) {
			alert("사진 용량은 4MB 이하만 가능합니다.");
			return;
		}
		;

		let thumnailView = document.querySelector("#pictureView");
		document.querySelector('#inputFileName').value = inputFile.name;

		//미리보기
		if (inputFile) {
			var reader = new FileReader();
			let pictureView = $('div#pictureView')[0];

			reader.onload = function(e) {
				//이미지 미리보기
				pictureView.style.backgroundImage = "url(" + e.target.result
						+ ")";
				pictureView.style.backgroundPosition = "center";
				pictureView.style.backgroundSize = "cover";
				pictureView.style.backgroundRepeat = "no-repeat";
			}
			reader.readAsDataURL(inputFile);
		}
	}

	function modify_go() {
		//alert("modify btn");
		//유효성 체크
		if ($("input[name='title']").val() == "") {
			alert("제목은 필수입니다.");
			$("input[name='title']").focus();
			return;
		}
		//유효성 체크
		if ($("input[name='content']").val() == "") {
			alert("내용은 필수입니다.");
			$("input[name='content']").focus();
			return;
		}
		var form = $('form[role="form"]');
		form.submit();
	}
</script>
<%@ include file="/WEB-INF/views/module/footer.jsp"%>














