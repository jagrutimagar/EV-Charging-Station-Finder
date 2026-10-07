<%@ page import="com.evcharging.model.Station, java.util.List" %>
<%
    List<Station> stations = (List<Station>) request.getAttribute("stations");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Stations | EV Charging Station Finder</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header class="topbar">
        <div class="brand">EV Charging Station Finder</div>
        <nav>
            <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
    </header>

    <main class="page-content">
        <section class="panel">
            <h2>Available charging stations</h2>
            <div class="station-grid">
                <% if (stations != null) { %>
                    <% for (Station station : stations) { %>
                        <div class="station-card">
                            <h3><%= station.getName() %></h3>
                            <p><strong>City:</strong> <%= station.getCity() %></p>
                            <p><strong>Address:</strong> <%= station.getAddress() %></p>
                            <p><strong>Connector:</strong> <%= station.getConnectorType() %></p>
                            <p><strong>Power:</strong> <%= station.getPowerKw() %> kW</p>
                            <p><strong>Price:</strong> $<%= String.format("%.2f", station.getPricePerHour()) %>/hr</p>
                            <p><strong>Status:</strong> <%= station.isAvailable() ? "Available" : "Busy" %></p>
                            <a class="btn primary" href="${pageContext.request.contextPath}/booking?stationId=<%= station.getId() %>">Book Slot</a>
                        </div>
                    <% } %>
                <% } %>
            </div>
        </section>
    </main>
</body>
</html>
