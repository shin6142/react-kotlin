import {useMutation} from "@tanstack/react-query";
import {createUser} from "@/feature/users/api/createUser.ts";
import {useDisplayUserDetail} from "@/feature/users/hooks/navigate/useDisplayUserDetail.ts";
import {User} from "@/feature/users/types";

export const useCreateUser = () => {
  const { displayUserDetail } = useDisplayUserDetail();
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
      displayUserDetail(user.userId)
    },
    mutationFn: createUser,
  })
}