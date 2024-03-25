import {useParams} from "react-router-dom";
import {useUser} from "@/feature/users/hooks/query/useUsers.ts";
import {Form} from "@/components/Form.tsx";

type Inputs = {
  userName: string;
}
export const UserDetail = () => {
  const {userId} = useParams<{ userId: string }>();
  const {data: user} = useUser(userId as string);
  if (!user) return <p>loading...</p>;
  return (
    <>
      <div>
        userId: {user.userId}
        userName: {user.userName}
      </div>
      <div>
        <Form<Inputs>
          onSubmit={(value) => {
            console.log(value);
          }}
          defaultValues={
            {
              userName: user.userName
            }
          }
        >
          {
            ({register}) => (
              <>
                <label>userName</label>
                <input
                  type={'text'}
                  {...register('userName')}
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