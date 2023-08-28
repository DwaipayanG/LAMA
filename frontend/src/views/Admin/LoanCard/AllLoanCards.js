import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import { useNavigate } from "react-router-dom";
import Header from "../../../components/Header";
import AdminNavigation from "../../../components/AdminNavigation";
import "../../../style/TabularViewAll.css";
import {CiEdit} from "react-icons/ci";
import { FcEmptyTrash } from "react-icons/fc";

function AllLoanCards() {
    const [loans, setLoans] = useState([]);
    const [error,setError] = useState(null);
    const navigate = useNavigate();
    var fd= [1,2,34,5];
   

    useEffect(()=>{
        const url= "http://localhost:8080/api/loan-card/all-loans";
        axios
        .get(url)
        .then((response) => {
            console.log(response.data);
            const data=response.data;
            if(data['statusCode']&&data['statusCode']==400)
              setError("No data to display");
            else
              setLoans(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[]);


    const handleDelete = async (id)=>{

      try{
        const response= await axios.delete("http://localhost:8080/api/loan-card",{params: {loanId:id}});
        console.log(response.data);
        if(response.data ==="Failue"){
          console.error("Loan Id Not Found");
        }
        else{
          // const loanData=loans.filter(loan => loan.loanId!==id);
          // setLoans(loanData);
          window.location.reload();
        }
      } catch(err){
        console.error("could not delete the loan");
      }
    }

    const handleEdit = (loanId) => {
      navigate('/editLoanCard', { state: {"loanId": loanId} });
     
    }

  return (
    <div>
      <Header></Header>
      <AdminNavigation/>
      <h3>View All Loan</h3>
    <div className="scrollOverflowX">
    { !error &&
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Loan ID</th>
          <th>Loan Type</th>
          <th>Loan Duration</th>
          <th className="noBorder"></th>
          <th className="noBorder"></th>
        </tr>
      </thead>

      <tbody>
    {loans.map(loan =>(
         <tr>
         <td>{loan.loanId}</td>
         <td>{loan.loanType}</td>
         <td>{loan.durationInYears}</td>
         <td className="noBorder"><button className="noBorder smallIcons" onClick={() => handleEdit(loan.loanId)}><CiEdit /></button></td>
         <td className="noBorder"><button className="noBorder smallIcons" onClick={() => handleDelete(loan.loanId)}><FcEmptyTrash/></button></td>
       </tr>
    ))}
      </tbody>
    </Table>
    }
    {
      error
      &&
      <div><h1>{error}</h1></div>
    }
    </div>
    </div>
  );
}

export default AllLoanCards;