import { Link } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Button from 'react-bootstrap/Button';
import "../style/Header.css";
import { useNavigate } from "react-router-dom";
import { useEffect } from "react";




function AdminNavigation() {

  const navigate = useNavigate();

  function handleLogout (){
    sessionStorage.clear();
    navigate("/");
  }

  useEffect(() => {
    const loggedInUser = sessionStorage.getItem("adminUsername");
    if (loggedInUser !=="admin") {
      navigate("/");
    }
  }, []);

  return (
    <div>
    <Navbar expand="lg" className="bg-body-tertiary justify-content-center m-auto navigationBar">
      <Container>
        <Navbar.Brand  href="/">Loan Admin Management Application</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="m-auto">
            <Nav.Link href="/adminDashboard" >Dashboard</Nav.Link>
            <NavDropdown title="Employee Data"  id="basic-nav-dropdown">
              <NavDropdown.Item  href="/addEmployee">Add Employee</NavDropdown.Item>
              <NavDropdown.Item href="/viewAllEmployees" >View Employees</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown  title="Item" id="basic-nav-dropdown">
              <NavDropdown.Item href="/addItem">Add Item</NavDropdown.Item>
              <NavDropdown.Item href="/viewAllItems" >View Items</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown  title="Loan" id="basic-nav-dropdown">
              <NavDropdown.Item href="/addLoanCard" >Add Loan</NavDropdown.Item>
              <NavDropdown.Item href="/viewAllLoanCards">View Loans</NavDropdown.Item>
            </NavDropdown>
          </Nav>
        <Button variant="danger" onClick={() =>handleLogout()}>Logout</Button>

        </Navbar.Collapse>

        
      </Container>
      
    </Navbar>
    </div>
  );
}

export default AdminNavigation;
