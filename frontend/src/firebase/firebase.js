import { initializeApp } from "firebase/app";
import { getAuth } from "firebase/auth";

const firebaseConfig = {
  apiKey: "AIzaSyDc8YAubzfzt5JNtTKDXlT_7U-YghldYfo",
  authDomain: "menu-bcb1a.firebaseapp.com",
  projectId: "menu-bcb1a",
  storageBucket: "menu-bcb1a.firebasestorage.app",
  messagingSenderId: "787686122184",
  appId: "1:787686122184:web:04fb2bfb08accda7be3bfd",
  measurementId: "G-HTD6BXXZ2X"
};

const app = initializeApp(firebaseConfig);
export const auth = getAuth(app);
