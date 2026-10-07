<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>EV Charging Station Finder</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header class="topbar">
        <div class="brand">EV Charging Station Finder</div>
        <nav>
            <% if (session.getAttribute("user") != null) { %>
                <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
                <a href="${pageContext.request.contextPath}/stations">Stations</a>
                <a href="${pageContext.request.contextPath}/logout">Logout</a>
            <% } else { %>
                <a href="${pageContext.request.contextPath}/login">Login</a>
                <a href="${pageContext.request.contextPath}/register">Register</a>
            <% } %>
        </nav>
    </header>

    <main class="hero">
        <section class="hero-copy">
            <span class="tag">Green travel made simple</span>
            <h1>Find a charging station before your next drive.</h1>
            <p>Discover nearby EV charging points, compare power and pricing, and reserve a convenient slot in minutes.</p>
            <div class="actions">
                <a class="btn primary" href="${pageContext.request.contextPath}/stations">Browse Stations</a>
                <a class="btn secondary" href="${pageContext.request.contextPath}/register">Create Account</a>
            </div>
        </section>
        <section class="hero-panel">
            <div class="info-box">
                <h3>Quick stats</h3>
                <ul>
                    <li>50+ fast charging points</li>
                    <li>Available across major cities</li>
                    <li>Book in under 2 minutes</li>
                </ul>
            </div>
        </section>
    </main>
</body>
</html>
