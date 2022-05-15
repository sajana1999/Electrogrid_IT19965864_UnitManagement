$(document).ready(function()
{ 

 $("#alertSuccess").hide(); 
 $("#alertError").hide(); 
}); 


$(document).on("click", "#btnSave", function(event)
{ 
	
// Clear alerts---------------------
 $("#alertSuccess").text(""); 
 $("#alertSuccess").hide(); 
 $("#alertError").text(""); 
 $("#alertError").hide(); 
 
 
// Form validation-------------------
var status = validateUnitForm();
if (status != true) 
 { 
 $("#alertError").text(status); 
 $("#alertError").show(); 
 return; 
 } 


// If valid------------------------
var type = ($("#hideUnitDSave").val() == "") ? "POST" : "PUT"; 
 $.ajax( 
 { 
 url : "UnitAPI", 
 type : type, 
 data : $("#formUnit").serialize(), 
 dataType : "text", 
 complete : function(response, status) 
 { 
 onUnitInformationSaveComplete(response.responseText, status); 
 } 
 }); 
});

function onUnitInformationSaveComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully saved."); 
 $("#alertSuccess").show(); 
 $("#divUnitsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while saving."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while saving.."); 
 $("#alertError").show(); 
 }
$("#hideUnitDSave").val(""); 
$("#formUnit")[0].reset(); 
}


// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event)
		{ 
		$("#hideUnitDSave").val($(this).data("unitsId")); 
		 $("#date").val($(this).closest("tr").find('td:eq(0)').text()); 
		 $("#unitMonth").val($(this).closest("tr").find('td:eq(1)').text()); 
		 $("#unitRange").val($(this).closest("tr").find('td:eq(2)').text()); 
		 $("#price").val($(this).closest("tr").find('td:eq(3)').text()); 
		 
		});




$(document).on("click", ".btnRemove", function(event)
		{ 
		 $.ajax( 
		 { 
		 url : "UnitAPI", 
		 type : "DELETE", 
		 data : "unitsId=" + $(this).data("unitsId"),
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
			 onUnitInformationDeleteComplete(response.responseText, status); 
		 } 
		 }); 
		});
		
function onUnitInformationDeleteComplete(response, status)
{ 
if (status == "success") 
 { 
 var resultSet = JSON.parse(response); 
 if (resultSet.status.trim() == "success") 
 { 
 $("#alertSuccess").text("Successfully deleted."); 
 $("#alertSuccess").show(); 
 $("#divUnitsGrid").html(resultSet.data); 
 } else if (resultSet.status.trim() == "error") 
 { 
 $("#alertError").text(resultSet.data); 
 $("#alertError").show(); 
 } 
 } else if (status == "error") 
 { 
 $("#alertError").text("Error while deleting."); 
 $("#alertError").show(); 
 } else
 { 
 $("#alertError").text("Unknown error while deleting.."); 
 $("#alertError").show(); 
 } 
}


// CLIENT-MODEL================================================================
function validateUnitForm()
{
	// user name
	if ($("#date").val().trim() == "")
	{
	return "Insert Date.";
	}
	// address
	if ($("#unitMonth").val().trim() == "")
	{
	return "Insert Month.";
	
    }
	// no of unit
	if ($("#unitRange").val().trim() == "")
	{
	return "Insert units range.";
	}
	// month
	if ($("#price").val().trim() == "")
	{
	return "Insert unit price.";
	
    }

	return true;
}