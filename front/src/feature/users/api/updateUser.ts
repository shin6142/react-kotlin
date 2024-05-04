import {userApi} from "@/infrastructure/openApiRepositories.ts";
import {User} from "@/feature/users/types";

export const updateUser = async (updateUser: User): Promise<User> => {
  await userApi.updateUser(updateUser.userId, updateUser)
  return updateUser
}