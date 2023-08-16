import { useEffect, useState } from "react";
import axios from "axios";
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import { Link } from "react-router-dom";
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

import "../style/ApplyLoan.css"

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
        <div  className="borderBox"style={{width:"70%",margin:"auto"}}>
            <h1> Apply Loan </h1>
            <br></br>
            <hr></hr>
            <br></br>
            <Form onSubmit={submitActionHandler}>
            <div className="field"> 
                <span className="column"> Employee ID :</span>
                <span className="value">{employeeId}</span>
            </div>
            <div className="field">
            <span className="column"> Item Category :</span>
                <select id="dropdown-basic-button" title="Dropdown button" onChange={categoryChangeHandler}>
                    <option selected="selected">--Select--</option>
                    {
                        category.map((val)=>{
                            return (<option value={val}>{val}</option>);
                        })
                    }
                </select>
            </div>
            
            <div className="field">
            <span className="column"> Item Make :</span>
                <select id="dropdown-basic-button" title="Dropdown button" onChange={makeChangeHandler}>
                <option selected="selected">--Select--</option>
                    {
                        makeList.map((val)=>{
                            return (<option value={val}>{val}</option>);
                        })
                    }
                </select>
            </div>

            <div className="field">
                <span className="column"> Value :</span>
                <span className="value">{value}</span>
            </div>

            <div className="field">
                <span className="column"> Description :</span>
                <span className="value" >{description}</span>
            </div>

            <Button variant="primary" type="submit">
                Submit
            </Button>
            </Form>
        </div>
    );
}