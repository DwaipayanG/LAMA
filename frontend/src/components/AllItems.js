import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';


function AllItems() {
    const [items, setItems] = useState([]);
    useEffect(()=>{
        const url= "http://localhost:8080/getAllItem";
        axios
        .get(url)
        .then((response) => {
            console.log(response.data);
            setItems(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[]);


  return (
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Item ID</th>
          <th>Description</th>
          <th>Issue Status</th>
          <th>Item Make</th>
          <th> Item Category </th>
          <th> Item Valuation</th>
          <th></th>
          <th></th>
        </tr>
      </thead>

      <tbody>
    {items.map(item =>(
         <tr>
         <td>{item.itemId}</td>
         <td>{item.description}</td>
         <td>{item.issueStatus}</td>
         <td>{item.itemMake}</td>
         <td>{item.itemCategory}</td>
         <td>{item.itemValuation}</td>
         <td>Edit</td>
         <td>Delete</td>
       </tr>
    ))}
      </tbody>
    </Table>
  );
}

export default AllItems;