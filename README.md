# EmployeeBenefitsSearchApi
This Spring Boot project exposes a search api for searching for employee benefit records based on plan name, sponsor name and sponsor state.
AWS Elastic search is the search engine and I am connecting to it via the microservice I wrote. I have used AWS Elastic Beanstalk to host the application via WAR file deployment.
The provided csv file with the data was first parsed to json and uploaded in chunks to Amazon ES since the parsed data was extremely large. I referred to the documentation in https://docs.aws.amazon.com/elasticsearch-service/latest/developerguide/es-gsg-upload-data.html to achieve this.

## Example API Calls

#### Call to the running application in local machine
```
http://localhost:5000/employeebenefitplan?sponsorState=MA
```

#### Direct call to Amazon Elastic Search API

```
curl -X POST \
  https://search-employeebenefits-vkalb3k6omwmi6rvjo6fvj6mqm.us-east-1.es.amazonaws.com/employeebenefits/_search \
  -H 'Content-Type: application/json' \
  -d '{
"from" : 1, 
"size" : 40,
  "query" : {
    "bool" : {
      "must" : {
        "match" : {
          "SPONS_DFE_MAIL_US_STATE" : {
            "query" : "MA"
          }
        }
      }
    }
  }
}
'
```

#### Call to the hosted application on AWS Elastic Beanstalk

```
curl -X GET \
  'http://default-environment.pmrxive4dd.us-east-1.elasticbeanstalk.com/employeebenefitplan?sponsorState=MA' \
  -H 'Accept: application/json' \
  -H 'Content-Type: application/json'
```

## Prerequisites
- AWS account   
- JDK    
- Maven


## Built With

* [Spring Boot](https://projects.spring.io/spring-boot/)
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Pranav Rao** - *Initial work*

