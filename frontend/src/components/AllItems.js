import axios from "axios";
import React, { useEffect, useState } from "react";
import Table from 'react-bootstrap/Table';
import { useNavigate } from "react-router-dom";
import Header from "./Header"
import "../style/TabularViewAll.css";
import {CiEdit} from "react-icons/ci";
import { FcEmptyTrash } from "react-icons/fc";

function AllItems() {
    const [items, setItems] = useState([]);
    const navigate = useNavigate();

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
          console.error("Item Id Not Found");
        }
        else{
          const itemData=items.filter(item => item.itemId!==id);
          setItems(itemData);
          
        }
      } catch(err){
        console.error("could not delete the item");
      }
    }

    const handleEdit = (id) => {
      navigate('/editItem', { state: {itemId: id} });
     
    }

  return (
    <div>

    <Header></Header>
    <h3>View All Items</h3>
    <Table striped bordered hover>
      <thead>
        <tr>
          <th>Item ID</th>
          <th>Description</th>
          <th>Issue Status</th>
          <th>Item Make</th>
          <th> Item Category </th>
          <th> Item Valuation</th>
          <th className="noBorder" ></th> 
          <th className="noBorder"></th>
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
         <td className="noBorder"><button className="noBorder smallIcons" onClick={() => handleEdit(item.itemId)}><CiEdit/></button></td>
         <td className="noBorder"><button className="noBorder smallIcons" onClick={() => handleDelete(item.itemId)}><FcEmptyTrash/></button></td>
       </tr>
       
    ))}
      </tbody>
    </Table>
    </div>
  );
}

export default AllItems;