import {User as UserResponse} from "@/infrastructure/api/openapi";
import {userApi} from "@/infrastructure/openApiRepositories.ts";
import {User} from "@/feature/users/types";

export const getUsers = async (): Promise<User[]> => {
    const response = (await userApi.getUsers()) as unknown as UserResponse[];
    return response.map((user) => (translate(user)));
}

export const getUser = async (userId: string): Promise<UserResponse> => {
    const response = (await userApi.getUser(userId)) as unknown as UserResponse;
    return translate(response);
}

export const translate = (res: UserResponse): User => {
    return {
        userId: res.userId,
        userName: res.userName,
    }
}