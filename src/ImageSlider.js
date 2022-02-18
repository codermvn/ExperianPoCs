import React from 'react';

import AliceCarousel from 'react-alice-carousel';
import "react-alice-carousel/lib/alice-carousel.css";

import './ListStyle.css';
import pic1 from './pictures/pic1.jpg';
import pic2 from './pictures/pic2.jpg';
import pic3 from './pictures/pic3.jpg';

export default function ImageSlider() {

    return (
     <div className="">        
    <AliceCarousel autoPlay autoPlayInterval="3000">
      <img src={pic1} className="sliderimg" alt=""/>  
      <img />
      <img/>
    </AliceCarousel>
    </div>   
      );
}
