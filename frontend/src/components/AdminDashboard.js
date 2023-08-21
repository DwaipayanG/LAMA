import { useEffect, useState } from "react";
import axios from "axios";
import Card from 'react-bootstrap/Card';
import Header from "./Header";
import "../style/Card.css"

export default function AdminDashboard(){

    const [user,setUser]=useState(null);
    
    return (
        <div>
            <Header></Header>
        
            <p className="welcomeText"> Welcome <b>{sessionStorage.getItem("adminUsername")}</b> </p>
            <div style={{width:"70%",margin:"auto"}} className="d-flex justify-content-center m-2">
        
            <Card className="bgCard bg1 col-sm-6 col-lg-3">

            <Card.Body>
                <Card.Title>Customer Data Management</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text> */}
                <Card.Link href="/addEmployee">Add employee</Card.Link>
            </Card.Body>
            </Card>
           <Card className="bgCard bg2 col-sm-6 col-lg-3">

            <Card.Body>
                <Card.Title>Loan Card Management</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text> */}
                <Card.Link href="/addLoanCard">Loan cards</Card.Link>
            </Card.Body>
            </Card>
            <Card className="bgCard bg3 col-sm-6 col-lg-3">

            <Card.Body>
                <Card.Title>Items Master Data</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text> */}
                <Card.Link href="/addItem">Items master</Card.Link>
            </Card.Body>
            </Card>
            <Card className="bgCard bg4 col-sm-6 col-lg-3">
            <Card.Body>
                <Card.Title>All items</Card.Title>
                {/* <Card.Text>
                Some quick example text to build on the card title and make up the
                bulk of the card's content.
                </Card.Text> */}
                <Card.Link href="/viewAllItems">All item</Card.Link>
            </Card.Body>
            </Card>
        </div>
        </div>
    );
}