import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Header from "../../components/Header";
import EmployeeNavigation from "../../components/EmployeeNavaigation";


function ViewItems() {
    const [items, setItem] = useState([]);
    const [empId, setEmployeeId]= useState("");
    const [error, setError] = useState(null);

    useEffect(()=>{
        setEmployeeId(sessionStorage.getItem("employeeId"));
        console.log("yo");
    });

    useEffect(()=>{
        const url= "http://localhost:8080/api/employee-card/all-items-by-employee-id";
        axios
        .get(url, {params: {employeeId:sessionStorage.getItem("employeeId")}})
        .then((response) => {
            console.log(response.data);
            const data = response.data;
            if(data.length==0)
              setError("No Items purchased!");
            else
              setItem(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[empId]);


  return (
    <>
    <Header></Header>
    <EmployeeNavigation/>
    
    { !error &&
      <Table striped bordered hover>
      <thead>
        <tr>
          <th>Issue ID</th>
          <th>Item Description</th>
          <th>Item Make</th>
          <th>Item Category</th>
          <th>Item valuations</th>
        </tr>
      </thead>

      <tbody>
    {items.map(item =>(
         <tr>
         <td>{item.issueId}</td>
         <td>{item.itemDescription}</td>
         <td>{item.itemMake}</td>
         <td>{item.itemCategory}</td>
         <td>{item.itemValuation}</td>
       </tr>
    ))}
      </tbody>
    </Table>}
    {error &&
    <div><h1>{error}</h1></div>}
    </>
  );
}

export default ViewItems;