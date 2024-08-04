import axios from 'axios';

const api = axios.create({
    baseURL: 'https://9c96-103-106-239-104.ap.ngrok.io/',
    headers: { "ngrok-skip-browser-warning": "true" }
});

export default api;