const API_URL = import.meta.env.VITE_API_URL || "http://localhost:8080";

export async function apiFetch(url, options = {}) {
  const token = localStorage.getItem("token");

  const headers = {
    ...(token && { Authorization: `Bearer ${token}` }),
    ...(options.body && { "Content-Type": "application/json" }),
    ...options.headers,
  };

  const response = await fetch(`${API_URL}${url}`, {
    ...options,
    headers,
  });

  if (response.status === 401 || response.status === 403) {
    console.warn("Token inválido o expirado");
    // opcional:
    // localStorage.removeItem("token");
    // window.location.href = "/login";
  }

  if (!response.ok) {
    const error = await response.text();
    throw new Error(error || "Error en la petición");
  }

  return response.json();
}
