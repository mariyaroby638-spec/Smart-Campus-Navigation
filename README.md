Smart Campus Navigation System

Overview

A web-based application designed to help students, staff, and visitors find the shortest routes between campus locations. The project demonstrates the practical application of Graph Data Structures and Dijkstra's Shortest Path Algorithm using Java.

Features

- Select a starting location and destination.
- Calculate the shortest route between campus locations.
- Display the total distance of the selected route.
- Represent campus locations using a weighted graph.
- Interactive and user-friendly web interface.

Technologies Used

- Java
- Spring Boot
- HTML, CSS, JavaScript
- Maven

Data Structures and Algorithms

The campus is represented as a weighted, undirected graph, where locations are vertices and paths are edges. Dijkstra's algorithm calculates the shortest route between the selected locations.

How It Works

1. The user selects a starting point and destination.
2. The frontend sends the request to the backend API.
3. Java calculates the shortest route using Dijkstra's algorithm.
4. The application displays the route and total distance.

Run Locally

Clone the repository:

git clone https://github.com/mariyaroby638-spec/Smart-Campus-Navigation.git
cd Smart-Campus-Navigation

Run on Windows:

.\mvnw.cmd spring-boot:run

Open "http://localhost:8080" in your browser.

Project Links

- Live Website: https://smart-campus-navigation-jkn3.onrender.com
- GitHub Repository: https://github.com/mariyaroby638-spec/Smart-Campus-Navigation

Future Enhancements

- Add more campus locations and paths.
- Integrate an interactive campus map.
- Display estimated walking time.
- Improve route visualization and mobile responsiveness.