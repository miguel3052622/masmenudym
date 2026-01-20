import React, { useState } from "react";
import { Link } from "react-router-dom";
import "../index.css";

export default function Navbar() {
  const [open, setOpen] = useState(false);

  return (
    <nav className="navbar">
      <div className="navbar-container">
        <h1 className="navbar-logo">+Menú</h1>

        {/* Links para escritorio */}
        <div className="navbar-links">
          <a href="#">Inicio</a>
          <a href="#">Cómo funciona</a>
          <a href="#">Contacto</a>
        </div>

        {/* Botón de acción */}
        <Link to="/login" className="navbar-btn">
        Entrar
        </Link>

        {/* Menú hamburguesa móvil */}
        <div className="hamburger" onClick={() => setOpen(!open)}>
          <div className="bar"></div>
          <div className="bar"></div>
          <div className="bar"></div>
        </div>
      </div>

      {/* Links móviles */}
      {open && (
        <div className="mobile-menu">
          <a href="#">Inicio</a>
          <a href="#">Cómo funciona</a>
          <a href="#">Contacto</a>
        </div>
      )}
    </nav>
  );
}
