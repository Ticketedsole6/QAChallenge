# 📂 Repository Structure
Welcome to our repository! Here's a quick overview of how things are organized:

## 🚀 Main Folders
### 📁 firstTask
Contains the automation of functional API testing.

### 📁 secondTask
Here you'll find the performance testing implementation.

## 🔍 First Task: Functional API Testing
In this task, I chose to automate the most complete test cases from the Swagger documentation. Some tests lacked important details (expected response, expected response code, etc.), so I didn't include them in the automation. These might be more suitable for exploratory testing.

### 🛠️ Tools Used
* Serenity
* RestAssured
* Cucumber
* Gradle
* Groovy
  
Following the Screenplay model, the files are organized into folders for easy understanding. The framework generates a report where you can check the functionality and results of the tests.

### 🐾 Selected APIs for Automation
* Find pets by status
* Find pets by tags
* Find pets by ID
* Add a new pet to the store
* Update an existing pet
* Place an order for a pet
* Find purchase order by ID
* Create a list of users with the given input array
* Log user into the system
* Get user information by username

You can find the test details in the Test cases.txt file in the firstTask folder.

## ⚡ Second Task: Performance Testing
The performance tests were implemented using k6 and JavaScript, with a script for each API case. We selected the APIs that would likely have the most traffic and could degrade the most under a high volume of requests, assuming they are connected to a database or depend on other components to function.

## 📊 Load Testing Details
I conducted load tests using the k6 tool in a local environment to evaluate the performance of an application under average and peak load conditions. The API endpoint tested was the "place an order for a pet," which utilizes a POST method. Each test lasted for 3 minutes, aiming to identify any issues such as slow response times or bottlenecks. The details and the report can be found in the Explanation.txt file of the secondTask folder.

## 📄 Additional Information
Within each folder, you'll find a file explaining the implementation of each project.

Thanks for checking out my repository! 😊
