import {userApi} from "@/infrastructure/openApiRepositories.ts";

export const createUser = async (userName: string) => {
  const createUser = { userName: userName }
  await userApi.createUser(createUser)
}