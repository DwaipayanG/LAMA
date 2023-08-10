import { Link } from "react-router-dom";

export default function Home(){
    return (
        <div>
            <h3> Home </h3>
            <Link to="/login"> Login </Link>
            <Link to="/about"> About </Link>
        </div>
    );
};