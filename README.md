# Fullstack-Analytics-application
This is a Full-stack Analytics dashboard for cell-tower data using Spring boot, and Angular

This is a project that combines an Angular front end and Java Spring backend. The project allows users to fetch cell-tower data from byanat sample api and filter it based on data fields. Also includes an endpoint with pagination to display the returned results on a table view.


Approach
Front End

The front end is built using Angular, which is a popular JavaScript framework. The front end communicates with the backend through RESTful API endpoints. The front end allows users to view a list of cell-tower data on a table view, and also includes a toggle button that switches to a chart view of the number of towers grouped by technology.  The front end is designed to be responsive and user-friendly, with intuitive UI elements and animations. I would like to improve the UI as I didn't spend much time on the aesthetics compared to functionality and correctness.


Back End

The backend is built using Java and the Spring Boot framework. The backend provides a RESTful API for the front end to communicate with. The API allows users to retrieve cell-towers and can filter them by parameters on one endpoint, as well as return the data paginated in another endpoint. 


Design Decisions
Front End

    Used Angular because it is a popular and well-supported framework, and has a large community of developers and resources available.
    Used Bootstrap for UI components because it is a widely used and well-documented CSS framework that provides a responsive and consistent UI design.
    Used HttpClientModule for HTTP requests because it is a built-in Angular module that provides an easy way to communicate with RESTful APIs.

    Towers Dashboard App

This project is an Angular-based web application that allows users to view a list of towers and display a chart showing the number of towers by technology.
Features

    Displays a paginated list of towers with filtering by network operator, technology and tower type.
    Allows the user to switch between a table view and a chart view of the data.
    Displays a chart of the number of towers by technology.

Technologies Used

    Angular
    ngx-pagination
    Chart.js

Design Decisions

    The app is built using Angular, a popular JavaScript framework for building single-page web applications. Angular provides a number of useful features for building complex applications, such as dependency injection, reactive programming with RxJS, and easy-to-use data binding.
    The ngx-pagination library is used to provide pagination support for the table view of the data. This library simplifies the process of adding pagination to a table and provides a lot of customization options.
    Chart.js is used to display the chart of the number of towers by technology. Chart.js is a popular charting library that provides a lot of customization options and supports a wide range of chart types.
    The app is designed to be responsive, so it looks good on different screen sizes.
    The app is designed to be easy to use, with a simple and intuitive interface that allows users to quickly find the information they need.

Trade-offs and Limitations

    The app is limited to displaying a fixed number of towers per page, which is set to 10. This could be customized to allow users to choose how many towers to display per page.
    The app only displays data for a fixed set of towers. This could be extended to allow users to add and edit towers.
    The app does not include any authentication or security features, so anyone with the URL can access the data. This could be addressed by adding authentication and authorization features to the app.


Back End

    Used Spring Boot because it is a widely used and well-documented Java framework that provides a simple and efficient way to build RESTful APIs.

    API Endpoints

The application provides two API endpoints:

    GET /api/paginatedTowerData - Retrieves a paginated list of cell towers from the external API.
        Query Parameters:
            page - The page number requested. Default value is 0.
            size - The number of items per page. Default value is 10.
            sortBy - The field to sort the page by. Default value is tower_id.
        Response Headers:
            Content-Type - The type of content returned. Value is application/json.
            X-Total-Count - The total number of items returned.
            Total-Towers - The total number of towers returned.
    GET /api/challenge/towers - Retrieves a list of cell towers from the external API based on filter parameters.
        Query Parameters:
            towerId - The id of the tower to filter by.
            networkOperator - The network operator of the tower to filter by.
            technology - The technology of the tower to filter by.
            towerType - The type of the tower to filter by.

Package Structure

The application is structured as follows:

    com.abdalsalam.spring.towerdata.demo.controller - Contains the REST API controller classes.
    com.abdalsalam.spring.towerdata.demo.model - Contains the model classes.
    com.abdalsalam.spring.towerdata.demo.repository - Contains the JPA repository classes.
    com.abdalsalam.spring.towerdata.demo.service - Contains the service classes.

Trade-offs and Limitations


The fact that I am not storing the data is a limitation, I would store the data in a database so I only have to fetch it once and then keep returning it from the database thus removing the depencency on an externtal api. This is only in the case that the data doesn't change. 

I also didn't get a chance to improve the UI and aesthetics, but made sure functionality was correct.

I chose to create an endpoint that allowed to return the entire dataset, and also the same endpoint can filter based on the given parameters if they are provided. This proved to be a better way to do it

I created a separate endpoint for the pagination because it has a different use case, an alternative way is to add the pagination to the same one as well but I wanted to simplify the implementation.

Security needs to be added as well but the endpoint is public and nothing sensitive is being done here

Better documentation for all components creating a summary of the whole project


I created a Dockerfile for each of the frontend and the backend. They work individually, didn't get a chance to create a docker-compose tha combines them both. Was able to test the backend and it works. 



What else can be created using this? 

Here are some use cases and examples

A map that shows the location of each tower along with a heatmap that represents the areas with the most coverage. This would give users an idea of the overall coverage of a particular network in a certain area. The map can be interactive, allowing users to zoom in and out and filter by different types of technology.

A comparison of the different types of technologies and how spread out they are in the country. This can be done by aggregating the data by technology type and then plotting the towers on a map, with different colors representing different types of technology. This can help identify which parts of the country have better coverage for a particular technology.

An analysis of which types of towers are more concentrated in which areas. This can be done by aggregating the data by tower type and then plotting the towers on a map, with different colors representing different types of towers. This can help identify which areas have more of a certain type of tower and which areas may be lacking in certain types of towers.

A coverage map of cell towers that determines if an area has coverage based on someone's location. This can be done by using the tower location data and signal strength data to create a predictive model that estimates the coverage in different areas. This can be exposed as an API that users can call to determine whether a particular area has coverage for a certain network.

Tower maintenance and planning: The dataset could be used by tower operators to plan maintenance activities, such as inspections or repairs. The information on tower type and height could also be used in tower planning, such as deciding where to place new towers or what type of tower to install.

Location-based services: The tower location data could be used in location-based services, such as mapping or navigation apps, to improve accuracy and speed. The technology data could also be used to identify areas with certain network capabilities, such as 5G coverage.

Competitive analysis: The dataset could be used by mobile network operators or market analysts to analyze the competition in different areas. For example, the dataset could be used to identify areas where a particular operator has a strong or weak presence.

Research and development: The dataset could be used by researchers and developers to develop new technologies or services related to mobile networks. For example, the dataset could be used to study the impact of tower height or location on network performance or to develop new algorithms for network optimization.




DEMO:

<img width="1404" alt="image" src="https://user-images.githubusercontent.com/35470559/236636690-ddfdf553-d8c2-49c6-8165-ed7b9c68960f.png">


<img width="1404" alt="image" src="https://user-images.githubusercontent.com/35470559/236636724-82be250b-573d-49a9-bb17-905a8cf14969.png">
