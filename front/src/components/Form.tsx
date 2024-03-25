import {zodResolver} from '@hookform/resolvers/zod';
import clsx from 'clsx';
import * as React from 'react';
import {useForm, UseFormReturn, SubmitHandler, UseFormProps, FieldValues, DefaultValues} from 'react-hook-form';
import {ZodType, ZodTypeDef} from 'zod';

export type AsyncDefaultValues<TFieldValues> = (
  payload?: unknown
) => Promise<TFieldValues>;

type FormProps<TFormValues extends FieldValues, Schema> = {
  className?: string;
  onSubmit: SubmitHandler<TFormValues>;
  children: (methods: UseFormReturn<TFormValues>) => React.ReactNode;
  options?: UseFormProps<TFormValues>;
  id?: string;
  schema?: Schema;
  defaultValues?: DefaultValues<TFormValues> | AsyncDefaultValues<TFormValues>;
};

export const Form = <
  TFormValues extends Record<string, unknown> = Record<string, unknown>,
  Schema extends ZodType<unknown, ZodTypeDef, unknown> = ZodType<unknown, ZodTypeDef, unknown>
>({
    onSubmit,
    children,
    className,
    options,
    id,
    schema,
    defaultValues,
  }: FormProps<TFormValues, Schema>) => {
  const methods = useForm<TFormValues>({
    ...options,
    resolver: schema && zodResolver(schema),
    defaultValues: defaultValues
  });
  return (
    <form
      className={clsx('space-y-6', className)}
      onSubmit={methods.handleSubmit(onSubmit)}
      id={id}
    >
      {children(methods)}
    </form>
  );
};
