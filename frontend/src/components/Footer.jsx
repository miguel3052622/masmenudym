import React from "react";
import "../index.css";

export default function Footer() {
  return (
    <footer className="footer-section">
      <p>© {new Date().getFullYear()} +Menú — Todos los derechos reservados</p>
      <p>
        <a href="#top">Volver arriba</a>
      </p>
    </footer>
  );
}
