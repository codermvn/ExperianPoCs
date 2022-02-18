import React, { Component } from 'react'  

import "slick-carousel/slick/slick.css";  
import "slick-carousel/slick/slick-theme.css";  

import Slider from "react-slick";  

import './slickdemo.css';  

import pic4 from './pictures/pic4.jpg';
import pic6 from './pictures/pic6.jpg';

import pic7 from './pictures/pic7.jpg';

export class SlickDemo extends Component {  
    render() {  
        var settings = {  
          dots: true,  
          infinite: true,  
          speed: 500,  
          centerMode: true,  
          slidesToShow: 1,  
          slidesToScroll: 1                      
          };  
          return (  
            <div>  
            <Slider {...settings} >  
              <div className="wdt1">  
              <img  className="img1" src= {pic4}  alt=''/>                
              </div>  
             
              <div className="wdt2">  
              <img  className="img2" src= {pic6} alt=''/>  
              </div >  
              
              <div className="wdt3">  
              <img  className="img3" src= {pic7} alt=''/>  
              </div>  
                           
            </Slider>  
            </div>  
          );  
        }  
      }  
  
export default SlickDemo