import './App.css';
import api from './api/axiosConfig';
import { useState, useEffect } from 'react';

function App() {
    const [movies, setMovies] = useState();

    const getMovies = async () => {
        try {
            const response = await api.get("api/v1/movies");
            console.log(response.data);
            setMovies(response.data);
        } catch (err) {
            console.log(err);
        }
    };

    useEffect(() => {
        getMovies();
    }, []);

    return (
        <div className="App">
            {movies && movies.map(movie => (
                <div key={movie.id}>{movie.title}</div>
            ))}
        </div>
    );
}

export default App;
