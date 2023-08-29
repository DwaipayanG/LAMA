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
import ChangePassword from './views/Employee/ChangePassword';
function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path="*" element={<PageNotFound/>}/>
          <Route exact path="/" element={ <Home/> }/> 
          <Route exact path="/admin/login" element={ <LoginAdmin/> }/>
          <Route exact path="/employee/login"element= { <LoginEmployee/> }/>
          <Route exact path="/employee/dashboard" element={ <EmployeeDashboard/> }/> 
          <Route exact path="/employee/apply-loan" element={ <ApplyLoans/> }/> 
          <Route exact path="/employee/loans" element= {<ViewLoans/>} />
          <Route exact path="/employee/items" element= {<ViewItems/>} />
          <Route exact path="/employee/change-password" element= {<ChangePassword />} />
          <Route exact path="/admin/dashboard" element={ <AdminDashboard /> }/>
          <Route exact path="/admin/employees/add" element={ <AddEmployee/> }/> 
          <Route exact path="/admin/loan-cards/add" element= {<AddLoanCard />} />
          <Route exact path="/admin/items/add" element= {<AddItem />} />
          <Route exact path="/admin/employees/view" element ={<AllEmployees />} />
          <Route exact path="/admin/items/view" element ={<AllItems/>} />
          <Route exact path="/admin/loan-cards/view" element={<AllLoanCards />} />
          <Route exact path="/admin/items/edit" element ={<EditItem/>} />
          <Route exact path="/admin/loan-cards/edit" element={<EditLoanCard />} />
          <Route exact path="/admin/employees/edit" element={<EditEmployee/>} />
        </Routes>
      </BrowserRouter>
      <></>
    </div>
  );
}

export default App;
