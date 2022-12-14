export const Microservices : {[key: string]: string} = {
    // give like this : 
    // "ms-name" : "http://localhost:[port-no.]/[context-root]"
    "auth"      : "http://localhost:8081/auth",
    "employee-system" : "http://localhost:8082/api/v1/employees",
    "employee-ratings" : "http://localhost:8083/ratings",
}