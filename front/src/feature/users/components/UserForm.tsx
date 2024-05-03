import {useCreateUser} from "@/feature/users/hooks/mutate/createUser.ts";
import {Form} from "@/components/Form.tsx";
import {z} from "zod";

type UserInputs = {
  name: string;
}

const schema = z.object({
  name: z.string().min(1, 'Required'),
});

export const UserForm = () => {
  const createUserMutation= useCreateUser()
  return (
    <Form<UserInputs, typeof schema>
      onSubmit={async (value) => {
        await createUserMutation.mutateAsync(value.name)
      }}
      defaultValues={
        {
          name: ""
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
              Create
            </button>
          </>
        )
      }
    </Form>
  )
}