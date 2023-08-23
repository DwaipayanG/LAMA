import { Link } from "react-router-dom";
import "../style/PageNotFound.css"

function PageNotFound(){
    return (
        <div className="pageNotFound">
            <h1 className="page404">404</h1>
            <h3 className="notFound">Page Not Found</h3>
            <Link className="safety" to="/">Go Back To Safety</Link>
        </div>
    );
}

export default PageNotFound;