<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/HomeStyle.css" rel="stylesheet" type="text/css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Health and Safety - Upload article</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">

<script src="js/bootstrap.js"></script>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>

<link href="css/menu.css" rel="stylesheet" type="text/css" />
<link href="css/HomePage.css" rel="stylesheet" type="text/css" />

<style>
* {

	font-size: 15px;
	line-height: 1.428;
}
</style>

</head>
<body>

	<div class="container-fluid">
		<div>
			<jsp:include page="../utilities/_header.jsp"></jsp:include>
		</div>

		<div>
			<jsp:include page="../utilities/_menu.jsp"></jsp:include>
			<div class="clear"></div>
		</div>
		<div>
			<jsp:include page="../utilities/bar.jsp"></jsp:include>
			<div class="clear"></div>
		</div>
		<div>
			<div class="leftNav">
				<h2>Quick Links:</h2>

				<ol class="list-group">
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFirstAid"
						class="list-group-item list-group-item-dark ">HSE First Aid</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionFireMarshall"
						class="list-group-item list-group-item-dark ">HSE Fire Martial</a></li>
					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionWellnessChampion"
						class="list-group-item list-group-item-dark ">HSE Wellness
							Champion</a></li>

					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyNewInspectionEnvironmental"
						class="list-group-item list-group-item-dark ">HSE
							Environmental</a></li>

					<li><a
						href="${pageContext.request.contextPath}/HealthSafetyUploadArticle"
						class="list-group-item list-group-item-dark  active">Upload HSE
							Articles</a></li>


					<li><a href="#" class="list-group-item list-group-item-dark ">Communicate
							with HR</a></li>

				</Ol>


			</div>


			<div class="rightNav container-fluid">

       
				<h2>Upload article</h2>
				<h4>Pick a location of the article to upload</h4>
				<form action="HealthSafetyUploadArticle.java"
					 method="POST">
					<div class="row">
						<div class="col-md-8">

							<div class="input-group article">
								<input type="text" class="form-control article-filename"
									disabled="disabled"> <span class="input-group-btn">
									<!-- image-preview-clear button -->
									<button type="button" class="btn btn-default article-clear"
										style="display: none;">
										<span class="glyphicon glyphicon-remove"></span> Clear
									</button>
									<div class="btn btn-default article-input">
										<span class="glyphicon glyphicon-folder-open"></span> <span
											class="article-input-title">Browse</span> <input type="file"
											accept=".xlsx,.xls,.doc, .docx,.ppt, .pptx,.txt,.pdf"
											name="input-file-preview" />
										<!-- rename it -->
									</div>
								</span>
							</div>
							<div>
								<button type="submit" class="btn btn-primary btn-lg btn-block"
									style="margin-top: 10px;">Submit</button>
							</div>
				</form>

			</div>
		</div>



	</div>

	<div class="clear"></div>

	<div>
		<jsp:include page="../utilities/_footer.jsp"></jsp:include>
	</div>


	<script>
		// Create the preview image
		$(".article-input input:file").change(function() {
			var img = $('<img/>', {
				id : 'dynamic',
				width : 250,
				height : 200
			});
			var file = this.files[0];
			var reader = new FileReader();
			// Set preview image into the popover data-content
			reader.onload = function(e) {
				$(".article-input-title").text("Change");
				$(".article-filename").val(file.name);
				img.attr('src', e.target.result);
			}
			reader.readAsDataURL(file);
		});
	</script>
</body>
</html>