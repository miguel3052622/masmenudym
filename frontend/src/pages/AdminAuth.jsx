import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { reauthWithPassword } from "../auth/authService";
import "../styles/admin.css";

export default function AdminAuth() {
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError("");

    try {
      await reauthWithPassword(password);
      navigate("/admin/panel");
    } catch {
      setError("Contraseña incorrecta");
    }
  };

  return (
    <div className="admin-auth-container">
      <form className="admin-auth-box" onSubmit={handleSubmit}>
        <h2>Acceso Administrador</h2>

        <input
          type="password"
          placeholder="Contraseña"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />

        {error && <p className="error">{error}</p>}

        <button type="submit">Ingresar</button>
      </form>
    </div>
  );
}
