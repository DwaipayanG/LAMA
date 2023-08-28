import { Link } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import "../style/Header.css"
import { useNavigate } from "react-router-dom";
import { Button } from "react-bootstrap";
import { useEffect } from "react";
import user from "../assets/user.png"

function EmployeeNavigation (){

  const navigate = useNavigate();

  function handleLogout (){
    sessionStorage.clear();
    navigate("/");
  }

  useEffect(() => {
    const loggedInUser = sessionStorage.getItem("employeeName");
    if (loggedInUser === null) {
      navigate("/");
    }
  }, []);

    return (
<div>
    <Navbar expand="lg" className="bg-body-tertiary justify-content-center m-auto navigationBar">
      <Container>
        <Navbar.Brand  href="/">Loan Employee Management Application</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="m-auto">
            <Nav.Link href="/employee/dashboard" >Dashboard</Nav.Link>
            <Nav.Link href="/employee/loans" >View Loans</Nav.Link>
            <Nav.Link href="/employee/items" >View Item</Nav.Link>
            <Nav.Link href="/employee/apply-loan" >Apply Loan</Nav.Link>
          </Nav>
          <img src={user} style ={{marginRight:"5px"}}/>
          <Button variant="danger" onClick={() =>handleLogout()}>Logout</Button>
        </Navbar.Collapse>
        

      </Container>
    </Navbar>
    </div>
  );
}

export default EmployeeNavigation;