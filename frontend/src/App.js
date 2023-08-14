import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import LoginEmployee from './components/LoginEmployee';
import LoginAdmin from './components/LoginAdmin';
import Home from './components/Home';
import About from './components/About';
import AddEmployee from './components/AddEmployee';
import Dashboard from './components/Dasboard';
import ApplyLoans from './components/ApplyLoan';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={ <Home/> }/> 
          <Route exact path="/loginAdmin" element={ <LoginAdmin/> }/>
          <Route exact path="/loginEmployee"element= { <LoginEmployee/> }/>
          <Route exact path="/about" element={ <About/> }/>
          <Route exact path="/addEmployee" element={ <AddEmployee/> }/> 
          <Route exact path="/dashboard" element={ <Dashboard/> }/> 
          <Route exact path="/applyLoan" element={ <ApplyLoans/> }/> 
        </Routes>
      </BrowserRouter>
      <></>
    </div>
  );
}

export default App;
