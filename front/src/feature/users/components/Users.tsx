import {useUsers} from "@/feature/users/hooks/query/useUsers.ts";


export const Users = () => {
    const users = useUsers();

    return (
        <div>
            List
        </div>
    )
}