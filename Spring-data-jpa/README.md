#### Pagination using JPA

/getUsersByPagination in ApplicationJPAController.java --> findEmployeeByPagination(UserServiceImpl.java)

#### QueryDSL

/findEmployeeByNameViaQueryDSL in EmployeeController.java

#### Named Query

/findAllByEmployeeByNamedQuery in EmployeeController.java --> Employee.java --> @NamedQuery && EmployeeRepository.java

#### Specification

/findEmployeeByFirstOrLastNameSpec & /findEmployeeByFirstAndLastNameSpec in EmployeeController.java

EmployeeSpecification contains specification

#### Http Patch using JSON patch

CustomerController.java --> /updateViaPatch

#### Custom & Native query 

ProjectController.java --> ProjectRepository.java





