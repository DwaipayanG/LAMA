import { Link } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import "../style/Header.css"
function EmployeeNavigation (){

    return (
<div>
    <Navbar expand="lg" className="bg-body-tertiary justify-content-center m-auto navigationBar">
      <Container>
        <Navbar.Brand  href="/">Loan Employee Management Application</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="m-auto">
            <Nav.Link href="/employeeDashboard" >Dashboard</Nav.Link>
            <Nav.Link href="/viewLoans" >View Loans</Nav.Link>
            <Nav.Link href="/viewItems" >View Item</Nav.Link>
            <Nav.Link href="/applyLoan" >Apply Loan</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </div>
  );
}

export default EmployeeNavigation;