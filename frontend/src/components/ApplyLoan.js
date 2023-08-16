import { useEffect, useState } from "react";
import axios from "axios";
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link } from "react-router-dom";
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

export default function ApplyLoans(){

    const [user,setUser]=useState(null);

    const [employeeId, setEmployeeId] = useState("");
    const [category, setCategory] = useState([]);
    const [selectedCategory, setSelectedCategory] = useState("");
    const [makeList, setMakeList] = useState([]);
    const [make, setMake] = useState("");
    const [value, setValue] = useState("");
    const [description, setDescription] = useState("");

    useEffect(()=>{
        setEmployeeId(sessionStorage.getItem("employeeId"));
    },[]);

    useEffect(()=>{
        const url="http://localhost:8080/getAllCategory";
        axios
        .get(url)
        .then((response) => {
            console.log(response.data);
            setCategory(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
    },[]);

    useEffect(()=>{
        const url="http://localhost:8080/getDistinctMakesByCategory";
        axios
        .post(url,{
            "itemCategory":selectedCategory
        })
        .then((response) => {
            console.log(response.data);
            setMakeList(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
    },[selectedCategory]);

    useEffect(()=>{
        const url="http://localhost:8080/getItem";
        axios
        .post(url,{
            itemCategory:selectedCategory,
            itemMake:make
        })
        .then((response) => {
            console.log(response.data);
            setValue(response.data.itemValuation);
            setDescription(response.data.itemDescription);
        })
        .catch((error) => {
            console.log(error);
        });
    },[selectedCategory,make]);



    const employeeIdChangeHandler = (event) => {
        setEmployeeId(event.target.value)
    }
    const categoryChangeHandler = (event) => {
        console.log(event.target.value);
        setSelectedCategory(event.target.value);

        // axios();

        setMakeList(['one','two']);
    }
    const makeChangeHandler = (event) => {
        console.log(event.target.value);
        setMake(event.target.value);

        // axios();

        setValue("0");
    }

    const submitActionHandler = () => {

    }

    return (
        <div style={{width:"70%",margin:"auto"}}>
            <Form onSubmit={submitActionHandler}>

            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Employee ID</Form.Label>
                <Form.Control type="text" value={employeeId} onChange={employeeIdChangeHandler} placeholder="Enter employee ID" disabled/>
            </Form.Group>
            <div>
                Item Category:
                <select id="dropdown-basic-button" title="Dropdown button" onChange={categoryChangeHandler}>
                    {
                        category.map((val)=>{
                            return (<option value={val}>{val}</option>);
                        })
                    }
                </select>
            </div>
            
            <div>
                Item Make:
                <select id="dropdown-basic-button" title="Dropdown button" onChange={makeChangeHandler}>
                    {
                        makeList.map((val)=>{
                            return (<option value={val}>{val}</option>);
                        })
                    }
                </select>
            </div>


            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Value</Form.Label>
                <Form.Control type="text" value={value} disabled/>
            </Form.Group>

            <Form.Group className="mb-3" controlId="formBasicEmail">
                <Form.Label>Description</Form.Label>
                <Form.Control type="text" value={description} disabled/>
            </Form.Group>

            <Button variant="primary" type="submit">
                Submit
            </Button>
            </Form>
        </div>
    );
}