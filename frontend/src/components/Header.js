import React from "react";
import "../style/Header.css"
import { Link } from "react-router-dom";

function Header(){
    return(
        <div className="header">
            <div id="logo">
                <Link to ="/">LAM</Link>                
                </div>
            <h1>
                Loan Application Management
            </h1>
        </div>
    )
}

export default Header;