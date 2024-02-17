import './App.css'
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import {FC} from "react";
import {Root} from "./routes/root.tsx";
import ErrorPage from "./error-page.tsx";
import Account from "./routes/account.tsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Root />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: "account/:userId",
                element: <Account />,
            },
        ],
    },
]);

export const Router: FC = () => {
    return <RouterProvider router={router} />;
};


function App() {

  return (
      <div className="App">
          <Router />
      </div>
  )
}

export default App
