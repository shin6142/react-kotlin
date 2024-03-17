import {useParams} from "react-router-dom";
import {useUser} from "@/feature/users/hooks/query/useUsers.ts";

export const UserDetail = () => {
    const {userId} = useParams<{ userId: string }>();
    const { data: user } = useUser(userId as string);
    if (!user) return <p>loading...</p>;
    return (
        <div>
            userId: {user.userId}
            userName: {user.userName}
        </div>
    )
}