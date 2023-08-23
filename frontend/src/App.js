import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import LoginEmployee from './views/Employee/LoginEmployee'
import LoginAdmin from './views/Admin/LoginAdmin';
import Home from './views/Home';
import About from './views/About';
import AddEmployee from './views/Admin/Employees/AddEmployee';
import EmployeeDashboard from './views/Employee/EmployeeDasboard';
import AdminDashboard from './views/Admin/AdminDashboard';
import ApplyLoans from './views/Employee/ApplyLoan';
import ViewLoans from './views/Employee/ViewLoans';
import ViewItems from './views/Employee/ViewItem';
import AddItem from './views/Admin/Item/AddItem';
import AddLoanCard from './views/Admin/LoanCard/AddLoanCard';
import AllEmployees from './views/Admin/Employees/AllEmployees';
import AllItems from './views/Admin/Item/AllItems';
import AllLoanCards from './views/Admin/LoanCard/AllLoanCards';
import EditItem from './views/Admin/Item/EditItem';
import EditLoanCard from './views/Admin/LoanCard/EditLoanCard';
import EditEmployee from './views/Admin/Employees/EditEmployee';
import PageNotFound from './views/PageNotFound';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path ="*" element={<PageNotFound/>}/>
          <Route exact path="/" element={ <Home/> }/> 
          <Route exact path="/loginAdmin" element={ <LoginAdmin/> }/>
          <Route exact path="/loginEmployee"element= { <LoginEmployee/> }/>
          <Route exact path="/about" element={ <About/> }/>
          <Route exact path="/adminDashboard" element={ <AdminDashboard /> }/>
          <Route exact path="/addEmployee" element={ <AddEmployee/> }/> 
          <Route exact path="/employeeDashboard" element={ <EmployeeDashboard/> }/> 
          <Route exact path="/applyLoan" element={ <ApplyLoans/> }/> 
          <Route exact path= "/viewLoans" element= {<ViewLoans/>} />
          <Route exact path= "/viewItems" element= {<ViewItems/>} />
          <Route exact path="/addLoanCard" element= {<AddLoanCard />} />
          <Route exact path="/addItem" element= {<AddItem />} />
          <Route exact path ="/viewAllEmployees" element ={<AllEmployees />} />
          <Route exact path ="/viewAllItems" element ={<AllItems/>} />
          <Route exact path="/viewAllLoanCards" element={<AllLoanCards />} />
          <Route exact path ="/editItem" element ={<EditItem/>} />
          <Route exact path="/editLoanCard" element={<EditLoanCard />} />
          <Route excat path="/editEmployee" element={<EditEmployee/>} />
        </Routes>
      </BrowserRouter>
      <></>
    </div>
  );
}

export default App;
