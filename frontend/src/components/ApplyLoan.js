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
    const [loanId, setLoanId] = useState("");
    const [itemId, setItemId] = useState("");

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
        const url="http://localhost:8080/getItemByMakeAndCategory";
        axios
        .post(url,{
            itemCategory:selectedCategory,
            itemMake:make
        })
        .then((response) => {
            console.log(response.data);
            setValue(response.data.itemValuation);
            setDescription(response.data.itemDescription);
            setItemId(response.data.itemId);
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
    }
    const makeChangeHandler = (event) => {
        console.log(event.target.value);
        setMake(event.target.value);

        setValue("0");
    }

    const submitActionHandler = async() => {
        const getLoanCardUrl = "http://localhost:8080/getLoanCardByLoanType"
        const loanApplyUrl = "http://localhost:8080/applyLoan"

        const loanIssueDate = new Date();

        await axios
            .post(getLoanCardUrl, {
                "loanType": selectedCategory
            })
            .then((response)=> {
                axios
                .post(loanApplyUrl, {
                    "loanId": response.data.loanId,
                    "employeeId": employeeId,
                    "itemId": itemId,
                    "loanIssueDate": loanIssueDate
                })
                .then((response)=>{
                    alert(loanId)
                })
                .catch((error)=> {
                    alert(error)
                })
                
            })
            .catch((error)=>{
                alert(error)
            });

      
    }

    return (
        <div  className="borderBox"style={{width:"70%",margin:"auto"}}>
            <h1> Apply Loan </h1>
            <br></br>
            <hr></hr>
            <br></br>
            <Form onSubmit={submitActionHandler}>
            <div className="field"> 
                <div className="column"> Employee ID :</div>
                <div className="value">{employeeId}</div>
            </div>
            <div className="field">
            <div className="column"> Item Category :</div>
                <div className="value">
                    <select id="dropdown-basic-button" title="Dropdown button" onChange={categoryChangeHandler}>
                        <option selected="selected">--Select--</option>
                        {
                            category.map((val)=>{
                                return (<option value={val}>{val}</option>);
                            })
                        }
                    </select>
                </div>
            </div>
            
            <div className="field">
                <div className="column"> Item Make :</div>
                <div className="value">
                    <select id="dropdown-basic-button" title="Dropdown button" onChange={makeChangeHandler}>
                    <option selected="selected">--Select--</option>
                        {
                            makeList.map((val)=>{
                                return (<option value={val}>{val}</option>);
                            })
                        }
                    </select>
                </div>
            </div>

            <div className="field">
                <div className="column"> Value :</div>
                <div className="value">{value}</div>
            </div>

            <div className="field">
                <div className="column"> Description :</div>
                <div className="value" >{description}</div>
            </div>

            <Button variant="primary" type="submit">
                Submit
            </Button>
            </Form>
        </div>
    );
}