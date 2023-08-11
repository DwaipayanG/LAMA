import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

import Login from './components/Login';
import Home from './components/Home';
import About from './components/About';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route exact path="/" element={ <Home/> }/> 
          <Route exact path="/login" element={ <Login/> }/>
          <Route exact path="/about" element={ <About/> }/> 
        </Routes>
      </BrowserRouter>
      <></>
    </div>
  );
}

export default App;
