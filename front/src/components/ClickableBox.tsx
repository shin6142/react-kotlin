import React, {MouseEventHandler} from "react";

export const ClickableBox = (props: ClickableBoxProps) => {
    const {onClick, children, injectClass = ""} = props;
    return (
        <div className={`clickable-content ${injectClass}`} onClick={onClick}>
            {children}
        </div>
    )
}

export type ClickableBoxProps = {
    onClick: MouseEventHandler | undefined;
    children: React.ReactNode;
    injectClass?: string;
}