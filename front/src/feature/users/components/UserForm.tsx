import {useForm} from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup"
import * as yup from "yup"

type UserInputs = {
    name: string;
}

const schema = yup
    .object()
    .shape({
        name: yup.string().required(),
    });

export const UserForm = () => {
    const { register, handleSubmit } = useForm<UserInputs>({
        resolver: yupResolver(schema)
    });
    return (
        <form onSubmit={handleSubmit((data) => console.log(data))}>
            <input {...register('name')} />
            <input type="submit" />
        </form>
    )
}