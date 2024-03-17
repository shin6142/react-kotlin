import {useUsers} from "@/feature/users/hooks/query/useUsers.ts";
import {ClickableBox} from "@/components/ClickableBox.tsx";
import {useDisplayUserDetail} from "@/feature/users/hooks/navigate/useDisplayUserDetail.ts";

export const Users = () => {
    const {users} = useUsers();
    const { displayUserDetail } = useDisplayUserDetail();
    if (!users) return <p>loading...</p>;
    return (
        <>
            <div>
                {users.map((user) => (
                        <ClickableBox
                            onClick={()=>{
                                displayUserDetail(user.userId)
                            }}
                            key={user.userId}>
                            <div>
                                {user.userId}
                                {user.userName}
                            </div>
                        </ClickableBox>
                    )
                )}
            </div>
        </>
    )
}