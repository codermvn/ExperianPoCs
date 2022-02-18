import './ListStyle.css';
import './Styling.css';

import {Link } from "react-router-dom";
import { Router , Route, Switch } from "react-router-dom";

export default function HeaderList() {
    return (
  <div>        
   <ul>     
  <li className='menu'><a href="">Menu</a>
  </li>

  <li className='logo'>Ultimatix logo</li>
  <li className='home'><a href="">Home</a></li>
  <li><a href="">Building on belief</a></li>
  <li><a href="">CEO Connect</a></li>
  <li><a href="">Covid 19</a></li>
</ul>

</div>   
    );
  }


  function myFunction() {
    document.getElementById("myDropdown").classList.toggle("show");
  }
  
  window.onclick = function(event) {
    if (!event.target.matches('.dropbtn')) {
      var dropdowns = document.getElementsByClassName("dropdown-content");
      var i;
      for (i = 0; i < dropdowns.length; i++) {
        var openDropdown = dropdowns[i];
        if (openDropdown.classList.contains('show')) {
          openDropdown.classList.remove('show');
        }
      }
    }
  }
    
