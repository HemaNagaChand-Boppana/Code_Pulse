import axios from "axios";

const api = axios.create({
  baseURL: "https://code-pulse-s70j.onrender.com",
});

export default api;