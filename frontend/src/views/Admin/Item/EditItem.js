import axios from "axios";
import { useState, useEffect } from "react";
import { useLocation } from "react-router-dom";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from "../../../components/Header";
import AdminNavigation from "../../../components/AdminNavigation";

export default function EditItem(){
    const location = useLocation();
    
    const [allCategory, setAllCategory] = useState([]);

    const [itemId, setItemId] = useState(location.state.itemId);
    const [itemCategory, setItemCategory] = useState('');
    const [itemDescription, setItemDescription] = useState('');
    const [itemValue, setItemValue] = useState('');
    const [itemMake, setItemMake] = useState('');
    const [itemStatus, setItemStatus] = useState("");
    const [message, setMessage] = useState(null);

    const getURL="http://localhost:8080/api/item/by-item-id";
    const editURL="http://localhost:8080/api/item";

     useEffect(()=>{
        setItemId(location.state.itemId);

        axios
        .get(getURL, {params: {"itemId" : itemId}})
        .then((response) => {
            console.log(response.data);
            setItemCategory(response.data.itemCategory);
            setItemDescription(response.data.itemDescription);
            setItemValue(response.data.itemValuation);
            setItemMake(response.data.itemMake);
            setItemStatus(response.data.itemStatus);
        })
        .catch((error) => {
            console.log(error);
        });
    },[]);

    useEffect(()=>{
        const url="http://localhost:8080/api/item/all-category";
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

    function SelectStatus(){
        if(itemStatus==="N"){
            return(
            <select id="dropdown-basic-button" title="Dropdown button" onChange={itemStatusChangeHandler}>
                <option selected="selected" value="N">No</option>
                <option value="Y">Yes</option>
            </select>
            );
        }

        else {

            return(
                <select id="dropdown-basic-button" title="Dropdown button" onChange={itemStatusChangeHandler}>
                    <option value="N">No</option>
                    <option selected="selected" value="Y">Yes</option>
                </select>
                );

        }
    }
  
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
            .put(editURL, {
                "itemId": itemId,
                "itemCategory": itemCategory,
                "itemDescription": itemDescription,
                "itemValuation": itemValue,
                "itemMake": itemMake,
                "itemStatus":itemStatus,
            },{
                params:{
                    "itemId": itemId
                }
            })
            .then((response) => {
                console.log(response)
                setMessage("Item edited successfully!")
            })
            .catch((error) => {
                alert(error);
            })
    }

    return (
        <div>
            <Header></Header>
            <AdminNavigation/>
        
        <div className="addEmployeeBox">
            <h3> Edit Item </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addItemColumn">Item ID</Form.Label>
                    <Form.Control className="addItemValue" type="text" value={itemId} onChange={itemIdChangeHandler} id="itemId" disabled />
                </Form.Group>
                <div className="addItemColumn"> Item Status </div>
                    <div className="addItemValue">
                        <SelectStatus/>
                    </div>
                <div className="addItemColumn"> Item Category :</div>
                <div className="addItemValue">
                    <select id="dropdown-basic-button" title="Dropdown button" onChange={itemCategoryChangeHandler} disabled>
                        {
                            allCategory.map((val)=>{
                                if (val=== itemCategory)
                                return (<option selected="selected" val= {val}> {val}</option>);
                                else
                                return (<option val= {val}>{val}</option>)
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
            {message && <div style={{color:"green"}}><b>{message}</b></div>}
        </div>
        </div>
    );
};