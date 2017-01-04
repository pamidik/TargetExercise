Project Description:
myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. 

The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 

Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention.

Build an application that performs the following actions: 
>> Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 
	Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 
	Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}

>> Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail) 
	Example: http://redsky.target.com/v1/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics

>> Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response.  
>> BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store.  
Environment Requirements:
Below mentioned software(s) are needed to run the application,
1. STS - Spring Tool Suite
2. MySQL DB & MySQL workbench

Instructions to run the Application:
1. Clone the Project repository from below GitHub URL 
	GitHub URL = https://github.com/pamidik/TargetExercise.git
2. Import the project as Maven project into the workspace.
3. Perform below to steps to make the project clean and build successfully.
	execute "clean install" Maven command using Run Configurations of the project in STS.
4. Copy the MyRetailRestFulServiceData.sql script into MySQL Work bench and run the provided script.
5. Update the application.properties file with correct MySQL DB connection details.
6. Run the application using below instruction
	Right Click on Project >> Run As >> Spring Boot App
7. Access the Below application URL's via any open source Rest Client(s) like Postman, Advanced Rest Client
	a. http://localhost:8100/retail/getProductDetails/{id}
		Method Type : GET
		Path Params : id
		Example: http://localhost:8100/retail/getProductDetails/15117729 
	b. http://localhost:8100/retail/retrieveProductName?id={id} 
		Method Type : GET
		Request Params : id
		Example : http://localhost:8100/retail/retrieveProductName?id=13860428
	c. http://localhost:8100/retail/getPricingInformation?id={id}&name={name}
		Method Type : GET
		Request Params : id, name
		Example : http://localhost:8100/retail/retrieveProductName?id=13860428
	d. http://localhost:8100/retail/updateProductPrice/{id}?value={value}
		Method Type : PUT
		Path Params : id
		Request Params : value
		Example : http://localhost:8100/retail/updateProductPrice/15117729?value=499.99

 