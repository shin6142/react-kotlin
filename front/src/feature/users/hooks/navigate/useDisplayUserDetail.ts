import {useNavigate} from "react-router-dom";

export const useDisplayUserDetail = () => {
    const navigate = useNavigate();
    const displayUserDetail = (userId: string) => {
        navigate(`/users/${userId}`);
    }
    return {displayUserDetail};
}