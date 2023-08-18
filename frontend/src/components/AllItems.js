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


    const handleDelete = async (id)=>{

      try{
        const response= await axios.get("http://localhost:8080/deleteItem",{params: {itemId:id}});
        console.log(response.data)
        if(response.data ==="Failue"){
          console.error("User Id Not Found");
        }
        else{
          const itemData=items.filter(item => item.itemId!==id);
          setItems(itemData);
          
        }
      } catch(err){
        console.error("could not delete the item");
      }
    }

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
         <td>{item.itemDescription}</td>
         <td>{item.itemStatus}</td>
         <td>{item.itemMake}</td>
         <td>{item.itemCategory}</td>
         <td>{item.itemValuation}</td>
         <td>Edit</td>
         <td><button onClick={() => handleDelete(item.itemId)}>Delete</button></td>
       </tr>
    ))}
      </tbody>
    </Table>
  );
}

export default AllItems;