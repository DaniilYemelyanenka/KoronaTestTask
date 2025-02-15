package by.yemelyanenka.core;

import by.yemelyanenka.core.entity.Employee;
import by.yemelyanenka.core.entity.Manager;
import by.yemelyanenka.core.entity.Worker;

import java.util.*;
import java.util.stream.Collectors;

public class WorkersMapper {


    public String getWorkersListFromFile(String fileContent,String sortType,String sortOrder) throws NullPointerException, NumberFormatException{

        Map<Object, String> workerMap = new HashMap<Object, String>();



        Arrays.stream(fileContent.split("\n")).forEach(worker -> {
                    if (worker.contains("Manager") && (worker.split(",").length == 5))
                    {
                        String[] managerFieldsArray = worker.split(",");
                        workerMap.put(MapStringFieldsArrayToObject(managerFieldsArray,"Manager"), "Manager");
                    }
                    else if (worker.contains("Employee") && (worker.split(",").length == 5))
                    {
                        String[] employeeFieldsArray = worker.split(",");
                        workerMap.put(MapStringFieldsArrayToObject(employeeFieldsArray,"Employee"), "Employee" );
                    }
                    else {
                        String[] uncorrectedFieldsArray = worker.split(",");
                        workerMap.put( MapStringFieldsArrayToObject(uncorrectedFieldsArray,"Uncorrected"), "Uncorrected");
                    }
                });



        return getStringOfWorkers(workerMap,sortType,sortOrder);


    }


    public String getStringOfWorkers(Map<Object,String> workersMap,String sortType, String sortOrder){

        ArrayList<Object> managerList =  workersMap.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(),"Manager"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList :: new));;

        ArrayList<Object> employeeList = workersMap.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(),"Employee"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList :: new));

        ArrayList<Object> uncorrectedList = workersMap.entrySet()
                .stream()
                .filter(entry -> Objects.equals(entry.getValue(),"Uncorrected"))
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(ArrayList :: new));

        StringBuilder sb = new StringBuilder();

        if(sortType.equals("name") ){
            if (sortOrder.equals("asc")){
                managerList.sort(Comparator.comparing(manager -> ((Manager) manager).getName()));
                employeeList.sort(Comparator.comparing(employee -> ((Employee) employee).getName()));
            }else if (sortOrder.equals("desc")){
                managerList.sort(Comparator.comparing(manager -> ((Manager) manager).getName()).reversed());
                employeeList.sort(Comparator.comparing(employee -> ((Employee) employee).getName()).reversed());
            }
        }else if(sortType.equals("salary")){
            if (sortOrder.equals("asc")) {
                managerList.sort(Comparator.comparing(manager -> ((Manager) manager).getSalary()));
                employeeList.sort(Comparator.comparing(employee -> ((Employee) employee).getSalary()));
            }else if (sortOrder.equals("desc")){
                managerList.sort(Comparator.comparing(manager -> ((Manager) manager).getSalary()).reversed());
                employeeList.sort(Comparator.comparing(employee -> ((Employee) employee).getSalary()).reversed());
            }
        }




        managerList.forEach(manager -> {
           manager = ( Manager) manager ;
           sb.append(((Manager) manager).getDepartment()+ "\n");
           sb.append(manager.toString());
           Integer ManagerId = ((Manager) manager).getId();
           employeeList.forEach( employee -> {
               employee = (Employee) employee;
               if(((Employee) employee).getManagerId().equals(ManagerId)){
                   sb.append(employee.toString());
               }

           });
        });

        sb.append("Некорректные данные:" + "\n");
        uncorrectedList.forEach(uncorrected -> sb.append(uncorrected + "\n"));

        return sb.toString();
    }


    private Object MapStringFieldsArrayToObject(String[] fieldsArray,String type) throws NullPointerException,
                                                                                          NumberFormatException {

        Manager manager = new Manager();
        Employee employee = new Employee();

        if (type.equals("Manager")) {

            manager.setPost("Manager");
            manager.setId(0);
            manager.setName("name");
            manager.setSalary(0.0);
            manager.setDepartment("department");

            for (String field : fieldsArray) {
                field = field.strip();
                if (!field.isBlank()) {
                    if (field.matches("[-+]?\\d+") && Integer.parseInt(field) < 100)
                        manager.setId(Integer.parseInt(field));
                    else if (field.contains(" "))
                        manager.setName(field);
                    else if (field.matches("\\d+") && Double.parseDouble(field) % 1 != Double.parseDouble(field))
                        manager.setSalary(Double.parseDouble(field));
                    else
                        manager.setDepartment(field);
                }
            }
            return manager;
        }


        if (type.equals("Employee")) {

            employee.setPost("Employee");
            employee.setId(0);
            employee.setName("name");
            employee.setSalary(0.0);
            employee.setManagerId(0);

            for (String field : fieldsArray) {
                field = field.strip();
                if (!field.isBlank()) {
                    if (field.contains("Employee"))
                        employee.setPost(field);
                    else if (field.matches("[-+]?\\d+") && Integer.parseInt(field) > 100 && Integer.parseInt(field) < 1000) {
                        employee.setId(Integer.parseInt(field));
                    } else if (field.contains(" "))
                        employee.setName(field);
                    else if ((field.matches("[-+]?\\d+") && Integer.parseInt(field) < 100))
                        employee.setManagerId(Integer.parseInt(field));
                    else if (isDouble(field) && Double.parseDouble(field) > 1000)
                        employee.setSalary(Double.parseDouble(field));
                }
            }

            return employee;
        }

        StringBuilder sb = new StringBuilder();
        for (String s : fieldsArray){
            sb.append(s);
        }
        return sb.toString();
    }


    private boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }




}
