<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register | EV Charging Station Finder</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header class="topbar">
        <div class="brand">EV Charging Station Finder</div>
        <nav>
            <a href="${pageContext.request.contextPath}/">Home</a>
            <a href="${pageContext.request.contextPath}/login">Login</a>
        </nav>
    </header>

    <main class="form-wrap">
        <form class="auth-card" method="post" action="${pageContext.request.contextPath}/register">
            <h2>Create Account</h2>
            <% if (request.getAttribute("error") != null) { %>
                <p class="message error"><%= request.getAttribute("error") %></p>
            <% } %>

            <label>Full Name</label>
            <input type="text" name="name" required>

            <label>Email</label>
            <input type="email" name="email" required>

            <label>Password</label>
            <input type="password" name="password" required>

            <button type="submit" class="btn primary">Register</button>
            <p class="switch-link">Already have an account? <a href="${pageContext.request.contextPath}/login">Login</a></p>
        </form>
    </main>
</body>
</html>
