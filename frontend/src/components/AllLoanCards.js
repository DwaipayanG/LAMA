import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import { useNavigate } from "react-router-dom";

function AllLoanCards() {
    const [loans, setLoans] = useState([]);
    const navigate = useNavigate();

    useEffect(()=>{
        const url= "http://localhost:8080/getAllLoanCards";
        axios
        .get(url)
        .then((response) => {
            console.log(response.data);
            setLoans(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[]);


    const handleDelete = async (id)=>{

      try{
        const response= await axios.get("http://localhost:8080/deleteLoanCard",{params: {loanId:id}});
        console.log(response.data)
        if(response.data ==="Failue"){
          console.error("Loan Id Not Found");
        }
        else{
          const loanData=loans.filter(loan => loan.itemId!==id);
          setLoans(loanData);
          
        }
      } catch(err){
        console.error("could not delete the loan");
      }
    }

    const handleEdit = (loanId) => {
      navigate('/editLoanCard', { state: {"loanId": loanId} });
     
    }

  return (
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Loan ID</th>
          <th>Loan Type</th>
          <th>Loan Duration</th>
          <th></th>
          <th></th>
        </tr>
      </thead>

      <tbody>
    {loans.map(loan =>(
         <tr>
         <td>{loan.loanId}</td>
         <td>{loan.loanType}</td>
         <td>{loan.durationInYears}</td>
         <td><button onClick={() => handleEdit(loan.loanId)}>Edit</button></td>
         <td><button onClick={() => handleDelete(loan.loanId)}>Delete</button></td>
       </tr>
    ))}
      </tbody>
    </Table>
  );
}

export default AllLoanCards;