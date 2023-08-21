import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { useNavigate } from "react-router-dom";



function AllEmployees() {
    const getURL= "http://localhost:8080/getAllEmployees";

    const [employees, setEmployees] = useState([]);
    const navigate = useNavigate();

    useEffect(()=>{
       
        axios
        .get(getURL)
        .then((response) => {
            console.log(response.data);
            setEmployees(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[]);

    const handleDelete = async (id)=>{

      try{
        const response= await axios.get("http://localhost:8080/deleteEmployee",{params: {employeeId:id}});
        console.log(response.data)
        if(response.data ==="Failue"){
          console.error("User Id Not Found");
        }
        else{
          const employeeData=employees.filter(employee => employee.employeeId!==id);
          setEmployees(employeeData);
          
        }
      } catch(err){
        console.error("could not delete the employee");
      }
    }

    const handleEdit = (id) => {
      navigate('/editEmployee', { state: {employeeId: id} });
     
    }

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
         <td><button onClick={() => handleEdit(employee.employeeId)}>Edit</button></td>
         <td>Edit</td>
         <td><button onClick={() => handleDelete(employee.employeeId)}>Delete</button></td>
       </tr>
    ))}
      </tbody>
    </Table>
  );

}

export default AllEmployees;