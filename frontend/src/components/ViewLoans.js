import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';


function ViewLoans() {
    const [loans, setLoan] = useState([]);
    const [empId, setEmployeeId]= useState("");

    useEffect(()=>{
        setEmployeeId(sessionStorage.getItem("employeeId"));
    },[]);

    useEffect(()=>{
        const url= "http://localhost:8080/viewLoans";
        axios
        .get(url, {params: {employeeId:empId}})
        .then((response) => {
            console.loge(response.data);
            setLoan(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[]);


  return (
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
         <td>{loan.loanTYpe}</td>
         <td>{loan.duration}</td>
         <td>{loan.cardIssueDetails}</td>
       </tr>
    ))}
      </tbody>
    </Table>
  );
}

export default ViewLoans;