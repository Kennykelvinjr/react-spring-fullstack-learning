import API from "./api";

// GET all
export const getSchools = () => API.get("/schools");

// GET one
export const getSchool = (id) => API.get(`/schools/${id}`);

// CREATE
export const createSchool = (data) => API.post("/schools", data);

// UPDATE
export const updateSchool = (id, data) =>
  API.put(`/schools/${id}`, data);

// DELETE
export const deleteSchool = (id) =>
  API.delete(`/schools/${id}`);