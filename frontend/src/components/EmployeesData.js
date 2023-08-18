import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';



function AllEmployees() {
    const [employees, setEmployees] = useState([]);
    useEffect(()=>{
        const url= "http://localhost:8080/getAllEmployees";
        //getAllLoans
        //getAllItem
        axios
        .get(url)
        .then((response) => {
            console.log(response.data);
            setEmployees(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[]);


  return (
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Employee ID</th>
          <th>Employee Name</th>
          <th>Designation</th>
          <th>Department</th>
          <th> Gender </th>
          <th> Date of Birth</th>
          <th>Date of Joining</th>
          <th></th>
          <th></th>
        </tr>
      </thead>

      <tbody>
    {employees.map(employee =>(
         <tr>
         <td>{employee.employeeId}</td>
         <td>{employee.employeeName}</td>
         <td>{employee.designation}</td>
         <td>{employee.department}</td>
         <td>{employee.gender}</td>
         <td>{employee.dateOfBirth}</td>
         <td>{employee.dateOfJoining}</td>
         <td>Edit</td>
         <td>Delete</td>
       </tr>
    ))}
      </tbody>
    </Table>
  );
}

export default AllEmployees;