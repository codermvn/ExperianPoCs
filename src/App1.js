
import { Route, Routes } from 'react-router-dom';
 
import {
  BrowserRouter as Router,
  Redirect,
} from "react-router-dom";
  
import Home from "./components/Home";
import About from "./components/About";
import ContactUs from "./components/ContactUs";
  
function App1() {
  return (
    <>
      <Router>
        <Routes>
          <Route exact path="/" component={Home} />
          <Route path="/about" component={About} />
          <Route path="/contactus" component={ContactUs} />            
         
        </Routes>
      </Router>
    </>
  );
}
  
export default App1;
