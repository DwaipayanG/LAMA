import { useEffect, useState } from "react";
import axios from "axios";
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from "../../components/Header";

import "../../style/ApplyLoan.css"
import EmployeeNavigation from "../../components/EmployeeNavaigation";

export default function ApplyLoans(){

    const [employeeId, setEmployeeId] = useState("");
    const [category, setCategory] = useState([]);
    const [selectedCategory, setSelectedCategory] = useState("");
    const [makeList, setMakeList] = useState([]);
    const [make, setMake] = useState("");
    const [value, setValue] = useState("");
    const [description, setDescription] = useState("");
    const [itemId, setItemId] = useState("");
    const [error, setError] = useState(null);
    const [message, setMessage] = useState(null);

    useEffect(()=>{
        setEmployeeId(sessionStorage.getItem("employeeId"));
    },[]);

    useEffect(()=>{
        const url="http://localhost:8080/api/item/all-category";
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
        const url="http://localhost:8080/api/item/makes-by-category";
        axios
        .get(url,{ params: {"itemCategory": selectedCategory }})
        .then((response) => {
            console.log(response.data);
            setMakeList(response.data);
        })
        .catch((error) => {
            console.log(error);
        });
        
    },[selectedCategory]);

    useEffect(()=>{
        const url="http://localhost:8080/api/item/by-make-and-category";
        axios
        .get(url,{params:{
            itemCategory:selectedCategory,
            itemMake:make
        }})
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

    const submitActionHandler = async(event) => {
        event.preventDefault();
        const getLoanCardUrl = "http://localhost:8080/api/loan-card/by-loan-type"
        const loanApplyUrl = "http://localhost:8080/api/employee/apply-loan"

        const loanIssueDate = new Date();

        await axios
            .get(getLoanCardUrl, { params: {"loanType": selectedCategory } })
            .then((response)=> {
                axios
                .post(loanApplyUrl, {
                    "loanId": response.data.loanId,
                    "employeeId": employeeId,
                    "itemId": itemId,
                    "loanIssueDate": loanIssueDate
                })
                .then((response)=>{
                    setMessage("Loan applied successfully!");
                })
                .catch((error)=> {
                    setError(error);
                })
                
            })
            .catch((error)=>{
                setError(error);
            });

        
    }

    return (
        <div>
            <Header></Header>
            <EmployeeNavigation/>
        <div  className="borderBox" >
            <h1> Apply Loan </h1>
           <hr/>
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
            {error && <div style={{color:"red"}}><b>{error}</b></div>}
            {message && <div style={{color:"green"}}><b>{message}</b></div>}
        </div>
        </div>
    );
}