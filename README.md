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

Back End

    Used Spring Boot because it is a widely used and well-documented Java framework that provides a simple and efficient way to build RESTful APIs.



Trade-offs and Limitations
Front End

    The front end is designed to be simple and easy to use, but may lack some advanced features or customizations that some users may desire.
    The front end may not be optimized for performance on slow or outdated devices, due to the use of animations and other UI effects.

Back End

    The back end is designed to be simple and efficient, but may lack some advanced features or customizations that some users may desire.
    The back end may not be optimized for performance on extremely high traffic or large-scale applications, due to limitations in the hardware or infrastructure.