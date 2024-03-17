
import {defineConfig } from "vite";
import path from "path";

// https://vitejs.dev/config/
export default () => {
  return defineConfig({
    resolve: {
      alias: {
        '@': path.resolve(__dirname, 'src'),
      },
    },
  });
};
