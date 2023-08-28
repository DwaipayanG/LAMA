import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Header from "../components/Header";
import "../style/Home.css";
import Starlights from "../components/Starlight/Starlights";

function Home() {
  return (
    <div className="homeBackground">
      <Header></Header>
    <Navbar expand="lg" className="bg-body-tertiary justify-content-center m-auto">
      <Container>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="m-auto">
            <Nav.Link href="/admin/login">Admin Login</Nav.Link>
            <Nav.Link href="/employee/login">Employee Login</Nav.Link>
            <Nav.Link href="/about">About</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    <Starlights/>
    <Starlights/>
    <Starlights/>
    <Starlights/>
    <Starlights/>
    <Starlights/>
    <div className="homeText">
      <h2 className="fadeInUp middle headText">
           You Dream, <span className="homeHighlight"> We Help</span>
      </h2>

      <h3 className="fadeInUp middle headText">
            Get Loans For <span className="homeHighlight rotator"></span>
      </h3>
      </div>

    </div>
  );
}

export default Home;
