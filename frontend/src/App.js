import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Login from './components/LoginEmployee';
import Home from './components/Home';
import About from './components/About';
import AddEmployee from './components/AddEmployee';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={ <Home/> }/> 
          <Route exact path="/login" element={ <Login/> }/>
          <Route exact path="/about" element={ <About/> }/>
          <Route exact path="/addEmployee" element={ <AddEmployee/> }/> 
        </Routes>
      </BrowserRouter>
      <></>
    </div>
  );
}

export default App;
