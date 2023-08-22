import { Link } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import Header from "./Header";

function Home() {
  return (
    <div>
      <Header></Header>
    <Navbar expand="lg" className="bg-body-tertiary justify-content-center m-auto">
      <Container>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="m-auto">
            <Nav.Link href="/loginAdmin">Admin Login</Nav.Link>
            <Nav.Link href="/loginEmployee">Employee Login</Nav.Link>
            <Nav.Link href="/about">About</Nav.Link>
          
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    </div>
  );
}

export default Home;
