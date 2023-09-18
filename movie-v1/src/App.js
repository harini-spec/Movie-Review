import './App.css';
import {useState, useEffect} from 'react';
import api from './axios/axiosConfig';
import { Route, Routes } from 'react-router-dom';
import Layout from './Components/Layout';
import HomeComponent from './Components/home/HomeComponent';
import HeaderComponent from './Components/header/HeaderComponent';
import TrailerComponent from './Components/trailer/TrailerComponent';
import Reviews from './Components/reviews/Reviews';

function App() {

  const [movies, setMovies] = useState();
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState([]);

  const getMovies = async () => {
    try{
      const response = await api.get("/v1/api/movies");  // axios imported
      // console.log(response.data);
      setMovies(response.data);
    }
    catch(err){
      console.log(err);
    }
  }

  useEffect(() =>{
    getMovies();
  }, [])

  // To get single movie data from id
  const getMovieData = async (movieId) => {
     
    try 
    {
        const response = await api.get(`/v1/api/movies/${movieId}`);
        const singleMovie = response.data;

        console.log(singleMovie);

        // console.log("1",singleMovie.reviews.body);
        setMovie(singleMovie);

        setReviews(singleMovie.reviewIds);
        // console.log("2",singleMovie.reviewsIds.review);
    } 
    catch (error) 
    {
      console.error(error);
    }

  }

  return (
    <div className="App">
      <HeaderComponent/>
      <Routes>
          <Route path="/" element={<Layout/>}>
              <Route path="/" element={<HomeComponent movies={movies}/>} />
              <Route path="/Trailer/:ytTrailerId" element={<TrailerComponent/>}></Route> 

              {/* this address is called from the hero component when play button is hit */}
              <Route path="/Reviews/:movieId" element ={<Reviews getMovieData = {getMovieData} movie={movie} reviews ={reviews} setReviews = {setReviews} />}></Route>
          </Route>
      </Routes>
    </div>
  );
}

export default App;
