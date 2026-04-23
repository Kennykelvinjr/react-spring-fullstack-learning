import React, { useEffect, useState } from "react";
import { getSchool, updateSchool } from "../services/schoolService";
import { useNavigate, useParams } from "react-router-dom";

const EditSchool = () => {
  const { id } = useParams(); 
  const navigate = useNavigate();

  const [form, setForm] = useState({
    name: "",
    address: "",
    email: "",
    phoneNumber: "",
    website: "",
  });

  useEffect(() => {
    fetchSchool();
  }, []);

  const fetchSchool = async () => {
    const res = await getSchool(id);
    setForm(res.data);
  };

  const handleChange = (e) => {
    setForm({
      ...form,
      [e.target.name]: e.target.value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    await updateSchool(id, form);
    navigate("/");
  };

  return (
    <form onSubmit={handleSubmit}>
      <input name="name" value={form.name} onChange={handleChange} />
      <input name="address" value={form.address} onChange={handleChange} />
      <input name="email" value={form.email} onChange={handleChange} />
      <input name="phoneNumber" value={form.phoneNumber || ""} onChange={handleChange} />
      <input name="website" value={form.website} onChange={handleChange} />
        
      <button type="submit">Update</button>
    </form>
  );
};

export default EditSchool;
