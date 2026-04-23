import React, { useEffect, useState } from "react";
import { getSchool } from "../services/schoolService";
import { useParams } from "react-router-dom";

const ViewSchool = () => {
  const { id } = useParams();
  const [school, setSchool] = useState(null);

  useEffect(() => {
    fetchSchool();
  }, []);

  const fetchSchool = async () => {
    const res = await getSchool(id);
    setSchool(res.data);
  };

  if (!school) return <p>Loading...</p>;

  return (
    <div>
      <h2>{school.name}</h2>
      <p>{school.address}</p>
      <p>{school.email}</p>
      <p>{school.phoneNumber}</p>
      <p>{school.website}</p>
    </div>
  );
};

export default ViewSchool;
