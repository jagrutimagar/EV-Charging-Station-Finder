<%@ page import="com.evcharging.model.User, com.evcharging.model.Booking, java.util.List" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/login");
        return;
    }
    List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard | EV Charging Station Finder</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <header class="topbar">
        <div class="brand">EV Charging Station Finder</div>
        <nav>
            <a href="${pageContext.request.contextPath}/stations">Stations</a>
            <a href="${pageContext.request.contextPath}/logout">Logout</a>
        </nav>
    </header>

    <main class="page-content">
        <section class="panel">
            <h2>Welcome, <%= user.getName() %></h2>
            <p>Manage your EV charging plans and booking history.</p>
            <div class="actions">
                <a class="btn primary" href="${pageContext.request.contextPath}/stations">Book a Station</a>
            </div>
        </section>

        <section class="panel">
            <h3>My bookings</h3>
            <% if (bookings == null || bookings.isEmpty()) { %>
                <p>No bookings yet. Start by choosing a station.</p>
            <% } else { %>
                <div class="booking-list">
                    <% for (Booking booking : bookings) { %>
                        <div class="booking-item">
                            <div>
                                <strong>Booking #<%= booking.getId() %></strong>
                            </div>
                            <div>Station ID: <%= booking.getStationId() %></div>
                            <div>Date: <%= booking.getBookingDate() %></div>
                            <div>Slot: <%= booking.getSlot() %></div>
                            <div>Status: <%= booking.getStatus() %></div>
                            <div>Amount: $<%= String.format("%.2f", booking.getTotalAmount()) %></div>
                        </div>
                    <% } %>
                </div>
            <% } %>
        </section>
    </main>
</body>
</html>
