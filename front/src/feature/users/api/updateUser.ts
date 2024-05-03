import {userApi} from "@/infrastructure/openApiRepositories.ts";

export const updateUser = async (updateUser: {userId: string, userName: string}) => {
  await userApi.updateUser(updateUser.userId, updateUser)
}