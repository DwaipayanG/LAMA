import axios from "axios";
import { useState } from "react";

export default function Login(){
    const baseURL = "http://localhost:8080/addEmployee";

    const [employeeId, setEmployeeId] = useState('');
    const [employeeName, setEmployeeName] = useState('');

    const employeeIdChangeHandler = (event) => {
        setEmployeeId(event.target.value)
    }

    const employeeNameChangeHandler = (event) => {
        setEmployeeName(event.target.value)
    }

    const submitActionHandler = (event) => {
        axios
            .post(baseURL, {
                "employeeId": employeeId,
                "employeeName": employeeName,
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
            <h3> Employee Login </h3>
             <form onSubmit={submitActionHandler}>
                ID : <input type="text" value={employeeId} onChange={employeeIdChangeHandler} id="employeeId"/><br></br>
                Name : <input type="text" value={employeeName} onChange={employeeNameChangeHandler} id="employeeName"/><br></br>
               
             </form>
        </div>
    );
};