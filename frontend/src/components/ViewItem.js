import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import Header from "./Header";


function ViewItems() {
    const [items, setItem] = useState([]);
    const [empId, setEmployeeId]= useState("");

    useEffect(()=>{
        setEmployeeId(sessionStorage.getItem("employeeId"));
        console.log("yo");
    });

    useEffect(()=>{
        const url= "http://localhost:8080/getAllItems";
        axios
        .get(url, {params: {employeeId:empId}})
        .then((response) => {
            console.log(response.data);
            setItem(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[empId]);


  return (
    <>
    <Header></Header>
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
    </Table>
    </>
  );
}

export default ViewItems;