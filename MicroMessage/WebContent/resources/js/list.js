
function deleteBatch(basePath){
	$("#mainForm").attr("action", basePath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}