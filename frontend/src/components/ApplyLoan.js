import { useEffect, useState } from "react";
import axios from "axios";
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link } from "react-router-dom";
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';
import { setMaxIdleHTTPParsers } from "http";

export default function ApplyLoans(){

    const [user,setUser]=useState(null);

    const [id,setId] = useState("");
    const [employeeId, setEmployeeId] = useState("");
    const [category, setCategory] = useState([]);
    const [makeList, setMakeList] = useState([]);
    const [make, setMake] = useState("");
    const [value, setValue] = useState("");

    useEffect(()=>{
        const id=sessionStorage.getItem("id");
        setId(id);
    },[]);

    useEffect(()=>{
        const url="http://localhost:8080/getAllCategories";
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
        const url="http://localhost:8080/getAllMakes";
        axios
        .get(url,{data:{
            itemCategory:category
        }})
        .then((response) => {
            console.log(response.data);
            setMake(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
    },[category]);

    useEffect(()=>{
        const url="http://localhost:8080/getValue";
        axios
        .get(url,{data:{
            itemCategory:category,
            itemMake:make
        }})
        .then((response) => {
            console.log(response.data);
            setValue(response.data.value);
        })
        .catch((error) => {
            console.log(error);
        });
    },[category,make]);



    const employeeIdChangeHandler = (event) => {
        setEmployeeId(event.target.value)
    }
    const categoryChangeHandler = (event) => {
        console.log(event.target.value);
        setCategory(event.target.value);

        // axios();

        setMakeList(['one','two']);
    }
    const makeChangeHandler = (event) => {
        console.log(event.target.value);
        setMake(event.target.value);

        // axios();

        setValue("Yo");
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
                    <option value={"Furniture1"}>Action</option>
                    <option value={"Furniture2"}>Another action</option>
                    <option value={"Furniture3"}>Something else</option>
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

            <Button variant="primary" type="submit">
                Submit
            </Button>
            </Form>
        </div>
    );
}