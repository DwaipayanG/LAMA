import { Link } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';


function AdminNavigation() {
  return (
    <div>
    <Navbar expand="lg" className="bg-body-tertiary justify-content-center m-auto adminNavigation">
      <Container>
        <Navbar.Brand className=" textWhite" href="/">Loan Admin Management Application</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="m-auto">
            <Nav.Link href="/adminDashboard" className=" textWhite">Dashboard</Nav.Link>
            <NavDropdown title="Employee Data" id="basic-nav-dropdown">
              <NavDropdown.Item className=" textWhite" href="/addEmployee">Add Employee</NavDropdown.Item>
              <NavDropdown.Item href="/viewAllEmployees" className=" textWhite">View Employees</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown title="Item" id="basic-nav-dropdown">
              <NavDropdown.Item href="/addItem">Add Item</NavDropdown.Item>
              <NavDropdown.Item href="/viewAllItems" className=" textWhite">View Items</NavDropdown.Item>
            </NavDropdown>
            <NavDropdown className=" textWhite" title="Loan" id="basic-nav-dropdown">
              <NavDropdown.Item href="/addLoanCard" className=" textWhite">Add </NavDropdown.Item>
              <NavDropdown.Item href="/viewLoans" className=" textWhite">View Loans</NavDropdown.Item>
            </NavDropdown>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </div>
  );
}

export default AdminNavigation;
