import Header from "../../components/Header.tsx";
import Login from "../../components/Login.tsx";

const LoginPage = () => {
    return (
        <>
            <Header
                heading="Login to your account"
                paragraph="Don't have an account yet? "
                linkName="Register"
                linkUrl="/register"
            />
            <Login/>
        </>
    )
}

export default LoginPage;