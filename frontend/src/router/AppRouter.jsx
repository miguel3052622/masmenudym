import { Routes, Route } from "react-router-dom";

import Home from "../pages/Home";
import Login from "../pages/Login";
import Register from "../pages/Register";
import Dashboard from "../pages/Dashboard";

import PrivateRoute from "../router/PrivateRoute";
import PublicRoute from "../auth/PublicRoute";

export default function AppRouter() {
  return (
    <Routes>
      <Route
        path="/"
        element={
          <PublicRoute>
            <Home />
          </PublicRoute>
        }
      />

      <Route
        path="/login"
        element={
          <PublicRoute>
            <Login />
          </PublicRoute>
        }
      />

      <Route
        path="/register"
        element={
          <PublicRoute>
            <Register />
          </PublicRoute>
        }
      />

      <Route
        path="/dashboard"
        element={
          <PrivateRoute>
            <Dashboard />
          </PrivateRoute>
        }
      />

      <Route 
        path="/admin" 
        element={
        <PrivateRoute>
        <AdminAuth />
        </PrivateRoute>
        } 
      />

      <Route 
        path="/admin/panel" 
        element={
         <PrivateRoute>
        <AdminPanel />
        </PrivateRoute>
        } 
      />

    </Routes>
  );
}
