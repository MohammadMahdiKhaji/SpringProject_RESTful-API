
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fa">
<head>
    <title>Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
<%--    <jsp:include page="assets/Include.jsp"></jsp:include>--%>
</head>
<body id="top" dir="rtl">
<div>
    <form action="${pageContext.servletContext.contextPath}/login" method="post">
        <div>
            <input name="username" type="text" placeholder="نام کاربری" aria-label="Full Name">
        </div>
        <div>
            <input name="password" type="password" autocomplete="off" placeholder="رمز عبور" aria-label="Password">
        </div>
        <div>
            <div>
                <input type="checkbox" id="rememberme">
                <label for="rememberme">
                    مرا به خاطر بسپار
                </label>
            </div>
<%--            <a href="forgotpassword.jsp">فراموشی رمز عبور</a>--%>
        </div>
        <div>
            <button type="submit">ورود</button>
        </div>
    </form>
<%--    <p>حساب کاربری ندارید؟ <a href="register.jsp">از اینجا ثبت نام کنید</a></p>--%>
</div>
</body>
</html>

