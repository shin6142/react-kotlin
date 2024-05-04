import {userApi} from "@/infrastructure/openApiRepositories.ts";
import {User} from "@/feature/users/types";

export const createUser = async (userName: string):Promise<User> => {
  const createUser = { userName: userName }
  const res = await userApi.createUser(createUser)
  return {
    userId: res.data.userId,
    userName: res.data.userName
  }
}