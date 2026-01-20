import {
  signInWithEmailAndPassword,
  createUserWithEmailAndPassword,
} from "firebase/auth";
import { auth } from "../firebase/firebase";

export async function login(email, password) {
  const result = await signInWithEmailAndPassword(auth, email, password);
  const token = await result.user.getIdToken();
  localStorage.setItem("token", token);
  return result.user;
}

export async function register(email, password) {
  const result = await createUserWithEmailAndPassword(
    auth,
    email,
    password
  );
  const token = await result.user.getIdToken();
  localStorage.setItem("token", token);
  return result.user;
}

export function logout() {
  localStorage.removeItem("token");
  auth.signOut();
}
