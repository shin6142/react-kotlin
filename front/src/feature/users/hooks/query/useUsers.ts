import {User} from "@/feature/users/types";
import {getUsers} from "@/feature/users/api/userApi.ts";
import {useQuery} from "@tanstack/react-query";


export const useUsers = () => {
    const fallback: User[] = [];
    const {data: users = fallback} = useQuery({
        queryKey: ["users"],
        queryFn: getUsers,
    })
    return {users};
}