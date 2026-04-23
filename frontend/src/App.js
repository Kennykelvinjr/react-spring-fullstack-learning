import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Schools from "./pages/Schools";
import AddSchool from "./pages/AddSchool";
import EditSchool from "./pages/EditSchool";
import ViewSchool from "./pages/ViewSchool";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Schools />} />
        <Route path="/add-school" element={<AddSchool />} />
        <Route path="/edit/:id" element={<EditSchool />} />
        <Route path="/view/:id" element={<ViewSchool />} />
      </Routes>
    </Router>
  );
}

export default App;