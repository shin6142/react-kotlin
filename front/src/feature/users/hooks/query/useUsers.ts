import {useQueryWrapper} from "@/lib/reactQuery/react-query.ts";
import {User} from "../../types";
import {getUser, getUsers} from "../../api/getUsers.ts";
import {useQuery} from "@tanstack/react-query";


export const useUsers = () => {
    const fallback: User[] = [];
    const {data: users = fallback} = useQuery({
        queryKey: ["users"],
        queryFn: getUsers,
    })
    return {users};
}


export const useUser = (userId: string) => {
    return useQueryWrapper<User>({
        queryKey: ["user", userId],
        queryFn: () => getUser(userId),
    });
}