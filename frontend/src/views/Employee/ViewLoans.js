import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Header from "../../components/Header";
import EmployeeNavigation from "../../components/EmployeeNavaigation";


function ViewLoans() {
    const [loans, setLoan] = useState([]);
    const [empId, setEmployeeId]= useState("");
    const [error, setError] = useState(null);

    useEffect(()=>{
        setEmployeeId(sessionStorage.getItem("employeeId"));
        console.log(sessionStorage.getItem("employeeId"));
    },[]);

    useEffect(()=>{
        const url= "http://localhost:8080/api/employee-card/all-loans-by-employee-id";
        axios
        .get(url, {params: {employeeId:sessionStorage.getItem("employeeId")}})
        .then((response) => {
            console.log(response.data);
            const data = response.data;
            if(data.length==0)
              setError("No Loans!");
            else
              setLoan(response.data);
              
        })
        .catch((err) =>{
          console.log(err);
        });
    },[empId]);

    useEffect(()=>{
      console.log(loans);
    },[loans]);


  return (
    <div>
      <Header/>
      <EmployeeNavigation/>
     
    {
      !error &&
      <Table striped bordered hover>
      <thead>
        <tr>
          <th>Loan ID</th>
          <th>Loan Type</th>
          <th>Duration</th>
          <th>Card Issue Date</th>
          <th>Active/Inactive</th>
        </tr>
      </thead>

      <tbody>
    {loans.map(loan =>{
      let date = new Date(loan.cardIssueDate.substr(0,10));
      date.setFullYear(date.getFullYear()+loan.durationInYears);
      
      return (
         <tr>
         <td>{loan.loanId}</td>
         <td>{loan.loanType}</td>
         <td>{loan.durationInYears}</td>
         <td>{loan.cardIssueDate.substr(0,10)}</td>
         <td>{(date>new Date()) && date.toDateString()}{(date<new Date()) && <div style={{color:"red"}}><b>Inactive</b></div>}</td>
         {/* <td>{(date<new Date()) && <div style={{color:"red"}}><b>Inactive</b></div>}</td> */}
       </tr>
    )})}
      </tbody>
    </Table>
    }
    {error && <div><h1>{error}</h1></div>}
    </div>
  );
}

export default ViewLoans;