import { useEffect, useState } from "react";

function App() {
  const [message, setMessage] = useState("");

  useEffect(() => {
    fetch("http://localhost:8080/")
      .then(res => res.text())
      .then(data => setMessage(data));
  }, []);

  return (
    <div style={{ padding: 20 }}>
      <h1>React Frontend</h1>
      <p>{message}</p>
    </div>
  );
}

export default App;