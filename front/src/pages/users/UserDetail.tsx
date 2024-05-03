import {useParams} from "react-router-dom";
import {useUser} from "@/feature/users/hooks/query/useUsers.ts";
import {Form} from "@/components/Form.tsx";
import {z} from "zod";
import {useUpdateUser} from "@/feature/users/hooks/mutate/updateUser.ts";

type UserInputs = {
  name: string;
}

const schema = z.object({
  name: z.string().min(1, 'Required'),
});

export const UserDetail = () => {
  const {userId} = useParams<{ userId: string }>();
  const {data: user} = useUser(userId as string);
  const updateUserMutation = useUpdateUser()
  if (!user) return <p>loading...</p>;
  return (
    <>
      <div>
        <p>userId: {user.userId}</p>
        <p>userName: {user.userName}</p>
      </div>
      <div>
        <Form<UserInputs, typeof schema>
          onSubmit={(value) => {
            updateUserMutation.mutateAsync({
              userId: user.userId,
              userName: value.name})
          }}
          defaultValues={
            {
              name: user.userName
            }
          }
        >
          {
            ({register}) => (
              <>
                <label>userName</label>
                <input
                  type={'text'}
                  {...register('name')}
                />
                <button
                  type="submit"
                >
                  Update
                </button>
              </>
            )
          }
        </Form>
      </div>
    </>
  )
}