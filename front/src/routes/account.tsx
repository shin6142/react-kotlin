import {useForm} from "react-hook-form";
import {useParams} from "react-router-dom";

export default function Account() {

    // formで利用する値のtype指定
    interface BankForm {
        balance: number;
    }

    // 利用するメソッドを定義しています。ここの今回メソッドを以下で説明します。
    const {
        register,
        handleSubmit
    } = useForm<BankForm>();

    const {userId} = useParams();

    const onSubmit = (data: BankForm) => console.log(data)

    return (
        <>
            <p>userId: {userId}</p>
            <form onSubmit={handleSubmit(onSubmit)}>
                <div>
                    <label htmlFor="balance">Balance</label>
                    <input
                        defaultValue={0}
                        {...register("balance", {required: true})}
                    />
                </div>
                <button
                    type="submit"
                >
                    Save
                </button>
            </form>
        </>
    )
}
