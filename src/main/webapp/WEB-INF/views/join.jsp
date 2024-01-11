<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
	<h2>회원 가입</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
		<form>
			<tr>
				<th>아이디 체크</th>
				<td><input type="text" name = "checkId" size="70">
				<input type="submit" value="중복체크"></td>
			</tr>
		</form>
		<form action="joinOk">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mid"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" name="mpw"></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="mname"></td>
		</tr>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="memail"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="가입완료"></td>
		</tr>
		</form>
	</table>
</body>
</html>