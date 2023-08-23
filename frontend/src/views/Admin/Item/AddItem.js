import axios from "axios";
import { useState, useEffect } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "../../../style/AddItem.css";
import Header from "../../../components/Header";
import AdminNavigation from "../../../components/AdminNavigation";

export default function AddItem(){
    const baseURL = "http://localhost:8080/api/item";

    const [allCategory, setAllCategory] = useState([]);
    const [itemId, setItemId] = useState('');
    const [itemCategory, setItemCategory] = useState('');
    const [itemDescription, setItemDescription] = useState('');
    const [itemValue, setItemValue] = useState('');
    const [itemMake, setItemMake] = useState('');
    const [itemStatus, setItemStatus] = useState("");
    const [error, setError] = useState(null);
  
    useEffect(()=>{
        const url="http://localhost:8080/api/loan-card/all-loan-types";
        axios
        .get(url)
        .then((response) => {
            console.log(response.data);
            setAllCategory(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
    },[]);

  
    const itemIdChangeHandler = (event) => {
        setItemId(event.target.value)
    }

    const itemCategoryChangeHandler = (event) => {
        setItemCategory(event.target.value)
    }

    const itemDescriptionChangeHandler = (event) => {
        setItemDescription(event.target.value)
    }
    const itemStatusChangeHandler = (event) => {
        setItemStatus(event.target.value)
    }

    const itemValueChangeHandler = (event) => {
        setItemValue(event.target.value)
    }

    const itemMakeChangeHandler = (event) => {
        setItemMake(event.target.value);
    }

    const submitActionHandler = (event) => {
        event.preventDefault();
        axios
            .post(baseURL, {
                "itemId": itemId,
                "itemCategory": itemCategory,
                "itemDescription": itemDescription,
                "itemValuation": itemValue,
                "itemMake": itemMake,
                "itemStatus":itemStatus,
            })
            .then((response) => {
                const data=response.data;
                if(data["statusCode"]&&data["statusCode"]==400)
                    setError(data["message"]);
                else
                    alert("Item created");
            })
            .catch((error) => {
                alert(error);
            })
    }

    return (
        <div>
            <Header></Header>
            <AdminNavigation></AdminNavigation>
        
        <div className="addItemBox">
            <h3> Add Item </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addItemColumn">Item ID</Form.Label>
                    <Form.Control className="addItemValue" type="text" value={itemId} onChange={itemIdChangeHandler} id="itemId" />
                </Form.Group>
                <div className="addItemColumn"> Item Status </div>
                    <div className="addItemValue">
                        <select id="dropdown-basic-button" title="Dropdown button" onChange={itemStatusChangeHandler}>
                                <option selected="selected">--Select--</option>
                                <option value="N">No</option>
                                <option value="Y">Yes</option>
                        </select>
                    </div>
                <div className="addItemColumn"> Item Category :</div>
                    <div className="addItemValue">
                        <select id="dropdown-basic-button" title="Dropdown button" onChange={itemCategoryChangeHandler}>
                            <option selected="selected">--Select--</option>
                            {
                                allCategory.map((val)=>{
                                    return (<option value={val}>{val}</option>);
                                })
                            }
                        </select>
                    </div>
                <Form.Group className="mb-3">
                    <Form.Label className="addItemColumn">Item Description</Form.Label>
                    <Form.Control className="addItemValue" type="text" value={itemDescription} onChange={itemDescriptionChangeHandler} id="itemDescription" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addItemColumn">Item Value</Form.Label>
                    <Form.Control className="addItemValue" type="text" value={itemValue} onChange={itemValueChangeHandler} id="itemValue" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addItemColumn">Item Make</Form.Label>
                    <Form.Control className="addItemValue" type="text" value={itemMake} onChange={itemMakeChangeHandler} id="itemMake" />
                </Form.Group>
                <Button variant="primary" type="submit">
                    Submit
                </Button>
            </Form>
            {error && <div style={{color:"red"}}><b>{error}</b></div>}
        </div>
        </div>
    );
};