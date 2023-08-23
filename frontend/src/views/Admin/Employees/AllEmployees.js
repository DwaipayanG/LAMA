import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Button from 'react-bootstrap/Button';
import { useNavigate } from "react-router-dom";
import Header from "../../../components/Header";
import AdminNavigation from "../../../components/AdminNavigation";
import "../../../style/TabularViewAll.css";
import {CiEdit} from "react-icons/ci";
import { FcEmptyTrash } from "react-icons/fc";




function AllEmployees() {
    const getURL= "http://localhost:8080/api/employee/all-employees";

    const [employees, setEmployees] = useState([]);
    const navigate = useNavigate();

    useEffect(()=>{
       
        axios
        .get(getURL)
        .then((response) => {
            console.log(response.data);
            const data=response.data;
            if(data['statusCode']&&data['statusCode']==400)
              alert("No data to display");
            else
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
    <div>

    <Header></Header>
    <AdminNavigation/>
    <h3>View All Employees</h3>
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
          <th className="noBorder" ></th> 
          <th className="noBorder"></th>
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
         <td className="noBorder"><button className="noBorder smallIcons"onClick={() => handleEdit(employee.employeeId)}><CiEdit/></button></td>
         <td className="noBorder"><button className="noBorder smallIcons" onClick={() => handleDelete(employee.employeeId)}><FcEmptyTrash/></button></td>
       </tr>
    ))}
      </tbody>
    </Table>
    </div>
  );

}

export default AllEmployees;