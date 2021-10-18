# spring-microservices
Spring Boot Microservices Projects with Docker and Kubernetes

Directory:
  1. backend: Java Spring Boot Microservice (implements EurekaClient and Resendpoint on port 9002)
  2. frontend: Java Spring Boot Microservice (implements EurekaClient and Restendpoint on port 9003)
  3. Serviceregistry: Java Spring Boot Microservice (implements EurekaServer on default port 8761)
  4. k8s: Kubernetes deployement files (yaml)
  5. helm-chart/springboot: helm charts for this entire app. On executing using "helm install springbootapp", it install all 3 microservices.


Architecture

A. Created 3 microservices:

  1. Service Registry : This is a Eureka server which register eureka client for smooth rest api handling. This runs on standard port 8761.

  2. Backend: This Service implements a rest endpoint. On receiving the rest call, it reads the environment variable and return "Hello <Env Variable User name>".
            This service runs on port 9002.
            
  3. Frontend: This call rest endpoints exposed by backend service, get back the "Hello <Username>" and appends local time and return it to the caller. This service runs on port 9003.

B. All 3 microservices are converted into docker images and pushed to dockerhub.

serviceregistry:0.0.1
backend:0.0.1
frontend:0.0.1

C. With these 3 docker images, kubernetes deployments has been done.

  1. Frontend Pod: 
    Implemented using 2 componentes i.e. Deployment and Service using ClusterIP.
  
  
  2. Backend: 
    This is also implemented using 2 component, Deployment and Service.
    This implements a Config Map which stores USER_NAME and pass it as environment variable to backend microservice.
    
  
  3. ServiceRegistry: 
    This is implemented using StatefulSet. Reason being we need a fixed name so that Eureka clients (frontend and backend) can connect to it.
    In case of deployment, a hash value is added to name. Also, stateful set needs the headless service (without cluster ip), hence that is also implemented.
    There is one more service (Nodeport) to enable eureka page access from outside on port 8761.
    Config map is created which stores EUREKA_SERVER Url and that would be set as environment and passed to service registry microservices.
    
     
Values which has been templatized in Helm Chart:
  a. Config Map Name
  b. User Name Env Variable
  c. Replica Count
  d. App Name
  e. Docker Hub Image Repository
  f. Docker Hub Image Pull Policy
  g. Container Port

  
                      
   

