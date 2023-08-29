import { Row } from "react-bootstrap";
import {Col} from "react-bootstrap";
import {CiEdit} from "react-icons/ci";
import { FcEmptyTrash } from "react-icons/fc";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import "../style/ListEmployeeItem.css";
import { useEffect } from "react";




function ListEmployeeItem(props){



    const getURL= "http://localhost:8080/api/employee/all-employees";

    const [employees, setEmployees] = useState([]);
    const [message, setMessage] = useState();
    const navigate = useNavigate();

    useEffect(()=>{
       
        axios
        .get(getURL)
        .then((response) => {
            console.log(response.data);
            const data=response.data;
            if(data['statusCode']&&data['statusCode']==400)
              setMessage("No employees to display");
            else
              setEmployees(response.data);
        })
        .catch((err) =>{
          console.log(err);
        });
    },[]);

    function alternate(number){
    if(number== 0){
        return " evenChildList";

    }

    else return " oddChildList";
}

    const handleDelete = async (id)=>{

        try{
          const response= await axios.delete("http://localhost:8080/api/employee",{params: {employeeId:id}});
          console.log(response.data)
          if(response.data ==="Failure"){
            console.error("User Id Not Found");
          }
          else{
            window.location.reload();           
          }
        } catch(err){
          console.error("could not delete the employee");
        }
      }
  
      const handleEdit = (id) => {
        navigate('/admin/employees/edit', { state: {employeeId: id} });
       
      }
    return(
        <>
        <div  >
            <Row className= {"employeeListItem"  +alternate(props.number)}  >
                <Col sm={5} lg={4}><b>ID:</b> {props.empId}</Col>
                <Col sm={5} lg={4}><b>Name: </b>{props.empName}</Col>
                <Col sm={5} lg={4}><b>DOB: </b> {props.dob}</Col>
                <Col  sm={5} lg={4}><b>Department: </b>{props.department}</Col>
                <Col  sm={5} lg={4}><b>Designation: </b>{props.designation}</Col>
                <Col  sm={5} lg={4}><b>DOJ: </b>{props.doj}</Col>
            
                <Col  sm={5} lg={4}><b>Gender: </b>{props.gender}</Col>
                <Col  sm={5} lg={4}>Edit: <button className="noBorder smallIcons"onClick={() => handleEdit(props.empId)}><CiEdit/></button></Col>
                <Col  sm={5} lg={4}>Delete: <button className="noBorder smallIcons" onClick={() => handleDelete(props.empId)}><FcEmptyTrash/></button></Col>
            </Row>
        </div>
        
        </>
    )
}

export default ListEmployeeItem;