import './App.css'
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import {FC} from "react";
import {Users} from "./pages/users/Users.tsx";
import {ErrorPage} from "./pages/ErrorPage.tsx";
import {Root} from "./pages/Root.tsx";

const router = createBrowserRouter([
    {
        path: "/",
        element: <Root />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: "users",
                element: <Users />,
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
