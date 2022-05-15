<%@page import="com.UnitInformation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.6.0.min.js"></script>
<script src="Components/UnitInformation.js"></script>
</head>
<body>
<div class="container-fluid">
			<nav class="navbar navbar-expand-lg navbar-light bg-light" >
				  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
				    <span class="navbar-toggler-icon"></span>
				  </button>
				  
				
				  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				      <li class="nav-item active">
				        <a class="nav-link" href="#"> <span class="sr-only">(current)</span></a>
				      </li>				     
				    </ul>
				  </div>
				</nav>
			<div class="row col-9 mx-2 my-5">
				<div class="col-2 shadow-lg p-3 mb-5 bg-white rounded col-md-5 offset-md-5 " >
				
					<h2 class="text-center mt-3 mb-3">Unit Details Management </h2>
					
					<form id="formUnit" name="formUnit" class="px-4">
					
						Date: 
						<input id="date" name="date" type="date" class="form-control form-control-sm mb-2"> 
						
						Valid Month:
						<select id="unitType" name="unitType" type="text" class="form-control form-control-sm mb-2">
							<option selected value="" >Please select</option>
							<option value="January">January</option>
							<option value="February">February</option>
							<option value="March">March</option>
							<option value="April">April</option>
							<option value="May">May</option>
							<option value="June">June</option>
							<option value="July">July</option>
							<option value="August">August</option>
							<option value="September">September</option>
							<option value="October">October</option>
							<option value="November">November</option>
							<option value="December">December</option>
						
						</select> 
						 
											      
						Unit Range: 					 
						<select id="unitType" name="unitType" type="number" class="form-control form-control-sm mb-2">
							<option selected value="" >Please select</option>
							<option value="a">0-60</option>
							<option value="b">61-90</option>
							<option value="c">91-120</option>
							<option value="d">121-180</option>
							<option value="e">More Than 180</option>
							
						
						</select>
						
						Unit Price: 
						<div class="input-group mb-3">
  							<span class="input-group-text">Rs</span>
  							<input id="price" name="price" type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
 							
						</div>
						
						
						
						 
						 
						  <div class="container">
							  <div class="row mt-3 mb-3">
							    <div class="col pl-1">
							    	<input type="button" value="Clear" class="btn btn-sm btn-secondary btn-block mt-3 m-0" onclick="resetForm();">
							    </div>
							    <div class="col pr-1">
							    	<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-sm btn-primary btn-block mt-3" >
								</div>							    
							  </div>
							</div>		 
						<input type="hidden" id="hidInquiryIDSave" name="hidInquiryIDSave" value="">
					
					</form>
					
					<div id="alertSuccess" class="alert alert-success mt-3 mx-4"></div>
					<div id="alertError" class="alert alert-danger mt-3 mx-4"></div>
					
					
				</div>
				<div id="divInquirysGrid" class="shadow-lg px-3 pt-3 mb-5 bg-white rounded offset-md-1" >
						<%
							UnitInformation unitobj = new UnitInformation();
							out.print(unitobj.readUnits());
						%>
				</div>
				
			</div>
	</div>

</body>
</html>