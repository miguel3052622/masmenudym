import { useNavigate } from "react-router-dom";
import { logout } from "../auth/authService";
import "../styles/dashboard.css";

export default function Dashboard() {
  const navigate = useNavigate();

  const handleLogout = async () => {
    await logout();
    navigate("/login");
  };

  return (
    <div className="dashboard-container">
      
      {/* HEADER */}
      <header className="dashboard-header">
        <h1>Panel de Control</h1>
        <button onClick={handleLogout}>Cerrar sesión</button>
      </header>

      {/* CUADRANTES */}
      <div className="dashboard-grid">

        <div
          className="dashboard-box"
          onClick={() => navigate("/tables")}
        >
          <h2>Mesas</h2>
          <p>Gestión de mesas(Función solo con Plan Pro.)</p>
        </div>

        <div
          className="dashboard-box"
          onClick={() => navigate("/kitchen")}
        >
          <h2>Cocina</h2>
          <p>Pedidos en preparación</p>
        </div>

        <div
          className="dashboard-box"
          onClick={() => navigate("/orders")}
        >
          <h2>Pedidos</h2>
          <p>Pedidos y toma de orden</p>
        </div>

        <div
          className="dashboard-box-admin"
          onClick={() => navigate("/admin")}
        >
          <h2>Administrador</h2>
          <p>Administración de menú, historial y gestion</p>
        </div>

      </div>
    </div>
  );
}
