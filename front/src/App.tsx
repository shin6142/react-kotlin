import './App.css'
import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";
import {FC} from "react";
import {UserList} from "./pages/users";
import {ErrorPage, Root} from "./pages";
import {QueryClientProvider} from "@tanstack/react-query";
import {queryClient} from "./lib/reactQuery/react-query.ts";
import {UserDetail} from "@/pages/users/UserDetail.tsx";

const PATH = {
    USERS: "/users",
    USERS_DETAIL: "/users/:userId",
    USERS_EDIT: "/users/:userId/edit",
    USERS_CREATE: "/users/create",
} as const;

const router = createBrowserRouter([
    {
        path: "/",
        element: <Root />,
        errorElement: <ErrorPage />,
        children: [
            {
                path: PATH.USERS,
                element: <UserList />,
            },
            {
                path: PATH.USERS_DETAIL,
                element: <UserDetail />,
            },
            {
                path: PATH.USERS_EDIT,
                element: <UserList />,
            },
            {
                path: PATH.USERS_CREATE,
                element: <UserList />,
            }
        ],
    },
]);

export const Router: FC = () => {
    return <RouterProvider router={router} />;
};


function App() {
    return (
        <div className="App">
            <QueryClientProvider client={queryClient}>
                <Router />
            </QueryClientProvider>
        </div>
    )
}

export default App
