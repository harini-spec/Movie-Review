import React from "react"; 
import HeroComponent from "../hero/HeroComponent";

const HomeComponent = ({movies}) => {
  return (
    <HeroComponent movies={movies}/>
  )
}

export default HomeComponent