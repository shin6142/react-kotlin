import {useMutation} from "@tanstack/react-query";
import {updateUser} from "@/feature/users/api/updateUser.ts";
import {queryClient} from "@/lib/reactQuery/react-query.ts";
import {User} from "@/feature/users/types";

export const useUpdateUser = () => {
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
    onSuccess: (user: User) => {
      console.log("will fire when it successes")
      queryClient.setQueryData(['user', user.userId], user)
    },
    mutationFn: updateUser
  })
}