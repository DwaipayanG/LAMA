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
import "../../../style/TabularViewAll.css";
import ListEmployeeItem from "../../../components/ListEmployeeItem";




function AllEmployees() {
    const getURL= "http://localhost:8080/api/employee/all-employees";

    const [employees, setEmployees] = useState([]);
    const [message, setMessage] = useState();
    const navigate = useNavigate();

    useEffect(()=>{
       
        axios
        .get(getURL)
        .then((response) => {
            console.log(response.data);
            const data=response.data;
            if(data['statusCode']&&data['statusCode']==400)
              setMessage("No employees to display");
            else
              setEmployees(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[]);

    const handleDelete = async (id)=>{

      try{
        const response= await axios.delete("http://localhost:8080/api/employee",{params: {employeeId:id}});
        console.log(response.data)
        if(response.data ==="Failure"){
          console.error("User Id Not Found");
        }
        else{
          window.location.reload();
        }
      } catch(err){
        console.error("Could not delete the employee");
      }
    }

    const handleEdit = (id) => {
      navigate('/admin/employees/edit', { state: {employeeId: id} });
     
    }

    let classNum=0;

    function addNum(){
      let temp= classNum +1;
      temp= temp%2;
      classNum= (temp);

      return temp;
    }

  return (
    <div>

    <Header></Header>
    <AdminNavigation/>
    <h3>View All Employees</h3>
    {
      !message &&
    employees.map(employee =>(
      <ListEmployeeItem empId={employee.employeeId} empName = {employee.employeeName} dob ={employee.dateOfBirth.substr(0,10)} department= {employee.department} designation ={employee.designation} doj= {employee.dateOfJoining.substr(0,10)} gender={employee.gender} allEmployees={employees} number={addNum()}></ListEmployeeItem>
    ))


    }
    {
      message
      &&
      <div><h1>{message}</h1></div>
    }
    </div>
  );

}

export default AllEmployees;