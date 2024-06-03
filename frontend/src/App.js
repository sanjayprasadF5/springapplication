import React, { useEffect, useState } from "react";
import axios from "axios";

const App = () => {
  const [user, setUser] = useState(null);

  useEffect(() => {
    const fetchUserDetails = async () => {
      try {
        const response = await axios.get("/user-details");
        setUser(response.data);
        console.log("User details fetched successfully:", response.data);
      } catch (error) {
        console.error("Error fetching user details:", error);
      }
    };

    fetchUserDetails();
  }, []);

  const Login = () => (
    <div>
      <h2>Login</h2>
      <a href="/oauth2/authorization/azure">Login with Microsoft</a>
    </div>
  );

  return (
    <div>
      <h1>Welcome</h1>
      {user ? (
        <div>
          <h2>User Details</h2>
          <pre>{JSON.stringify(user, null, 2)}</pre>
          <a href="/logout">Logout</a>
        </div>
      ) : (
        <Login />
      )}
    </div>
  );
};

export default App;
