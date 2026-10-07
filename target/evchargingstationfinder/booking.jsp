<%@ page import="com.evcharging.model.Station" %>
<%
    Station station = (Station) request.getAttribute("station");
    if (station == null) {
        response.sendRedirect(request.getContextPath() + "/stations");
        return;
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Charging Slot | EV Charging Station Finder</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header class="topbar">
        <div class="brand">EV Charging Station Finder</div>
        <nav>
            <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
            <a href="${pageContext.request.contextPath}/stations">Stations</a>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
    </header>

    <main class="form-wrap">
        <form class="auth-card" method="post" action="${pageContext.request.contextPath}/booking">
            <h2>Book a charging slot</h2>
            <input type="hidden" name="stationId" value="<%= station.getId() %>">

            <div class="booking-summary">
                <h3><%= station.getName() %></h3>
                <p><%= station.getCity() %> · <%= station.getAddress() %></p>
                <p><strong>Connector:</strong> <%= station.getConnectorType() %></p>
                <p><strong>Rate:</strong> $<%= String.format("%.2f", station.getPricePerHour()) %>/hour</p>
            </div>

            <% if (request.getAttribute("error") != null) { %>
                <p class="message error"><%= request.getAttribute("error") %></p>
            <% } %>

            <label>Date</label>
            <input type="date" name="date" required>

            <label>Preferred Slot</label>
            <select name="slot" required>
                <option value="">Select a slot</option>
                <option value="08:00-10:00">08:00-10:00</option>
                <option value="10:00-12:00">10:00-12:00</option>
                <option value="12:00-14:00">12:00-14:00</option>
                <option value="14:00-16:00">14:00-16:00</option>
                <option value="16:00-18:00">16:00-18:00</option>
                <option value="18:00-20:00">18:00-20:00</option>
            </select>

            <button type="submit" class="btn primary">Confirm Booking</button>
        </form>
    </main>
</body>
</html>
