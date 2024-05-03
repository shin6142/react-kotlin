import {useMutation} from "@tanstack/react-query";
import {createUser} from "@/feature/users/api/createUser.ts";

export const useCreateUser = () => {
  return useMutation({
    onMutate: () => {
      console.log(`wil fire before mutation, takes same variables that mutation function receives`)
    },
    onSettled: () => {
      console.log("will fire after mutation, no matter the result is success or failure")
    },
    onError: () => {
      console.log("will fire when error occurred")
    },
    onSuccess: () => {
      console.log("will fire when it successes")
    },
    mutationFn: createUser,
  })
}