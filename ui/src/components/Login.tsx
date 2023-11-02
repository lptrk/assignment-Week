import {ChangeEvent, FormEvent, useState} from 'react';
import FormAction from './FormAction';
import FormExtra from './FormExtra';
import Input from './Input';
import jwtDecode from 'jwt-decode';
import Cookies from 'universal-cookie';
import axios from '../api/axios';
import toast, {Toaster} from "react-hot-toast";
import {useNavigate} from "react-router-dom";

const LOGIN_URL = '/auth/login';

export default function Login() {
    const cookies = new Cookies();
    const [loginState, setLoginState] = useState({email: '', password: ''});
    const [user, setUser] = useState(null);
    const navigate = useNavigate();
    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        const {id, value} = e.target;
        setLoginState({...loginState, [id]: value});
    };

    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        await authenticateUser();
    };

    const authenticateUser = async () => {
        try {
            const response = await axios.post(LOGIN_URL, loginState, {
                withCredentials: true,
            });
            if (response.status == 200) {
                const accessToken = response.data.jwt;
                login(accessToken);
                toast.success("Login successful");
                setTimeout(() => {
                    navigate('/dashboard');
                }, 2000);
            }
        } catch (error) {
            console.log(error);
            toast.error('Something went wrong')
        }
    };

    const login = (token: string) => {
        const decoded: any = jwtDecode(token);
        setUser(decoded);
        cookies.set(decoded.sub, decoded, {expires: new Date(decoded.exp * 1000)});
    };

    return (
        <>
            <Toaster/>
            <form className="mt-8 space-y-6" onSubmit={handleSubmit}>
                <div className="-space-y-px">
                    <Input
                        key="email"
                        handleChange={handleChange}
                        value={loginState.email}
                        labelText="Email"
                        labelFor="email"
                        id="email"
                        name="email"
                        type="text"
                        isRequired={true}
                        placeholder="Enter your email"
                    />
                    <Input
                        key="password"
                        handleChange={handleChange}
                        value={loginState.password}
                        labelText="Password"
                        labelFor="password"
                        id="password"
                        name="password"
                        type="password"
                        isRequired={true}
                        placeholder="Enter your password"
                    />
                </div>

                <FormExtra/>
                <FormAction handleSubmit={handleSubmit} text="Login"/>
            </form>
        </>

    );
}
