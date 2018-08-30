<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/jquery.js"></script>
</head>
<body>
<a href="${pageContext.request.contextPath }/down/http2.txt">文件下载超链接</a><br>
<hr>
<a href="${pageContext.request.contextPath }/down/http2.txt">文件下载超链接</a><br>
<a href="${pageContext.request.contextPath }/poi?fileName=http2.txt">servlet文件下载超</a><br>
<hr>
<a href="${pageContext.request.contextPath }/poi?fileName=http协议.txt">带中文的servlet文件下载超</a><br>
<hr>

<a href="${pageContext.request.contextPath }/test">测试生成excel</a><br>
<hr>

<input type="button" name="" value="按钮下载">

<select type="radio">男</select>
<select type="radio">女</select>

<hr>
<hr>
<form name="from1" id="form1" action="test.do">
			<label>性别：</label>
			<input type="radio" name="sex" value='male'/><label>男</label>
			<input name="sex" checked type="radio" value="female"/><label>女</label>
			<input name="sex" checked type="radio" value="gay"/><label>同性恋</label>
			<br>
			<label>科目：</label>
			<input name='subject' type="checkbox" value="Chinese" /><label>语文</label>
			<input name='subject' type="checkbox" checked value="Math" /><label>数学</label>
			<input name='subject' type="checkbox" checked="checked" value="English"/><label>英语</label>
			<input name='subject' type="checkbox" value="Sport"/><label>体育</label>
			<input type="submit" />   <input type="reset" /><br>
			<input type="button" value="ajax" id="a1"/>  
		</form>
</body>

<script type="text/javascript">
	$("#a1").click(function(){
	   $("#form1").submit();
	});

</script>
</html>