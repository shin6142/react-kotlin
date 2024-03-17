import {
    useMutation,
    UseMutationOptions,
    UseMutationResult,
    useQuery,
    UseQueryOptions,
    UseQueryResult
} from "@tanstack/react-query";
import {AxiosError} from "axios";
import {DefaultOptions, QueryClient} from "@tanstack/react-query";

const queryConfig: DefaultOptions = {
    queries: {
        refetchOnWindowFocus: false,
        staleTime: 0,
        gcTime: 0,
        retry: false,
    },
};
export const queryClient = new QueryClient({defaultOptions: queryConfig});

export type TError = AxiosError<{ code: string; message: string }>;
export type TQueryKey = [string, string] | [string];
export const useQueryWrapper = <T, TData=T>(
    options: UseQueryOptions<T, TError, TData, TQueryKey>
):UseQueryResult<TData, TError> => {
    return useQuery<T, TError, TData, TQueryKey>(options);
}



export type MutateOption<T, TVariables = void> = UseMutationOptions<
    T,
    TError,
    TVariables
>;
export const useMutationWrapper = <T, TVariables = void>(
    options: MutateOption<T, TVariables>,
    onMutate?: (variables: TVariables) => void
): UseMutationResult<T, TError, TVariables, void> => {
    const result = useMutation({
        ...options,
        onMutate: (variables) => {
            console.log(`wil fire before mutation, takes same variables that mutation function receives, which is${variables}`)
            onMutate?.(variables)
        },
        onSettled: () => {
            console.log("will fire after mutation, no matter the result is success or failure")
        },
        onError: (error, variables, context) => {
            if(options.onError !== undefined){
                options.onError(error, variables, context)
                return;
            }
            if(error?.response?.status === 400){
                return;
            }
            console.log("status is other than 400, will show error boundary")
        }
    });
    return result;
}