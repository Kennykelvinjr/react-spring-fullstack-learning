import React, { useState } from "react";
import { createSchool } from "../services/schoolService";
import { useNavigate } from "react-router-dom";

const AddSchool = () => {
    const navigate = useNavigate();

  const [form, setForm] = useState({
    name: "",
    address: "",
    email: "",
    phoneNumber: "",
    website: "",
  });

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await createSchool(form);
    alert("School added");
    navigate("/"); // redirect to schools page
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" onChange={handleChange} placeholder="Name" />
      <input name="address" onChange={handleChange} placeholder="Address" />
      <input name="email" onChange={handleChange} placeholder="Email" />
      <input name="phoneNumber" onChange={handleChange} placeholder="Phone Number" />
      <input name="website" onChange={handleChange} placeholder="Website" />

      <button type="submit">Add</button>
    </form>
  );
};

export default AddSchool;