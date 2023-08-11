import { Link } from "react-router-dom";

export default function Home(){
    return (
        <div>
            <h3> Home </h3>
            <Link to="/login"> Employee Login </Link>
            <Link to="/about"> About </Link>
            <Link to="/addEmployee">Add Employee</Link>
        </div>
    );
};