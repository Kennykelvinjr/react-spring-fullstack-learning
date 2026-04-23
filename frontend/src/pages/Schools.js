import React, { useEffect, useState } from "react";
import { getSchools, deleteSchool } from "../services/schoolService";
import { Link } from "react-router-dom";

const Schools = () => {
  const [schools, setSchools] = useState([]);

  useEffect(() => {
    fetchSchools();
  }, []);

  const fetchSchools = async () => {
    const res = await getSchools();
    setSchools(res.data);
  };

  const handleDelete = async (id) => {
    await deleteSchool(id);
    fetchSchools();
  };

  return (
    <div>
      <h2>Schools</h2>

      <Link to="/add-school">
        <button>Add School</button>
      </Link>

      {schools.map((school) => (
        <div key={school.id}>
          <p>{school.name}</p>

          <Link to={`/view/${school.id}`}>
            <button>View</button>
          </Link>

          <Link to={`/edit/${school.id}`}>
            <button>Edit</button>
          </Link>

          <button onClick={() => handleDelete(school.id)}>
            Delete
          </button>
        </div>
      ))}
    </div>
  );
};

export default Schools;