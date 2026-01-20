import React from "react";
import { Link } from "react-router-dom";
import "../index.css";

export default function Hero() {
  return (
    <section className="hero-section">
      <div className="hero-text">
        <h2>
          Crea tu cuenta de negocio <span className="highlight">y gestiona tu restaurante</span>
        </h2>
        <p>
          Con <strong>+Menú</strong>, administra tu restaurante pequeño, mediano o grande. 
          Controla pedidos, actualiza tu menú y ofrece una experiencia moderna a tus clientes.
        </p>
        <div className="hero-buttons">
         
           <Link className="btn-primary" to="/register">Registrar restaurante</Link>
          <button className="btn-secondary">Más información</button>
        </div>
      </div>

      <div className="hero-image">
        <div className="hero-placeholder">
          <span>📱 Gestión de tu restaurante aquí</span>
        </div>
      </div>
    </section>
  );
}
