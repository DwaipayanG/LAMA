import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Header from "./Header";
import AdminNavigation from "./AdminNavigation";


function ViewLoans() {
    const [loans, setLoan] = useState([]);
    const [empId, setEmployeeId]= useState("");

    useEffect(()=>{
        setEmployeeId(sessionStorage.getItem("employeeId"));
        console.log(sessionStorage.getItem("employeeId"));
    },[]);

    useEffect(()=>{
        const url= "http://localhost:8080/getAllLoans";
        axios
        .get(url, {params: {employeeId:sessionStorage.getItem("employeeId")}})
        .then((response) => {
            console.log(response.data);
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
      <AdminNavigation/>
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Loan ID</th>
          <th>Loan Type</th>
          <th>Duration</th>
          <th>Card Issue Date</th>
        </tr>
      </thead>

      <tbody>
    {loans.map(loan =>(
         <tr>
         <td>{loan.loanId}</td>
         <td>{loan.loanType}</td>
         <td>{loan.durationInYears}</td>
         <td>{loan.cardIssueDate.substr(0,10)}</td>
       </tr>
    ))}
      </tbody>
    </Table>
    </div>
  );
}

export default ViewLoans;