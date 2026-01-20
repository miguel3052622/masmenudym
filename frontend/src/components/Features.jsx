import "../index.css";

const features = [
  { title: "Escaneo QR", desc: "Acceso inmediato sin apps." },
  { title: "Pedidos rápidos", desc: "Sin esperar al mesero." },
  { title: "Actualización fácil", desc: "Edita tu menú en segundos." },
];

export default function Features() {
  return (
    <section className="features-section">
      <div className="features-container">
        <h3>
          ¿Por qué usar <span className="highlight">+Menú</span>?
        </h3>

        <div className="features-grid">
          {features.map((f, i) => (
            <div key={i} className="feature-card">
              <h4>{f.title}</h4>
              <p>{f.desc}</p>
            </div>
          ))}
        </div>
      </div>
    </section>
  );
}
