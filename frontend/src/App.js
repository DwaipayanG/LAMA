import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import LoginEmployee from './components/LoginEmployee';
import LoginAdmin from './components/LoginAdmin';
import Home from './components/Home';
import About from './components/About';
import AddEmployee from './components/AddEmployee';
import EmployeeDashboard from './components/EmployeeDasboard';
import AdminDashboard from './components/AdminDashboard';
import ApplyLoans from './components/ApplyLoan';
import ViewLoans from './components/ViewLoans';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={ <Home/> }/> 
          <Route exact path="/loginAdmin" element={ <LoginAdmin/> }/>
          <Route exact path="/loginEmployee"element= { <LoginEmployee/> }/>
          <Route exact path="/about" element={ <About/> }/>
          <Route exact path="/adminDashboard" element={ <AdminDashboard /> }/>
          <Route exact path="/addEmployee" element={ <AddEmployee/> }/> 
          <Route exact path="/employeeDashboard" element={ <EmployeeDashboard/> }/> 
          <Route exact path="/applyLoan" element={ <ApplyLoans/> }/> 
          <Route exact path= "/viewLoans" element= {<ViewLoans/>} />
        </Routes>
      </BrowserRouter>
      <></>
    </div>
  );
}

export default App;
