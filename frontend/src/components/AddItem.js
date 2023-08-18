import axios from "axios";
import { useState } from "react";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import "../style/AddEmployee.css";
import Header from "./Header";

export default function AddItem(){
    const baseURL = "http://localhost:8080/addItem";

    const [itemId, setItemId] = useState('');
    const [itemCategory, setItemCategory] = useState('');
    const [itemDescription, setItemDescription] = useState('');
    const [itemValue, setItemValue] = useState('');
    const [itemMake, setItemMake] = useState('');
    const [itemStatus, setItemStatus] = useState("");
  
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
                alert(response.data);
            })
            .catch((error) => {
                alert(error);
            })
    }

    return (
        <div>
            <Header></Header>
        
        <div className="addEmployeeBox">
            <h3> Add Item </h3>             
            <Form onSubmit={submitActionHandler}>
                <Form.Group className="mb-3">
                    <Form.Label className="addItemColumn">Item ID</Form.Label>
                    <Form.Control className="addItemValue" type="text" value={itemId} onChange={itemIdChangeHandler} id="itemId" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addItemColumn">Item Status</Form.Label>
                    <Form.Control className="addItemValue" type="itemStatus" value={itemStatus} onChange={itemStatusChangeHandler} id="itemStatus" />
                </Form.Group>
                <Form.Group className="mb-3">
                    <Form.Label className="addItemColumn">Item Category</Form.Label>
                    <Form.Control className="addItemValue" type="text" value={itemCategory} onChange={itemCategoryChangeHandler} id="itemCategory" />
                </Form.Group>
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
        </div>
        </div>
    );
};