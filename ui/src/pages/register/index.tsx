import Header from "../../components/Header.tsx";
import Register from "../../components/Register.tsx";

const ResgisterPage = () => {
    return (
        <>
            <Header
                heading="Signup to create an account"
                paragraph="Already have an account? "
                linkName="Login"
                linkUrl="/"
            />
            <Register/></>
    )
}

export default ResgisterPage;