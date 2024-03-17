import {User as UserResponse} from "../../../infrastructure/api/openapi";
import {User} from "../types";
import {userApi} from "../../../infrastructure/openApiRepositories.ts";


export const getUsers = async (): Promise<User[]> => {
    const response = await userApi.getUsers()
    const data = response.data as unknown as UserResponse[];
    return data.map((value) => (translate(value)));
}

export const getUser = async (userId: string): Promise<UserResponse> => {
    const response = await userApi.getUser(userId)
    const data = response.data as unknown as UserResponse
    return translate(data);
}

export const translate = (res: UserResponse): User => {
    return {
        userId: res.userId,
        userName: res.userName,
    }
}